package pro.buildmysoftware.ddd.bike.rental.domain.station;

import pro.buildmysoftware.ddd.bike.common.AggregateRoot;

@AggregateRoot
public class BikeStation {

	private int availableBikes;
	private BikeStationId bikeStationId;

	private BikeStation(int availableBikes) {
		this.availableBikes = availableBikes;
	}

	public static BikeStation withAnyRandomSingleBike() {
		return new BikeStation(1);
	}

	public static BikeStation empty() {
		return new BikeStation(0);
	}

	public BikeEvent rentBy(User user) {
		if (availableBikes == 0 || user.isBlocked()) {
			return new BikeRentFailed();
		}
		availableBikes--;
		return new BikeRent();
	}
}
