package pro.buildmysoftware.ddd.certit.request.infrastructure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pro.buildmysoftware.ddd.certit.request.model.CertificatesOffice;
import pro.buildmysoftware.ddd.certit.request.model.DomainEventPublisher;

@Configuration
public class SpringConfig {
	@Bean
	public CertificatesOffice certificatesOffice(DomainEventPublisher eventPublisher) {
		return new CertificatesOffice(eventPublisher);
	}
}
