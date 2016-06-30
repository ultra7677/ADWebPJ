package com.adweb.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.adweb.app.entity.Item;
import com.adweb.app.entity.SearchHistory;
import com.adweb.app.entity.User;

public interface SearchHistoryRepository  extends CrudRepository<SearchHistory,Long>{
	List<SearchHistory> findByItem(Item item);
	List<SearchHistory> findByUser(User user);
}
