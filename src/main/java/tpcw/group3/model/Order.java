package tpcw.group3.model;/*
 * tpcw.model.Order.java - tpcw.model.Order class Stores the important pertinent to a
 *              single order
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

import java.util.Date;
import java.sql.*;

//Glorified struct to pass order information from the DB to tpcw.group3.servlets

/**
 * The type Order.
 */
public class Order extends Entity<Integer> {
    /**
     * Instantiates a new Order.
     *
     * @param rs the rs
     */
    public Order(ResultSet rs) {
		try {
			o_id = rs.getInt("o_id");
			c_fname = rs.getString("c_fname");
			c_lname = rs.getString("c_lname");
			c_passwd = rs.getString("c_passwd");
			c_uname = rs.getString("c_uname");
			c_phone = rs.getString("c_phone");
			c_email = rs.getString("c_email");
			o_date = rs.getDate("o_date");
			o_subtotal = rs.getDouble("o_sub_total");
			o_tax = rs.getDouble("o_tax");
			o_total = rs.getDouble("o_total");
			o_ship_type = rs.getString("o_ship_type");
			o_ship_date = rs.getDate("o_ship_date");
			o_status = rs.getString("o_status");
			cx_type = rs.getString("cx_type");

			bill_addr_street1 = rs.getString("bill_addr_street1");
			bill_addr_street2 = rs.getString("bill_addr_street2");
			bill_addr_state = rs.getString("bill_addr_state");
			bill_addr_zip = rs.getString("bill_addr_zip");
			bill_co_name = rs.getString("bill_co_name");

			ship_addr_street1 = rs.getString("ship_addr_street1");
			ship_addr_street2 = rs.getString("ship_addr_street2");
			ship_addr_state = rs.getString("ship_addr_state");
			ship_addr_zip = rs.getString("ship_addr_zip");
			ship_co_name = rs.getString("ship_co_name");
		} catch (java.lang.Exception ex) {
			ex.printStackTrace();
		}
    }

    /**
     * The O id.
     */
    public int o_id;
    /**
     * The C fname.
     */
    public String c_fname;
    /**
     * The C lname.
     */
    public String c_lname;
    /**
     * The C passwd.
     */
    public String c_passwd;
    /**
     * The C uname.
     */
    public String c_uname;
    /**
     * The C phone.
     */
    public String c_phone;
    /**
     * The C email.
     */
    public String c_email;
    /**
     * The O date.
     */
    public Date o_date;
    /**
     * The O subtotal.
     */
    public double o_subtotal;
    /**
     * The O tax.
     */
    public double o_tax;
    /**
     * The O total.
     */
    public double o_total;
    /**
     * The O ship type.
     */
    public String o_ship_type;
    /**
     * The O ship date.
     */
    public Date o_ship_date;
    /**
     * The O status.
     */
    public String o_status;

    /**
     * The Bill addr street 1.
     */
//Billing address
    public String bill_addr_street1;
    /**
     * The Bill addr street 2.
     */
    public String bill_addr_street2;
    /**
     * The Bill addr state.
     */
    public String bill_addr_state;
    /**
     * The Bill addr zip.
     */
    public String bill_addr_zip;
    /**
     * The Bill co name.
     */
    public String bill_co_name;

    /**
     * The Ship addr street 1.
     */
//Shipping address
    public String ship_addr_street1;
    /**
     * The Ship addr street 2.
     */
    public String ship_addr_street2;
    /**
     * The Ship addr state.
     */
    public String ship_addr_state;
    /**
     * The Ship addr zip.
     */
    public String ship_addr_zip;
    /**
     * The Ship co name.
     */
    public String ship_co_name;

    /**
     * The Cx type.
     */
    public String cx_type;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bill_addr_state == null) ? 0 : bill_addr_state.hashCode());
		result = prime * result + ((bill_addr_street1 == null) ? 0 : bill_addr_street1.hashCode());
		result = prime * result + ((bill_addr_street2 == null) ? 0 : bill_addr_street2.hashCode());
		result = prime * result + ((bill_addr_zip == null) ? 0 : bill_addr_zip.hashCode());
		result = prime * result + ((bill_co_name == null) ? 0 : bill_co_name.hashCode());
		result = prime * result + ((c_email == null) ? 0 : c_email.hashCode());
		result = prime * result + ((c_fname == null) ? 0 : c_fname.hashCode());
		result = prime * result + ((c_lname == null) ? 0 : c_lname.hashCode());
		result = prime * result + ((c_passwd == null) ? 0 : c_passwd.hashCode());
		result = prime * result + ((c_phone == null) ? 0 : c_phone.hashCode());
		result = prime * result + ((c_uname == null) ? 0 : c_uname.hashCode());
		result = prime * result + ((cx_type == null) ? 0 : cx_type.hashCode());
		result = prime * result + ((o_date == null) ? 0 : o_date.hashCode());
		result = prime * result + o_id;
		result = prime * result + ((o_ship_date == null) ? 0 : o_ship_date.hashCode());
		result = prime * result + ((o_ship_type == null) ? 0 : o_ship_type.hashCode());
		result = prime * result + ((o_status == null) ? 0 : o_status.hashCode());
		long temp;
		temp = Double.doubleToLongBits(o_subtotal);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(o_tax);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(o_total);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((ship_addr_state == null) ? 0 : ship_addr_state.hashCode());
		result = prime * result + ((ship_addr_street1 == null) ? 0 : ship_addr_street1.hashCode());
		result = prime * result + ((ship_addr_street2 == null) ? 0 : ship_addr_street2.hashCode());
		result = prime * result + ((ship_addr_zip == null) ? 0 : ship_addr_zip.hashCode());
		result = prime * result + ((ship_co_name == null) ? 0 : ship_co_name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (bill_addr_state == null) {
			if (other.bill_addr_state != null)
				return false;
		} else if (!bill_addr_state.equals(other.bill_addr_state))
			return false;
		if (bill_addr_street1 == null) {
			if (other.bill_addr_street1 != null)
				return false;
		} else if (!bill_addr_street1.equals(other.bill_addr_street1))
			return false;
		if (bill_addr_street2 == null) {
			if (other.bill_addr_street2 != null)
				return false;
		} else if (!bill_addr_street2.equals(other.bill_addr_street2))
			return false;
		if (bill_addr_zip == null) {
			if (other.bill_addr_zip != null)
				return false;
		} else if (!bill_addr_zip.equals(other.bill_addr_zip))
			return false;
		if (bill_co_name == null) {
			if (other.bill_co_name != null)
				return false;
		} else if (!bill_co_name.equals(other.bill_co_name))
			return false;
		if (c_email == null) {
			if (other.c_email != null)
				return false;
		} else if (!c_email.equals(other.c_email))
			return false;
		if (c_fname == null) {
			if (other.c_fname != null)
				return false;
		} else if (!c_fname.equals(other.c_fname))
			return false;
		if (c_lname == null) {
			if (other.c_lname != null)
				return false;
		} else if (!c_lname.equals(other.c_lname))
			return false;
		if (c_passwd == null) {
			if (other.c_passwd != null)
				return false;
		} else if (!c_passwd.equals(other.c_passwd))
			return false;
		if (c_phone == null) {
			if (other.c_phone != null)
				return false;
		} else if (!c_phone.equals(other.c_phone))
			return false;
		if (c_uname == null) {
			if (other.c_uname != null)
				return false;
		} else if (!c_uname.equals(other.c_uname))
			return false;
		if (cx_type == null) {
			if (other.cx_type != null)
				return false;
		} else if (!cx_type.equals(other.cx_type))
			return false;
		if (o_date == null) {
			if (other.o_date != null)
				return false;
		} else if (!o_date.equals(other.o_date))
			return false;
		if (o_id != other.o_id)
			return false;
		if (o_ship_date == null) {
			if (other.o_ship_date != null)
				return false;
		} else if (!o_ship_date.equals(other.o_ship_date))
			return false;
		if (o_ship_type == null) {
			if (other.o_ship_type != null)
				return false;
		} else if (!o_ship_type.equals(other.o_ship_type))
			return false;
		if (o_status == null) {
			if (other.o_status != null)
				return false;
		} else if (!o_status.equals(other.o_status))
			return false;
		if (Double.doubleToLongBits(o_subtotal) != Double.doubleToLongBits(other.o_subtotal))
			return false;
		if (Double.doubleToLongBits(o_tax) != Double.doubleToLongBits(other.o_tax))
			return false;
		if (Double.doubleToLongBits(o_total) != Double.doubleToLongBits(other.o_total))
			return false;
		if (ship_addr_state == null) {
			if (other.ship_addr_state != null)
				return false;
		} else if (!ship_addr_state.equals(other.ship_addr_state))
			return false;
		if (ship_addr_street1 == null) {
			if (other.ship_addr_street1 != null)
				return false;
		} else if (!ship_addr_street1.equals(other.ship_addr_street1))
			return false;
		if (ship_addr_street2 == null) {
			if (other.ship_addr_street2 != null)
				return false;
		} else if (!ship_addr_street2.equals(other.ship_addr_street2))
			return false;
		if (ship_addr_zip == null) {
			if (other.ship_addr_zip != null)
				return false;
		} else if (!ship_addr_zip.equals(other.ship_addr_zip))
			return false;
		if (ship_co_name == null) {
			if (other.ship_co_name != null)
				return false;
		} else if (!ship_co_name.equals(other.ship_co_name))
			return false;
		return true;
	}
}
