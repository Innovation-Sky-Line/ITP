package com.ossms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ossms.model.EmpBasicInfo;

@Repository
public interface EmpBasicInfoRepo extends CrudRepository<EmpBasicInfo , String>{


}
