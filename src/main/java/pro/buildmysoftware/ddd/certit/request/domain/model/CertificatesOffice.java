package pro.buildmysoftware.ddd.certit.request.domain.model;

import pro.buildmysoftware.ddd.certit.request.domain.DomainEventPublisher;

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
		return new CertificateRequest(requestCertificate.getDate());
	}
}
