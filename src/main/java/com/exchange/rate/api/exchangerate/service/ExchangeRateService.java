package com.exchange.rate.api.exchangerate.service;

import com.exchange.rate.api.exchangerate.model.entity.ExchangeRate;
import com.exchange.rate.api.exchangerate.model.request.ExchangeRateRequest;
import com.exchange.rate.api.exchangerate.model.request.ExchangeRateSearchRequest;
import com.exchange.rate.api.exchangerate.model.response.ExchangeRateResponse;
import rx.Single;

import java.util.List;

public interface ExchangeRateService {

    Single<ExchangeRateResponse> calculate(ExchangeRateSearchRequest request);
    Single<ExchangeRateResponse> save(ExchangeRateRequest request);

    //public List<ExchangeRate> getExchangeRates();
}


