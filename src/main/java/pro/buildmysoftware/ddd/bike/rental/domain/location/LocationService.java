package pro.buildmysoftware.ddd.bike.rental.domain.location;

import pro.buildmysoftware.ddd.bike.common.DomainService;
import pro.buildmysoftware.ddd.bike.rental.domain.station.BikeStation;

@DomainService
public interface LocationService {

	boolean otherStationExistsAtThis(Location location);

	BikeStation stationAt(Location location);

	void registerStationAt(BikeStation bikeStation, Location location);
}
