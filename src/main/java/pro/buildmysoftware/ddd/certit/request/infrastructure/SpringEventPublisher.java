package pro.buildmysoftware.ddd.certit.request.infrastructure;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import pro.buildmysoftware.ddd.certit.request.model.CertificateRequested;
import pro.buildmysoftware.ddd.certit.request.model.DomainEventPublisher;

@Component
public class SpringEventPublisher implements DomainEventPublisher {
	private ApplicationEventPublisher publisher;

	public SpringEventPublisher(ApplicationEventPublisher publisher) {
		this.publisher = publisher;
	}

	@Override
	public void publish(CertificateRequested certificateRequestedEvent) {
		publisher.publishEvent(certificateRequestedEvent);
	}
}
