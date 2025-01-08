package com.example.cmi.model.entites;

import com.example.cmi.dto.NotificationType;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "notifications")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id", nullable = false)
    private Utilisateur utilisateur;

    @Column(nullable = false)
    private String message;

    @Column(nullable = false)
    private NotificationType type; // EMAIL, SMS, PUSH

    @Column(nullable = false)
    private LocalDateTime date = LocalDateTime.now();
}

