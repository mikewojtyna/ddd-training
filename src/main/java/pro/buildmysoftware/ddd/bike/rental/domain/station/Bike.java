package pro.buildmysoftware.ddd.bike.rental.domain.station;

import pro.buildmysoftware.ddd.bike.common.DomainEntity;

@DomainEntity
public class Bike {

	private BikeId id;
	private boolean available = true;

	public void rent() {
		// TODO: explore rules and add some business logic
		available = false;
	}
}
