package com.blackjack;

public class Gamer {
	private int money;						//생성자에서 초기화
	private Card[] card=new Card[11];		//맴버변수 초기화
	private int index=0;					//맴버변수 초기화
	
	//생성자
	public  Gamer(int money){
		this.money=money;

	}
	//카드를 받는다
	public void getCard(Card card){
		this.card[index++] = card;		
		// this.내가 받은 카드를 저장하는 배열 이름 = 저장 할 공간 이름(getCard의 매개변수 Card card);
	}
	
	
	
	//카드를 보여준다
	public Card showCard(getCard) {
		this.card[index++] = card;
		int i =0;
		
		while (i<=index) {						//	Q1 (int i=0<=index) 안되는건가?..
			System.out.println(card);
		}	
		return card;
	}
	
	//카드의 합을 구한다
 
	//Gamer의 카드합과 21의 차이를 구한다(승패결정)
	//돈을 분배한다
	
}
//public 반환형 함수이름(매개변수타입 매개변수명){
//}
//클래스의 이름은 자료형(ex int, double...)같은 거지만 주소를 전달하는 참조형임.
//
//
//public  getCard(Card card){
//    return card;
//}