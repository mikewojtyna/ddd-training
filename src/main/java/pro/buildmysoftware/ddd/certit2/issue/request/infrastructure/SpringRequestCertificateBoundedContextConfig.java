package pro.buildmysoftware.ddd.certit2.issue.request.infrastructure;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pro.buildmysoftware.ddd.certit2.issue.Office;
import pro.buildmysoftware.ddd.certit2.issue.request.primaryports.RequestCertificatePort;
import pro.buildmysoftware.ddd.certit2.issue.request.primaryports.RequestCertificatePortImpl;
import pro.buildmysoftware.ddd.certit2.issue.request.secondaryports.EventPublisher;

@Configuration
public class SpringRequestCertificateBoundedContextConfig {
	@Bean
	public EventPublisher eventPublisher(ApplicationEventPublisher springEventPublisher) {
		return myFavouriteEventPublisher(springEventPublisher);
	}

	@Bean
	public Office office() {
		return new Office();
	}

	@Bean
	public RequestCertificatePort requestCertificatePort(Office office,
							     EventPublisher eventPublisher) {
		return new RequestCertificatePortImpl(office, eventPublisher);
	}

	private EventPublisher myFavouriteEventPublisher(ApplicationEventPublisher springEventPublisher) {
		return event -> springEventPublisher.publishEvent(event);
	}
}
