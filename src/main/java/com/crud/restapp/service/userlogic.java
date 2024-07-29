package com.crud.restapp.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.crud.restapp.Entity.User;
import com.crud.restapp.Repo.userRepo;

@Component
public class userlogic {
	@Autowired
	userRepo userRepo;
	
	public CompletableFuture<List<User>> getUsers() {
	try {		
		return CompletableFuture.completedFuture(userRepo.getAllUser());
	}catch(Exception e) {
		 System.out.println(e.getMessage());
	 }
	return null;
    }
	
	public String addUser(User user) {
		try {		
			return userRepo.addUser(user);
		}catch(Exception e) {
			 System.out.println(e.getMessage());
		 }
		return "";
	    }
	
	public String updateUser(User user) {
		try {		
			return userRepo.updateUser(user);
		}catch(Exception e) {
			 System.out.println(e.getMessage());
		 }
		return "";
	    }
	public void delUser(int id) {
		userRepo.delUser(id);
	}
}
