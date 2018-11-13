package datasource;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.PreparedStatement;

import database.DBConnection;
import model.DeckModel;
import finder.DeckQueries;

public class DeckRDG {
	private long game_id;
	private int user_id;
	private String count;
	
	public int insert(long game_id, long user_id) {
		
		PreparedStatement findStatement = null;
		int deckid = 0;
		long count = 0;
		try {
			findStatement = (PreparedStatement) DBConnection.prepareStatement(DeckQueries.createUserDeck());
			findStatement.setLong(1, game_id);
			findStatement.setLong(2, user_id);
			findStatement.setLong(3, count);
			findStatement.executeUpdate();
			
			ResultSet rs = findStatement.getGeneratedKeys();
			if(rs.next())
			{
				deckid = rs.getInt(1);
			}
     
			DBConnection.closeConnection();
			
     
		} catch (SQLException e) {
			  e.printStackTrace();
		}
		
		
		return deckid;
		
	}
	
	public DeckModel findUserWithDeckId(long deck_id) {
		PreparedStatement findStatement = null;
		DeckModel deck = new DeckModel();
		
		try {
			findStatement = (PreparedStatement) DBConnection.prepareStatement(DeckQueries.getDeckUserId());
			findStatement.setLong(1, deck_id);
			
			ResultSet rs = findStatement.executeQuery();
			
			if(rs.next()) {
				deck.setDeck_id(Long.parseLong(rs.getString("deck_id")));
				deck.setGame_id(Long.parseLong(rs.getString("game_id")));
				deck.setUser_id(Long.parseLong(rs.getString("user_id")));
			}
     
			DBConnection.closeConnection();
     
		} catch (SQLException e) {
			  e.printStackTrace();
		}
		
		return deck;
	}
	

	

}
