package tpcw.service;

import java.awt.print.Book;
import java.sql.Connection;
import java.util.Vector;

import tpcw.model.Cart;
import tpcw.model.Customer;
import tpcw.model.Order;

public class TPCW_Service implements ITPCW_Service {

	public TPCW_Service() {
		// TODO Auto-generated constructor stub
	}

	public String[] getName(int c_id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Book getBook(int i_id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Customer getCustomer(String UNAME) {
		// TODO Auto-generated method stub
		return null;
	}

	public Vector doSubjectSearch(String search_key) {
		// TODO Auto-generated method stub
		return null;
	}

	public Vector doTitleSearch(String search_key) {
		// TODO Auto-generated method stub
		return null;
	}

	public Vector doAuthorSearch(String search_key) {
		// TODO Auto-generated method stub
		return null;
	}

	public Vector getNewProducts(String subject) {
		// TODO Auto-generated method stub
		return null;
	}

	public Vector getBestSellers(String subject) {
		// TODO Auto-generated method stub
		return null;
	}

	public Order GetMostRecentOrder(String c_uname, Vector order_lines) {
		// TODO Auto-generated method stub
		return null;
	}

	public Cart getCart(int SHOPPING_ID, double c_discount) {
		// TODO Auto-generated method stub
		return null;
	}

	public double getCDiscount(Connection con, int c_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getCAddrID(Connection con, int c_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getCAddr(Connection con, int c_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getStock(Connection con, int i_id) {
		// TODO Auto-generated method stub
		return 0;
	}

}
