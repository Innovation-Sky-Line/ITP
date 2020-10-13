package com.ossms.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ossms.model.Stocks;

public interface StockRepository extends CrudRepository<Stocks, Integer> {

	List<Stocks> findStockByPurchaseDate(String date);
	
}
