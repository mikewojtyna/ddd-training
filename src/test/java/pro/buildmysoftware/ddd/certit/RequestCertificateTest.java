package pro.buildmysoftware.ddd.certit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RequestCertificateTest {

	@DisplayName("customer can request a new certificate")
	@Test
	void test() throws Exception {
		// given
		CertificatesOffice office = certificateRequestService();
		Customer customer = anyCustomer();

		// when
		CertificateRequest certificateRequest = office
			.requestCertificateBy(customer);

		// then
		assertThat(certificateRequest).isNotNull();
	}

	private Customer anyCustomer() {
		return new Customer();
	}

	private CertificatesOffice certificateRequestService() {
		return new DummyCertificateRequestService();
	}
}
