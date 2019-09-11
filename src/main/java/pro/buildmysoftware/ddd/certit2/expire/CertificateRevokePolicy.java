package pro.buildmysoftware.ddd.certit2.expire;

import pro.buildmysoftware.ddd.certit2.issue.exam.Certificate;

public interface CertificateRevokePolicy {
	boolean checkIfRevoked(Certificate certificate);
}
