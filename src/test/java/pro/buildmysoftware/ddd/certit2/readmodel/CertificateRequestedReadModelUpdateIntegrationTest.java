package pro.buildmysoftware.ddd.certit2.readmodel;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import pro.buildmysoftware.ddd.certit2.issue.request.model.Client;
import pro.buildmysoftware.ddd.certit2.issue.request.model.RequestCertificateType;
import pro.buildmysoftware.ddd.certit2.issue.request.primaryports.RequestCertificatePort;
import pro.buildmysoftware.ddd.certit2.issue.request.readmodel.RequestedCertificateTypeReadModel;
import pro.buildmysoftware.ddd.certit2.issue.request.readmodel.RequestedCertificateTypes;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
public class CertificateRequestedReadModelUpdateIntegrationTest {
	@Autowired
	private RequestCertificatePort port;
	@Autowired
	private RequestedCertificateTypes finder;

	// @formatter:off
	@DisplayName(
		"when request a new certificate using primary port, " +
		"then request certificate read model is updated with new " +
		"request"
	)
	// @formatter:on
	@Test
	void test() throws Exception {
		// given
		RequestCertificateType type = new RequestCertificateType(
			"Java");
		Client client = new Client(true);

		// when
		port.requestCertificate(type, client);

		// then
		Collection<RequestedCertificateTypeReadModel> allRequestedTypes = finder
			.findAllRequestedTypes();
		assertThat(allRequestedTypes)
			.containsOnly(new RequestedCertificateTypeReadModel(
				"Java"));
	}
}
