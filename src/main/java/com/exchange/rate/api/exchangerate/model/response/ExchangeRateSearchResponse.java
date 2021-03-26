package com.exchange.rate.api.exchangerate.model.response;

import java.math.BigDecimal;

public class ExchangeRateSearchResponse {
    private String code;//monto base
    private BigDecimal calculatedAmount; // monto calculado
    private String originCurrency; // moneda inicial
    private String destinationCurrency; // moneda destino
}
