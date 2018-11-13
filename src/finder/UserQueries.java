package finder;


public class UserQueries {
	
	public static String createUser() {
		 return "insert into users (first_name, email, password, last_login, created)"
			        + " values (?, ?, ?, ?, ?)";
	}
	public static String getUserWithId() {
		 return "select user_id, first_name, email, last_login, role, created  from users where user_id = ?";
	}
	public static String getEmail() {
		return "select email from users where email = ?";
	}
	public static String getUserPasswordWithEmail() {
		 return "select user_id, password from users where email = ?";
	}
	public static String updateUserFirstNameWithId() {
		 return "update users set first_name = ?  where user_id = ?";
	}
	public static String updateUserEmailWithId() {
		 return "update users set email = ?  where user_id = ?";
	}
	public static String updateUserPasswordWithId() {
		 return "update users set password  = ?  where user_id = ?";
	}
	public static String updateUserWithId() {
		 return "update users set first_name = ?, email = ?, password  = ?  where user_id = ?";
	}
	public static String updateUserLastLoginWithId() {
		 return "update users set last_login = ? where user_id = ?";
	}
	public static String deleteUserWithId() {
		 return "delete from users where user_id = ?";
	}
	
	
}
