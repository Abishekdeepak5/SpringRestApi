package com.crud.restapp.Entity;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName = "prototype")
public class User {
	    public int id;
	    public String name;
	    public int age;
}
