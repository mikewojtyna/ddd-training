package pro.buildmysoftware.ddd.bike;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Bike {
	private User whom;
	private LocalDateTime rentTime;

	public BikeRent rentBy(User whom, LocalDateTime time) {
		this.whom = whom;
		rentTime = time;
		return new BikeRent(time);
	}

	public BikeReturned returnBike(LocalDateTime returnTime) {
		return new BikeReturned(calculatePayment(returnTime));
	}

	private Money calculatePayment(LocalDateTime returnTime) {
		return Money.of(CurrencyUnit.USD, 20.00).multipliedBy(rentTime
			.until(returnTime, ChronoUnit.HOURS))
			.multipliedBy(1.0 - userDiscount(),
				RoundingMode.HALF_UP);
	}

	private double userDiscount() {
		if (whom.isPremium()) {
			return 0.5;
		}
		return 0;
	}
}
