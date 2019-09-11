package pro.buildmysoftware.ddd.certit.request.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.buildmysoftware.ddd.certit.request.domain.CertificateRequestRepository;

public interface JpaCertificateRequestRepository extends JpaRepository<CertififcateRequestJpaEntity, Long>, CertificateRequestRepository {
}
