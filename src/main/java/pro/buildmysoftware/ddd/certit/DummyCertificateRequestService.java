package pro.buildmysoftware.ddd.certit;

public class DummyCertificateRequestService implements CertificatesOffice {
	@Override
	public CertificateRequest requestCertificateBy(Customer customer) {
		return new CertificateRequest();
	}
}
