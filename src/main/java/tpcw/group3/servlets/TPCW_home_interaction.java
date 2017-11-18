package tpcw.group3.servlets;/*
 * tpcw.servlets.TPCW_home_interaction.java - Servlet Class implements home interaction.
 *
 ************************************************************************
 *
 * This is part of the the Java TPC-W distribution,
 * written by Harold Cain, Tim Heil, Milo Martin, Eric Weglarz, and Todd
 * Bezenek.  University of Wisconsin - Madison, Computer Sciences
 * Dept. and Dept. of Electrical and Computer Engineering, as a part of
 * Prof. Mikko Lipasti's Fall 1999 ECE 902 course.
 *
 * Copyright (C) 1999, 2000 by Harold Cain, Timothy Heil, Milo Martin, 
 *                             Eric Weglarz, Todd Bezenek.
 *
 * This source code is distributed "as is" in the hope that it will be
 * useful.  It comes with no warranty, and no author or distributor
 * accepts any responsibility for the consequences of its use.
 *
 * Everyone is granted permission to copy, modify and redistribute
 * this code under the following conditions:
 *
 * This code is distributed for non-commercial use only.
 * Please contact the maintainer for restrictions applying to 
 * commercial use of these tools.
 *
 * Permission is granted to anyone to make or distribute copies
 * of this code, either as received or modified, in any
 * medium, provided that all copyright notices, permission and
 * nonwarranty notices are preserved, and that the distributor
 * grants the recipient permission for further redistribution as
 * permitted by this document.
 *
 * Permission is granted to distribute this code in compiled
 * or executable form under the same conditions that apply for
 * source code, provided that either:
 *
 * A. it is accompanied by the corresponding machine-readable
 *    source code,
 * B. it is accompanied by a written offer, with no time limit,
 *    to give anyone a machine-readable copy of the corresponding
 *    source code in return for reimbursement of the cost of
 *    distribution.  This written offer must permit verbatim
 *    duplication by anyone, or
 * C. it is distributed by someone who received only the
 *    executable form, and is accompanied by a copy of the
 *    written offer of source code that they received concurrently.
 *
 * In other words, you are welcome to use, share and improve this codes.
 * You are forbidden to forbid anyone else to use, share and improve what
 * you give them.
 *
 ************************************************************************/

import tpcw.group3.service.TPCW_promotional_processing;
import tpcw.group3.service.TPCW_say_hello;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class TPCW_home_interaction extends HttpServlet {
    
  public void doGet(HttpServletRequest req, HttpServletResponse res)
    throws IOException, ServletException {
      int i;	
      String url;
      Vector column1 = new Vector();
      Vector column2 = new Vector();

      column1.addElement("ARTS");//1
      column2.addElement("NON-FICTION");
      column1.addElement("BIOGRAPHIES");//2
      column2.addElement("PARENTING");
      column1.addElement("BUSINESS");//3
      column2.addElement("POLITICS");
      column1.addElement("CHILDREN");//4
      column2.addElement("REFERENCE");
      column1.addElement("COMPUTERS");//5
      column2.addElement("RELIGION");
      column1.addElement("COOKING");//6
      column2.addElement("ROMANCE");
      column1.addElement("HEALTH");//7
      column2.addElement("SELF-HELP");
      column1.addElement("HISTORY");//8
      column2.addElement("SCIENCE-NATURE");
      column1.addElement("HOME");//9
      column2.addElement("SCIENCE-FICTION");
      column1.addElement("HUMOR");//10
      column2.addElement("SPORTS");
      column1.addElement("LITERATURE");//11
      column2.addElement("MYSTERY");

      /*SERVLET SETUP*/
      HttpSession session = req.getSession(false);
      if(session == null)
	  session = req.getSession(true);
      // This must be after the getSession() call.
      PrintWriter out = res.getWriter();
      // Set the content type of this servlet's result.
      res.setContentType("text/html");

      //int C_ID = -1;
      //int SHOPPING_ID = -1;
      String C_ID = req.getParameter("C_ID");
      String SHOPPING_ID = req.getParameter("SHOPPING_ID");

      //Generate Home Page Head
      out.print("<HTML> <HEAD> <TITLE>TPC-W Home Page</TITLE></HEAD>\n");
      out.print("<BODY BGCOLOR=\"#ffffff\">\n"); 
      out.print("<H1 ALIGN=\"center\">TPC Web Commerce Benchmark (TPC-W)</H1>\n");
      out.print("<P ALIGN=\"CENTER\">\n");
      out.print("<IMG SRC=\"../tpcw/Images/tpclogo.gif\" ALIGN=\"BOTTOM\""+ 
		"BORDER=\"0\" WIDTH=\"288\" HEIGHT=\"67\"></P>\n");
      out.print("<H2 ALIGN=\"center\">Home Page</H2>\n");
      

      //Say Hello!
      // Does not need caching due to session caching the attributes
      TPCW_say_hello.print_hello(session, req, out);

      //Insert the promotional processing
      TPCW_promotional_processing.DisplayPromotions(out, req, res,-1);

      //Generate Table of What's New and BestSellers
      //Table headings
      out.print("<TABLE ALIGN=\"center\" BGCOLOR=\"#c0c0c0\" BORDER=\"0\""+
		" CELLPADDING=\"6\" CELLSPACING=\"0\" WIDTH=\"700\">\n");
      out.print("<TR ALIGN=\"CENTER\" BGCOLOR=\"#ffffff\" VALIGN=\"top\">\n");
      out.print("<TD COLSPAN=\"2\" VALIGN=\"MIDDLE\" WIDTH=\"300\">\n");
      out.print("<IMG SRC=\"../tpcw/Images/whats_new.gif\""+ 
		" ALT=\"New Product\">\n");
      out.print("</TD>\n");
      out.print("<TD BGCOLOR=\"#ffffff\" WIDTH=\"100\"></TD>\n");
      out.print("<TD COLSPAN=\"2\" WIDTH=\"300\">\n");
      out.print("<IMG SRC=\"../tpcw/Images/best_sellers.gif\""+
		" ALT=\"Best Seller\"></TD></TR>\n");
      
      for(i = 0; i < column1.size(); i++){
	  out.print("<TR><TD><P ALIGN=\"center\">");
	  url = "tpcw.servlets.TPCW_new_products_servlet";
	  url = url+"?subject=" + column1.elementAt(i);
	  if(SHOPPING_ID != null)
	      url = url + "&SHOPPING_ID=" + SHOPPING_ID;
	  if(C_ID != null)
	      url = url+"&C_ID=" + C_ID;
	  out.print("<A HREF=\"" +res.encodeUrl(url));
	  
	  out.print("\">" + column1.elementAt(i) + "</A></P></TD>\n");
	  url = "tpcw.servlets.TPCW_new_products_servlet";
	  url = url+"?subject=" +column2.elementAt(i);
	  if(SHOPPING_ID != null)
	      url = url + "&SHOPPING_ID=" + SHOPPING_ID;
	  if(C_ID != null)
	      url = url+"&C_ID=" + C_ID;
	  
	  out.print("<TD><P ALIGN=\"center\"><A HREF=\""+ 
		    res.encodeUrl(url));
	  
	  
	  out.print("\">" + column2.elementAt(i)+"</A></P></TD>\n");
	  out.print("<TD BGCOLOR=\"#ffffff\" WIDTH=\"50\"></TD>\n");
	  out.print("<TD> <P ALIGN=\"center\">");
	  url = "tpcw.servlets.TPCW_best_sellers_servlet";
	  url = url + "?subject=" + column1.elementAt(i);
	  if(SHOPPING_ID != null)
	      url = url + "&SHOPPING_ID=" + SHOPPING_ID;
	  if(C_ID != null)
	      url = url+"&C_ID=" + C_ID;
	  
	  out.print("<A HREF=\"" + res.encodeUrl(url));
	  
	  out.print("\">" + column1.elementAt(i) + "</A></P></TD>\n");
	  
	  url = "tpcw.servlets.TPCW_best_sellers_servlet";
	  url = url + "?subject=" + column2.elementAt(i);
	  if(SHOPPING_ID != null)
	      url = url + "&SHOPPING_ID=" + SHOPPING_ID;
	  if(C_ID != null)
	      url = url+"&C_ID=" + C_ID;
	  
	  out.print("<TD><P ALIGN=\"center\"><A HREF=\"" + 
		    res.encodeUrl(url));
	  out.print("\">" + column2.elementAt(i)+"</A></P></TD>\n");
	  out.print("</TR>\n");
      }
      out.print("</TABLE>\n");
      
      //Generate shopping cart, search, and order status buttons.
      out.print("<P ALIGN=\"CENTER\">\n");
      url = "tpcw.servlets.TPCW_shopping_cart_interaction";
      url = url + "?ADD_FLAG=N";
      if(SHOPPING_ID != null)
	  url = url + "&SHOPPING_ID=" + SHOPPING_ID;
      if(C_ID != null)
	  url = url+"&C_ID=" + C_ID;
      
      out.print("<A HREF=\"" + res.encodeUrl(url)); 

      out.print("\"><IMG SRC=\"../tpcw/Images/shopping_cart_B.gif\"" +
		" ALT=\"Shopping tpcw.model.Cart\"></A>\n");
      
      url = "tpcw.servlets.TPCW_search_request_servlet";
      if(SHOPPING_ID != null){
	  url = url+"?SHOPPING_ID="+SHOPPING_ID;
	  if(C_ID!=null)
	      url = url + "&C_ID=" + C_ID;
      }
      else if(C_ID!=null)
	  url = url + "?C_ID=" + C_ID;
      
      out.print("<A HREF=\"" + res.encodeUrl(url));
      out.print("\"><IMG SRC=\"../tpcw/Images/search_B.gif\"" +
		" ALT=\"Search\"></A>\n");
      
      url = "tpcw.servlets.TPCW_order_inquiry_servlet";
      if(SHOPPING_ID != null){
	  url = url+"?SHOPPING_ID="+SHOPPING_ID;
	  if(C_ID!=null)
	      url = url + "&C_ID=" + C_ID;
      }
      else if(C_ID!=null)
	  url = url + "?C_ID=" + C_ID;
      
      out.print("<A HREF=\"" + res.encodeUrl(url));
      
      out.print("\"><IMG SRC=\"../tpcw/Images/order_status_B.gif\"" +
		" ALT=\"tpcw.model.Order Status\"></A>\n");
      
      //Generate Trailer
      out.print("<hr><font size=-1>\n");
      out.print("<a href=\"http://www.tpc.org/miscellaneous/TPC_W.folder/Company_Public_Review.html\">TPC-W Benchmark</a>,\n"); 
      out.print("<a href=\"http://www.cae.wisc.edu/~mikko/ece902.html\">ECE 902</a>,\n");
      out.print("<a href=\"http://www.cs.wisc.edu/~arch/uwarch\">University of Wisconsin Computer Architecture</a>,November 1999.\n");
      out.print("</font> </BODY> </HTML>\n");
      out.close();
      return;
  }
    
}
