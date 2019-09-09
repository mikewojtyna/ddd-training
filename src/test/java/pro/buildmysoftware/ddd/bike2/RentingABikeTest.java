package pro.buildmysoftware.ddd.bike2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class RentingABikeTest {
	// @formatter:off
	@DisplayName(
		"given user with 100 pln on balance, " +
		"when rent a bike, " +
		"then bike is rent without hard time limit" +
		"and with 6 hours soft time limit"
	)
	// @formatter:on
	@Test
	void test() throws Exception {
		// given
		User user = registeredUserWithBalanceInPln(100.00);
		Bike bike = anyBike();

		// when
		BikeRent bikeRentEvent = bike.rentBy(user, anyTime());

		// then
		assertThat(bikeRentEvent.getSoftLimit()).isEqualTo(6);
		assertThat(bikeRentEvent.getHardLimit())
			.isEqualTo(HardLimit.UNLIMITED);
	}

	// @formatter:off
	@DisplayName(
		"given user with 100 pln on balance who rent a bike, " +
		"when return the bike after 7 hours, " +
		"then financial penalty of value 50 pln is issued"
	)
	// @formatter:on
	@Test
	void test1() throws Exception {
		// given
		User user = registeredUserWithBalanceInPln(100.00);
		Bike bike = anyBike();
		LocalDateTime rentTime = LocalDateTime.of(2019, 9, 1, 10, 0);
		bike.rentBy(user, rentTime);

		// when
		LocalDateTime returnTime = rentTime.plusHours(8);
		BikeReturned bikeReturnedEvent = bike.returnBike(returnTime);

		// then
		assertThat(bikeReturnedEvent.getPenalty()).isEqualTo(50);
	}

	private LocalDateTime anyTime() {
		return LocalDateTime.now();
	}

	private Bike anyBike() {
		return null;
	}

	private User registeredUserWithBalanceInPln(double pln) {
		return null;
	}
}
