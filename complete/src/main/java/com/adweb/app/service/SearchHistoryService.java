package com.adweb.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adweb.app.entity.Item;
import com.adweb.app.entity.SearchHistory;
import com.adweb.app.entity.User;
import com.adweb.app.repository.SearchHistoryRepository;

@Service
public class SearchHistoryService {
	@Autowired SearchHistoryRepository searchHistoryRepository;
	
	public SearchHistory create(SearchHistory searchHistory){
		this.searchHistoryRepository.save(searchHistory);
		return searchHistory;
	}
	
	public List<SearchHistory> findByUser(User user){
		return this.searchHistoryRepository.findByUSer(user);
	}
	
	public List<SearchHistory> findByItem(Item item){
		return this.searchHistoryRepository.findByItem(item);
	}
	
}
