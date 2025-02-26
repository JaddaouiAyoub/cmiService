package com.example.cmi.model.entites;


import com.example.cmi.model.CarteVirtuelle;
import com.example.cmi.model.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "utilisateurs")
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role; // CLIENT, AGENT, ADMIN

    @Column(nullable = false)
    private String mdp;

    @JsonIgnore
    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    private List<Portefeuilles> portefeuilles;

    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    private List<CarteVirtuelle> virtualCards;

    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    private List<Notification> notifications;

    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<PaiementRecurrent> paiementsRecurrents;
}

