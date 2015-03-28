package com.excercise.product;

import static org.junit.Assert.assertTrue;

import java.util.HashMap;

import org.apache.log4j.BasicConfigurator;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.excersise.product.solution2.CheckoutImpl;
import com.excersise.product.solution2.DiscountProcessor;
import com.excersise.product.solution2.Discounts.Product;

public class CheckoutImplTest {
	
	CheckoutImpl impl;
	
	DiscountProcessor processor;
	
	@BeforeClass
	public static void configure(){
        BasicConfigurator.configure();
	}
	
	@Before
	public void setup(){
		impl = new CheckoutImpl();
	}
	
	/**
	 * Test with input string that includes all 3 products and uses
	 * the 5 for 3 discount for item 8
	 */
	@Test
	public void testcheckout(){
		int total = impl.checkout("BABACABBB");
		assertTrue(total ==240);
	}
	
	@Test
	public void testCheckout_As(){
		int cost = impl.checkout("AAAAAAAAAAAA");
		assertTrue(cost==240);
	}
	
	@Test
	public void testCheckout_ABs(){
		int cost = impl.checkout("AABBBBBB");
		assertTrue(cost==240);
	}
	
	@Test
	public void testCheckout_ACs(){
		int cost = impl.checkout("CACACAACAA");
		assertTrue(cost==240);
	}
	
	@Test
	public void testCheckout_BCs(){
		int cost = impl.checkout("BCBCBC");
		assertTrue(cost==240);
	}
	
 	/**
 	 * Total for these are > 240. Tests when more than 5 discount product
 	 * is included
 	 */
	@Test
	public void testCheckout_Bs(){
		int cost = impl.checkout("BBBBBBBBBB");
		assertTrue(cost==300);
	}

	@Test
	public void testCheckoutinvalid() {

		int cost = impl.checkout("D???BA BACABBB");
		assertTrue(cost==240);

   	}
	
	@Test
	public void testApplyDiscounts(){
		processor = new DiscountProcessor();
		HashMap<Product, Integer> counterMap = new HashMap<>();
		counterMap.put(Product.B, 10);
		int total = processor.applyDiscount(500, counterMap);
		assertTrue(total == 300);
	}
}
