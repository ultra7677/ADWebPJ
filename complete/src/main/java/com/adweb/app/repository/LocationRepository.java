package com.adweb.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.adweb.app.entity.Location;

public interface LocationRepository extends  CrudRepository<Location,Long>  {
	Location findByName(String name);
	
	List<Location> findAll();
}
