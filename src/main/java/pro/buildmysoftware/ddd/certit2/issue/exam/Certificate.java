package pro.buildmysoftware.ddd.certit2.issue.exam;

import lombok.Value;
import pro.buildmysoftware.ddd.certit2.expire.CertificateRevokePolicy;
import pro.buildmysoftware.ddd.certit2.expire.CertificateRevoked;

import java.time.LocalDate;
import java.util.Optional;

@Value
public class Certificate {
	private final LocalDate expirationDate;

	public CertificateRevoked revoke() {
		// TODO: explore rules
		return new CertificateRevoked();
	}

	public Optional<CertificateRevoked> revoke(CertificateRevokePolicy policy) {
		return Optional.of(policy.checkIfRevoked(this)).filter(b -> b)
			.map(b -> new CertificateRevoked());
	}
}
