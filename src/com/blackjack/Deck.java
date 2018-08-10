package com.blackjack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	List<Integer> cardNum;
	int index = 0;
	public Deck() {
		cardNum = new ArrayList<Integer>();
		for (int i = 1; i <= 52; i++) {
			cardNum.add(i);
		}
		suffleCard();
	}
	public int getCardNum(int index) {
		return cardNum.get(index);
	}
	public Card giveCard() {
		int num = cardNum.get(index++);
		String shape = null;
		int cNum = 0;
		// heart(1~13)
		if (num <= 13) {
			shape = "♥";
			cNum = num;
		} else if (num <= 26) {// diamond(14~26)
			shape = "●";
			cNum = num - 13;
		} else if (num <= 39) {// spade(27~39)
			shape = "♠";
			cNum = num - 26;
		} else { // clover (40~52)
			shape = "♣";
			cNum = num - 39;
		}
		return new Card(shape, cNum);
	}
	
	private void suffleCard() {
		Collections.shuffle(cardNum);
	}

	
	
}
