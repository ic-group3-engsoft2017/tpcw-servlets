package tpcw.service;

import org.junit.Test;

import tpcw.group3.servlets.TPCW_admin_request_servlet;
import tpcw.group3.servlets.TPCW_admin_response_servlet;
import tpcw.group3.servlets.TPCW_best_sellers_servlet;
import tpcw.group3.servlets.TPCW_buy_confirm_servlet;
import tpcw.group3.servlets.TPCW_buy_request_servlet;
import tpcw.group3.servlets.TPCW_customer_registration_servlet;
import tpcw.group3.servlets.TPCW_execute_search;
import tpcw.group3.servlets.TPCW_new_products_servlet;
import tpcw.group3.servlets.TPCW_order_display_servlet;
import tpcw.group3.servlets.TPCW_product_detail_servlet;
//import tpcw.group3.servlets.TPCW_say_hello;
import tpcw.group3.servlets.TPCW_shopping_cart_interaction;

import com.meterware.httpunit.PostMethodWebRequest;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;
import com.meterware.servletunit.InvocationContext;
import com.meterware.servletunit.ServletRunner;
import com.meterware.servletunit.ServletUnitClient;

import static org.junit.Assert.*;

/**
 * Classe para cobertura de testes dos seguintes servlets:
 * TPCW_say_hello
 * TPCW_admin_request_servlet
 * TPCW_admin_response_servlet
 * TPCW_product_detail_servlet
 * TPCW_buy_request_servlet --> CANDIDATO A CACHE
 * TPCW_execute_search
 * TPCW_new_products_servlet
 * TPCW_best_sellers_servlet --> CANDIDATO A CACHE
 * TPCW_order_display_servlet
 * TPCW_buy_confirm_servlet
 * TPCW_customer_registration_servlet
 * TPCW_promotional_processing
 * TPCW_shopping_cart_interaction --> CANDIDATO A CACHE
 * TPCW_buy_request_servlet
 */


public class TPCW_ServiceTest {
		
	ServletRunner sr = new ServletRunner();
	ServletUnitClient sc = sr.newClient();

	
	/**
	 * TODO: servlet nao tem doGet 
	 * Teste para login de usuario
	 * TPCW_say_hello
	 * @throws Exception
	 */
    @Test
    public void getName() throws Exception { 
    	    	 	
    	//Inicio testes para TPCW_say_hello
    	//sr.registerServlet("TPCW_say_hello", TPCW_say_hello.class.getName()); 
    	WebRequest request = new PostMethodWebRequest("http://localhost:8080/TPCW_say_hello"); // TODO trocar para endereco da amazon
 
	    try {
	    	//request.setParameter( "c_id", "999" );
	    	InvocationContext ic = sc.newInvocation( request );
			WebResponse response = ic.getServletResponse();
			assertNotNull( "No response received", response.getText());
			assertEquals( "content type", "text/plain", response.getContentType() );    	  	        		    		       	        
	    }
	    catch (Exception e){
	        fail("Error testing method getName from TPCW_say_hello. Exception is  " + e);
	        e.printStackTrace();
	    }
    	//Fim testes para TPCW_say_hello
    	  	    	
    	//service.getName(c_id);
     	   	
    }

    /**
     * Teste para consulta de livro
     * TPCW_admin_request_servlet
     * TPCW_admin_response_servlet
     * TPCW_product_detail_servlet
     * @throws Exception
     */
    @Test
    public void getBook() throws Exception {
    	
    	//Inicio testes para TPCW_admin_request_servlet
    	sr.registerServlet("TPCW_admin_request_servlet", TPCW_admin_request_servlet.class.getName());
    	WebRequest request = new PostMethodWebRequest("http://localhost:8080/TPCW_admin_request_servlet"); // TODO trocar para endereco da amazon    	
	    try {    		        
	        InvocationContext ic = sc.newInvocation( request );
	        WebResponse response = ic.getServletResponse();
	        assertNotNull( "No response received", response.getText());
	        assertEquals( "content type", "text/plain", response.getContentType() );       	        
	    }
	    catch (Exception e){
	        fail("Error testing method getName from TPCW_admin_request_servlet. Exception is  " + e);
	        e.printStackTrace();
	    }
    	//Fim testes para TPCW_admin_request_servlet
    	 	   	
    	//Inicio testes para TPCW_admin_response_servlet
    	sr.registerServlet("TPCW_admin_response_servlet", TPCW_admin_response_servlet.class.getName());
    	WebRequest request2 = new PostMethodWebRequest("http://localhost:8080/TPCW_admin_response_servlet"); // TODO trocar para endereco da amazon
   	 
	    try {    	
	    	 InvocationContext ic = sc.newInvocation( request2 );
		     WebResponse response = ic.getServletResponse();
		     assertNotNull( "No response received", response.getText());
		     assertEquals( "content type", "text/plain", response.getContentType() );     	        
	    }
	    catch (Exception e){
	        fail("Error testing method getName from TPCW_admin_response_servlet. Exception is  " + e);
	        e.printStackTrace();
	    }
    	//Fim testes para TPCW_admin_response_servlet
    	    	
    	//Inicio testes para TPCW_product_detail_servlet
    	sr.registerServlet("TPCW_product_detail_servlet", TPCW_product_detail_servlet.class.getName());
    	WebRequest request3 = new PostMethodWebRequest("http://localhost:8080/TPCW_product_detail_servlet"); // TODO trocar para endereco da amazon
   	 
	    try {    	
	    	 InvocationContext ic = sc.newInvocation( request3 );
		     WebResponse response = ic.getServletResponse();
		     assertNotNull( "No response received", response.getText());
		     assertEquals( "content type", "text/plain", response.getContentType() );  	        
	    }
	    catch (Exception e){
	        fail("Error testing method getName from TPCW_product_detail_servlet. Exception is  " + e);
	        e.printStackTrace();
	    }
    	//Fim testes para TPCW_product_detail_servlet		

    	//service.getBook(i_id);
    }

    /**
     * Teste para obtencao de cliente
     * TPCW_buy_request_servlet
     * @throws Exception
     */
    @Test
    public void getCustomer() throws Exception {
    	
    	//Inicio testes para TPCW_buy_request_servlet
    	sr.registerServlet("TPCW_buy_request_servlet", TPCW_buy_request_servlet.class.getName());
    	WebRequest request = new PostMethodWebRequest("http://localhost:8080/TPCW_buy_request_servlet"); // TODO trocar para endereco da amazon
      	 
	    try {    	
	    	 InvocationContext ic = sc.newInvocation( request );
		     WebResponse response = ic.getServletResponse();
		     assertNotNull( "No response received", response.getText());
		     assertEquals( "content type", "text/plain", response.getContentType() );    	        
	    }
	    catch (Exception e){
	        fail("Error testing method getName from TPCW_buy_request_servlet. Exception is  " + e);
	        e.printStackTrace();
	    }
    	//Fim testes para TPCW_buy_request_servlet
    	
    	//service.getCustomer(UNAME);
    }

    /**
     * Teste para busca de livro por topico/categoria
     * TPCW_execute_search
     * @throws Exception
     */
    @Test
    public void doSubjectSearch() throws Exception {
    	
    	//Inicio testes para TPCW_execute_search
    	sr.registerServlet("TPCW_execute_search", TPCW_execute_search.class.getName());
    	WebRequest request = new PostMethodWebRequest("http://localhost:8080/TPCW_execute_search"); // TODO trocar para endereco da amazon
     	 
	    try {    	
	    	 InvocationContext ic = sc.newInvocation( request );
		     WebResponse response = ic.getServletResponse();
		     assertNotNull( "No response received", response.getText());
		     assertEquals( "content type", "text/plain", response.getContentType() );    	     	        
	    }
	    catch (Exception e){
	        fail("Error testing method getName from TPCW_execute_search. Exception is  " + e);
	        e.printStackTrace();
	    }
    	//Fim testes para TPCW_execute_search
    	
    	//service.doSubjectSearch(search_key);
    }

    /**
     * Teste para a busca de livro por titulo
     * TPCW_execute_search
     * @throws Exception
     */
    @Test
    public void doTitleSearch() throws Exception {
    	
    	//Inicio testes para TPCW_execute_search
    	sr.registerServlet("TPCW_execute_search", TPCW_execute_search.class.getName());
    	WebRequest request = new PostMethodWebRequest("http://localhost:8080/TPCW_execute_search"); // TODO trocar para endereco da amazon
    	 
	    try {    	
	    	 InvocationContext ic = sc.newInvocation( request );
		     WebResponse response = ic.getServletResponse();
		     assertNotNull( "No response received", response.getText());
		     assertEquals( "content type", "text/plain", response.getContentType() );    	 	        
	    }
	    catch (Exception e){
	        fail("Error testing method getName from TPCW_execute_search. Exception is  " + e);
	        e.printStackTrace();
	    }
    	//Fim testes para TPCW_execute_search
    	
    	//service.doTitleSearch(search_key);
    }

    /**
     * Teste para a busca de livro por autor
     * TPCW_execute_search
     * @throws Exception
     */
    @Test
    public void doAuthorSearch() throws Exception {
    	
    	//Inicio testes para TPCW_execute_search
    	sr.registerServlet("TPCW_execute_search", TPCW_execute_search.class.getName());
    	WebRequest request = new PostMethodWebRequest("http://localhost:8080/TPCW_execute_search"); // TODO trocar para endereco da amazon
   	 
	    try {    	
	    	 InvocationContext ic = sc.newInvocation( request );
		     WebResponse response = ic.getServletResponse();
		     assertNotNull( "No response received", response.getText());
		     assertEquals( "content type", "text/plain", response.getContentType() );    	   	        
	    }
	    catch (Exception e){
	        fail("Error testing method getName from TPCW_execute_search. Exception is  " + e);
	        e.printStackTrace();
	    }
    	//Fim testes para TPCW_execute_search
    	
    	//service.doAuthorSearch(search_key);
    }

    /**
     * Teste para obter novos livros
     * TPCW_new_products_servlet
     * @throws Exception
     */
    @Test
    public void getNewProducts() throws Exception {
    	
    	//Inicio testes para TPCW_new_products_servlet
    	sr.registerServlet("TPCW_new_products_servlet", TPCW_new_products_servlet.class.getName());
    	WebRequest request = new PostMethodWebRequest("http://localhost:8080/TPCW_new_products_servlet"); // TODO trocar para endereco da amazon
      	 
	    try {    	
	    	 InvocationContext ic = sc.newInvocation( request );
		     WebResponse response = ic.getServletResponse();
		     assertNotNull( "No response received", response.getText());
		     assertEquals( "content type", "text/plain", response.getContentType() );    	    	        
	    }
	    catch (Exception e){
	        fail("Error testing method getName from TPCW_new_products_servlet. Exception is  " + e);
	        e.printStackTrace();
	    }
    	//Fim testes para TPCW_new_products_servlet
    	
    	//service.getNewProducts(subject);
    }

    /**
     * Teste para as melhores vendas
     * TPCW_best_sellers_servlet
     * @throws Exception
     */
    @Test
    public void getBestSellers() throws Exception {
    	
    	//Inicio testes para TPCW_best_sellers_servlet
    	sr.registerServlet("TPCW_best_sellers_servlet", TPCW_best_sellers_servlet.class.getName());
    	WebRequest request = new PostMethodWebRequest("http://localhost:8080/TPCW_best_sellers_servlet"); // TODO trocar para endereco da amazon
     	 
	    try {    	
	    	 InvocationContext ic = sc.newInvocation( request );
		     WebResponse response = ic.getServletResponse();
		     assertNotNull( "No response received", response.getText());
		     assertEquals( "content type", "text/plain", response.getContentType() );    	         
	    }
	    catch (Exception e){
	        fail("Error testing method getName from TPCW_best_sellers_servlet. Exception is  " + e);
	        e.printStackTrace();
	    }
    	//Fim testes para TPCW_best_sellers_servlet
    	
    	//service.getBestSellers(subject);
    }

    /**
     * Teste para as compras mais recentes
     * TPCW_order_display_servlet
     * @throws Exception
     */
    @Test
    public void getMostRecentOrder() throws Exception {
    	
    	//Inicio testes para TPCW_best_sellers_servlet
    	sr.registerServlet("TPCW_order_display_servlet", TPCW_order_display_servlet.class.getName());
    	WebRequest request = new PostMethodWebRequest("http://localhost:8080/TPCW_order_display_servlet"); // TODO trocar para endereco da amazon
    	 
	    try {    	
	    	 InvocationContext ic = sc.newInvocation( request );
		     WebResponse response = ic.getServletResponse();
		     assertNotNull( "No response received", response.getText());
		     assertEquals( "content type", "text/plain", response.getContentType() );    	    	        
	    }
	    catch (Exception e){
	        fail("Error testing method getName from TPCW_order_display_servlet. Exception is  " + e);
	        e.printStackTrace();
	    }
    	//Fim testes para TPCW_order_display_servlet
    	
    	//service.GetMostRecentOrder(c_uname, order_lines);
    }

    /**
     * Teste para a requisicao de compra
     * TPCW_buy_request_servlet
     * @throws Exception
     */
    @Test
    public void getCart() throws Exception {
    	
    	//Inicio testes para TPCW_buy_request_servlet
    	sr.registerServlet("TPCW_buy_request_servlet", TPCW_buy_request_servlet.class.getName());
    	WebRequest request = new PostMethodWebRequest("http://localhost:8080/TPCW_buy_request_servlet"); // TODO trocar para endereco da amazon
   	 
	    try {    	
	    	 InvocationContext ic = sc.newInvocation( request );
		     WebResponse response = ic.getServletResponse();
		     assertNotNull( "No response received", response.getText());
		     assertEquals( "content type", "text/plain", response.getContentType() );    	     	        
	    }
	    catch (Exception e){
	        fail("Error testing method getName from TPCW_buy_request_servlet. Exception is  " + e);
	        e.printStackTrace();
	    }
    	//Fim testes para TPCW_buy_request_servlet
    	
    	//service.getCart(SHOPPING_ID, c_discount);
    }

    /*
    @Test
    public void getCDiscount() throws Exception {
    }

    @Test
    public void getCAddrID() throws Exception {
    }

    @Test
    public void getCAddr() throws Exception {
    }

    @Test
    public void getStock() throws Exception {
    }
    
    */
    /**
     * Teste para a confirmacao de compra
     * TPCW_buy_confirm_servlet
     * @throws Exception
     */
    @Test
    public void doBuyConfirm() throws Exception {  

    	//Inicio testes para TPCW_buy_confirm_servlet
    	sr.registerServlet("TPCW_buy_confirm_servlet", TPCW_buy_confirm_servlet.class.getName());
    	WebRequest request = new PostMethodWebRequest("http://localhost:8080/TPCW_buy_confirm_servlet"); // TODO trocar para endereco da amazon
      	 
	    try {    	
	    	 InvocationContext ic = sc.newInvocation( request );
		     WebResponse response = ic.getServletResponse();
		     assertNotNull( "No response received", response.getText());
		     assertEquals( "content type", "text/plain", response.getContentType() );    	   	        
	    }
	    catch (Exception e){
	        fail("Error testing method getName from TPCW_buy_request_servlet. Exception is  " + e);
	        e.printStackTrace();
	    }
    	//Fim testes para TPCW_buy_confirm_servlet
    	
    	
    	//service.doBuyConfirm(shopping_id, customer_id, cc_type, cc_number, cc_name, cc_expiry, shipping, street_1, street_2, city, state, zip, country);
    	
    	//service.doBuyConfirm(shopping_id, customer_id, cc_type, cc_number, cc_name, cc_expiry, shipping);
    }
    
    /**
     * Teste para o registro de cliente
     * TPCW_customer_registration_servlet
     * @throws Exception
     */
    //@Test
    public void getUserName() throws Exception { 
    	
    	//Inicio testes para TPCW_customer_registration_servlet
    	sr.registerServlet("TPCW_customer_registration_servlet", TPCW_customer_registration_servlet.class.getName());
    	WebRequest request = new PostMethodWebRequest("http://localhost:8080/TPCW_customer_registration_servlet"); // TODO trocar para endereco da amazon
     	 
	    try {    	
	    	 InvocationContext ic = sc.newInvocation( request );
		     WebResponse response = ic.getServletResponse();
		     assertNotNull( "No response received", response.getText());
		     assertEquals( "content type", "text/plain", response.getContentType() );    	  	        
	    }
	    catch (Exception e){
	        fail("Error testing method getName from TPCW_customer_registration_servlet. Exception is  " + e);
	        e.printStackTrace();
	    }
    	//Fim testes para TPCW_customer_registration_servlet
    	
    	//service.getUserName(c_id);
    }
    
    /**
     * Teste para acesso do usuario com senha
     * TPCW_order_display_servlet
     */
    @Test
    public void getPassword() throws Exception {
    	
    	//Inicio testes para TPCW_order_display_servlet
    	sr.registerServlet("TPCW_order_display_servlet", TPCW_order_display_servlet.class.getName());
    	WebRequest request = new PostMethodWebRequest("http://localhost:8080/TPCW_order_display_servlet"); // TODO trocar para endereco da amazon
    	 
	    try {    	
	    	 InvocationContext ic = sc.newInvocation( request );
		     WebResponse response = ic.getServletResponse();
		     assertNotNull( "No response received", response.getText());
		     assertEquals( "content type", "text/plain", response.getContentType() );    	  	        
	    }
	    catch (Exception e){
	        fail("Error testing method getName from TPCW_order_display_servlet. Exception is  " + e);
	        e.printStackTrace();
	    }
    	//Fim testes para TPCW_order_display_servlet
    	
    	//service.getPassword(c_uname);
    	
    }
        
    /**
     * Teste para carrinho vazio
     * TPCW_shopping_cart_interaction
     * @throws Exception
     */
    @Test
    public void createEmptyCart() throws Exception {
    	
    	//Inicio testes para TPCW_shopping_cart_interaction
    	sr.registerServlet("TPCW_shopping_cart_interaction", TPCW_shopping_cart_interaction.class.getName());
    	WebRequest request = new PostMethodWebRequest("http://localhost:8080/TPCW_shopping_cart_interaction"); // TODO trocar para endereco da amazon
   	 
	    try {    	
	    	 InvocationContext ic = sc.newInvocation( request );
		     WebResponse response = ic.getServletResponse();
		     assertNotNull( "No response received", response.getText());
		     assertEquals( "content type", "text/plain", response.getContentType() );    	  	        
	    }
	    catch (Exception e){
	        fail("Error testing method getName from TPCW_shopping_cart_interaction. Exception is  " + e);
	        e.printStackTrace();
	    }
    	//Fim testes para TPCW_shopping_cart_interaction
    	
    	//service.createEmptyCart();
    	
    }
    
    /**
     * Teste para carrinho cheio
     * TPCW_shopping_cart_interaction
     * @throws Exception
     */
    @Test
    public void doCart() throws Exception {
    	
    	//Inicio testes para TPCW_shopping_cart_interaction
    	sr.registerServlet("TPCW_shopping_cart_interaction", TPCW_shopping_cart_interaction.class.getName());
    	WebRequest request = new PostMethodWebRequest("http://localhost:8080/TPCW_shopping_cart_interaction"); // TODO trocar para endereco da amazon
    	 
	    try {    	
	    	 InvocationContext ic = sc.newInvocation( request );
		     WebResponse response = ic.getServletResponse();
		     assertNotNull( "No response received", response.getText());
		     assertEquals( "content type", "text/plain", response.getContentType() );     	        
	    }
	    catch (Exception e){
	        fail("Error testing method getName from TPCW_shopping_cart_interaction. Exception is  " + e);
	        e.printStackTrace();
	    }
    	//Fim testes para TPCW_shopping_cart_interaction
    	
    	//service.doCart(SHOPPING_ID, I_ID, ids, quantities);
    	
    }
    
    //TODO
    /**
     * TPCW_buy_request_servlet
     * @throws Exception
     */
    @Test
    public void refreshSession() throws Exception {      	
    }  

    //TODO
    /**
     * TPCW_admin_response_servlet
     * @throws Exception
     */
    @Test
    public void adminUpdate() throws Exception {    	   	
    }
     
    //TODO
    /**Servlet n�o tem doGet
     * TPCW_promotional_processing
     * @throws Exception
     */
    @Test
    public void getRelated() throws Exception {  	      	
    }

}