package com.blackjack;

public class Guest implements Gamer {
	private static final int MAXCARD = 11;
	private int getCardcnt = 0;
	private Card[] card;
	public Guest() {
		card = new Card[MAXCARD];
	}
	
	@Override
	public boolean isGiveCard() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void getCard(Card card) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void openCard() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public int cardSum() {
		// TODO Auto-generated method stub
		return 0;
	}
}
