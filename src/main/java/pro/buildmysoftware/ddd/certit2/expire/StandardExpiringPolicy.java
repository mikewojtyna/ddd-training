package pro.buildmysoftware.ddd.certit2.expire;

import pro.buildmysoftware.ddd.certit2.issue.Certificate;

import java.time.LocalDate;
import java.util.Optional;

public class StandardExpiringPolicy implements ExpiringPolicy {
	@Override
	public Optional<CertificateExpiringSoon> checkIfExpires(Certificate certificate, LocalDate currentDate) {
		if (currentDate.equals(certificate.getExpirationDate()
			.minusDays(30))) {
			return Optional.of(new CertificateExpiringSoon());
		}
		return Optional.empty();
	}

	@Override
	public Optional<CertificateExpired> checkIfExpired(Certificate certificate, LocalDate currentDate) {
		if (currentDate
			.equals(certificate.getExpirationDate().plusDays(1))) {
			return Optional.of(new CertificateExpired());
		}
		return Optional.empty();
	}
}
