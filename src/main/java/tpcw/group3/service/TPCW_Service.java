package tpcw.group3.service;


import tpcw.group3.cache.model.CachableEntity;
import tpcw.group3.cache.service.BookCacheCriteriaService;
import tpcw.group3.cache.service.CacheCriteria;
import tpcw.group3.cache.service.ITPCW_Cache;
import tpcw.group3.cache.service.TPCW_Cache;
import tpcw.group3.model.*;
import tpcw.group3.repository.TPCW_Database;

import java.sql.Date;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;
import java.util.Vector;

import static tpcw.group3.cache.model.criteria.builder.BookCriteriaBuilder.builder;


public class TPCW_Service implements ITPCW_Service {

    public TPCW_Service() {
        this.cache = TPCW_Cache.getInstance();
        this.database = TPCW_Database.getInstance();
        this.bookCacheService = BookCacheCriteriaService.getInstance();
    }

    private static TPCW_Service service;

    public static TPCW_Service getInstance() {
        if(service == null) {
            service = new TPCW_Service();
        }
        return service;
    }
    
    private ITPCW_Cache cache;
    private TPCW_Database database;
    private CacheCriteria bookCacheService;

	public String[] getName(int c_id) {
		return TPCW_Database.getInstance().getName(c_id);
	}

	public Book getBook(int i_id) {
		return TPCW_Database.getInstance().getBook(i_id);
	}

	public Customer getCustomer(String UNAME) {
		return TPCW_Database.getInstance().getCustomer(UNAME);
	}

	public Vector doSubjectSearch(String search_key) {

		return TPCW_Database.getInstance().doSubjectSearch(search_key);
	}

	public Vector doTitleSearch(String search_key) {
		return TPCW_Database.getInstance().doTitleSearch(search_key);
	}

	public Vector doAuthorSearch(String search_key) {

        List<CachableEntity> listForCriteria = bookCacheService.getByCriteria(
                builder().withAuthorLastName(search_key)
                        .build());

		return TPCW_Database.getInstance().doAuthorSearch(search_key);
	}

	public Vector getNewProducts(String subject) {
		return TPCW_Database.getInstance().getNewProducts(subject);
	}
	public Vector getBestSellers(String subject) {
		return TPCW_Database.getInstance().getBestSellers(subject);
	}

	public Order GetMostRecentOrder(String c_uname, Vector order_lines) {
		return TPCW_Database.getInstance().GetMostRecentOrder(c_uname, order_lines);
	}

	public Cart getCart(int SHOPPING_ID, double c_discount) {
		return TPCW_Database.getInstance().getCart(SHOPPING_ID, c_discount);
	}

	public double getCDiscount(int c_id) {
		return TPCW_Database.getInstance().getCDiscount(c_id);
	}

	public int getCAddrID(int c_id) {
		return TPCW_Database.getInstance().getCAddrID(c_id);
	}

	public int getCAddr(int c_id) {
		return TPCW_Database.getInstance().getCAddr(c_id);
	}

	public int getStock(int i_id) {

		return TPCW_Database.getInstance().getStock(i_id);
	}

	@Override
	public void adminUpdate(int i_id, double v, String i_new_image, String i_new_thumbnail) {
		TPCW_Database.getInstance().adminUpdate(i_id, v, i_new_image, i_new_thumbnail);
	}

	@Override
	public BuyConfirmResult doBuyConfirm(int shopping_id, int c_id, String cc_type, long cc_number, String cc_name, Date date, String shipping, String street_1, String street_2, String city, String state, String zip, String country) {
		return TPCW_Database.getInstance().doBuyConfirm(shopping_id, c_id, cc_type, cc_number, cc_name, date, shipping, street_1, street_2, city, state, zip, country);
	}

	@Override
	public BuyConfirmResult doBuyConfirm(int shopping_id, int c_id, String cc_type, long cc_number, String cc_name, Date date, String shipping) {
		return TPCW_Database.getInstance().doBuyConfirm(shopping_id, c_id, cc_type, cc_number, cc_name, date, shipping);
	}

	@Override
	public void refreshSession(int c_id) {
		TPCW_Database.getInstance().refreshSession(c_id);
	}

	@Override
	public Customer createNewCustomer(Customer cust) {
		return TPCW_Database.getInstance().createNewCustomer(cust);
	}

	@Override
	public String getUserName(int c_idnum) {
		return TPCW_Database.getInstance().GetUserName(c_idnum);
	}

	@Override
	public String GetPassword(String uname) {
		return TPCW_Database.getInstance().GetPassword(uname);
	}

	@Override
	public void getRelated(int i_id, Vector related_item_ids, Vector thumbnails) {

	}

	@Override
	public int createEmptyCart() {
		return 0;
	}

	@Override
	public Cart doCart(int shopping_id, Integer i_id, Vector ids, Vector quantities) {
		return null;
	}
}
