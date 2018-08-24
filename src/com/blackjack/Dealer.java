package com.blackjack;

public class Dealer extends Gamer{
	public Dealer() {
		cards = new Card[MAXCARD];
	}
	@Override
	public int cardSum() {
		int sum = 0;
		for(int i = 0; i < getCardcnt; i++) {
			sum += cards[i].getNum();
		}
		return sum;
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
	
	public void showCard() {
		System.out.println("<<Dealer Card>>");
		
			cards[0].printTopCard();
			for(int i = 1; i < getCardcnt; i++) {
				System.out.print("\t");
				hiddenCardTopPrint();
			}
			System.out.println();
			cards[0].printTopNum();
			for(int i = 1; i < getCardcnt; i++) {
				System.out.print("\t");
				hiddenCardMiddlePrint();
			}
			System.out.println();
			cards[0].printShape();
			for(int i = 1; i < getCardcnt; i++) {
				System.out.print("\t");
				hiddenCardMiddlePrint();
			}
			System.out.println();
			cards[0].printBottomNum();
			for(int i = 1; i < getCardcnt; i++) {
				System.out.print("\t");
				hiddenCardMiddlePrint();
			}
			System.out.println();
			cards[0].printBottomCard();
			for(int i = 1; i < getCardcnt; i++) {
				System.out.print("\t");
				hiddenCardBottomPrint();
			}
			System.out.println();
		
	}
	
	public void hiddenCardTopPrint() {
		System.out.print("┌─────┐");
	}
	public void hiddenCardMiddlePrint() {
		System.out.print("│＊ ＊ ＊│");
	}
	public void hiddenCardBottomPrint() {
		System.out.print("└─────┘");
	}
	
	
}
