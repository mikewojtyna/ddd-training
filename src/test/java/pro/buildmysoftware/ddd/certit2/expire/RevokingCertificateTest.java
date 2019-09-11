package pro.buildmysoftware.ddd.certit2.expire;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pro.buildmysoftware.ddd.certit2.catalogue.CertificateCatalogue;
import pro.buildmysoftware.ddd.certit2.issue.exam.Certificate;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

public class RevokingCertificateTest {
	// @formatter:off
	@DisplayName("revoke a certificate manually")
	// @formatter:on
	@Test
	void manual() throws Exception {
		// given
		CertificateCatalogue catalogue = () -> List
			.of(new Certificate(anyDate()));
		Certificate certificate =
			anyCertificateFromCatalogue(catalogue);

		// when
		// TODO: can we always revoke? for now, let's assume we can
		//  always do this, that's why there's no Optional or any
		//  kind of exceptions
		CertificateRevoked certificateRevoked = certificate.revoke();

		// then
		assertThat(certificateRevoked).isNotNull();
	}

	// @formatter:off
	@DisplayName(
		"certificate can be revoked using policy"
	)
	// @formatter:on
	@Test
	void policy() throws Exception {
		// given
		CertificateCatalogue catalogue = () -> List
			.of(new Certificate(anyDate()));
		Certificate certificate =
			anyCertificateFromCatalogue(catalogue);
		CertificateRevokePolicy policy = c -> true;

		// when
		Optional<CertificateRevoked> event =
			certificate.revoke(policy);

		// then
		assertThat(event).isPresent();
	}

	// @formatter:off
	@DisplayName(
		"certificate is not revoked when using policy that returns " +
		"false"
	)
	// @formatter:on
	@Test
	void policy2() throws Exception {
		// given
		CertificateCatalogue catalogue = () -> List
			.of(new Certificate(anyDate()));
		Certificate certificate =
			anyCertificateFromCatalogue(catalogue);
		CertificateRevokePolicy policy = c -> false;

		// when
		Optional<CertificateRevoked> event =
			certificate.revoke(policy);

		// then
		assertThat(event).isEmpty();
	}

	private LocalDate anyDate() {
		return LocalDate.now();
	}

	private Certificate anyCertificateFromCatalogue(CertificateCatalogue certificateCatalogue) {
		return certificateCatalogue.allCertificates().iterator().next();
	}
}
