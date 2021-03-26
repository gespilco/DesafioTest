package com.exchange.rate.api.exchangerate.model.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ExchangeRateRequest {

    private BigDecimal exchangeRateValue; //2.3, 3,4
    private String originCurrency;
    private String destinationCurrency;


}
