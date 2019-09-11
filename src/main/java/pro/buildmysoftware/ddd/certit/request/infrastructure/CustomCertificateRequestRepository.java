package pro.buildmysoftware.ddd.certit.request.infrastructure;

import pro.buildmysoftware.ddd.certit.request.domain.CertificateRequestId;
import pro.buildmysoftware.ddd.certit.request.domain.CertificateRequestRepository;
import pro.buildmysoftware.ddd.certit.request.domain.model.CertificateRequest;

import java.util.Optional;

public class CustomCertificateRequestRepository implements CertificateRequestRepository {
	@Override
	public Optional<CertificateRequestRepository> load(CertificateRequestId id) {
		// TODO: implement this
		return Optional.empty();
	}

	@Override
	public void save(CertificateRequest certificateRequest) {
		// TODO: implement this
	}
}
