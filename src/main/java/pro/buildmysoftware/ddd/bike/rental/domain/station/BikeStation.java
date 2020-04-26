package pro.buildmysoftware.ddd.bike.rental.domain.station;

import pro.buildmysoftware.ddd.bike.common.AggregateRoot;

import java.util.LinkedList;

@AggregateRoot
public class BikeStation {

	private LinkedList<Bike> availableBikes;
	private LinkedList<Bike> rentBikes;
	private BikeStationId bikeStationId;

	private BikeStation(int numberOfAvailableBikes) {
		rentBikes = new LinkedList<>();
		availableBikes = new LinkedList<>();
		for (int i = 0; i < numberOfAvailableBikes; i++) {
			availableBikes.add(new Bike());
		}
		bikeStationId = new BikeStationId();
	}

	public static BikeStation withAnyRandomSingleBike() {
		return new BikeStation(1);
	}

	public static BikeStation empty() {
		return new BikeStation(0);
	}

	public BikeEvent rentBy(User user) {
		if (availableBikes.size() == 0 || user.isBlocked()) {
			return new BikeRentFailed();
		}
		Bike bike = availableBikes.pop();
		bike.rent();
		rentBikes.add(bike);
		return new BikeRent();
	}
}
