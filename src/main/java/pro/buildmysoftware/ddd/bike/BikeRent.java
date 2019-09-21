package pro.buildmysoftware.ddd.bike;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class BikeRent {
	private final LocalDateTime rentTime;
}
