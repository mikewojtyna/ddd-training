package pro.buildmysoftware.ddd.bike;

import lombok.Value;
import org.joda.money.Money;

@Value
public class BikeReturned {
	private final Money payment;
}
