package finder;

public class DeckQueries {
	public static String createUserDeck() {
		 return "insert into deck (game_id, user_id, card_count)"
			        + " values (?, ?, ?)";
	}
	public static String getDeckUserId() {
		 return "select * from deck where deck_id = ? ";
	}
}
