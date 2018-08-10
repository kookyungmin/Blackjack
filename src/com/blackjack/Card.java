package com.blackjack;

public class Card {
	private String shape;
	private int num;
	
	public Card(String shape, int num) {
		this.shape=shape;
		this.num=num;
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
	public void printCard() {
		String num;
		String tnum;
		String bnum;
		if(this.num == 1) {
			num = "A";
		}else if(this.num == 10) {
			num = "10";
		}
		else if(this.num == 11) {
			num = "J";
		}else if(this.num == 12) {
			num = "Q";
		}else if(this.num == 13 ) {
			num = "K";
		}else {
			num = String.valueOf(this.num);
		}
		if(!num.equals("10")) {
			tnum = " " + num;
			bnum = num + " ";
		}else {
			tnum = num;
			bnum = num;
		}
		System.out.println("┌─────┐");
		System.out.println("│   "+tnum+"│");
		System.out.println("│  "+shape+"  │");
		System.out.println("│"+bnum+"   │");
		System.out.println("└─────┘");
	}
}
