package datasource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.json.simple.JSONObject;

import com.mysql.jdbc.PreparedStatement;

import database.DBConnection;
import enums.UserRole;
import model.UserModel;
import finder.ListPlayersQueries;
import finder.UserQueries;
import utils.Security;

public class UserRDG {
	private long user_id; // Soo, never used this...
	private int version;
	private String first_name;
	private String email;
	private String password;
	
	public UserModel insert(String first_name, String email, String password) {
		UserModel user;
		
		Security security = new Security();
		
		String hashedPass = security.hashPassword(password);
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String currentTime = sdf.format(date);
		
		PreparedStatement findStatement = null;
		try {
			findStatement = (PreparedStatement) DBConnection.prepareStatement(UserQueries.createUser());
			findStatement.setString(1, first_name);
			findStatement.setString(2, email);
			findStatement.setString(3, hashedPass);
			findStatement.setString(4, currentTime);
			findStatement.setString(5, currentTime);
			findStatement.executeUpdate();
     
			DBConnection.closeConnection();
     
		} catch (SQLException e) {
			  e.printStackTrace();
		} finally {
			user = this.findByEmailAndPassword(email, password);
		}
		
		
		return user;
		
	}
	
	public UserModel update(long user_id, String first_name, String email, String password) {
		UserModel user = null;
		
		PreparedStatement findStatement = null;
		try {
			// Need to cover more cases ... if the user wants to only update a specific column
			findStatement = (PreparedStatement) DBConnection.prepareStatement(UserQueries.getUserWithId());
			findStatement.setString(1, first_name);
			findStatement.setString(2, email);
			findStatement.setString(3, password);
			findStatement.setLong(4, user_id);
			findStatement.executeUpdate();
     
			DBConnection.closeConnection();
     
		} catch (SQLException e) {
			  e.printStackTrace();
		} finally {
			user = this.findById(user_id);
		}
		
		return user;
	}
	
	public void delete(long user_id) {
		
		PreparedStatement findStatement = null;
		try {
			findStatement = (PreparedStatement) DBConnection.prepareStatement(UserQueries.deleteUserWithId());
			findStatement.setLong(1, user_id);
			findStatement.executeUpdate();
     
			DBConnection.closeConnection();
     
		} catch (SQLException e) {
			  e.printStackTrace();
		}
		
	}
	
	@SuppressWarnings("null")
	public UserModel findById(long user_id) {
		
		UserModel user = new UserModel();

		PreparedStatement findStatement = null;
		try {
			findStatement = (PreparedStatement) DBConnection.prepareStatement(UserQueries.getUserWithId());
			findStatement.setLong(1, user_id);
			ResultSet rs = findStatement.executeQuery();
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			
			while (rs.next())
		      {
				user.setUser_id(Long.parseLong(rs.getString("user_id")));
				user.setFirst_name(rs.getString("first_name"));
				user.setEmail(rs.getString("email"));
				user.setRole(rs.getString("role"));
//				user.setCreated(rs.getString("created")); Parsing dates ... sql.TimeStamp, java.Date... Crashes
		      }
     
			DBConnection.closeConnection();
     
		} catch (SQLException e) {
			  e.printStackTrace();
		}
		
		
		return user;
	}
	public long findByUserName(long user_id) {
		UserModel user = new UserModel(user_id);
		
		
		return user_id;
	}
	public UserModel findByEmailAndPassword(String email,String password) {
		UserModel user = null;
		Security security = new Security();

		PreparedStatement findStatement = null;
		
		try {
			findStatement = (PreparedStatement) DBConnection.prepareStatement(UserQueries.getUserPasswordWithEmail());
			findStatement.setString(1, email);
			
			ResultSet rs = findStatement.executeQuery();
			
			
			if(rs.next()) {
				// Check if the hashed password is the same as the entered one.
				if(security.isPasswordValid(password, rs.getString("password"))) {
					user = this.findById(Long.parseLong(rs.getString("user_id")));
				}
		    }
     
			DBConnection.closeConnection();
     
		} catch (SQLException e) {
			  e.printStackTrace();
		}
		
		return user;
	}
	
	public boolean isEmailTaken(String email) {
		PreparedStatement findStatement = null;
		boolean isTaken = false;
		
		try {
			findStatement = (PreparedStatement) DBConnection.prepareStatement(UserQueries.getEmail());
			findStatement.setString(1, email);
			
			ResultSet rs = findStatement.executeQuery();
			
			
			if(rs.next()) {
				// Check if the hashed password is the same as the entered one.
				isTaken = true;
		    }
     
			DBConnection.closeConnection();
     
		} catch (SQLException e) {
			  e.printStackTrace();
		}
		
		return isTaken;
	}
	
	public ArrayList<UserModel> findAll() {
		PreparedStatement findStatement = null;
		ArrayList<UserModel> players = new ArrayList<UserModel>();
		
		try {
			findStatement = (PreparedStatement) DBConnection.prepareStatement(ListPlayersQueries.getPlayers());
			
			ResultSet rs = findStatement.executeQuery();
			
			while(rs.next()) {
				UserModel user = new UserModel();
				user.setUser_id(Long.parseLong(rs.getString("user_id")));
				user.setFirst_name(rs.getString("first_name"));
				user.setEmail(rs.getString("email"));
				user.setRole(rs.getString("role"));
				players.add(user);
			}
     
			DBConnection.closeConnection();
     
		} catch (SQLException e) {
			  e.printStackTrace();
		}
		
		return players;
	}
	

	

}
