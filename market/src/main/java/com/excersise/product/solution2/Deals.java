package com.excersise.product.solution2;

import java.util.HashMap;

public final class Deals {
	
	public static final HashMap<String, Integer> DEALMOD = new HashMap<>();
	
	public static final HashMap<String, Integer> FREECOUNT = new HashMap<>();

	/**
	 * Map stores mod value associated with each deal.
	 */
	static{
		DEALMOD.put("5for3", 5);
		DEALMOD.put("7for4", 7);
	}
	
	/**
	 * Map stores number of free items in each deal.
	 */
	static{
		FREECOUNT.put("5for3", 2);
		FREECOUNT.put("7for4", 3);
	}
	
	public static int getMod(String deal){
		return DEALMOD.get(deal);
	}
	
	public static int getFreeCount(String deal){
		return FREECOUNT.get(deal);
	}

}
