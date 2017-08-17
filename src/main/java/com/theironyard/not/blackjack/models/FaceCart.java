package com.theironyard.not.blackjack.models;

public class FaceCart implements Cart {

	private String visualRepresentation;
	private String soot;

	public FaceCart(String visualRepresentation, String soot) {
		this.soot = soot;
		this.visualRepresentation = visualRepresentation;
	}

	@Override
	public String toString() {
		return this.getVisualRepresentation() + " of " + this.getSoot();
	}

	public String getVisualRepresentation() {
		return visualRepresentation;
	}

	public String getSoot() {
		return soot;
	}
	
	public int[] getValues() {
		return new int[] { 10, 10 };
	}
	
}
