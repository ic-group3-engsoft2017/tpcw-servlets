package tpcw;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/* @WebFilter(name = "tpcw.Medidor", servletNames = { "TPCW_admin_request_servlet",
 "TPCW_admin_response_servlet", "TPCW_buy_confirm_servlet",
  "TPCW_buy_request_servlet", "TPCW_customer_registration_servlet",
  "TPCW_execute_search", "TPCW_home_interaction", "TPCW_new_products_servlet",
  "TPCW_order_display_servlet", "TPCW_order_inquiry_servlet",
  "TPCW_product_detail_servlet", "TPCW_search_request_servlet",
  "TPCW_shopping_cart_interaction" })*/

@WebFilter("/*")
public class Medidor implements Filter {
	static final Logger logger = Logger.getLogger(Medidor.class.getName());

	public void destroy() { // TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		Long tempoInicial = System.nanoTime();

		chain.doFilter(request, response);

		Long tempoFinal = System.nanoTime();
		String uri = ((HttpServletRequest) request).getRequestURI();

		logger.log(Level.SEVERE, "Tempo da requisicao de " + uri + " demorou (ms): "
				+ (tempoFinal - tempoInicial));
		/*System.out.println("Tempo da requisicao de " + uri + " demorou (ms): "
				+ (tempoFinal - tempoInicial));*/
	}

	public void init(FilterConfig arg0) throws ServletException { // TODO

	}

}
