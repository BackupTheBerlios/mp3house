/*
 * Created on Jun 9, 2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
package com.bs.tests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * @author Administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Generation - Code and Comments
 */
public class DBConTest extends TestCase {
	
	public static void main(String[] args) {

	}
	/*
	 * @see TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
	}
	/*
	 * @see TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	/**
	 * Constructor for DBConTest.
	 * @param arg0
	 */
	public DBConTest(String arg0) {
		super(arg0);
	}
	public final void testGetConnection() {
		//TODO Implement getConnection().
	}
	
	public static Test suite() { 
	    TestSuite suite= new TestSuite(); 
	    suite.addTest(new DBConTest("testGetConnection")); 
	    return suite;
	}
}
