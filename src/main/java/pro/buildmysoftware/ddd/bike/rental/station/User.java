package pro.buildmysoftware.ddd.bike.rental.station;

import lombok.Value;

@Value
public class User {

	private boolean blocked;

	public static User active() {
		return new User(false);
	}

	public static User blocked() {
		return new User(true);
	}
}
