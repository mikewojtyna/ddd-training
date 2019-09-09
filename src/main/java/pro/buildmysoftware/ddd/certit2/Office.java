package pro.buildmysoftware.ddd.certit2;

public class Office {
	public CertificateRequested requestCertificate() {
		return new CertificateRequested();
	}

	public CertificateRequest handle(CertificateRequested certificateRequested) {
		return new CertificateRequest();
	}
}
