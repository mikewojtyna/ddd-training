package pro.buildmysoftware.ddd.certit2.issue.request.infrastructure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pro.buildmysoftware.ddd.certit2.issue.request.secondaryports.EventPublisher;

@Configuration
public class SpringRequestCertificateBoundedContextConfig {
	@Bean
	public EventPublisher eventPublisher() {
		return myFavouriteEventPublisher();
	}

	private EventPublisher myFavouriteEventPublisher() {
		return null;
	}
}
