package pro.buildmysoftware.ddd.bike;

public class User {
	private String name;
	private boolean premium = false;

	public User(String name) {
		this.name = name;
	}

	public static User premium(String name) {
		User user = new User(name);
		user.premium = true;
		return user;
	}

	public boolean isPremium() {
		return premium;
	}
}
