package pro.buildmysoftware.ddd.certit.request.domain;

import pro.buildmysoftware.ddd.certit.request.domain.model.CertificateRequested;

public interface DomainEventPublisher {
	void publish(CertificateRequested certificateRequestedEvent);
}
