package com.blackjack;

public class Card {
	private String shape;
	private int num;
	private String sNum;
	
	public Card(String shape, int num) {
		this.shape=shape;
		this.num=num;
		chNumString();
	}
	
	public void chNumString() {
		if(num == 1) {
			sNum = "A";
		}else if(num == 10) {
			sNum = "10";
		}
		else if(num == 11) {
			sNum = "J";
		}else if(num == 12) {
			sNum = "Q";
		}else if(num == 13 ) {
			sNum = "K";
		}else {
			sNum = String.valueOf(this.num);
		}
	}
	public void printTopCard() {
		System.out.print("┌─────┐");
	}
	public void printTopNum() {
		String tnum;
		if(!sNum.equals("10")) {
			tnum = " " + sNum;
		}else {
			tnum = sNum;
		}
		System.out.print("│   "+tnum+"│");	
	}
	public void printShape() {
		System.out.print("│  "+shape+"  │");
	}
	public void printBottomNum() {
		String bnum;
		if(!sNum.equals("10")) {
			bnum = sNum + " ";
		}else {
			bnum = sNum;
		}
		System.out.print("│"+bnum+"   │");
	}
	public void printBottomCard() {
		System.out.print("└─────┘");
	}
	
	public String getShape() {
		return shape;
	}
	public void setShape(String shape) {
		this.shape = shape;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
}
