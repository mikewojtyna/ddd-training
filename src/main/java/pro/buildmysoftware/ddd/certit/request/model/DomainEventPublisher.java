package pro.buildmysoftware.ddd.certit.request.model;

public interface DomainEventPublisher {
	void publish(CertificateRequested certificateRequestedEvent);
}
