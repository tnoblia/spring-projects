//package com.mycompany.invoise.core;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ApplicationContext;
//
//import com.mycompany.invoise.core.controller.InvoiceControllerInterface;
//
////@Configuration //inutile car compris dans l'annotation springbootapp
////@ImportResource("classpath:applicationContext.xml")//pour utiliser le fichier xml en complément (mais pas utilisé ici)
////@PropertySource("classpath:application.properties")// => inutile car springbootapp cherche automatiquement un fichier application.properties
///*@ComponentScan(basePackages= {
//		"com.mycompany.invoise.core.controller.web",
//		"com.mycompany.invoise.core.service.prefix",
//		"com.mycompany.invoise.core.repository.database"})*/ // => inutile car springbootapp scanne automatiquement le projet et on a supprimé les annotations en trop en haut des fichiers.
//
//@SpringBootApplication
//public class App 
//{
//    public static void main( String[] args )
//    {
//    	//ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//    	//ApplicationContext context = new AnnotationConfigApplicationContext(AppConfigPasUtilisé.class);
//    	//ApplicationContext context = new AnnotationConfigApplicationContext(App.class);
//    	ApplicationContext context = SpringApplication.run(App.class,args );
//    	InvoiceControllerInterface invoiceController = context.getBean(InvoiceControllerInterface.class);
//    	invoiceController.createInvoice();
//    }
//}
