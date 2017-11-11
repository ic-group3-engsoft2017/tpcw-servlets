package tpcw.service;

import java.sql.Connection;
import java.util.Vector;

import tpcw.model.Book;
import tpcw.model.Cart;
import tpcw.model.Customer;
import tpcw.model.Order;
import tpcw.repository.TPCW_Database;



public class TPCW_Service implements ITPCW_Service {

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

}
