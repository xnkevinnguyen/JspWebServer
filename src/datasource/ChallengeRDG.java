package datasource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import database.DBConnection;
import enums.ChallengeStatus;
import model.ChallengesModel;
import finder.ChallengesQueries;

public class ChallengeRDG {
	private long challenge_id; // Soo, never used this...
	private int challenger;
	private String challengee;
	private String status;
	
	public boolean insert(long challenger_id, long challengee_id) {
		
		PreparedStatement findStatement = null;
		try {
			GameRDG gamerdg = new GameRDG();
			findStatement = (PreparedStatement) DBConnection.prepareStatement(ChallengesQueries.createChallenge());
			findStatement.setLong(1, challenger_id);
			findStatement.setLong(2, challengee_id);
			findStatement.executeUpdate();
			
			ResultSet rs = findStatement.getGeneratedKeys();
			if(rs.next())
			{
				int challenge_id = rs.getInt(1);
				gamerdg.insert(challenge_id, challenger_id, challengee_id);
			}
			
			
     
			DBConnection.closeConnection();
			
			return true;
     
		} catch (SQLException e) {
			  e.printStackTrace();
		}
		
		
		return false;
		
	}
	
	public ChallengesModel update(ChallengeStatus status, long challenge_id) {
		ChallengesModel challenge = null;
		
		PreparedStatement findStatement = null;
		try {
			findStatement = (PreparedStatement) DBConnection.prepareStatement(ChallengesQueries.updateChallengeStatusWithId());
			findStatement.setString(1, status.toString());
			findStatement.setLong(2, challenge_id);
			findStatement.executeUpdate();
     
			DBConnection.closeConnection();
     
		} catch (SQLException e) {
			  e.printStackTrace();
		} finally {
			challenge = this.findChallengeById(challenge_id);
		}
		
		return challenge;
	}
	
	public void delete(long challenge_id) {
		
		PreparedStatement findStatement = null;
		try {
			findStatement = (PreparedStatement) DBConnection.prepareStatement(ChallengesQueries.deleteChallengeWithId());
			findStatement.setLong(1, challenge_id);
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

	public ArrayList<ChallengesModel> findOpenByChallengee(long challengee_id) {
		PreparedStatement findStatement = null;
		ArrayList<ChallengesModel> challenges = new ArrayList<ChallengesModel>();
		
		try {
			findStatement = (PreparedStatement) DBConnection.prepareStatement(ChallengesQueries.getChallengesByChallengeeWithId());
			findStatement.setLong(1,challengee_id);
			
			ResultSet rs = findStatement.executeQuery();
			
			while(rs.next()) {
				ChallengesModel challenge = new ChallengesModel();
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
	
	
	
	public ArrayList<ChallengesModel> findAllOpen() {
		PreparedStatement findStatement = null;
		ArrayList<ChallengesModel> challenges = new ArrayList<ChallengesModel>();
		
		try {
			findStatement = (PreparedStatement) DBConnection.prepareStatement(ChallengesQueries.getChallenges());
			
			ResultSet rs = findStatement.executeQuery();
			
			while(rs.next()) {
				ChallengesModel challenge = new ChallengesModel();
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
	
	public ChallengesModel findChallengeById(long challenge_id) {
		PreparedStatement findStatement = null;
		ChallengesModel challenge = new ChallengesModel();
		
		try {
			findStatement = (PreparedStatement) DBConnection.prepareStatement(ChallengesQueries.getChallengeWithId());
			findStatement.setLong(1, challenge_id);
			
			ResultSet rs = findStatement.executeQuery();
			
			if(rs.next()) {
				challenge.setChallenge_id(Long.parseLong(rs.getString("challenge_id")));
				challenge.setChallenge_id(Long.parseLong(rs.getString("challenger_id")));
				challenge.setChallenge_id(Long.parseLong(rs.getString("challengee_id")));
			}
     
			DBConnection.closeConnection();
     
		} catch (SQLException e) {
			  e.printStackTrace();
		}
		
		return challenge;
	}
	

	

}
