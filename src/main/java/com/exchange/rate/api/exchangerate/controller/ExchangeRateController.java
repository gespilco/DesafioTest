package com.exchange.rate.api.exchangerate.controller;

import com.exchange.rate.api.exchangerate.model.entity.ExchangeRate;
import com.exchange.rate.api.exchangerate.model.request.ExchangeRateRequest;
import com.exchange.rate.api.exchangerate.model.request.ExchangeRateSearchRequest;
import com.exchange.rate.api.exchangerate.model.response.ExchangeRateResponse;
import com.exchange.rate.api.exchangerate.service.ExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rx.Single;

import java.util.List;

@RestController
@RequestMapping("/api/v1/exchange-rate")
public class ExchangeRateController {

    @Autowired
    ExchangeRateService exchangeRateService;


    @PostMapping(value = "/calculate", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Single<ExchangeRateResponse> calculate(@RequestBody ExchangeRateSearchRequest request) {
        return exchangeRateService.calculate(request);
    }

    @PostMapping(value = "/save", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Single<ExchangeRateResponse> save(@RequestBody ExchangeRateRequest request) {
        return exchangeRateService.save(request);
    }



    //private ExchangeRateService exchangeRateService;

    /*@GetMapping
    public String hello () {
        return "Hello java";
    }*/

    /*@GetMapping("/exchange-rate")
    public ResponseEntity<List<ExchangeRate>> exchangerates() {
        List<ExchangeRate> exchangerates = exchangeRateService.getExchangeRates();
        return new ResponseEntity<>(exchangerates, HttpStatus.OK);
    }*/


}
