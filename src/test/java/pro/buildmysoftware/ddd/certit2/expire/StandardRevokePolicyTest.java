package pro.buildmysoftware.ddd.certit2.expire;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pro.buildmysoftware.ddd.certit2.issue.exam.Certificate;

import java.time.Clock;
import java.time.LocalDate;
import java.time.ZoneOffset;

import static org.assertj.core.api.Assertions.assertThat;
import static pro.buildmysoftware.ddd.certit2.expire.TestFixtureUtils.certificateWithExpirationDate;

public class StandardRevokePolicyTest {
	// @formatter:off
	@DisplayName(
		"given certificate and current date 30 days after " +
		"expiration date, " +
		"then certificate is revoked"
	)
	// @formatter:on
	@Test
	void test() throws Exception {
		// given
		LocalDate expirationDate = anyDate();
		Certificate certificate =
			certificateWithExpirationDate(expirationDate);
		Clock clock = Clock
			.fixed(expirationDate.plusDays(30).atStartOfDay()
				.toInstant(ZoneOffset.UTC), ZoneOffset.UTC);
		CertificateRevokePolicy policy =
			new StandardCertificateRevokePolicy(clock, 29);

		// when
		boolean certificateRevoked =
			policy.checkIfRevoked(certificate);

		// then
		assertThat(certificateRevoked).isTrue();
	}

	private LocalDate anyDate() {
		return LocalDate.now();
	}
}
