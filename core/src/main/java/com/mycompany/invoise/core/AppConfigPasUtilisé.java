package com.mycompany.invoise.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ImportResource("classpath:applicationContext.xml")//pour utiliser le fichier xml en complément
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages= {
		"com.mycompany.invoise.core.controller.web",
		"com.mycompany.invoise.core.service.prefix",
		"com.mycompany.invoise.core.repository.database"})
public class AppConfigPasUtilisé {
	
}
