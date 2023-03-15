package lesson023.entity.data;

public abstract class Person {

	private String id;
	private String email;
	private String password;

	public Person(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	public abstract String randomGenerateId();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}