package tpcw.group3.model;/*
 * tpcw.model.Customer.java - stores the important information for a single customer.
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

import java.sql.*;
import java.util.Date;

/**
 * The type Customer.
 */
//glorified struct used for passing customer info around.
public class Customer extends Entity<Integer> {

    /**
     * The C id.
     */
    public int c_id;
    /**
     * The C uname.
     */
    public String c_uname;
    /**
     * The C passwd.
     */
    public String c_passwd;
    /**
     * The C fname.
     */
    public String c_fname;
    /**
     * The C lname.
     */
    public String c_lname;
    /**
     * The C phone.
     */
    public String c_phone;
    /**
     * The C email.
     */
    public String c_email;
    /**
     * The C since.
     */
    public Date c_since;
    /**
     * The C last visit.
     */
    public Date c_last_visit;
    /**
     * The C login.
     */
    public Date c_login;
    /**
     * The C expiration.
     */
    public Date c_expiration;
    /**
     * The C discount.
     */
    public double c_discount;
    /**
     * The C balance.
     */
    public double c_balance;
    /**
     * The C ytd pmt.
     */
    public double c_ytd_pmt;
    /**
     * The C birthdate.
     */
    public Date c_birthdate;
    /**
     * The C data.
     */
    public String c_data;

    /**
     * The Addr id.
     */
//From the addess table
    public int addr_id;
    /**
     * The Addr street 1.
     */
    public String addr_street1;
    /**
     * The Addr street 2.
     */
    public String addr_street2;
    /**
     * The Addr city.
     */
    public String addr_city;
    /**
     * The Addr state.
     */
    public String addr_state;
    /**
     * The Addr zip.
     */
    public String addr_zip;
    /**
     * The Addr co id.
     */
    public int addr_co_id;

    /**
     * The Co name.
     */
//From the country table
    public String co_name;

    /**
     * Instantiates a new Customer.
     */
    public Customer(){}

    /**
     * Instantiates a new Customer.
     *
     * @param rs the rs
     */
    public Customer(ResultSet rs) {
	// The result set should have all of the fields we expect.
	// This relies on using field name access.  It might be a bad
	// way to break this up since it does not allow us to use the
	// more efficient select by index access method.  This also
	// might be a problem since there is no type checking on the
	// result set to make sure it is even a reasonble result set
	// to give to this function.
       
	try {
	    c_id = rs.getInt("c_id");
	    c_uname = rs.getString("c_uname");
	    c_passwd = rs.getString("c_passwd");
	    c_fname = rs.getString("c_fname");
	    c_lname = rs.getString("c_lname");

	    c_phone = rs.getString("c_phone");
	    c_email = rs.getString("c_email");
	    c_since = rs.getDate("c_since");
	    c_last_visit = rs.getDate("c_last_login");
	    c_login = rs.getDate("c_login");
	    c_expiration = rs.getDate("c_expiration");
	    c_discount = rs.getDouble("c_discount");
	    c_balance = rs.getDouble("c_balance");
	    c_ytd_pmt = rs.getDouble("c_ytd_pmt");
	    c_birthdate = rs.getDate("c_birthdate");
	    c_data = rs.getString("c_data");

	    addr_id = rs.getInt("addr_id");
	    addr_street1 = rs.getString("addr_street1");
	    addr_street2 = rs.getString("addr_street2");
	    addr_city = rs.getString("addr_city");
	    addr_state = rs.getString("addr_state");
	    addr_zip = rs.getString("addr_zip");
	    addr_co_id = rs.getInt("addr_co_id");

	    co_name = rs.getString("co_name");
	    
	} catch (java.lang.Exception ex) {
	    ex.printStackTrace();
	}
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        return c_id == customer.c_id;
    }

    @Override
    public int hashCode() {
        return c_id;
    }
}
