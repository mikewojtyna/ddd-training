package pro.buildmysoftware.ddd.certit2.expire;

import pro.buildmysoftware.ddd.certit2.issue.Certificate;

import java.time.Clock;
import java.time.LocalDate;
import java.util.Optional;

public class StandardCertificateRevokePolicy implements CertificateRevokePolicy {
	private Clock clock;
	private int gracePeriodInDays;

	public StandardCertificateRevokePolicy(Clock clock,
					       int gracePeriodInDays) {
		this.clock = clock;
		this.gracePeriodInDays = gracePeriodInDays;
	}

	@Override
	public Optional<CertificateRevoked> checkIfRevoked(Certificate certificate) {
		LocalDate currentDate = LocalDate.now(clock);
		if (currentDate.isAfter(certificate.getExpirationDate()
			.plusDays(gracePeriodInDays))) {
			return Optional.of(new CertificateRevoked());
		}
		return Optional.empty();
	}
}
