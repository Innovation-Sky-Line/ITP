package com.ossms.service;

import java.util.List;

import com.ossms.model.Stocks;

public interface StockService {
	
	public List<Stocks> getAllStocks();

	public Stocks getStocksById(int idPurchasedStock);
	
	public void saveOrUpdate(Stocks stocks);
	
	public void deleteStocks(int idPurchasedStock);

}
