package finder;

public class GameQueries {
	public static String createGame() {
		 return "insert into game (challenge_id)"
			        + " values (?)";
	}
	public static String getOpenGames() {
		 return "select * from game LEFT JOIN challenges ON game.challenge_id = challenges.challenge_id where challenges.status = OPEN AND challenges.status = ACCEPTED";
	}
	public static String getCloseGames() {
		 return "select * from game LEFT JOIN challenges ON game.challenge_id = challenges.challenge_id where challenges.status = WITHDRAWN AND challenges.status = REFUSED";
	}
	public static String getGames() {
		 return "select * from game";
	}
	public static String getGameWithId() {
		 return "select * from game where game_id = ?";
	}
	public static String getStatus() {
		return "select status from game NATURAL JOIN challenges where game.challenge_id = ?";
	}
	public static String updateChallengeDecks() {
		return "update game set challenger_deck = ?, challengee_deck = ? where game_id = ?";
	}
	
	public static String deleteGameWithId() {
		 return "delete from game where game_id = ?";
	}
}
