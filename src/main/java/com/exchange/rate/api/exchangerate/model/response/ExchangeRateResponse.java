package com.exchange.rate.api.exchangerate.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
public class ExchangeRateResponse {

    private String code;//monto base
    private BigDecimal amount; // monto calculado
    private String originCurrency; // moneda inicial
    private String destinationCurrency; // moneda destino
}
