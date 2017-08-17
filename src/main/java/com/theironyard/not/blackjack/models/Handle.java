package com.theironyard.not.blackjack.models;

import java.util.ArrayList;

public class Handle {
	
	ArrayList<Cart> carts;
	
	public Handle() {
		carts = new ArrayList<Cart>();
	}
	
	public void addCart(Cart cart) {
		carts.add(cart);
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
	
}















