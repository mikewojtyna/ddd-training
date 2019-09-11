package pro.buildmysoftware.ddd.certit.request.infrastructure;

import pro.buildmysoftware.ddd.certit.request.domain.model.CertificateRequest;

public interface CertificateRequestMapper {
	CertificateRequest fromEntity(CertificateRequestJpaEntity entity);

	CertificateRequestJpaEntity fromDomain(CertificateRequest request);
}
