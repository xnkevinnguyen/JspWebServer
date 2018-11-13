package finder;

public class CardQueries {
	public static String addCard() {
		 return "insert into cards (deck_id, type, name)"
			        + " values (?, ?, ?)";
	}

}
