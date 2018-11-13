package model;

public class GameModel {
	private long game_id;
	private long challenge_id;
	private long challenger_deck;
	private long challengee_deck;

	public GameModel () {

	}
	
	public GameModel (int game_id,int challenger_deck,int challengee_deck) {
		this.game_id = game_id;
		this.challenger_deck = challenger_deck;
		this.challengee_deck = challengee_deck;
	}
	
	public long getGame_id() {
		return game_id;
	}
	
	public void setGame_id(long game_id) {
		this.game_id = game_id;
	}
	public long getChallenger_deck() {
		return challenger_deck;
	}
	public void setChallenger_deck(long challenger_deck) {
		this.challenger_deck = challenger_deck;
	}
	public long getChallengee_deck() {
		return challengee_deck;
	}
	public void setChallengee_deck(long challengee_deck) {
		this.challengee_deck = challengee_deck;
	}
	public long getChallenge_id() {
		return challenge_id;
	}

	public void setChallenge_id(long challenge_id) {
		this.challenge_id = challenge_id;
	}
	
	

}
