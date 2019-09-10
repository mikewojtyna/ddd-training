package pro.buildmysoftware.ddd.certit2.expire;

import pro.buildmysoftware.ddd.certit2.issue.Certificate;

import java.util.Optional;

public interface CertificateRevokePolicy {
	Optional<CertificateRevoked> checkIfRevoked(Certificate certificate);
}
