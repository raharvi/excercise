package com.excersise.product.solution2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.excersise.product.solution2.Discounts.Product;
import com.exercise.product.SuperMarket;

public class CheckoutImpl implements SuperMarket {

	Logger LOG = Logger.getLogger(CheckoutImpl.class);

	public static final Map<Discounts.Product, Integer> costMap;
	static {
		costMap = new HashMap<>();
		costMap.put(Product.A, 20);
		costMap.put(Product.B, 50);
		costMap.put(Product.C, 30);
	}

	private HashMap<Product, Integer> counterMap = new HashMap<>();

	private int aCount = 0;
	private int bCount = 0;
	private int cCount = 0;

	/**
	 * Solution2: This solution is a bit enhancement over solution one as it allows
	 * you to add discounts for each product. It applies discount in the end after 
	 * cost of all products is added. 
	 * 
	 * @param items  input string representing the products being checked out.
	 * @return total total value of purchase after discount is applied.
	 */
	public int checkout(String items) {
		char[] products = items.toCharArray();
		ArrayList<Integer> tally = new ArrayList<>();
		for (char item : products) {
			try {
				Product product = Discounts.getEnumType(item);
				tally.add(costMap.get(product));
				addCount(product);
			} catch (Exception e) {
				LOG.warn(e.getMessage());
			}
		}
		counterMap.put(Product.A, aCount);
		counterMap.put(Product.B, bCount);
		counterMap.put(Product.C, cCount);

		int total = getTotal(tally);
		DiscountProcessor processor = new DiscountProcessor();
		total = processor.applyDiscount(total, counterMap);
		LOG.info("Purchase total : " + total);
		return total;
	}

	private void addCount(Product product) {
		switch (product) {
		case A:
			aCount++;
			break;
		case B:
			bCount++;
			break;
		case C:
			cCount++;
			break;
		}
	}

	/**
	 * @param costList List of Integers each being cost of product in
	 * 		  		   the inputstring		
	 * @return total of cost of products in the checkout.
	 */
	public int getTotal(ArrayList<Integer> costList) {
		int total = costList.stream().mapToInt(Integer::intValue).sum();
		return total;
	}

}
