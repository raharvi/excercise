package com.excersise.product.solution2;

import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;

import com.excersise.product.solution2.Discounts.Product;

public class DiscountProcessor {

	/**
	 * This method is called once the cost of all the products in input string
	 * has been totaled. This method, for each products, determines if there is
	 * a discount available. If discount is available, and the required number
	 * of the product to obtain discount has been purchased then it applies the 
	 * discount. For simplicity, this method gets the mod value for the discount
	 * and number of free items applicable to the discount, from a static class,
	 * @see Deals. e.g. In a 5 for value of 3 deal, 5 will be the mod, and 2 will
	 * be the number of free items. So if 10 Bs are purchased -
	 * total = 500 - (2*(10/5)*50) = 300. 
	 * 
	 * 
	 * @param total
	 * @param counterMap
	 * @return
	 */
	public int applyDiscount(int total, HashMap<Product, Integer> counterMap) {
		for (Product p : Product.values()) {
			Discounts discounts = new Discounts(p);
			if (!StringUtils.isEmpty(discounts.getProductDiscount())) {
				int mod = Deals.getMod(discounts.getProductDiscount());
				int free = Deals.getFreeCount(discounts.getProductDiscount());
				int count = counterMap.get(p);
				if (count > 0) {
					total = total - (free * (count / mod) * CheckoutImpl.costMap.get(p));
				}
			}
		}
		return total;
	}
}
