package com.exchange.rate.api.exchangerate.repository;

import com.exchange.rate.api.exchangerate.model.entity.ExchangeRate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ExchangeRateRepository extends CrudRepository<ExchangeRate,String> {

}



