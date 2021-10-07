package com.revature.service;

import java.util.List;

import com.revature.model.Card;

public class CardService {

	public int getSum(List<Card> cards) {

		int sum = 0;
		int aces = 0;
		int value = 0;

		for (Card c : cards) {

			try {
				value = Integer.parseInt(c.getValue());
				sum += value;
			} catch (NumberFormatException e) {}
			
			if (c.getValue().equals("JACK") || c.getValue().equals("QUEEN") || c.getValue().equals("KING")) {
				sum += 10;
			}
			
			if (c.getValue().equals("ACE")) {
				aces++;
			}
		}
		
		while (aces > 0) {
			if (sum <= 10) {
				sum += 11;
				aces--;
			} else {
				sum += 1;
				aces--;
			}
			
		}
		return sum;
	}
}

