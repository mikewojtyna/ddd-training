package pro.buildmysoftware.ddd.certit2;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowableOfType;

public class CertificateRequestTest {
	// @formatter:off
	@DisplayName(
		"requesting a certificate"
	)
	// @formatter:on
	@Test
	void test() throws Exception {
		// given
		Office office = anyOffice();
		Client client = anyClient();

		// when
		RequestCertificateType certificate = anyCertificate();
		CertificateRequested certificateRequested = office
			.requestCertificate(client, certificate);

		// then
		assertThat(certificateRequested.getClient()).isEqualTo(client);
		assertThat(certificateRequested.getCertificate())
			.isEqualTo(certificate);
	}

	// @formatter:off
	@DisplayName(
		"given certificate requested event, " +
		"then create a new certificate request without scheduled exam"
	)
	// @formatter:on
	@Test
	void test1() throws Exception {
		// given
		Office office = anyOffice();
		Client client = anyClient();
		RequestCertificateType certificate = anyCertificate();
		CertificateRequested certificateRequested = office
			.requestCertificate(client, certificate);

		// when
		CertificateRequest certificateRequest = office
			.handle(certificateRequested);

		// then
		assertThat(certificateRequest.isExamScheduled()).isFalse();
	}

	// @formatter:off
	@DisplayName(
		"scheduling an exam for certificate request"
	)
	// @formatter:on
	@Test
	void test2() throws Exception {
		// given
		CertificateRequest certificateRequest =
			generateCertificateRequest();
		LocalDateTime examDate = LocalDateTime.of(2019, 1, 1, 10, 0);

		// when
		ExamScheduled examScheduled = certificateRequest
			.scheduleExam(examDate, anyPriceCalculator());

		// then
		assertThat(examScheduled.getDate()).isEqualTo(examDate);
		assertThat(certificateRequest.isExamScheduled()).isTrue();
	}

	// @formatter:off
	@DisplayName(
		"given certificate request " +
		"when schedule an exam, " +
		"then price is calculated by exam price calculator"
	)
	// @formatter:on
	@Test
	void payEx1() throws Exception {
		// given
		RequestCertificateType javaCertificate = javaCert();
		CertificateRequest certificateRequest =
			requestCertificateByRegularClientFor(javaCertificate);
		ExamPriceCalculator calculator =
			(client, certificate) -> usd(10.00);

		// when
		ExamScheduled examScheduled = certificateRequest
			.scheduleExam(anyDate(), calculator);

		// then
		assertThat(examScheduled.getPrice()).isEqualTo(usd(10.00));
	}

	// @formatter:off
	@DisplayName(
		"cannot schedule exam twice"
	)
	// @formatter:on
	@Test
	void scheduleExamTwice() throws Exception {
		// given
		CertificateRequest certificateRequest = scheduleExam();

		// when
		CannotRescheduleExamException exception =
			catchThrowableOfType(() -> certificateRequest
			.scheduleExam(anyDate(), anyPriceCalculator()),
				CannotRescheduleExamException.class);

		// then
		assertThat(exception).isNotNull();
	}

	private ExamPriceCalculator anyPriceCalculator() {
		return (client, certificate) -> usd(10.00);
	}

	private RequestCertificateType anyCertificate() {
		return javaCert();
	}

	private Client anyClient() {
		return regularClient();
	}

	private Money usd(double v) {
		return Money.of(CurrencyUnit.USD, v);
	}

	private CertificateRequest requestCertificateByRegularClientFor(RequestCertificateType certificate) {
		return new CertificateRequest(regularClient(), certificate);
	}

	private Client regularClient() {
		return new Client(true);
	}

	private RequestCertificateType javaCert() {
		return new RequestCertificateType("JAVA");
	}

	private CertificateRequest scheduleExam() {
		CertificateRequest certificateRequest =
			generateCertificateRequest();
		certificateRequest
			.scheduleExam(anyDate(), anyPriceCalculator());
		return certificateRequest;
	}

	private LocalDateTime anyDate() {
		return LocalDateTime.now();
	}

	private CertificateRequest generateCertificateRequest() {
		return new CertificateRequest(anyClient(), anyCertificate());
	}

	private Office anyOffice() {
		return new Office();
	}
}
