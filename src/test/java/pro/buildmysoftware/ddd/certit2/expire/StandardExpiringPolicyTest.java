package pro.buildmysoftware.ddd.certit2.expire;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pro.buildmysoftware.ddd.certit2.issue.Certificate;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class StandardExpiringPolicyTest {
	// @formatter:off
	@DisplayName(
		"given expiring policy, certificate and current time, " +
		"if current is 30 days before certificate expiration date, " +
		"then it's time publish certificate expiring soon event"
	)
	// @formatter:on
	@Test
	void thirtyDaysBefore() throws Exception {
		// given
		// configure policy to tell it's time to notify
		ExpiringPolicy expiringPolicy = new StandardExpiringPolicy();
		// TODO: shared kernel?
		LocalDate expirationDate = anyDate();
		Certificate certificate =
			certificateWithExpirationDate(expirationDate);
		LocalDate currentDate = expirationDate.minusDays(30);

		// when
		Optional<CertificateExpiringSoon> certificateExpiringSoon =
			expiringPolicy
			.checkIfExpires(certificate, currentDate);

		// then
		assertThat(certificateExpiringSoon).isPresent();
	}

	// @formatter:off
	@DisplayName(
		"given current time one day after certificate expiration date, " +
		"then certificate is expired"
	)
	// @formatter:on
	@Test
	void expiredEx0() throws Exception {
		// given
		ExpiringPolicy standardExpiringPolicy =
			new StandardExpiringPolicy();
		LocalDate expirationDate = anyDate();
		Certificate certificate =
			certificateWithExpirationDate(expirationDate);
		LocalDate currentDate = expirationDate.plusDays(1);

		// when
		Optional<CertificateExpired> certficiateExpired =
			standardExpiringPolicy
			.checkIfExpired(certificate, currentDate);

		// then
		assertThat(certficiateExpired).isPresent();
	}

	private Certificate certificateWithExpirationDate(LocalDate expirationDate) {
		return TestFixtureUtils
			.certificateWithExpirationDate(expirationDate);
	}

	private LocalDate anyDate() {
		return LocalDate.now();
	}
}
