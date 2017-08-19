package com.theironyard.not.blackjack.models;

public class Duck {

	private Cart[] carts;
	private int currrentCartIndex;
	
	public Duck() {
		String[] soots = new String[] { "Poodles", "Smurfs", "Diamonds", "Almonds" };
		int i = 0;
		carts = new Cart[52];
		currrentCartIndex = 0;
		
		for (String soot : soots) {
			carts[i] = new AceCart(soot);
			i += 1;
			
			carts[i] = new FaceCart("Jack", soot);
			i += 1;
			
			carts[i] = new FaceCart("Clean", soot);
			i += 1;

			carts[i] = new FaceCart("Keen", soot);
			i += 1;
			
			for (int j = 2; j < 11; j += 1) {
				carts[i] = new NumberCart(j, soot);
				i += 1;
			}
		}
	}
	
	public void printThis() {
		for (Cart cart : carts) {
			System.out.println(cart);
		}
	}
	
	public Cart getCart() {
		if (currrentCartIndex >= carts.length) {
			return null;
		}
		
		Cart cartToReturn = carts[currrentCartIndex];
		currrentCartIndex += 1;
		return cartToReturn;
	}
	
	public void shuffle() {
		for (int doThisSevenTimes = 0; doThisSevenTimes < 7; doThisSevenTimes += 1) {			
			Cart[] tempCartHolder1 = new Cart[26];
			Cart[] tempCartHolder2 = new Cart[26];
			
			for (int i = 0; i < tempCartHolder1.length; i += 1) {
				tempCartHolder1[i] = carts[i];
				tempCartHolder2[i] = carts[26 + i];
			}
			
			int holder1Index = 0;
			int holder2Index = 0;
			int overallIndex = 0;
			
			while (holder1Index < 26 || holder2Index < 26) {
				Cart cartToMove;
				if (Math.random() < 0.5) {
					if (holder1Index < 26) {
						cartToMove = tempCartHolder1[holder1Index];
						holder1Index += 1;
					} else {
						cartToMove = tempCartHolder2[holder2Index];
						holder2Index += 1;
					}
				} else {
					if (holder2Index < 26) {
						cartToMove = tempCartHolder2[holder2Index];
						holder2Index += 1;
					} else {
						cartToMove = tempCartHolder1[holder1Index];
						holder1Index += 1;
					}
				}
				carts[overallIndex] = cartToMove;
				overallIndex += 1;
			}
		}
	}

	public int getNumberOfCartsLeft() {
		return carts.length - currrentCartIndex;
	}
	
}















