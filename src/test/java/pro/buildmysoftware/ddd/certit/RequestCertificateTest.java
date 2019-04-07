package pro.buildmysoftware.ddd.certit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;

public class RequestCertificateTest {

	@DisplayName("customer can request a new certificate")
	@Test
	void test0() throws Exception {
		// given
		CertificatesOffice office = certificateRequestService();
		Customer customer = anyCustomer();

		// when
		CertificateRequest certificateRequest = office
			.requestCertificateBy(customer);

		// then
		assertThat(certificateRequest).isNotNull();
	}

	@DisplayName("given certificate request, the exam can be scheduled")
	@Test
	void test1() throws Exception {
		// given
		CertificateRequest certificateRequest = requestCertificate();
		LocalDate currentDate = LocalDate.of(2019, 1, 16);

		// when
		certificateRequest.scheduleExam(currentDate);

		// then
		assertThat(certificateRequest.examDate())
			.isEqualTo(LocalDate.of(2019, 2, 16));
	}

	// @formatter:off
	@DisplayName(
		"given certificate request with scheduled exam, " +
		"and exam is not paid, " +
		"then user cannot take the exam"
	)
	// @formatter:on
	@Test
	void test2() throws Exception {
		// given
		CertificateRequest certificateRequest =
			notPaidCertificateRequest();

		// when
		boolean userCanTakeExam = certificateRequest
			.canCustomerTakeExam();

		// then
		assertThat(userCanTakeExam).isFalse();
	}

	// @formatter:off
	@DisplayName(
		"given certificate request with scheduled exam, " +
		"when exam is paid, " +
		"then user can take the exam"
	)
	// @formatter:on
	@Test
	void test3() throws Exception {
		// given
		CertificateRequest certificateRequest =
			paidCertificateRequest();

		// when
		boolean canCustomerTakeExam = certificateRequest
			.canCustomerTakeExam();

		// then
		assertThat(canCustomerTakeExam).isTrue();
	}

	private CertificateRequest paidCertificateRequest() {
		CertificateRequest certificateRequest = requestCertificate();
		certificateRequest.pay();
		return certificateRequest;
	}

	private CertificateRequest notPaidCertificateRequest() {
		CertificateRequest certificateRequest = requestCertificate();
		certificateRequest.scheduleExam(anyDate());
		return certificateRequest;
	}

	private LocalDate anyDate() {
		return LocalDate.of(2010, 10, 10);
	}

	private CertificateRequest requestCertificate() {
		return certificateRequestService()
			.requestCertificateBy(anyCustomer());
	}

	private Customer anyCustomer() {
		return new Customer();
	}

	private CertificatesOffice certificateRequestService() {
		return new DummyCertificateRequestService();
	}
}
