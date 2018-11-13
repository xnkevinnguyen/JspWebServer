package utils;

import utils.BCrypt;

public class Security {
	
	public String hashPassword(String password) {
		return BCrypt.hashpw(password, BCrypt.gensalt());
	}
	
	public boolean isPasswordValid(String passwordEntered, String hash) {
		return BCrypt.checkpw(passwordEntered, hash);
	}

}
