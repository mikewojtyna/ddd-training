package pro.buildmysoftware.ddd.certit2.issue.exam;

import lombok.Value;

import java.time.LocalDate;

@Value
public class Certificate {
	private final LocalDate expirationDate;
}
