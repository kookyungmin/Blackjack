package com.blackjack;

public class Guest extends Gamer {

	private int money;						//생성자에서 초기화
	private Card[] getCard=new Card[11];	//맴버변수 초기화
	private int index=0;					//맴버변수 초기화
	private int sum = 0;					//맴버변수 초기화
	private boolean win = false;			//승패
	
	public Guest(int money) {
		super(money);
	}

	void card (){
		
	}
	
	void ShowCard() {
		
	}

}
