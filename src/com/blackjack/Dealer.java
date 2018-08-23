package com.blackjack;

public class Dealer extends Gamer{
	public Dealer() {
		cards = new Card[MAXCARD];
	}
	
	public void initOpenCard() {
		
		
	}
	public void showCard() {
		
		
	}
	
	@Override
	public void openCard() {
		System.out.println("<<Dealer Card>>");
		super.openCard();
		
	}
	
	@Override
	public boolean isGetCard() {
		boolean isGetCard = true;
		if(cardSum()>=17) {
			isGetCard = false;
		}
		return isGetCard;
	}
	
	@Override
	public int cardSum() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void hiddenCardTopPrint() {
		System.out.print("┌─────┐");
	}
	public void hiddenCardMiddlePrint() {
		System.out.println("│＊ ＊ ＊│");
	}
	public void hiddenCardBottomPrint() {
		System.out.println("└─────┘");
	}
	
	
}
