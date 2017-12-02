package tpcw.group3.service;

import tpcw.group3.model.*;

import java.sql.Date;
import java.util.Vector;


/**
 * The interface Itpcw service.
 */
//Interface para abstrair o comportamento de requisição de serviço de dados.
public interface ITPCW_Service {

    /**
     * Gets book.
     *
     * @param i_id the id
     * @return the book
     */
    Book getBook(int i_id);

    /**
     * Gets customer.
     *
     * @param UNAME the uname
     * @return the customer
     */
    Customer getCustomer(String UNAME);

    /**
     * Do subject search vector.
     *
     * @param search_key the search key
     * @return the vector
     */
    Vector doSubjectSearch(String search_key);

    /**
     * Do title search vector.
     *
     * @param search_key the search key
     * @return the vector
     */
    Vector doTitleSearch(String search_key);

    /**
     * Do author search vector.
     *
     * @param search_key the search key
     * @return the vector
     */
    Vector doAuthorSearch(String search_key);

    /**
     * Gets new products.
     *
     * @param subject the subject
     * @return the new products
     */
    Vector getNewProducts(String subject);

    /**
     * Gets best sellers.
     *
     * @param subject the subject
     * @return the best sellers
     */
    Vector getBestSellers(String subject);

    /**
     * Get most recent order order.
     *
     * @param c_uname     the c uname
     * @param order_lines the order lines
     * @return the order
     */
    Order GetMostRecentOrder(String c_uname, Vector order_lines);

    /**
     * Gets cart.
     *
     * @param SHOPPING_ID the shopping id
     * @param c_discount  the c discount
     * @return the cart
     */
    Cart getCart(int SHOPPING_ID, double c_discount);

    /**
     * Admin update.
     *
     * @param i_id            the id
     * @param v               the v
     * @param i_new_image     the new image
     * @param i_new_thumbnail the new thumbnail
     */
    void adminUpdate(int i_id, double v, String i_new_image, String i_new_thumbnail);

    /**
     * Do buy confirm buy confirm result.
     *
     * @param shopping_id the shopping id
     * @param c_id        the c id
     * @param cc_type     the cc type
     * @param cc_number   the cc number
     * @param cc_name     the cc name
     * @param date        the date
     * @param shipping    the shipping
     * @param street_1    the street 1
     * @param street_2    the street 2
     * @param city        the city
     * @param state       the state
     * @param zip         the zip
     * @param country     the country
     * @return the buy confirm result
     */
    BuyConfirmResult doBuyConfirm(int shopping_id, int c_id, String cc_type, long cc_number, String cc_name, Date date, String shipping, String street_1, String street_2, String city, String state, String zip, String country);

    /**
     * Do buy confirm buy confirm result.
     *
     * @param shopping_id the shopping id
     * @param c_id        the c id
     * @param cc_type     the cc type
     * @param cc_number   the cc number
     * @param cc_name     the cc name
     * @param date        the date
     * @param shipping    the shipping
     * @return the buy confirm result
     */
    BuyConfirmResult doBuyConfirm(int shopping_id, int c_id, String cc_type, long cc_number, String cc_name, Date date, String shipping);

    /**
     * Refresh session.
     *
     * @param c_id the c id
     */
    void refreshSession(int c_id);

    /**
     * Create new customer customer.
     *
     * @param cust the cust
     * @return the customer
     */
    Customer createNewCustomer(Customer cust);

    /**
     * Gets user name.
     *
     * @param c_idnum the c idnum
     * @return the user name
     */
    String getUserName(int c_idnum);

    /**
     * Get password string.
     *
     * @param uname the uname
     * @return the string
     */
    String GetPassword(String uname);

    /**
     * Create empty cart int.
     *
     * @return the int
     */
    int createEmptyCart();

    /**
     * Do cart cart.
     *
     * @param shopping_id the shopping id
     * @param i_id        the id
     * @param ids         the ids
     * @param quantities  the quantities
     * @return the cart
     */
    Cart doCart(int shopping_id, Integer i_id, Vector ids, Vector quantities);
}

