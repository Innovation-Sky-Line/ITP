package com.ossms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ossms.model.Paymentss;
import com.ossms.model.Stocks;
import com.ossms.repository.StockRepository;

@Service
@Transactional
public class StockServiceImpl implements StockService {
	
	@Autowired
	StockRepository stockRepository;

	@Override
	public List<Stocks> getAllStocks() {
		return (List<Stocks>) stockRepository.findAll();
	}

	@Override
	public Stocks getStocksById(int idPurchasedStock) {
		return stockRepository.findById(idPurchasedStock).get();
	}

	public void saveOrUpdate(Stocks stocks) {
		stockRepository.save(stocks);
		
	}

	public void deleteStocks(int idPurchasedStock) {
		stockRepository.deleteById(idPurchasedStock);
		
	}
	
	@Override
	public List<Stocks> getStockByDate(String date) {
		return stockRepository.findStockByPurchaseDate(date);
	}

}
