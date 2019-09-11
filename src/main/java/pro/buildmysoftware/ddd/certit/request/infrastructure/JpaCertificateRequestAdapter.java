package pro.buildmysoftware.ddd.certit.request.infrastructure;

import org.springframework.stereotype.Component;
import pro.buildmysoftware.ddd.certit.request.domain.CertificateRequestId;
import pro.buildmysoftware.ddd.certit.request.domain.CertificateRequestRepository;
import pro.buildmysoftware.ddd.certit.request.domain.model.CertificateRequest;

import java.util.Optional;

@Component
public class JpaCertificateRequestAdapter implements CertificateRequestRepository {
	private JpaCertificateRequestRepository adaptee;
	private CertificateRequestMapper mapper;

	public JpaCertificateRequestAdapter(JpaCertificateRequestRepository adaptee, CertificateRequestMapper mapper) {
		this.adaptee = adaptee;
		this.mapper = mapper;
	}

	@Override
	public Optional<CertificateRequest> load(CertificateRequestId id) {
		return adaptee.findById(id.getValue()).map(mapper::fromEntity);
	}

	@Override
	public void save(CertificateRequest certificateRequest) {
		// TODO: similar here as in load
	}
}
