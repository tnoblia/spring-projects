package com.mycompany.invoise.core.repository.database;
//
//import java.sql.PreparedStatement;
//import java.sql.Statement;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.support.GeneratedKeyHolder;
//import org.springframework.jdbc.support.KeyHolder;
//import org.springframework.stereotype.Repository;
//
//import com.mycompany.invoise.core.entity.Invoice;
//import com.mycompany.invoise.core.repository.InvoiceRepositoryInterface;
//
////@Repository est une annotation fille de @Component (c'est exactement la même annotation en fait)
////La seule différence est que @Repository est une annotation plus explicite (mais pas de différence techniquement)
//@Repository //Donne automatiquement accès à un jdbc template
//public class InvoiceRepositoryDatabase implements InvoiceRepositoryInterface{
//	
//	private static List<Invoice> invoices = new ArrayList<>();
//	
//	@Autowired //voir commentaire sur @Repository
//	private JdbcTemplate jdbcTemplate;
//	
//	public Invoice create(Invoice invoice) {
//		KeyHolder kh = new GeneratedKeyHolder();
//		jdbcTemplate.update(connection -> {
//			PreparedStatement ps = connection.prepareStatement("insert into invoice (customer_name,order_number) values (?,?)",
//				    new String[] { "invoice_number" });
//			ps.setString(1,invoice.getCustomerName());
//			ps.setString(2,invoice.getOrderNumber());
//			return ps;
//		},kh);
//		invoice.setNumber(kh.getKey().toString());;
//		return invoice;
//	}
//	
//	public List<Invoice> list(){
//		return jdbcTemplate.query("select invoice_number, customer_name from invoice",
//				(rs,rowNum) -> new Invoice(String.valueOf(rs.getLong("invoice_number")),rs.getString("customer_name")));
//	}
//	
//	@SuppressWarnings("deprecation")
//	public Invoice getById(String number) {
//		long longNumber = Long.valueOf(number);
//		return jdbcTemplate.queryForObject("select invoice_number, customer_name, order_number from invoice where invoice_number = ?",
//				new Object[] {longNumber},
//				(rs,rowNum) -> new Invoice(String.valueOf(rs.getLong("invoice_number")),rs.getString("customer_name"),rs.getString("order_number")));
//	}
//}
