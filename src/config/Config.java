package config;

public class Config {
	private String salt = "";
	private String DB_URL = "";
	
	public Config () {
		this.salt = "rsY3to*STF:$K(,UF|M}U-]Y${)TyW!k9?e[W_qrv}?(}`+|9z^Uw_c-Qum4$z8X";
		this.DB_URL = "jdbc:mysql://localhost/Soen387?user=root&password=root"; 
	}
	
	public String getSalt() {
		return this.salt;
	}
	
	public String getDbUrl() {
		return this.DB_URL;
	}
	
}
