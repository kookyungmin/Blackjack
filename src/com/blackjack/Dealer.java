package com.blackjack;

public class Dealer implements Gamer{
	private static final int MAXCARD = 11;
	private int getCardcnt = 0;
	private Card[] card;
	
	public Dealer() {
		card = new Card[MAXCARD];
	}
	
	public void initOpenCard() {
		// TODO Auto-generated method stub
		
	}
	public void showCard() {
		// TODO Auto-generated method stub
		
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
