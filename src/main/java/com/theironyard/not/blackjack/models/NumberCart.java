package com.theironyard.not.blackjack.models;

public class NumberCart implements Cart {

	private int value;
	private String soot;

	public NumberCart(int value, String soot) {
		this.value = value;
		this.soot = soot;
	}

	@Override
	public String toString() {
		return this.getVisualRepresentation() + " of " + this.getSoot();
	}

	public int[] getValues() {
		return new int[] { value, value };
	}

	public String getSoot() {
		return soot;
	}
	
	public String getVisualRepresentation() {
		return String.valueOf(value);
	}
	
}
