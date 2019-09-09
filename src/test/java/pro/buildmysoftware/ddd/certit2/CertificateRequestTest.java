package pro.buildmysoftware.ddd.certit2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

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

		// when
		CertificateRequested certificateRequested = office
			.requestCertificate();

		// then
		assertThat(certificateRequested).isNotNull();
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
		CertificateRequested certificateRequested = office
			.requestCertificate();

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
	void test3() throws Exception {
		// given
		CertificateRequest certificateRequest = scheduleExam();

		// when
		ExamPaid examPaid = certificateRequest.pay();

		// then
		assertThat(examPaid).isNotNull();
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
		return new CertificateRequest();
	}

	private Office anyOffice() {
		return new Office();
	}
}
