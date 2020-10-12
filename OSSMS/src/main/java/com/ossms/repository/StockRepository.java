package com.ossms.repository;

import org.springframework.data.repository.CrudRepository;

import com.ossms.model.Stocks;

public interface StockRepository extends CrudRepository<Stocks, Integer> {

}
