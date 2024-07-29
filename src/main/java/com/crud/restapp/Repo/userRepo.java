package com.crud.restapp.Repo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
//import javax.swing.tree.RowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.stereotype.Repository;
//import org.springframework.jdbc.core.RowMapper;
import com.crud.restapp.Entity.User;
@Repository
public class userRepo{
	 @Autowired
	 private JdbcTemplate template;
	 public String addUser(User user) {
		 String query = "INSERT INTO userdetail (name, age) VALUES ( ?, ?)";
	     template.update(query,user.name, user.age);
	       return "Added";
	 }
	 public List<User> getAllUser(){
		 try {
	        String sql = "select * from userdetail";
	        RowMapper<User> rowMapper = new RowMapper() {
				@Override
				public User mapRow(ResultSet result, int rows) throws SQLException {
					User user = new User();
	                user.id = result.getInt("ID");
	                user.name= result.getString("NAME");
	                user.age = result.getInt("AGE");
	                return user;
				}
			};	     
			return template.query(sql, rowMapper);
		 }catch(Exception e) {
			 System.out.println(e.getMessage());
		 }
		 return null;
	    }
	 public String updateUser(User user) {
		 String query = "UPDATE userdetail SET name = ?, age = ? WHERE id = ?";
	     template.update(query,user.name, user.age,user.id);
	       return "Updated";
	 }
	 
	 public String delUser(int user) {
	 String query = "DELETE from userdetail where id = ?";
     template.update(query, user);
     return "Deleted";
	 }
}
