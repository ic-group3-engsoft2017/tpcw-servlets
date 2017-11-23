package tpcw.service;

import java.sql.Connection;
import java.sql.Date;
import java.util.Vector;

import tpcw.model.*;

//Interface para abstrair o comportamento de requisição de serviço de dados.
public interface ITPCW_Service {

	public String[] getName(int c_id);
	
	public tpcw.model.Book getBook(int i_id);
	
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
	
	public String getUserName(int c_id);
	
	public String getPassword(String c_uname);
	
	public int createEmptyCart();
	
	public Cart doCart(int SHOPPING_ID, Integer I_ID, Vector ids, Vector quantities);
	
	public void refreshSession(int c_id);
	
	public BuyConfirmResult doBuyConfirm(int shopping_id, int customer_id, String cc_type, long cc_number, String cc_name, Date cc_expiry, String shipping);
	
	public BuyConfirmResult doBuyConfirm(int shopping_id, int customer_id, String cc_type, long cc_number, String cc_name, Date cc_expiry, String shipping, String street_1, String street_2, String city, String state, String zip, String country);

	public void adminUpdate(int i_id, double cost, String image, String thumbnail);

	public void getRelated(int i_ID, Vector related_item_ids, Vector thumbnails);

}

