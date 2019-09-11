package pro.buildmysoftware.ddd.certit.request.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCertificateRequestRepository extends JpaRepository<CertificateRequestJpaEntity, Long> {
}
