package com.ossms.dao;

import org.springframework.data.repository.CrudRepository;


import com.ossms.model.Supplier;

public interface SupplierDao extends CrudRepository<Supplier, Integer>  {

}
