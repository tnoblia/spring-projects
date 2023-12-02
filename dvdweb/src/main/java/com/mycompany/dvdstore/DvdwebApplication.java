package com.mycompany.dvdstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;

@SpringBootApplication
public class DvdwebApplication {

	public static void main(String[] args) {
		SpringApplication.run(DvdwebApplication.class, args);
	}
	
	@Bean
	public Hibernate5Module datatypeHibernateModule() {
	   return new Hibernate5Module();
	}


}
