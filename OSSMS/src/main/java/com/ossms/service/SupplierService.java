package com.ossms.service;
import java.util.List;

import com.ossms.model.*;



public interface SupplierService {

	public List<Supplier> getAllSupplier();

	public Supplier getSupplierById(int idSupplier);
	
	public void saveOrUpdate(Supplier supplier);
	
	public void deleteSupplier(int idSupplier);
	
	public List<Supplier> searchSupplier(String name);

}