package com.mycompany.invoise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;

@SpringBootApplication
public class InvoiseWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvoiseWebApplication.class, args);
	}
	
	@Bean
	public Hibernate5Module datatypeHibernate5Module() {
		return new Hibernate5Module();
	}

}
