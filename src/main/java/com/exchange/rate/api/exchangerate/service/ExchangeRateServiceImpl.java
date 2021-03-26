package com.exchange.rate.api.exchangerate.service;

import com.exchange.rate.api.exchangerate.model.entity.ExchangeRate;
import com.exchange.rate.api.exchangerate.model.request.ExchangeRateRequest;
import com.exchange.rate.api.exchangerate.model.request.ExchangeRateSearchRequest;
import com.exchange.rate.api.exchangerate.model.response.ExchangeRateResponse;
import com.exchange.rate.api.exchangerate.repository.ExchangeRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rx.Single;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class ExchangeRateServiceImpl implements ExchangeRateService {

    @Autowired
    private ExchangeRateRepository exchangeRateRepository;

    @Override
    public Single<ExchangeRateResponse> calculate(ExchangeRateSearchRequest request) {
        String code = request.getOriginCurrency().concat(request.getDestinationCurrency());

        Optional<ExchangeRate> exchangeRate =
                exchangeRateRepository.findById(code);

        BigDecimal amountFinal = null;

        if (exchangeRate.isPresent()){
            amountFinal = request.getAmount()
                    .multiply(exchangeRate.get().getExchangeRateValue());
        }else{
            throw new EntityNotFoundException("no encontrado");
        }

        ExchangeRateResponse response =  ExchangeRateResponse.builder()
                .code(exchangeRate.get().getCode())
                .amount(amountFinal)
                .originCurrency(exchangeRate.get().getOriginCurrency())
                .destinationCurrency(exchangeRate.get().getDestinationCurrency())
                .build();

        return Single.just(response);

    }

    @Override
    public Single<ExchangeRateResponse> save(ExchangeRateRequest request) {
        ExchangeRate exchangeRate  = ExchangeRate.builder()
                .code(request.getOriginCurrency().concat(request.getDestinationCurrency()))
                .originCurrency(request.getOriginCurrency())
                .destinationCurrency(request.getDestinationCurrency())
                .exchangeRateValue(request.getExchangeRateValue())
                .build();
        exchangeRateRepository.save(exchangeRate);
        return Single.just(ExchangeRateResponse.builder()
                .amount(request.getExchangeRateValue())
                .originCurrency(request.getOriginCurrency())
                .destinationCurrency(request.getDestinationCurrency())
                .code(exchangeRate.getCode())
                .build()
        );
    }

}
