package com.exchange.rate.api.exchangerate.model.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ExchangeRateSearchRequest {

    private BigDecimal amount;
    private String originCurrency;
    private String destinationCurrency;


}
