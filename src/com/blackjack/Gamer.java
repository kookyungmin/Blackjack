package com.blackjack;

abstract public class Gamer {
	protected static final int MAXCARD = 11;
	protected int getCardcnt = 0;
	protected Card[] cards;
	
	abstract public boolean isGetCard();
	abstract public int cardSum();
	
	public void getCard(Card card) {
		cards[getCardcnt++] = card;
	}
	
	public void openCard() {
		for (int i = 0; i < getCardcnt; i++) {
			cards[i].printTopCard();
			System.out.print("\t");
		}
		System.out.println();
		for (int i = 0; i < getCardcnt; i++) {
			cards[i].printTopNum();
			System.out.print("\t");
		}
		System.out.println();
		for (int i = 0; i < getCardcnt; i++) {
			cards[i].printShape();
			System.out.print("\t");
		}
		System.out.println();
		for (int i = 0; i < getCardcnt; i++) {
			cards[i].printBottomNum();
			System.out.print("\t");
		}
		System.out.println();
		for (int i = 0; i < getCardcnt; i++) {
			cards[i].printBottomCard();
			System.out.print("\t");
		}
		System.out.println();
	}
	
}


