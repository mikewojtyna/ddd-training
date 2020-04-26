package pro.buildmysoftware.ddd.bike.rental.primaryports;

import pro.buildmysoftware.ddd.bike.common.EventPublisher;
import pro.buildmysoftware.ddd.bike.common.PrimaryPort;
import pro.buildmysoftware.ddd.bike.rental.secondaryports.UserId;
import pro.buildmysoftware.ddd.bike.rental.secondaryports.UserIdentityService;
import pro.buildmysoftware.ddd.bike.rental.station.BikeEvent;
import pro.buildmysoftware.ddd.bike.rental.station.BikeStationId;
import pro.buildmysoftware.ddd.bike.rental.station.BikeStationRepository;

@PrimaryPort
public class BikeRentalService {

	private EventPublisher eventPublisher;
	private UserIdentityService userIdentityService;
	private BikeStationRepository bikeStationRepository;

	public BikeRentalService(EventPublisher eventPublisher,
				 UserIdentityService userIdentityService,
				 BikeStationRepository bikeStationRepository) {
		this.eventPublisher = eventPublisher;
		this.userIdentityService = userIdentityService;
		this.bikeStationRepository = bikeStationRepository;
	}

	public void rentBikeBy(UserId userId, BikeStationId stationId) {
		userIdentityService.findUser(userId)
			.ifPresent(user -> bikeStationRepository
				.findById(stationId).ifPresent(bikeStation -> {
					BikeEvent bikeEvent = bikeStation
						.rentBy(user);
					bikeStationRepository.save(bikeStation);
					eventPublisher.publish(bikeEvent);
				}));
	}
}
