package tpcw.service;

import java.sql.Connection;
import java.sql.Date;
import java.util.Vector;

import tpcw.model.Book;
import tpcw.model.BuyConfirmResult;
import tpcw.model.Cart;
import tpcw.model.Customer;
import tpcw.model.Order;
import tpcw.repository.TPCW_Database;



public class TPCW_Service implements ITPCW_Service {

    private static TPCW_Service service;

    public static TPCW_Service getInstance() {
        if(service == null) {
            service = new TPCW_Service();
        }
        return service;
    }

	public String[] getName(int c_id) {
		return TPCW_Database.getName(c_id);
	}

	public Book getBook(int i_id) {
		return TPCW_Database.getBook(i_id);
	}

	public Customer getCustomer(String UNAME) {
		return TPCW_Database.getCustomer(UNAME);
	}

	public Vector doSubjectSearch(String search_key) {

		return TPCW_Database.doSubjectSearch(search_key);
	}

	public Vector doTitleSearch(String search_key) {
		return TPCW_Database.doTitleSearch(search_key);
	}

	public Vector doAuthorSearch(String search_key) {
		return TPCW_Database.doAuthorSearch(search_key);
	}

	public Vector getNewProducts(String subject) {
		return TPCW_Database.getNewProducts(subject);
	}

	public Vector getBestSellers(String subject) {
		return TPCW_Database.getBestSellers(subject);
	}

	public Order GetMostRecentOrder(String c_uname, Vector order_lines) {
		return TPCW_Database.GetMostRecentOrder(c_uname, order_lines);
	}

	public Cart getCart(int SHOPPING_ID, double c_discount) {
		return TPCW_Database.getCart(SHOPPING_ID, c_discount);
	}

	public double getCDiscount(Connection con, int c_id) {
		return TPCW_Database.getCDiscount(con, c_id);
	}

	public int getCAddrID(Connection con, int c_id) {
		return TPCW_Database.getCAddrID(con, c_id);
	}

	public int getCAddr(Connection con, int c_id) {
		return TPCW_Database.getCAddr(con, c_id);
	}

	public int getStock(Connection con, int i_id) {

		return TPCW_Database.getStock(con, i_id);
	}
	
	public String GetUserName(int C_ID) {
		return TPCW_Database.GetUserName(C_ID);
	}
	
	public String GetPassword(String c_uname) {
		return TPCW_Database.GetPassword(c_uname);
	}
	
	
	//TODO
	public void getRelated(int i_id, Vector related_item_ids, Vector thumbnails) {
		//return TPCW_Database.getRelated(i_id, related_item_ids, thumbnails);
		return;
	}
	
	public int createEmptyCart() {
		return TPCW_Database.createEmptyCart();
	}
	
	public Cart doCart(int SHOPPING_ID, Integer I_ID, Vector ids, Vector quantities) {
		return TPCW_Database.doCart(SHOPPING_ID, I_ID, ids, quantities);
	}

	//TODO
	public void refreshSession(int C_ID) {
		//return TPCW_Database.refreshSession(C_ID);
		return;
	}
	
	public BuyConfirmResult doBuyConfirm(int shopping_id, int customer_id, String cc_type, long cc_number, String cc_name, Date cc_expiry, String shipping) {
		return TPCW_Database.doBuyConfirm(shopping_id, customer_id, cc_type, cc_number, cc_name, cc_expiry, shipping);
	}
	
	public BuyConfirmResult doBuyConfirm(int shopping_id, int customer_id, String cc_type, long cc_number, String cc_name, Date cc_expiry, String shipping, String street_1, String street_2, String city, String state, String zip, String country) {
		return TPCW_Database.doBuyConfirm(shopping_id, customer_id, cc_type, cc_number, cc_name, cc_expiry, shipping, street_1, street_2, city, state, zip, country);
	}
	
	//TODO	
	public void adminUpdate(int i_id, double cost, String image, String thumbnail) {
		//return TPCW_Database.adminUpdate(i_id, cost, image, thumbnail);
		return;
	}

	public String getUserName(int c_id) {
		return TPCW_Database.GetUserName(c_id);
	}

	public String getPassword(String c_uname) {
		return TPCW_Database.GetPassword(c_uname);
	}

}

