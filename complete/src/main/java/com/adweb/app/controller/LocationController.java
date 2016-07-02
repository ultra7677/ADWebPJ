package com.adweb.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.adweb.app.entity.Location;
import com.adweb.app.repository.LocationRepository;
import com.adweb.app.service.LocationService;

@Controller
public class LocationController {
	@Autowired 
	private LocationService locationService;
	
	@Autowired
	private LocationRepository locationRepository;
	
	@RequestMapping(value = "/getLocationList", method = RequestMethod.GET)
	public @ResponseBody List<Location> getLocationList(){
		return this.locationRepository.findAll();
	}
	
}
