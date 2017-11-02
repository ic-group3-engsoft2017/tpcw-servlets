package tpcw.service;

import java.awt.print.Book;
import java.sql.Connection;
import java.util.Vector;

import tpcw.model.*;

//Interface para abstrair o comportamento de requisição de serviço de dados.
public interface ITPCW_Service {

	public String[] getName(int c_id);
	
	public Book getBook(int i_id);
	
	public Customer getCustomer(String UNAME);
	
	public Vector doSubjectSearch(String search_key);
	
	public Vector doTitleSearch(String search_key); 
	
	public Vector doAuthorSearch(String search_key);
	
	public Vector getNewProducts(String subject);
	
	public Vector getBestSellers(String subject);
	
	public Order GetMostRecentOrder(String c_uname, Vector order_lines);
	
	public Cart getCart(int SHOPPING_ID, double c_discount);
	
	public double getCDiscount(Connection con, int c_id);
	
	public int getCAddrID(Connection con, int c_id);
	
	public int getCAddr(Connection con, int c_id);
	
	public int getStock(Connection con, int i_id);
}
