package pro.buildmysoftware.ddd.certit.request;

import java.time.LocalDate;

public class CertificateRequestTestFixture {
	public static CertificateRequest requestAnyCertificate() {
		return new CertificateRequest(LocalDate.now());
	}

	public static CertificateRequest requestCertificateWithDate(LocalDate certificateRequestedDate) {
		return new CertificateRequest(certificateRequestedDate);
	}
}
