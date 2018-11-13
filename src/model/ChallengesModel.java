package model;

import enums.ChallengeStatus;

public class ChallengesModel {
	private long challenge_id;
	private long challenger_id;
	private long challengee_id;
	private ChallengeStatus status;

	public ChallengesModel() {
		
	}
	
	public ChallengesModel(int challenge_id, int challenger_id, int challengee_id,ChallengeStatus status) {
		this.challenge_id = challenge_id;
		this.challenger_id = challenger_id;
		this.challengee_id = challengee_id;
		this.status = status;
	}
	
	public long getChallenge_id() {
		return challenge_id;
	}
	public void setChallenge_id(long challenge_id) {
		this.challenge_id = challenge_id;
	}
	public long getChallenger_id() {
		return challenger_id;
	}
	public void setChallenger_id(int challenger_id) {
		this.challenger_id = challenger_id;
	}
	public long getChallengee_id() {
		return challengee_id;
	}
	public void setChallengee_id(int challengee_id) {
		this.challengee_id = challengee_id;
	}
	public ChallengeStatus getStatus() {
		return status;
	}
	public void setStatus(ChallengeStatus status) {
		this.status = status;
	}
	
}
