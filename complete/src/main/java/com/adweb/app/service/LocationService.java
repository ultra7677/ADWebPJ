package com.adweb.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adweb.app.entity.Location;
import com.adweb.app.repository.LocationRepository;

@Service
public class LocationService {
	@Autowired LocationRepository locationRepository;
	
	public Location create(Location location){
		this.locationRepository.save(location);
		return location;
	}
	
	public 	List<Location> findAll(){
		return this.locationRepository.findAll();
	}	
	
	public Location findByName(String name){
		return this.locationRepository.findByName(name);
	}
}
