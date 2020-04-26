package pro.buildmysoftware.ddd.bike.rental.primaryadapters;

import pro.buildmysoftware.ddd.bike.common.PrimaryAdapter;
import pro.buildmysoftware.ddd.bike.rental.domain.station.BikeStationId;
import pro.buildmysoftware.ddd.bike.rental.primaryports.BikeRentalService;
import pro.buildmysoftware.ddd.bike.rental.secondaryports.UserId;

@PrimaryAdapter
public class CliRentalService {

	private BikeRentalService bikeRentalService;

	public CliRentalService(BikeRentalService bikeRentalService) {
		this.bikeRentalService = bikeRentalService;
	}

	public void rentBike(String[] args) {
		bikeRentalService
			.rentBikeBy(parseUserId(args),
				parseBikeStationId(args));
	}

	private BikeStationId parseBikeStationId(String[] args) {
		return null;
	}

	private UserId parseUserId(String[] args) {
		return null;
	}
}
