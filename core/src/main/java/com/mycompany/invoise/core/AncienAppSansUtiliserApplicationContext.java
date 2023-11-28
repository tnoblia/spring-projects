//package com.mycompany.invoise.core;
//
//import java.util.Scanner;
//
//import com.mycompany.invoise.core.controller.InvoiceControllerInterface;
//import com.mycompany.invoise.core.repository.InvoiceRepositoryInterface;
//import com.mycompany.invoise.core.service.InvoiceServiceInterface;
//
//public class AncienAppSansUtiliserApplicationContext 
//{
//    public static void AncienMain( String[] args )
//    {
//    	Scanner scanner = new Scanner(System.in);
//    	System.out.println("Quel est la classe de controller?");
//    	String classController = scanner.nextLine();
//    	System.out.println("Quel est la classe de service?");
//    	String classService = scanner.nextLine();
//    	System.out.println("Quel est la classe de repository?");
//    	String classRepository = scanner.nextLine();
//    	
//    	InvoiceControllerInterface invoiceController = null;
//    	InvoiceServiceInterface invoiceService= null;
//    	InvoiceRepositoryInterface invoiceRepository = null;
//    	
//    	try {
//    		invoiceController=(InvoiceControllerInterface)Class.forName(classController).getDeclaredConstructor().newInstance();
//        	invoiceService=(InvoiceServiceInterface)Class.forName(classService).getDeclaredConstructor().newInstance();
//        	invoiceRepository=(InvoiceRepositoryInterface)Class.forName(classRepository).getDeclaredConstructor().newInstance();	
//    	}catch(Exception e) {
//    		e.printStackTrace();
//    	}
//	
//		//invoiceController.setInvoiceService(invoiceService);
//		//invoiceService.setInvoiceRepository(invoiceRepository);
//		invoiceController.createInvoice();
//		scanner.close();
//    
//    }
//}
