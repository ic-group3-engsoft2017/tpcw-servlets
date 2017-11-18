package tpcw.group3.service;

import tpcw.group3.model.*;
import java.util.Vector;


//Interface para abstrair o comportamento de requisição de serviço de dados.
public interface ITPCW_Service {

	String[] getName(int c_id);

	Book getBook(int i_id);
	
	Customer getCustomer(String UNAME);
	
	Vector doSubjectSearch(String search_key);
	
	Vector doTitleSearch(String search_key);
	
	Vector doAuthorSearch(String search_key);
	
	Vector getNewProducts(String subject);
	
	Vector getBestSellers(String subject);
	
	Order GetMostRecentOrder(String c_uname, Vector order_lines);
	
	Cart getCart(int SHOPPING_ID, double c_discount);
	
	double getCDiscount(int c_id);
	
	int getCAddrID(int c_id);
	
	int getCAddr(int c_id);
	
	int getStock(int i_id);
}

