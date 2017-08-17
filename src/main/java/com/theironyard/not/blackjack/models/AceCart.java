package com.theironyard.not.blackjack.models;

public class AceCart implements Cart {
	
	private String soot;

	public AceCart(String soot) {
		this.soot = soot;
	}
	
	@Override
	public String toString() {
		return this.getVisualRepresentation() + " of " + this.getSoot();
	}

	/* (non-Javadoc)
	 * @see com.theironyard.not.blackjack.models.Cart#getSoot()
	 */
	@Override
	public String getSoot() {
		return soot;
	}
	
	/* (non-Javadoc)
	 * @see com.theironyard.not.blackjack.models.Cart#getVisualRepresentation()
	 */
	@Override
	public String getVisualRepresentation() {
		return "Ace";
	}
	
	/* (non-Javadoc)
	 * @see com.theironyard.not.blackjack.models.Cart#getValues()
	 */
	@Override
	public int[] getValues() {
		return new int[] { 1, 11 };
	}
	
}
