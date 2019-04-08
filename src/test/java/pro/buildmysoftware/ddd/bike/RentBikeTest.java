package pro.buildmysoftware.ddd.bike;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowableOfType;

public class RentBikeTest {

	// @formatter:off
	@DisplayName(
		"user can rent a bike for 20 minutes, " +
		"when she has at least $5 in her account"
	)
	// @formatter:on
	@Test
	void test1() throws Exception {
		// given
		Bike bike = new Bike();
		User user = userWithSomeDollarsInAccount(6);

		// when
		BikeRent event = bike.rentBy(user);

		// then
		assertThat(event.rentTimeInMinutes()).isEqualTo(20);
	}

	// @formatter:off
	@DisplayName(
		"user cannot rent a bike at all, " +
		"when she has less than $5 in her account"
	)
	// @formatter:on
	@Test
	void test2() throws Exception {
		// given
		User veryPoorUser = userWithSomeDollarsInAccount(4);
		Bike bike = anyBike();

		// when
		CannotRentABike cannotRentABike =
			catchThrowableOfType(() -> bike
			.rentBy(veryPoorUser), CannotRentABike.class);

		// then
		assertThat(cannotRentABike).isNotNull()
			.hasMessage("EX_INSUFFICIENT_FUNDS");
	}

	private Bike anyBike() {
		return new Bike();
	}

	private User anyUser() {
		return userWithSomeDollarsInAccount(0);
	}

	private User userWithSomeDollarsInAccount(int someDollars) {
		return new User(someDollars);
	}
}
