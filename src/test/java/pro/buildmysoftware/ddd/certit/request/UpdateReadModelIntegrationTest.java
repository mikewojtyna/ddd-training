package pro.buildmysoftware.ddd.certit.request;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pro.buildmysoftware.ddd.certit.request.domain.model.CertificatesOffice;
import pro.buildmysoftware.ddd.certit.request.domain.model.Client;
import pro.buildmysoftware.ddd.certit.request.domain.model.RequestCertificateCommand;
import pro.buildmysoftware.ddd.certit.request.read.CertificateRequestReadModel;
import pro.buildmysoftware.ddd.certit.request.read.CertificateRequestReadModelRepository;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UpdateReadModelIntegrationTest {
	@Autowired
	private CertificateRequestReadModelRepository repository;
	@Autowired
	private CertificatesOffice office;

	// @formatter:off
	@DisplayName(
		"when create certificate request by goobar, " +
		"then request read model is updated"
	)
	// @formatter:on
	@Test
	void test() throws Exception {
		// given
		RequestCertificateCommand command =
			new RequestCertificateCommand(new Client("goobar"),
				LocalDate
			.now());

		// when
		office.request(command);

		// then
		Iterable<CertificateRequestReadModel> allCertificates =
			repository
			.findAll();
		assertThat(allCertificates).hasSize(1)
			.hasOnlyOneElementSatisfying(c -> c.getClient()
				.equals("goobar"));
	}

	@BeforeEach
	void beforeEach() {
		repository.deleteAll();
	}
}
