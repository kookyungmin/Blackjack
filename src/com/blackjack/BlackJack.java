package com.blackjack;

import java.util.Scanner;

/*
 * getInt 구현 (예외처리), 테스트
 */
public class BlackJack {
	private boolean isOver21; 
	private Dealer dealer;
	private Guest guest;
	private Deck deck;
	private Scanner sc; 
	private boolean dealerCheck;
	private boolean guestCheck;
	//생성자
	public BlackJack() { 
		this.isOver21 = false;
		this.dealer = new Dealer();
		this.guest = new Guest();
		this.deck = new Deck();
		this.sc = new Scanner(System.in);
		this.dealerCheck = true;
		this.guestCheck = true;
	}
	// 게임 실행하는 매소드
	public void execute() {
		while (true) {
			int ch = execInit();
			sc.nextLine();
			switch(ch) {
			case 1:
				playGame();
				break;
			case 2:
				System.out.println("이용해주셔서 감사합니다");
				return;
			default:
				System.out.println("잘못 입력 하셨습니다.");
				continue;
			}
		}
	}
	
	
	
	//플레이 게임
	private void playGame() {
		System.out.println("─────────────────────");
		System.out.println("  게임을 시작하겠습니다");
		
		// 카드를 섞는다
		deck.suffleCard();
		
		// 카드를 2장씩 나눠준다
		giveInitCard();
		
		// 21넘는사람있는지 확인
		isOver21 = checkOver21();
		if (!isOver21) {
			
			// 카드 화면에 보여줌
			showCard();
			
			// 둘다 카드 안 받을때까지 턴 진행
			while (turn()) {
				// 받았는데 21 넘으면 게임 끝
				isOver21 = checkOver21();
				if (isOver21) {
					break;
				}
				showCard();
			}
		}
		openCard();
		//승자 확인
		checkWinner(isOver21);
		sc.nextLine();
	}
	
	
	
	private int execInit() {
		showInit(); // 초기화면 출력
		int choice = getInt(); // 숫자를 입력받음
		return choice;
	}
	private void showInit() {
		System.out.println("─────────────────────");
		System.out.println("      BLACKJACK      ");
		System.out.println("       ♥ ● ♠ ♣       ");
		System.out.println("─────────────────────");
		System.out.println("      1. 게임시작           ");
		System.out.println("      2. 종료                ");
		System.out.println("─────────────────────");
	}
	
	private int getInt() {
		try {
			System.out.print("번호 입력:");
			return sc.nextInt();
		}catch(Exception e) {
			System.out.println("숫자가 아닙니다.");
			return 0;
		}
	}
	
	private void giveInitCard() {
		giveCardDealer();
		giveCardDealer();
		giveCardGuest();
		giveCardGuest();
	}
	
	private boolean checkOver21() {
		boolean isOver21 = false;
		
		int guestScore = guest.cardSum();
		int dealerScore = dealer.cardSum();
		
		if(guestScore>21 || dealerScore>21) {
			isOver21 = true;
		}
		return isOver21;
	}

	private boolean turn() {
		boolean isNextTurn = true; 
		// 딜러 카드 받을거니?
		if(dealerCheck) {
			dealerCheck = dealer.isGetCard();
		}
		// ok라면 딜러가 카드를 받는다
		if (dealerCheck) {
			giveCardDealer();
		}
		// 게스트 카드 받을거니
		if(guestCheck) {
			guestCheck = guest.isGetCard();
		}
		// ok라면 게스트가 카드를 받는다
		if (guestCheck) {
			giveCardGuest();
		}
		// 둘 다 안받는다고 한다면 false
		if (!guestCheck && !dealerCheck) {
			isNextTurn = false;
		}
		return isNextTurn;
	}
	
	
	private void checkWinner(boolean isOver21) {
		int guestScore = guest.cardSum();
		int dealerScore = dealer.cardSum();
		if(isOver21) {
			if(dealerScore > 21 && guestScore >21) {
				System.out.println("─────────────────────");
				System.out.println("딜러 합:"+dealerScore+", 당신의 합:"+guestScore);
				System.out.println("  게임결과: 비겼습니다");
			
			}else if(guestScore > 21) {
				System.out.println("─────────────────────");
				System.out.println("딜러 합:"+dealerScore+", 당신의 합:"+guestScore);
				System.out.println("게임결과: 딜러가 이겼습니다");
				
			}else {
				System.out.println("─────────────────────");
				System.out.println("딜러 합:"+dealerScore+", 당신의 합:"+guestScore);
				System.out.println("게임결과: 당신이 이겼습니다");
				
			}
		}else {
			if(guestScore > dealerScore) {
				System.out.println("─────────────────────");
				System.out.println("딜러 합:"+dealerScore+", 당신의 합:"+guestScore);
				System.out.println("게임결과: 당신이 이겼습니다");
			}else if(guestScore < dealerScore) {
				System.out.println("─────────────────────");
				System.out.println("딜러 합:"+dealerScore+", 당신의 합:"+guestScore);
				System.out.println("게임결과: 딜러가 이겼습니다");
			}else {
				System.out.println("─────────────────────");
				System.out.println("딜러 합:"+dealerScore+", 당신의 합:"+guestScore);
				System.out.println("  게임결과: 비겼습니다");
			}
		}
	}
	private void showCard() {
		dealer.showCard();
		guest.openCard();
	}
	
	private void openCard() {
		dealer.openCard();
		guest.openCard();
	}
	


	private void giveCardDealer() {
		Card card = deck.giveCard();
		dealer.getCard(card);
	}

	private void giveCardGuest() {
		Card card = deck.giveCard();
		guest.getCard(card);
	}




}
