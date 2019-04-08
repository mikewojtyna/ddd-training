package pro.buildmysoftware.ddd.bike;

public class BikeRent {

	private final int minutes;

	public BikeRent(int minutes) {
		this.minutes = minutes;
	}

	public int rentTimeInMinutes() {
		return minutes;
	}
}
