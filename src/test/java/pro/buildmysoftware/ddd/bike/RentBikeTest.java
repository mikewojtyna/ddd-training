package pro.buildmysoftware.ddd.bike;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RentBikeTest {

	// @formatter:off
	@DisplayName(
		"can rent a bike"
	)
	// @formatter:on
	@Test
	void test() throws Exception {
		// given
		BikeRack bikeRack = anyBikeRack();

		// when
		BikeRent bikeRent = bikeRack.rent();

		// then
		assertThat(bikeRent).isNotNull();
	}

	private BikeRack anyBikeRack() {
		return new BikeRack();
	}
}
