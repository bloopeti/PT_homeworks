package bll.validators;

import model.Order;

public class OrderNrValidator implements Validator<Order> {
	private static final int MIN_NR = 0;

	public void validate(Order t) {

		if (t.getNr() > MIN_NR){
			throw new IllegalArgumentException("The Order Nr limit is not respected!");
		}

	}

}
