package pro.buildmysoftware.ddd.bike;

public class User {
	private final int funds;

	public User(int funds) {
		this.funds = funds;
	}

	public int funds() {
		return funds;
	}
}
