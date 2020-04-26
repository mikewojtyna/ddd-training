package pro.buildmysoftware.ddd.bike.rental.domain.station;

import pro.buildmysoftware.ddd.bike.common.DomainFactory;
import pro.buildmysoftware.ddd.bike.rental.domain.location.Location;
import pro.buildmysoftware.ddd.bike.rental.domain.location.LocationService;

@DomainFactory
public class BikeStationFactory {

	private LocationService locationService;

	public BikeStationFactory(LocationService locationService) {
		this.locationService = locationService;
	}

	public BikeStation bikeStationAtLocation(Location location) {
		if (locationService.otherStationExistsAtThis(location)) {
			return locationService.stationAt(location);
		}
		BikeStation bikeStation = BikeStation.empty();
		locationService.registerStationAt(bikeStation, location);
		return bikeStation;
	}
}
