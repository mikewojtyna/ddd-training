package pro.buildmysoftware.ddd.bike.rental.primaryadapters;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.buildmysoftware.ddd.bike.common.PrimaryAdapter;
import pro.buildmysoftware.ddd.bike.rental.domain.station.BikeStationId;
import pro.buildmysoftware.ddd.bike.rental.primaryports.BikeRentalService;
import pro.buildmysoftware.ddd.bike.rental.secondaryports.UserId;

import java.security.Principal;

@PrimaryAdapter
@RestController
@RequestMapping("/api/rental")
public class RestRentalService {

	private BikeRentalService bikeRentalService;

	public RestRentalService(BikeRentalService bikeRentalService) {
		this.bikeRentalService = bikeRentalService;
	}

	@PostMapping("/stations/{bikeStation}")
	public void rentBike(@PathVariable("bikeStation") String bikeStationId
		, Principal principal) {
		bikeRentalService
			.rentBikeBy(UserId.valueOf(principal), BikeStationId
				.valueOf(bikeStationId));
	}
}
