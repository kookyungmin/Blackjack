package com.blackjack;

abstract public class Gamer {
	protected static final int MAXCARD = 11;
	protected int getCardcnt = 0;
	protected Card[] cards;
	
	abstract public boolean isGetCard();
	
	public int cardSum() {
		int sum = 0;
		boolean cardA=false;							
		for(int i = 0; i < getCardcnt; i++) {	
			int cardNum = cards[i].getNum();
			
			if(cardNum == 11 || cardNum == 12 || cardNum == 13) {
				sum += 10;
			} else if(cardNum == 1){							
				sum += 1;
				cardA = true;
			}else {
				sum += cardNum;
			}
			
		}
		
		if (cardA == true) {					
			sum = sum+10;
			if(sum>21) {
				sum = sum-10;
			}
		}

		return sum;
	}
	public boolean isCheckOver21() {
		boolean isCheckOver21 = false;
		
		if(cardSum()>21) {
			isCheckOver21 = true;
		}
		
		return isCheckOver21;
	}
	
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


