package pro.buildmysoftware.ddd.bike2;

import lombok.Value;

@Value
public class BikeRent {
	private final int softLimit;
	private final HardLimit hardLimit;
}
