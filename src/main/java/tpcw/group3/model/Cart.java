package tpcw.group3.model;/*
 * tpcw.model.Cart.java - Class stores the necessary components of a shopping cart
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

import java.util.*;
import java.sql.*;

/**
 * The type Cart.
 */
public class Cart extends Entity <Integer>{

    /**
     * The Sc sub total.
     */
    public double SC_SUB_TOTAL;
    /**
     * The Sc tax.
     */
    public double SC_TAX;
    /**
     * The Sc ship cost.
     */
    public double SC_SHIP_COST;
    /**
     * The Sc total.
     */
    public double SC_TOTAL;

    /**
     * The Lines.
     */
    public Vector lines;

    /**
     * Instantiates a new Cart.
     *
     * @param rs the rs
     */
    public Cart(ResultSet rs)
    {
    }

    /**
     * Instantiates a new Cart.
     *
     * @param rs         the rs
     * @param C_DISCOUNT the c discount
     * @throws SQLException the sql exception
     */
    public Cart (ResultSet rs, double C_DISCOUNT) throws java.sql.SQLException{
    int i;
	int total_items;
	lines = new Vector();
	while(rs.next()){//While there are lines remaining
	    CartLine line = new CartLine(rs.getString("i_title"),
					 rs.getDouble("i_cost"),
					 rs.getDouble("i_srp"),
					 rs.getString("i_backing"),
					 rs.getInt("scl_qty"),
					 rs.getInt("scl_i_id"));
	    lines.addElement(line);
	}

	SC_SUB_TOTAL = 0;
	total_items = 0;
	for(i = 0; i < lines.size(); i++){
	    CartLine thisline = (CartLine) lines.elementAt(i);
	    SC_SUB_TOTAL += thisline.scl_cost * thisline.scl_qty;
	    total_items += thisline.scl_qty;
	}
	
	//Need to multiply the sub_total by the discount.
	SC_SUB_TOTAL = SC_SUB_TOTAL * ((100 - C_DISCOUNT)*.01);
	SC_TAX = SC_SUB_TOTAL * .0825;
	SC_SHIP_COST = 3.00 + (1.00 * total_items);
	SC_TOTAL = SC_SUB_TOTAL + SC_SHIP_COST + SC_TAX;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(SC_SHIP_COST);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(SC_SUB_TOTAL);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(SC_TAX);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(SC_TOTAL);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((lines == null) ? 0 : lines.hashCode());
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
		Cart other = (Cart) obj;
		if (Double.doubleToLongBits(SC_SHIP_COST) != Double.doubleToLongBits(other.SC_SHIP_COST))
			return false;
		if (Double.doubleToLongBits(SC_SUB_TOTAL) != Double.doubleToLongBits(other.SC_SUB_TOTAL))
			return false;
		if (Double.doubleToLongBits(SC_TAX) != Double.doubleToLongBits(other.SC_TAX))
			return false;
		if (Double.doubleToLongBits(SC_TOTAL) != Double.doubleToLongBits(other.SC_TOTAL))
			return false;
		if (lines == null) {
			if (other.lines != null)
				return false;
		} else if (!lines.equals(other.lines))
			return false;
		return true;
	}

	
}
