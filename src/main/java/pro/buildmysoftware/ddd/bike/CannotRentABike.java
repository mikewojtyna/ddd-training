package pro.buildmysoftware.ddd.bike;

public class CannotRentABike extends RuntimeException {
	public CannotRentABike(String message) {
		super(message);
	}

	public CannotRentABike(String message, Throwable cause) {
		super(message, cause);
	}

	public CannotRentABike() {

	}
}
