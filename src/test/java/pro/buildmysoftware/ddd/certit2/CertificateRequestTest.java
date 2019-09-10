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
		Certificate certificate = anyCertificate();
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
		Certificate certificate = anyCertificate();
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
			.scheduleExam(examDate);

		// then
		assertThat(examScheduled.getDate()).isEqualTo(examDate);
		assertThat(certificateRequest.isExamScheduled()).isTrue();
	}

	// @formatter:off
	@DisplayName(
		"paying for exam"
	)
	// @formatter:on
	@Test
	void payEx0() throws Exception {
		// given
		CertificateRequest certificateRequest = scheduleExam();

		// when
		ExamPaid examPaid = payForExam(certificateRequest);

		// then
		assertThat(examPaid).isNotNull();
	}

	// @formatter:off
	@DisplayName(
		"given certificate request " +
		"when pay for exam, " +
		"then price is calculated by exam price calculator"
	)
	// @formatter:on
	@Test
	void payEx1() throws Exception {
		// given
		Certificate javaCertificate = javaCert();
		CertificateRequest certificateRequest =
			requestCertificateByRegularClientFor(javaCertificate);
		certificateRequest.scheduleExam(anyDate());
		ExamPriceCalculator calculator =
			(client, certificate) -> usd(10.00);

		// when
		ExamPaid examPaid = certificateRequest.pay(calculator);

		// then
		assertThat(examPaid.getPrice()).isEqualTo(usd(10.00));
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
			.scheduleExam(anyDate()),
				CannotRescheduleExamException.class);

		// then
		assertThat(exception).isNotNull();
	}

	private Certificate anyCertificate() {
		return javaCert();
	}

	private Client anyClient() {
		return regularClient();
	}

	private ExamPaid payForExam(CertificateRequest certificateRequest) {
		return certificateRequest
			.pay(((client, certificate) -> usd(10.00)));
	}

	private Money usd(double v) {
		return Money.of(CurrencyUnit.USD, v);
	}

	private CertificateRequest requestCertificateByRegularClientFor(Certificate certificate) {
		return new CertificateRequest(regularClient(), certificate);
	}

	private Client regularClient() {
		return new Client(true);
	}

	private Certificate javaCert() {
		return new Certificate("JAVA");
	}

	private CertificateRequest scheduleExam() {
		CertificateRequest certificateRequest =
			generateCertificateRequest();
		certificateRequest.scheduleExam(anyDate());
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
