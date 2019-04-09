package pro.buildmysoftware.ddd.certit.request;

public interface DomainEventPublisher {
	void publish(CertificateRequested certificateRequestedEvent);
}
