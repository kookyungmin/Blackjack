package com.blackjack;

public class Guest extends Gamer {
	public Guest() {
		cards = new Card[MAXCARD];
	}
	
	@Override
	public boolean isGetCard() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void openCard() {
		System.out.println("<<Guest Card>>");
		super.openCard();
	}
	@Override
	public int cardSum() {
		
		return 0;
	}
}
