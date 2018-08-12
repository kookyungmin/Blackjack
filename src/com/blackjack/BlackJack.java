package com.blackjack;

public class BlackJack {
	
	private Object setNum;

	public Gamer printView() {
		
		Gamer show = showCard();
		String hi = "블랙잭에 오신것을 환영합니다.";			
		
		//출력
		System.out.println(hi);
		Gamer gamer = new Gamer();
		
		System.out.println(Gamer.showCard());
		return printView();
	}
	
}
