package pro.buildmysoftware.ddd.bike.accountmanagement.user;

import lombok.Value;
import org.joda.money.Money;
import pro.buildmysoftware.ddd.bike.rental.station.BikeRent;

@Value
public class User {

	private RentalHistory history;
	private Frauds frauds;
	private Money balance;

	public void updateHistory(BikeRent bikeRent) {

	}
}
