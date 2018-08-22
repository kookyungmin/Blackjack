package com.blackjack;
/*
 * getInt 구현 (예외처리), 테스트
 */
public class BlackJack {
	private Dealer dealer;
	private Guest guest;
	private Deck deck;

	public BlackJack() {
		this.dealer = new Dealer();
		this.guest = new Guest();
		this.deck = new Deck();
	}

	public void execute() {
		// 게임 실행하는 매소드
		outer: while (execInit() == 1) {
			System.out.println("게임을 시작하겠습니다");
			// 카드를 섞는다
			deck.suffleCard();

			// 카드를 2장씩 나눠준다
			giveInitCard();

			// 21넘는사람있는지 확인
			if (checkOver21()) {
				continue;
			}

			// 카드를 처음 방식으로 오픈한다
			initOpenCard();

			// 둘다 카드 안 받을때까지 턴
			while (turn()) {
				// 받았는데 21 넘으면 게임 끝
				if (checkOver21()) {
					continue outer;
				}
				showCard();
			}
			
			//승자 확인
			checkWinner();
			System.out.println("─────────────────────");
			System.out.println("    게임이 끝났습니다!");
		}
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
		return 0;
	}

	private void giveInitCard() {
		giveCardDealer();
		giveCardDealer();
		giveCardGuest();
		giveCardGuest();
	}

	private void giveCardDealer() {
		Card card = deck.giveCard();
		dealer.getCard(card);
	}

	private void giveCardGuest() {
		Card card = deck.giveCard();
		guest.getCard(card);
	}

	// 처음카드 보여줌
	private void initOpenCard() {
		dealer.initOpenCard();
		guest.openCard();

	}

	// 추가카드 보여줌
	private void showCard() {
		dealer.showCard();
		guest.openCard();
	}

	private boolean turn() {
		boolean result = true;

		// 딜러 카드 받을거니?
		boolean dealerCheck = dealer.isGiveCard();
		// ok라면 딜러가 카드를 받는다
		if (dealerCheck) {
			giveCardDealer();
			checkOver21();
		}
		// 게스트 카드 받을거니
		boolean guestCheck = guest.isGiveCard();
		// ok라면 게스트가 카드를 받는다
		if (guestCheck) {
			giveCardGuest();
			checkOver21();
		}
		// 둘 다 안받는다고 한다면 false
		if (!guestCheck && !dealerCheck) {
			result = false;
		}
		return result;
	}

	private boolean checkOver21() {
		boolean result = false;
		
		int guestScore = guest.cardSum();
		int dealerScore = dealer.cardSum();
		
		if(guestScore>21 && dealerScore>21) {
			openCard();
			System.out.println("둘 다 21이 넘어서 비겼습니다");
			result = true;
		}else if(guestScore>21) {
			openCard();
			System.out.println("당신이 21이 넘어서 딜러가 이겼습니다");
			result = true;
		}else if(dealerScore>21) {
			openCard();
			System.out.println("딜러가 21이 넘어서 당신이 이겼습니다");
			result = true;
		}
		
		return result;
	}

	// 게임 끝나고 카드를 보여줌
	private void openCard() {
		dealer.openCard();
		guest.openCard();
	}

	private void checkWinner() {
		int guestScore = guest.cardSum();
		int dealerScore = dealer.cardSum();
		
		openCard();
		
		if(guestScore > dealerScore) {
			System.out.println("당신이 이겼습니다");
		}else if(guestScore < dealerScore) {
			System.out.println("딜러가 이겼습니다");
		}else {
			System.out.println("비겼습니다");
		}
	}

}
