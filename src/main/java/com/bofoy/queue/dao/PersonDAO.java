package com.bofoy.queue.dao;

import java.util.List;

import com.bofoy.queue.domain.Person;

public interface PersonDAO {

	List<Person> getAllUsers();
	
	Person getUser(String userName);
	
	void addUser(String userName, String password);
	
}
