package com.excercise.product.solution1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.exercise.product.SuperMarket;

public class SuperMarketImpl implements SuperMarket {

	private static final Map<Character, Integer> costMap;
	static {
		costMap = new HashMap<Character, Integer>();
		costMap.put('A', 20);
		costMap.put('B', 50);
		costMap.put('C', 30);
	}

	/**
	 * Takes an input string which it reads as a character array, where each
	 * character is an item purchased. If a product other than A, B or C is
	 * entered, it is not included in the total. This method calculates total and 
	 * applies discount for product B. It strictly applies 5 for price of 3 
	 * discount. When 5th B is found, it's cost is NOT included, and cost of one 
	 * B is removed.
	 *  
	 * @param items inputString that is character array representation of products
	 *            	bought.
	 * @return int  total value of the items bought.
	 */
	public int checkout(String items) {
		char[] products = items.toCharArray();
		ArrayList<Integer> tally = new ArrayList<>();
		int bCounter = 1;

		for (char item : products) {
			if (costMap.containsKey(item)) {
				boolean bflag = isDiscount(item, bCounter);
				if (item == 'B' && bflag)
					tally.add(-costMap.get(item));
				else
					tally.add(costMap.get(item));
				if (item == 'B')
					bCounter++;
			}
		}
		return getTotal(tally);
	}


	/**
	 * Returns true if discount is applicable for a given item. The counter
	 * keeps track of how many of a specific item have been included. One 
	 * discount rule is added. It applies to Product B. Discount applies at
	 * every 5th product B sold. 3 Product Bs for every 5 bought. Discounts
	 * for product A or C can also be applied. Case for B can be enhanced to 
	 * apply other discounts e.g. 4 for price of 7.
	 * 
	 * @param  item Product Item being checked for discount 
	 * @param  count number of the a specific item included in the
	 *  	   total
	 * @return true if discount is applicable
	 */
	public boolean isDiscount(char item, int count) {
		boolean isDiscount = false;
		switch (item) {
		case 'B': {
			if (count % 5 == 0)
				isDiscount = true;
			break;
		}
		case 'A':
			break;
		case 'C':
			break;
		default:
			break;
		}
		return isDiscount;
	}
	
	/**
	 * 
	 * @param costList List of Integers each being cost of product in
	 * 		  		   the inputstring		
	 * @return total of cost of products in the checkout.
	 */
	public int getTotal(ArrayList<Integer> costList) {
		int total = costList.stream().mapToInt(Integer::intValue).sum();
		return total;
	}
	
}
