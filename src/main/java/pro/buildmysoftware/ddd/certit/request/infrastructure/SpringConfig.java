package pro.buildmysoftware.ddd.certit.request.infrastructure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pro.buildmysoftware.ddd.certit.request.domain.DomainEventPublisher;
import pro.buildmysoftware.ddd.certit.request.domain.model.CertificateRequest;
import pro.buildmysoftware.ddd.certit.request.domain.model.CertificatesOffice;

@Configuration
public class SpringConfig {
	@Bean
	public CertificatesOffice certificatesOffice(DomainEventPublisher eventPublisher) {
		return new CertificatesOffice(eventPublisher);
	}

	@Bean
	public CertificateRequestMapper mapper() {
		return new CertificateRequestMapper() {
			@Override
			public CertificateRequest fromEntity(CertificateRequestJpaEntity entity) {
				return null;
			}

			@Override
			public CertificateRequestJpaEntity fromDomain(CertificateRequest request) {
				return null;
			}
		};
	}
}
