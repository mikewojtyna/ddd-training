package pro.buildmysoftware.ddd.certit2;

import java.util.Objects;

public class Office {
	public CertificateRequested requestCertificate(Client client,
						       Certificate certificate) {
		Objects.requireNonNull(client);
		Objects.requireNonNull(certificate);
		return new CertificateRequested(client, certificate);
	}

	public CertificateRequest handle(CertificateRequested certificateRequested) {
		Objects.requireNonNull(certificateRequested);
		return new CertificateRequest(certificateRequested
			.getClient(), certificateRequested.getCertificate());
	}
}
