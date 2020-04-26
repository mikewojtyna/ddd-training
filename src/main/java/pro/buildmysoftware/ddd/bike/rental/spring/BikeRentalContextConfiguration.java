package pro.buildmysoftware.ddd.bike.rental.spring;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pro.buildmysoftware.ddd.bike.common.EventPublisher;
import pro.buildmysoftware.ddd.bike.rental.domain.station.BikeStation;
import pro.buildmysoftware.ddd.bike.rental.domain.station.BikeStationId;
import pro.buildmysoftware.ddd.bike.rental.domain.station.BikeStationRepository;
import pro.buildmysoftware.ddd.bike.rental.primaryports.BikeRentalService;
import pro.buildmysoftware.ddd.bike.rental.secondaryadapters.AccountManagementUserIdentityService;
import pro.buildmysoftware.ddd.bike.rental.secondaryports.UserIdentityService;

import java.util.Optional;

@Configuration
public class BikeRentalContextConfiguration {

	@Bean
	public BikeRentalService bikeRenstalService(EventPublisher eventPublisher, UserIdentityService identityServie, BikeStationRepository repository) {
		return new BikeRentalService(eventPublisher, identityServie,
			repository);
	}

	@Bean
	public EventPublisher eventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		return applicationEventPublisher::publishEvent;
	}

	@Bean
	public UserIdentityService userIdentityService() {
		return new AccountManagementUserIdentityService();
	}

	@Bean
	public BikeStationRepository bikeStationRepository() {
		return new BikeStationRepository() {
			@Override
			public Optional<BikeStation> findById(BikeStationId stationId) {
				return Optional.empty();
			}

			@Override
			public void save(BikeStation bikeStation) {

			}
		};
	}
}
