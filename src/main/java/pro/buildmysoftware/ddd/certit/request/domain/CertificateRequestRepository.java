package pro.buildmysoftware.ddd.certit.request.domain;

import pro.buildmysoftware.ddd.certit.request.domain.model.CertificateRequest;

import java.util.Optional;

public interface CertificateRequestRepository {
	Optional<CertificateRequest> load(CertificateRequestId id);

	void save(CertificateRequest certificateRequest);
}
