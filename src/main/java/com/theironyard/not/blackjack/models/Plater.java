package com.theironyard.not.blackjack.models;

import java.util.List;

public class Plater {
	
	private int availableCash;
	private Handle handle;

	public Plater() {
		availableCash = 50;
		handle = new Handle();
	}
	
	public boolean isBust() {
		int[] values = handle.getValues();
		return values[0] > 21 && values[1] > 21;
	}
	
	public int getAvailableCash() {
		return availableCash;
	}
	
	public int ante(int bet) {
		handle = new Handle();
		bet = Math.min(bet, availableCash);
		availableCash -= bet;
		return bet;
	}

	public void takeCart(Cart cart) {
		handle.addCart(cart);
	}
	
	public List<Cart> getCarts() {
		return handle.getCarts();
	}

	public void payout(int money) {
		availableCash += money;
	}

	public boolean hasBlackjack() {
		return handle.isBlackjack();
	}

	public int getBestScore() {
		return handle.getHighestValidValue();
	}
	
}
