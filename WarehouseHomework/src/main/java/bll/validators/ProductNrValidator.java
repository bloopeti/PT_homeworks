package bll.validators;

import model.Product;

public class ProductNrValidator implements Validator<Product> {
	private static final int MIN_NR = 0;

	public void validate(Product t) {

		if (t.getNr() > MIN_NR){
			throw new IllegalArgumentException("The Product Nr limit is not respected!");
		}

	}

}
