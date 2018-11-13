package model;

import enums.CardTypes;

public class CardsModel {
	private int card_id;
	private int deck_id;
	private CardTypes type;
	private String name;
	
	public CardsModel(int card_id, int deck_id,CardTypes type,String name) {
		this.card_id = card_id;
		this.deck_id = deck_id;
		this.type = type;
		this.name = name;
	}
	
	
	public int getCard_id() {
		return card_id;
	}
	public void setCard_id(int card_id) {
		this.card_id = card_id;
	}
	public int getDeck_id() {
		return deck_id;
	}
	public void setDeck_id(int deck_id) {
		this.deck_id = deck_id;
	}
	public CardTypes getType() {
		return type;
	}
	public void setType(CardTypes type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
