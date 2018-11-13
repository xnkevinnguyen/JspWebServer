package finder;

public class MigrationsQueries {
	@SuppressWarnings("unused")
	public String createUsersTable() {
		return "CREATE TABLE IF NOT EXISTS `users` (\n" + 
    			"  `user_id` int(11) unsigned NOT NULL AUTO_INCREMENT,\n" + 
				"  `first_name` varchar(80)  NOT NULL, \n " +
    			"  `email` varchar(254) DEFAULT NULL COMMENT 'https://en.wikipedia.org/wiki/Email_address#Syntax',\n" + 
    			"  `password` varchar(80) DEFAULT '',\n" + 
    			"  `role` enum('MEMBER','ADMIN','DISABLED') NOT NULL DEFAULT 'MEMBER',\n" + 
    			"  `last_login` datetime DEFAULT '2013-11-01 00:00:00',\n" + 
    			"  `created` datetime DEFAULT NULL,\n" + 
    			"  PRIMARY KEY (`user_id`)\n" + 
    			") ENGINE=InnoDB AUTO_INCREMENT=15893 DEFAULT CHARSET=utf8;";
	}
	@SuppressWarnings("unused")
	public String createChallengesTable() {
		return "create TABLE IF NOT EXISTS `challenges` (\n" +
    			" `challenge_id` int(11) unsigned NOT NULL AUTO_INCREMENT, \n "+
    			" `challenger_id` int unsigned NOT NULL, \n " + 
    			" `challengee_id` int unsigned NOT NULL, \n " + 
    			" `status` enum('OPEN','REFUSED','WITHDRAWN','ACCEPTED') NOT NULL DEFAULT 'OPEN', \n" + 
//    			"  FOREIGN KEY (challenge_id) REFERENCES game(game_id)\n"+ Errors when inserting ... on cascade for inserts doesnt seem to be well documented 
    			"  PRIMARY KEY (`challenge_id`)\n" +
    			") ENGINE=InnoDB CHARSET=utf8;";
	}
	@SuppressWarnings("unused")
	public String createGameTable() {
		return "create TABLE IF NOT EXISTS `game` (\n" +
    			" `game_id` int(11) unsigned NOT NULL AUTO_INCREMENT, \n "+
    			" `challenge_id` int(11) unsigned NOT NULL, \n "+
    			" `challenger_deck` int unsigned NOT NULL DEFAULT 0, \n " + 
    			" `challengee_deck` int unsigned NOT NULL DEFAULT 0, \n" +
//    			" FOREIGN KEY (challenger_deck) REFERENCES deck(deck_id), \n "+
//    			" FOREIGN KEY (challengee_deck) REFERENCES deck(deck_id), \n" +
    			" PRIMARY KEY (`game_id`)\n" +
    			") ENGINE=InnoDB CHARSET=utf8;";
	}
	@SuppressWarnings("unused")
	public String createDeckTable() {
		return "create TABLE IF NOT EXISTS `deck` (\n" +
				" `deck_id` int(11) unsigned NOT NULL AUTO_INCREMENT, \n "+
				" `game_id` int(11) unsigned NOT NULL, \n "+
				" `user_id` int(11) unsigned NOT NULL, \n "+
				" `card_count` int unsigned NOT NULL, \n"+
				"  PRIMARY KEY (`deck_id`)\n"+
				") ENGINE=InnoDB CHARSET=utf8;";
	}
	@SuppressWarnings("unused")
	public String createCardsTable() {
		return	"create TABLE IF NOT EXISTS `cards` (\n" +
				" `card_id` int(11) unsigned NOT NULL AUTO_INCREMENT, \n "+
				" `deck_id` int unsigned NOT NULL, \n " + 
				" `type` enum('e','p','t') NOT NULL, \n " + 
				" `name` varchar(80) NOT NULL, \n" +
//				" FOREIGN KEY (deck_id) REFERENCES deck(deck_id), \n" + 
				" PRIMARY KEY (`card_id`)\n" +
				") ENGINE=InnoDB CHARSET=utf8;";
	}
	
	
}
