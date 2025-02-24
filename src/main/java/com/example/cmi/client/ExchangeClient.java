package com.example.cmi.client;

import com.example.cmi.dto.Devise;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name = "service-paiement-multidevises", url = "https://servicepaiementmultidevises-production.up.railway.app/api/exchange")
public interface ExchangeClient {
    @GetMapping("/rate")
    Double getExchangeRate(
            @RequestParam("fromCurrency") Devise fromCurrency,
            @RequestParam("toCurrency") Devise toCurrency
    );
}
