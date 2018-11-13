package finder;

public class SharedQueries {
	/*
	 * https://dev.mysql.com/doc/refman/8.0/en/information-functions.html#function_last-insert-id
	 * 
	 * The ID that was generated is maintained in the server on a 
	 * per-connection basis. This means that the value returned by the 
	 * function to a given client is the first AUTO_INCREMENT value generated 
	 * for most recent statement affecting an AUTO_INCREMENT column by that 
	 * client. This value cannot be affected by other clients, even if they 
	 * generate AUTO_INCREMENT values of their own. This behavior ensures that
	 *  each client can retrieve its own ID without concern for the activity of
	 *   other clients, and without the need for locks or transactions.
	 */
	public static String getLastInsertedId() {
		return "SELECT LAST_INSERT_ID()";
	}
}
