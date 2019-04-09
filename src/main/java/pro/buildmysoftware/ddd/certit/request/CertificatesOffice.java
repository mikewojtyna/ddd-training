package pro.buildmysoftware.ddd.certit.request;

public class CertificatesOffice {

	private DomainEventPublisher eventPublisher;

	public CertificatesOffice(DomainEventPublisher eventPublisher) {
		this.eventPublisher = eventPublisher;
	}

	public CertificateRequest request(RequestCertificateCommand requestCertificate) {
		CertificateRequested event =
			new CertificateRequested(requestCertificate
			.getClient());
		eventPublisher.publish(event);
		return new CertificateRequest();
	}

}