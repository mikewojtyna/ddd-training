package pro.buildmysoftware.ddd.certit2.expire;

import pro.buildmysoftware.ddd.certit2.issue.exam.Certificate;

import java.time.Clock;
import java.time.LocalDate;

public class StandardCertificateRevokePolicy implements CertificateRevokePolicy {
	private Clock clock;
	private int gracePeriodInDays;

	public StandardCertificateRevokePolicy(Clock clock,
					       int gracePeriodInDays) {
		this.clock = clock;
		this.gracePeriodInDays = gracePeriodInDays;
	}

	@Override
	public boolean checkIfRevoked(Certificate certificate) {
		LocalDate currentDate = LocalDate.now(clock);
		return currentDate.isAfter(certificate.getExpirationDate()
			.plusDays(gracePeriodInDays));
	}
}
