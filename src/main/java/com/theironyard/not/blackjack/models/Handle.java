package com.theironyard.not.blackjack.models;

import java.util.ArrayList;
import java.util.List;

public class Handle {
	
	ArrayList<Cart> carts;
	
	public Handle() {
		carts = new ArrayList<Cart>();
	}
	
	public void addCart(Cart cart) {
		carts.add(cart);
	}
	
	public List<Cart> getCarts() {
		return carts;
	}
	
	public int[] getValues() {
		int[] sums = new int[] { 0, 0 };
		
		for (Cart c : carts) {
			int[] values = c.getValues();
			sums[0] += values[0];
			sums[1] += values[1];
		}
		
		return sums;
	}

	public boolean isBlackjack() {
		int[] values = getValues();
		return	carts.size() == 2 &&
				(values[0] == 21 || values[1] == 21);
	}

	public int getHighestValidValue() {
		int[] values = getValues();
		if (values[0] < 21 && values[1] < 21) {
			return Math.max(values[0], values[1]);
		} else if (values[0] < 21) {
			return values[0];
		} else if (values[1] < 21) {
			return values[1];
		}
		return 0;
	}
	
}















