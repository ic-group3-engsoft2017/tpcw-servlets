package tpcw.group3.service;

import tpcw.group3.model.*;

import java.sql.Date;
import java.util.Vector;


//Interface para abstrair o comportamento de requisição de serviço de dados.
public interface ITPCW_Service {

	Book getBook(int i_id);
	
	Customer getCustomer(String UNAME);
	
	Vector doSubjectSearch(String search_key);
	
	Vector doTitleSearch(String search_key);
	
	Vector doAuthorSearch(String search_key);
	
	Vector getNewProducts(String subject);
	
	Vector getBestSellers(String subject);
	
	Order GetMostRecentOrder(String c_uname, Vector order_lines);
	
	Cart getCart(int SHOPPING_ID, double c_discount);

	void adminUpdate(int i_id, double v, String i_new_image, String i_new_thumbnail);

	BuyConfirmResult doBuyConfirm(int shopping_id, int c_id, String cc_type, long cc_number, String cc_name, Date date, String shipping, String street_1, String street_2, String city, String state, String zip, String country);

	BuyConfirmResult doBuyConfirm(int shopping_id, int c_id, String cc_type, long cc_number, String cc_name, Date date, String shipping);

	void refreshSession(int c_id);

	Customer createNewCustomer(Customer cust);

	String getUserName(int c_idnum);

	String GetPassword(String uname);

	int createEmptyCart();

	Cart doCart(int shopping_id, Integer i_id, Vector ids, Vector quantities);
}

