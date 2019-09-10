package pro.buildmysoftware.ddd.certit2.expire;

import pro.buildmysoftware.ddd.certit2.issue.Certificate;

import java.time.LocalDate;

public class TestFixtureUtils {
	public static Certificate certificateWithExpirationDate(LocalDate expirationDate) {
		return new Certificate(expirationDate);
	}
}
