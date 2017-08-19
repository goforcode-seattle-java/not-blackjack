package com.theironyard.not.blackjack.models;

public class HoleCart implements Cart {

	@Override
	public String getSoot() {
		return "";
	}

	@Override
	public String getVisualRepresentation() {
		return "«unknown»";
	}

	@Override
	public int[] getValues() {
		return new int[] { 0, 0 };
	}

}
