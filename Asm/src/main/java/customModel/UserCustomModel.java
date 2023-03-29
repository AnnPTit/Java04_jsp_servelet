package customModel;

public class UserCustomModel {

	private String username, email;

	public UserCustomModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserCustomModel(String username, String email) {
		super();
		this.username = username;
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
