package com.crud.restapp.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.crud.restapp.Entity.User;
import com.crud.restapp.service.userlogic;

@RestController
@RequestMapping("/api")
public class usercontroller {
	@Autowired
	userlogic userLogic;
	 @GetMapping("/users")
	 public CompletableFuture<List<User>> users() {
		 try {
			 CompletableFuture<List<User>> user=userLogic.getUsers();
			 return user;
		 }catch(Exception e) {
			 System.out.println(e.getMessage());
		 }
	        return null;
	    }
	 
	 @PostMapping("/adduser")
	 public String adduser(@RequestBody User u) {
		 try {
			userLogic.addUser(u);
			 return "Added";
		 }catch(Exception e) {
			 System.out.println(e.getMessage());
		 }
	        return null;
	    }
	 
	 @PutMapping("/updateuser")
	 public String updateuser(@RequestBody User u) {
		 try {
			userLogic.updateUser(u);
			 return "updated";
		 }catch(Exception e) {
			 System.out.println(e.getMessage());
		 }
	        return null;
	    }
	 @PutMapping("/deluser")
	 public String deluser(@RequestBody User user) {
		 try {
			userLogic.delUser(user.id);
			 return "Deleted";
		 }catch(Exception e) {
			 System.out.println(e.getMessage());
		 }
	        return null;
	    }
	 
}
