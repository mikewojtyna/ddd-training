package pro.buildmysoftware.ddd.bike.rental.domain.station;

import pro.buildmysoftware.ddd.bike.common.DomainRepostiory;

import java.util.Optional;

@DomainRepostiory
public interface BikeStationRepository {

	Optional<BikeStation> findById(BikeStationId stationId);

	void save(BikeStation bikeStation);
}
