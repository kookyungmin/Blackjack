package com.blackjack;

import java.util.Scanner;

public class Guest extends Gamer {
	Scanner sc = new Scanner(System.in);
	
	public Guest() {
		cards = new Card[MAXCARD];
	}
	
	@Override
	public boolean isGetCard() {
		while(true) {
			int ch = getChoice();
			sc.nextLine();
			switch(ch) {
			case 1:
				return true;
			case 2:
				return false;
			default:
				System.out.println("잘못 입력 하셨습니다.");
				continue;
			}
		}
	}
	
	@Override
	public int cardSum() {
		int sum = 0;
		for(int i = 0; i < getCardcnt; i++) {
			int cardNum = cards[i].getNum();
			if(cardNum == 11 || cardNum == 12 || cardNum == 13) {
				sum += 10;
			}else {
				sum += cardNum;
			}
		}
		return sum;
	}
	
	@Override
	public void openCard() {
		System.out.println("<<Guest Card>>");
		super.openCard();
	}
	
	public int getChoice() {
		System.out.println("─────────────────────");
		System.out.print("카드를 더 받으시겠습니까?(1)YES  (2)NO:");
		try {
			int choice = sc.nextInt();
			return choice;
		}catch(Exception e) {
			return 0;
		}
		
	}
}
