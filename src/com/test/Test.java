package com.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {

	public static void main(String[] args) {

		  List<Integer> cardNum = new ArrayList<Integer>();
	         
	        for (int i = 0; i <= 51; i++) {
	            cardNum.add(i);
	        }
	        // set���� ���� �������� ���´�
	        Collections.shuffle(cardNum);
	 
	        int[] shuffledNum = new int[52];
	        for (int i = 0; i < 52; i++) {
	            shuffledNum[i] = cardNum.get(i);
	        }
	        for (int i = 0; i < 52; i++) {
	            System.out.println(shuffledNum[i]);
	        }
	}

}
