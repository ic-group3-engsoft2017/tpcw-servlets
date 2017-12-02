package tpcw.group3.model;
/*
 * tpcw.model.Book.java - Class used to store all of the data associated with a single
 *             book. 
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

import tpcw.group3.cache.model.CachableEntity;

import java.sql.*;

/**
 * The type Book.
 */
public class Book extends CachableEntity {

    /**
     * The constant I_ID.
     */
    public static final String I_ID = "i_id";
    /**
     * The constant I_TITLE.
     */
    public static final String I_TITLE = "i_title";
    /**
     * The constant A_FNAME.
     */
    public static final String A_FNAME = "a_fname";
    /**
     * The constant A_LNAME.
     */
    public static final String A_LNAME = "a_lname";

    /**
     * Instantiates a new Book.
     *
     * @param i_id    the id
     * @param i_title the title
     * @param a_fname the a fname
     * @param a_lname the a lname
     */
// Construct with required arguments for use of mocks
    public Book(int i_id, String i_title, String a_fname, String a_lname) {
        this.i_id = i_id;
        this.i_title = i_title;
        this.a_fname = a_fname;
        this.a_lname = a_lname;
    }

    /**
     * Instantiates a new Book.
     *
     * @param rs the rs
     */
// Construct a book from a ResultSet
    public Book(ResultSet rs) {
	// The result set should have all of the fields we expect.
	// This relies on using field name access.  It might be a bad
	// way to break this up since it does not allow us to use the
	// more efficient select by index access method.  This also
	// might be a problem since there is no type checking on the
	// result set to make sure it is even a reasonble result set
	// to give to this function.
       
	try {
	    i_id = rs.getInt(I_ID);
	    i_title = rs.getString(I_TITLE);
	    i_pub_Date = rs.getDate("i_pub_Date");
	    i_publisher = rs.getString("i_publisher");
	    i_subject = rs.getString("i_subject");
	    i_desc = rs.getString("i_desc");
	    i_related1 = rs.getInt("i_related1");
	    i_related2 = rs.getInt("i_related2");
	    i_related3 = rs.getInt("i_related3");
	    i_related4 = rs.getInt("i_related4");
	    i_related5 = rs.getInt("i_related5");
	    i_thumbnail = rs.getString("i_thumbnail");
	    i_image = rs.getString("i_image");
	    i_srp = rs.getDouble("i_srp");
	    i_cost = rs.getDouble("i_cost");
	    i_avail = rs.getDate("i_avail");
	    i_isbn = rs.getString("i_isbn");
	    i_page = rs.getInt("i_page");
	    i_backing = rs.getString("i_backing");
	    i_dimensions = rs.getString("i_dimensions");
	    a_id = rs.getInt("a_id");
	    a_fname = rs.getString(A_FNAME);
	    a_lname = rs.getString(A_LNAME);
	} catch (java.lang.Exception ex) {
	    ex.printStackTrace();
	}
    }

    /**
     * The Id.
     */
// From Item
    public int i_id;
    /**
     * The Title.
     */
    public String i_title;
    /**
     * The Pub date.
     */
//  public int i_a_id;   // Redundant
    public Date i_pub_Date;
    /**
     * The Publisher.
     */
    public String i_publisher;
    /**
     * The Subject.
     */
    public String i_subject;
    /**
     * The Desc.
     */
    public String i_desc;
    /**
     * The Related 1.
     */
    public int i_related1;
    /**
     * The Related 2.
     */
    public int i_related2;
    /**
     * The Related 3.
     */
    public int i_related3;
    /**
     * The Related 4.
     */
    public int i_related4;
    /**
     * The Related 5.
     */
    public int i_related5;
    /**
     * The Thumbnail.
     */
    public String i_thumbnail;
    /**
     * The Image.
     */
    public String i_image;
    /**
     * The Srp.
     */
    public double i_srp;
    /**
     * The Cost.
     */
    public double i_cost;
    /**
     * The Avail.
     */
    public Date i_avail;
    /**
     * The Isbn.
     */
    public String i_isbn;
    /**
     * The Page.
     */
    public int i_page;
    /**
     * The Backing.
     */
    public String i_backing;
    /**
     * The Dimensions.
     */
    public String i_dimensions;

    /**
     * The A id.
     */
// From Author
    public int a_id;
    /**
     * The A fname.
     */
    public String a_fname;
    /**
     * The A lname.
     */
    public String a_lname;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (i_id != book.i_id) return false;
        return i_isbn != null ? i_isbn.equals(book.i_isbn) : book.i_isbn == null;
    }

    @Override
    public int hashCode() {
        int result = i_id;
        result = 31 * result + (i_isbn != null ? i_isbn.hashCode() : 0);
        return result;
    }
}



