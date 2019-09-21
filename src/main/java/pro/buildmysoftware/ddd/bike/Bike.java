package pro.buildmysoftware.ddd.bike;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Bike {
	private LocalDateTime rentTime;

	public BikeRent rentBy(User whom, LocalDateTime time) {
		rentTime = time;
		return new BikeRent(time);
	}

	public BikeReturned returnBike(LocalDateTime returnTime) {
		return new BikeReturned(Money.of(CurrencyUnit.USD, 20.00)
			.multipliedBy(rentTime
				.until(returnTime, ChronoUnit.HOURS)));
	}
}
