package com.ossms.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ossms.model.Supplier;
import com.ossms.repository.SupplierRepository;

@Service
@Transactional
public class SupplierServiceImpl implements SupplierService {
	
	@Autowired
	SupplierRepository supplierRepository;

	@Override
	public List<Supplier> getAllSupplier() {
		return (List<Supplier>) supplierRepository.findAll();
	}

	@Override
	public Supplier getSupplierById(int idSupplier) {
		return supplierRepository.findById(idSupplier).get();
	}

	public void saveOrUpdate(Supplier supplier) {
		supplierRepository.save(supplier);
		
	}

	public void deleteSupplier(int idSupplier) {
		supplierRepository.deleteById(idSupplier);
		
	}

	@Override
	public List<Supplier> searchSupplier(String name) {
		return supplierRepository.searchSupplier(name);
	}

}
