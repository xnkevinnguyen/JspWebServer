package finder;

public class ChallengesQueries {
	public static String createChallenge() {
		 return "insert into challenges (challenger_id, challengee_id)"
			        + " values (?, ?)";
	}
	public static String getChallengesByChallengerWithId() {
		 return "select * from challenges where challenger_id = ?";
	}
	public static String getChallengesByChallengeeWithId() {
		 return "select * from challenges where challenger_id = ?"; // Not sure if I understood... Open by the challengee makes him the challenger.
	}
	public static String getChallenges() {
		 return "select * from challenges where status = OPEN";
	}
	public static String getChallengeWithId() {
		 return "select * from challenges where challenge_id = ?";
	}
	public static String getStatus() {
		return "select status from challenges where challenge_id = ?";
	}
	public static String updateChallengeStatusWithId() {
		return "update challenges set status = ? where challenge_id = ?";
	}
	
	public static String deleteChallengeWithId() {
		 return "delete from challenges where challenge_id = ?";
	}
}
