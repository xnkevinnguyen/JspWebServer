package model;

public class DeckModel {
	private long deck_id;
	private long game_id;
	private long user_id;
	private long card_count;
	
	public DeckModel() {
		
	}
	
	public long getGame_id() {
		return game_id;
	}

	public void setGame_id(long game_id) {
		this.game_id = game_id;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public DeckModel(long deck_id,long card_count) {
		this.deck_id = deck_id;
		this.card_count = card_count;
	}
	
	public long getDeck_id() {
		return deck_id;
	}

	public void setDeck_id(long deck_id) {
		this.deck_id = deck_id;
	}
	public long getCard_count() {
		return card_count;
	}
	public void setCard_count(long card_count) {
		this.card_count = card_count;
	}
	
	

}
