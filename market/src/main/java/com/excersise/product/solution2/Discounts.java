package com.excersise.product.solution2;

public class Discounts {

	public Product product;

	public enum Product {
		A, B, C
	}

	public Discounts(Product product) {
		this.product = product;
	}

	public static Product getEnumType(char item) throws Exception{
		if (String.valueOf(item).equalsIgnoreCase(Product.A.toString()))
			return Product.A;
		else if (String.valueOf(item).equalsIgnoreCase(Product.B.toString()))
			return Product.B;
		else  if (String.valueOf(item).equalsIgnoreCase(Product.C.toString()))			
			return Product.C;
		else throw new Exception("Invalid Product");


	}

	/**
	 * @return The discount applicable to each product enum type.
	 */
	public String getProductDiscount() {
		String discountType = "";
		switch (product) {
		case A:
			discountType = null;
			break;
		case B:
			discountType = "5for3";
			break;
		case C:
			discountType = null;
			break;
		default:
			break;
		}
		return discountType;
	}
}
