package datasource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import database.DBConnection;
import enums.ChallengeStatus;
import model.ChallengesModel;
import model.GameModel;
import finder.ChallengesQueries;
import finder.GameQueries;
import finder.SharedQueries;

public class GameRDG {
	private long game_id; 
	private int user_id;
	private String count;
	
	public boolean insert(long challenge_id, long challenger_id, long challengee_id) {
		
		PreparedStatement findStatement = null;
		long challenger_deckId = 0;
		long challengee_deckId = 0;
		long gameId = 0;
		try {
			DeckRDG deckRdg = new DeckRDG();
			
			// Create a game, followed by creating 2 user decks
			
			findStatement = (PreparedStatement) DBConnection.prepareStatement(GameQueries.createGame());
			findStatement.setLong(1, challenge_id);
			
			findStatement.executeUpdate();
			ResultSet rs = findStatement.getGeneratedKeys();
			if(rs.next())
			{
				gameId = rs.getInt(1);
			}
			
			// Create two decks
			
			challenger_deckId = deckRdg.insert(gameId, challenger_id);
			challengee_deckId = deckRdg.insert(gameId, challengee_id);
			
			findStatement = (PreparedStatement) DBConnection.prepareStatement(GameQueries.updateChallengeDecks());
			findStatement.setLong(1, challenger_deckId);
			findStatement.setLong(2, challengee_deckId);
			findStatement.setLong(3, gameId);
			findStatement.executeUpdate();
			
     
			DBConnection.closeConnection();
			
			return true;
     
		} catch (SQLException e) {
			  e.printStackTrace();
		}
		
		
		return false;
		
	}
	
	
	
	public void delete(long game_id) {
		
		PreparedStatement findStatement = null;
		try {
			findStatement = (PreparedStatement) DBConnection.prepareStatement(GameQueries.deleteGameWithId());
			findStatement.setLong(1, game_id);
			findStatement.executeUpdate();
     
			DBConnection.closeConnection();
     
		} catch (SQLException e) {
			  e.printStackTrace();
		}
		
	}
	
	@SuppressWarnings("null")
	public ArrayList<ChallengesModel> findOpenByChallenger(long challenger_id) {
		PreparedStatement findStatement = null;
		ArrayList<ChallengesModel> challenges = new ArrayList<ChallengesModel>();
		
		try {
			findStatement = (PreparedStatement) DBConnection.prepareStatement(ChallengesQueries.getChallengesByChallengerWithId());
			findStatement.setLong(1,challenger_id);
			
			ResultSet rs = findStatement.executeQuery();
			
			while(rs.next()) {
				ChallengesModel challenge = new ChallengesModel();
				// Challenge ID doesnt seem to be passed back... not sure if its a caching or something else. While debugging, the value is set properly.
				challenge.setChallenge_id(Long.parseLong(rs.getString("challenge_id"))); 
				challenge.setChallenge_id(Long.parseLong(rs.getString("challenger_id")));
				challenge.setChallenge_id(Long.parseLong(rs.getString("challengee_id")));
				challenges.add(challenge);
			}
     
			DBConnection.closeConnection();
     
		} catch (SQLException e) {
			  e.printStackTrace();
		}
		
		return challenges;
	}

	public ArrayList<GameModel> findOpenGames() {
		PreparedStatement findStatement = null;
		ArrayList<GameModel> games = new ArrayList<GameModel>();
		
		try {
			findStatement = (PreparedStatement) DBConnection.prepareStatement(GameQueries.getOpenGames());
			
			ResultSet rs = findStatement.executeQuery();
			
			while(rs.next()) {
				GameModel game = new GameModel();
				game.setGame_id(Long.parseLong(rs.getString("game_id")));
				game.setChallenger_deck(Long.parseLong(rs.getString("challenger_deck")));
				game.setChallengee_deck(Long.parseLong(rs.getString("challengee_deck")));
				games.add(game);
			}
     
			DBConnection.closeConnection();
     
		} catch (SQLException e) {
			  e.printStackTrace();
		}
		
		return games;
	}
	
	
	
	public ArrayList<GameModel> findAll() {
		PreparedStatement findStatement = null;
		ArrayList<GameModel> games = new ArrayList<GameModel>();
		
		try {
			findStatement = (PreparedStatement) DBConnection.prepareStatement(GameQueries.getGames());
			
			ResultSet rs = findStatement.executeQuery();
			
			while(rs.next()) {
				GameModel game = new GameModel();
				game.setGame_id(Long.parseLong(rs.getString("game_id")));
				game.setChallenge_id(Long.parseLong(rs.getString("challenge_id")));
				game.setChallenger_deck(Long.parseLong(rs.getString("challenger_deck")));
				game.setChallengee_deck(Long.parseLong(rs.getString("challengee_deck")));
				games.add(game);
			}
     
			DBConnection.closeConnection();
     
		} catch (SQLException e) {
			  e.printStackTrace();
		}
		
		return games;
	}
	
	public GameModel findGameById(long game_id) {
		PreparedStatement findStatement = null;
		GameModel game = new GameModel();
		
		try {
			findStatement = (PreparedStatement) DBConnection.prepareStatement(GameQueries.getGameWithId());
			findStatement.setLong(1, game_id);
			
			ResultSet rs = findStatement.executeQuery();
			
			if(rs.next()) {
				game.setGame_id(Long.parseLong(rs.getString("game_id")));
				game.setChallenge_id(Long.parseLong(rs.getString("challenge_id")));
				game.setChallenger_deck(Long.parseLong(rs.getString("challenger_deck")));
				game.setChallengee_deck(Long.parseLong(rs.getString("challengee_deck")));
			}
     
			DBConnection.closeConnection();
     
		} catch (SQLException e) {
			  e.printStackTrace();
		}
		
		return game;
	}
	

	

}
