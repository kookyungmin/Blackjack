package com.test;

import com.blackjack.Deck;

public class Test {

	public static void main(String[] args) {	
		Deck d = new Deck();
		for(int i = 0; i < 10; i++) {
			d.giveCard().printCard();
		}
	}
}
