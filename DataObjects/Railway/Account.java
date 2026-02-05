package Railway;

public class Account {
	private String username;
	private String password;
	private String pid;
	
	public Account(String username, String password, String pid) {
		this.username = username;
		this.password = password;
		this.pid = pid;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setPid(String pid) {
		this.pid = pid;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public String getPid() {
		return this.pid;
	}
}