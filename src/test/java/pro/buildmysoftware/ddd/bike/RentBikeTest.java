package pro.buildmysoftware.ddd.bike;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class RentBikeTest {
	// @formatter:off
	@DisplayName(
		"simply rent a bike by someone"
	)
	// @formatter:on
	@Test
	void rent0() throws Exception {
		// given
		Bike bike = anyBike();
		User whom = anyUser();

		// when
		LocalDateTime time = anyTime();
		BikeRent bikeRentEvent = bike.rentBy(whom, time);

		// then
		assertThat(bikeRentEvent).isNotNull();
	}

	// @formatter:off
	@DisplayName(
		"when user rents a bike, " +
		"then the event holds the rent time"
	)
	// @formatter:on
	@Test
	void rent1() throws Exception {
		// given
		Bike bike = anyBike();
		User whom = anyUser();
		LocalDateTime time = LocalDateTime.of(2019, 9, 21, 10, 20);

		// when
		BikeRent bikeRent = bike.rentBy(whom, time);

		// then
		assertThat(bikeRent.getRentTime()).isEqualTo(time);
	}

	// @formatter:off
	@DisplayName(
		"given a regular user Patryk who rent a bike, " +
		"when Patryk decides to return a bike after an hour, " +
		"then he needs to pay $20 USD"
	)
	// @formatter:on
	@Test
	void rent2() throws Exception {
		// given
		Bike bike = anyBike();
		User patryk = regularUserWithName("Patryk");
		LocalDateTime rentTime = LocalDateTime.of(2019, 9, 21, 10, 0);
		bike.rentBy(patryk, rentTime);
		Money expectedPayment = Money.of(CurrencyUnit.USD, 20.00);
		LocalDateTime returnTime = rentTime.plusHours(1);

		// when
		BikeReturned bikeReturned = bike.returnBike(returnTime);

		// then
		assertThat(bikeReturned.getPayment())
			.isEqualTo(expectedPayment);
	}

	// @formatter:off
	@DisplayName(
		"given a regular user Patryk who rent a bike, " +
		"when Patryk decides to return a bike after two hours, " +
		"then he needs to pay $40 USD"
	)
	// @formatter:on
	@Test
	void rent3() throws Exception {
		// given
		Bike bike = anyBike();
		User patryk = regularUserWithName("Patryk");
		LocalDateTime rentTime = LocalDateTime.of(2019, 9, 21, 10, 0);
		bike.rentBy(patryk, rentTime);
		Money expectedPayment = Money.of(CurrencyUnit.USD, 40.00);
		LocalDateTime returnTime = rentTime.plusHours(2);

		// when
		BikeReturned bikeReturned = bike.returnBike(returnTime);

		// then
		assertThat(bikeReturned.getPayment())
			.isEqualTo(expectedPayment);
	}

	// @formatter:off
	@DisplayName(
		"given a premium user Patryk who rent a bike, " +
		"when Patryk decides to return a bike after one hour, " +
		"then he needs to pay only $10 USD"
	)
	// @formatter:on
	@Test
	void rent4() throws Exception {
		// given
		Bike bike = anyBike();
		User patryk = premiumUserWithName("Patryk");
		LocalDateTime rentTime = LocalDateTime.of(2019, 9, 21, 10, 0);
		bike.rentBy(patryk, rentTime);
		Money expectedPayment = Money.of(CurrencyUnit.USD, 10.00);
		LocalDateTime returnTime = rentTime.plusHours(1);

		// when
		BikeReturned bikeReturned = bike.returnBike(returnTime);

		// then
		assertThat(bikeReturned.getPayment())
			.isEqualTo(expectedPayment);
	}

	private User premiumUserWithName(String name) {
		return User.premium(name);
	}

	private User regularUserWithName(String patryk) {
		return new User(patryk);
	}

	private LocalDateTime anyTime() {
		return LocalDateTime.MIN;
	}

	private User anyUser() {
		return new User("George");
	}

	private Bike anyBike() {
		return new Bike();
	}
}
