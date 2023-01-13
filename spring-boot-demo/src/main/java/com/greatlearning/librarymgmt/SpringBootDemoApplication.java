package com.greatlearning.librarymgmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
		System.out.println("hiiiii this is spring framework " + 
		"a framework is nothing but supporting software libraries to make " + 
		"your application devlopment easy" );
	}

}
