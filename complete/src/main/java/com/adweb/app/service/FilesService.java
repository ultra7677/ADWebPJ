package com.adweb.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adweb.app.entity.Files;
import com.adweb.app.repository.FilesRepository;

@Service
public class FilesService {
	@Autowired
	private FilesRepository filesRepository;
	
	public void create(Files files){
		this.filesRepository.save(files);
	}
	
	public String findById(Long id){
		Files file = this.filesRepository.findOne(id);
		return file.getFilelocation();
	}
	
}
