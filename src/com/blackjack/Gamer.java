package com.blackjack;

public class Gamer {
	private int money;						//생성자에서 초기화
	private Card[] getCard=new Card[11];	//맴버변수 초기화
	private int index=0;					//맴버변수 초기화
	private int sum = 0;					//맴버변수 초기화
	private int win = 0;			//승패 [dealer 기준 -1:패 / 0:무승부 / 1:승
	private int max=0;						//맴버변수 초기화
	private int prizeMoney = 10000;
	
	Dealer dealer = new Dealer();			//********메인갈거
	Guest guest = new Guest();				//********메인갈거

	//생성자
	public  Gamer(int money){
		this.money=money;

	}
	//카드를 받는다
	public void card(Card card){
		this.getCard[index++] = card;		
		// this.내가 받은 카드를 저장하는 배열 이름 = 저장 할 공간 이름(card의 매개변수 Card card);
	}
	
	
	
	//카드를 보여준다
	private void ShowCard() {
		for (int i = 0; i < getCard.length; i++) {
			System.out.println(getCard[i]);
		}
	}
	
	//카드의 합을 구한다
	private int cardSum() {
		for (int i = 0; i < getCard.length; i++) {
			Card card = getCard[i];
			if(card.getNum()==11||card.getNum()==12||card.getNum()==13) {
				sum += 11;
			}else {
				sum += card.getNum();
			}
		}
		return sum;
	}
		
	//Gamer의 카드합과 21의 차이를 구한다(승패결정)

	private int score() {	//guest기준으로 작성									// 메인메소드로 이동??????
		
		if(sum == max) {	
			win = -1;								//guest가 이겼으므로 dealer는 패배. 그래서 -1
			if(dealer.sum == guest.sum) {
				win = 0;
			}
		}else if(sum > max){
			win = 1;
			if(dealer.sum > max && guest.sum > max) {
				win = 0;
			}
		}else {
			if(dealer.sum > guest.sum) {
				win = 1;
			}else if(dealer.sum = guest.sum) {
				win = 0;
			}else {
				win = -1;
			}
		}
		
		return win;
		
	}
	
	//돈을 분배한다												(Dealer)만 하는건가??
	private void result() {
		
		switch(win){
			case -1 :	// dealer 패배
				System.out.println("우승하셨습니다.");				// guest 기준
				dealer.money = dealer.money - prizeMoney;
				guest.money = guest.money + prizeMoney;
				break;
			case 0 :	//무승부
				System.out.println("무승부입니다.");
				break;
			case 1 :	// dealer 우승
				System.out.println("게임에서 패하셨습니다.");			// guest 기준
				dealer.money = dealer.money + prizeMoney;
				guest.money = guest.money - prizeMoney;
				break;
		}
	}
}


