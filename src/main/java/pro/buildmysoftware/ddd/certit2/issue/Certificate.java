package pro.buildmysoftware.ddd.certit2.issue;

import lombok.Value;

import java.time.LocalDate;

@Value
public class Certificate {
	private final LocalDate expirationDate;
}
