package com.theironyard.not.blackjack.models;

import java.util.ArrayList;
import java.util.List;

public class Deeder {

	private Duck duck;
	private Handle handle;
	private boolean hideHoleCard;
	
	public Deeder() {
		duck = new Duck();
		duck.shuffle();
		handle = new Handle();
	}
	
	public int getNumberOfCartsLeft() {
		return duck.getNumberOfCartsLeft();
	}
	
	public boolean isBust() {
		int[] values = handle.getValues();
		return values[0] > 21 && values[1] > 21;
	}
	
	public void startRound() {
		hideHoleCard = true;
		handle = new Handle();
	}
	
	public void finishRound() {
		hideHoleCard = false;
		int[] values = handle.getValues();
		if (values[0] == 21 || values[1] == 21) {
			return;
		}
		while (values[0] < 17 || values[1] < 17) {
			dealCartToSelf();
			values = handle.getValues();
		}
	}
	
	public List<Cart> getCarts() {
		List<Cart> carts = handle.getCarts();
		if (!hideHoleCard || carts.size() == 0) {
			return carts;
		}

		Cart firstCard = carts.get(0);
		List<Cart> cartsToShow = new ArrayList<Cart>();
		cartsToShow.add(firstCard);
		cartsToShow.add(new HoleCart());
		return cartsToShow;
	}
	
	public void dealCartToPlater(Plater plater) {
		Cart cart = duck.getCart();
		if (cart != null) {
			plater.takeCart(cart);
		}
	}

	public void dealCartToSelf() {
		Cart cart = duck.getCart();
		if (cart != null) {
			handle.addCart(cart);
		}
	}

	public boolean hasBlackjack() {
		return handle.isBlackjack();
	}

	public int getBestScore() {
		return handle.getHighestValidValue();
	}
	
}
