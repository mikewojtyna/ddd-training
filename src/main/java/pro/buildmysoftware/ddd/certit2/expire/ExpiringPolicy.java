package pro.buildmysoftware.ddd.certit2.expire;

import pro.buildmysoftware.ddd.certit2.issue.Certificate;

import java.time.LocalDate;
import java.util.Optional;

public interface ExpiringPolicy {
	Optional<CertificateExpiringSoon> checkIfExpires(Certificate certificate, LocalDate currentDate);

	Optional<CertificateExpired> checkIfExpired(Certificate certificate,
						    LocalDate currentDate);
}
