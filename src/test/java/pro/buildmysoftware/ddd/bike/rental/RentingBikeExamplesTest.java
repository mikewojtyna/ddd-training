package pro.buildmysoftware.ddd.bike.rental;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pro.buildmysoftware.ddd.bike.rental.domain.station.*;

import static org.assertj.core.api.Assertions.assertThat;

public class RentingBikeExamplesTest {

	// @formatter:off
	@DisplayName(
	        "given an empty bike station, " +
	        "when rent a bike by active user, " +
	        "then rent fails"
	)
	//@formatter:on
	@Test
	void rentEmpty() throws Exception {
		// given
		BikeStation station = emptyBikeRack();
		User activeUser = activeUser();

		// when
		BikeEvent event = station.rentBy(activeUser);

		// then
		assertThat(event).isInstanceOf(BikeRentFailed.class);
	}

	// @formatter:off
	@DisplayName(
	        "given bike station with one bike, " +
	        "when rent a bike by active user, " +
	        "then bike is rent"
	)
	//@formatter:on
	@Test
	void rentBike() throws Exception {
		// given
		BikeStation rack = bikeStationWithSingleBike();
		User activeUser = activeUser();

		// when
		BikeEvent bikeRentEvent = rack.rentBy(activeUser);

		// then
		assertThat(bikeRentEvent).isInstanceOf(BikeRent.class);
	}

	// @formatter:off
	@DisplayName(
	        "given bike station with one bike, " +
	        "when rent a bike twice by active user, " +
	        "then only first rent succeeds"
	)
	//@formatter:on
	@Test
	void rentTwice() throws Exception {
		// given
		BikeStation bikeStation = bikeStationWithSingleBike();
		User activeUser = activeUser();

		// when
		BikeEvent firstRent = bikeStation.rentBy(activeUser);
		BikeEvent secondRent = bikeStation.rentBy(activeUser);

		// then
		assertThat(firstRent).isNotNull();
		assertThat(secondRent).isInstanceOf(BikeRentFailed.class);
	}

	// @formatter:off
	@DisplayName(
	        "given station with at least one bike, " +
	        "when rent a bike by user who is blocked, " +
	        "then rent fails"
	)
	//@formatter:on
	@Test
	void rentByBlockedUser() throws Exception {
		// given
		BikeStation bikeStation = bikeStationWithSingleBike();
		User blockedUser = blockedUser();

		// when
		BikeEvent bikeEvent = bikeStation.rentBy(blockedUser);

		// then
		assertThat(bikeEvent).isInstanceOf(BikeRentFailed.class);
	}

	private User activeUser() {
		return User.active();
	}

	private User blockedUser() {
		return User.blocked();
	}

	private BikeStation bikeStationWithSingleBike() {
		return BikeStation.withAnyRandomSingleBike();
	}

	private BikeStation emptyBikeRack() {
		return BikeStation.empty();
	}
}
