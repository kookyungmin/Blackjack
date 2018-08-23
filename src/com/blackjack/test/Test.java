package com.blackjack.test;

import com.blackjack.Card;
import com.blackjack.Deck;

public class Test {

	public static void main(String[] args) {
		Deck d = new Deck();
		d.suffleCard();
		Card[] c = new Card[5];
		for (int i = 0; i < c.length; i++) {
			c[i] = d.giveCard();
		}
		
		for (int i = 0; i < c.length; i++) {
			c[i].printTopCard();
			System.out.print("\t");
		}
		System.out.println();
		for (int i = 0; i < c.length; i++) {
			c[i].printTopNum();
			System.out.print("\t");
		}
		System.out.println();
		for (int i = 0; i < c.length; i++) {
			c[i].printShape();
			System.out.print("\t");
		}
		System.out.println();
		for (int i = 0; i < c.length; i++) {
			c[i].printBottomNum();
			System.out.print("\t");
		}
		System.out.println();
		for (int i = 0; i < c.length; i++) {
			c[i].printBottomCard();
			System.out.print("\t");
		}
		System.out.println();

	}

}
