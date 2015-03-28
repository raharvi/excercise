package com.excercise.product;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.apache.log4j.BasicConfigurator;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.excercise.product.solution1.SuperMarketImpl;


public class SuperMarketTest {
	
	SuperMarketImpl sp;
	
	@BeforeClass
	public static void configure(){
        BasicConfigurator.configure();
	}
	
	@Before
	public void setup(){
		sp = new SuperMarketImpl();
	}
	
	/**
	 * Test with input string that includes all 3 products and uses
	 * the 5 for 3 discount for item 8
	 */
	@Test
	public void testCheckout() {

		int cost = sp.checkout("BABACABBB");
		assertTrue(cost==240);
 	}
	
	/**
	 * Test for exception cases such as product other than A, B or C. 
	 * Other characters or spaces. 
	 */
	@Test
	public void testCheckoutinvalid() {

		int cost = sp.checkout("D???BA BACABBB");
		assertTrue(cost==240);
  	}
	
	@Test
	public void testCheckout_Cs(){
		int cost = sp.checkout("CCCCCCCC");
		assertTrue(cost==240);
	}
	
	@Test
	public void testCheckout_As(){
		int cost = sp.checkout("AAAAAAAAAAAA");
		assertTrue(cost==240);
	}
	
	@Test
	public void testCheckout_ABs(){
		int cost = sp.checkout("AABBBBBB");
		assertTrue(cost==240);
	}
	
	@Test
	public void testCheckout_ACs(){
		int cost = sp.checkout("CACACAACAA");
		assertTrue(cost==240);
	}
	
	@Test
	public void testCheckout_BCs(){
		int cost = sp.checkout("BCBCBC");
		assertTrue(cost==240);
	}
	
 	
	@Test
	public void testCheckout_Bs(){
		int cost = sp.checkout("BBBBBBBBBB");
		assertTrue(cost==300);
	}

	@Test
	public void testGetTotal(){
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(12);
		list.add(25);
		int total = sp.getTotal(list);
		assertTrue(total==37);
	}

	
	@Test
	public void testisDiscount(){
		assertFalse(sp.isDiscount('B', 4));
		assertTrue(sp.isDiscount('B', 5));
		assertTrue(sp.isDiscount('B', 10));
		assertFalse(sp.isDiscount('A', 4));
		assertFalse(sp.isDiscount('B', 6));
		assertFalse(sp.isDiscount('C', 1));
		assertFalse(sp.isDiscount('B', 3));
 	}

}
