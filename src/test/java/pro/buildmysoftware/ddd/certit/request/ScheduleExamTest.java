package pro.buildmysoftware.ddd.certit.request;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pro.buildmysoftware.ddd.certit.request.domain.model.CertificateRequest;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static pro.buildmysoftware.ddd.certit.request.CertificateRequestTestFixture.requestCertificateWithDate;

public class ScheduleExamTest {

	// @formatter:off
	@DisplayName(
		"exam can be scheduled on date not before certificate request" +
		" date"
	)
	// @formatter:on
	@Test
	void test() throws Exception {
		// given
		LocalDate certificateRequestedDate = LocalDate.of(2010, 10,
			15);
		LocalDate examDate = certificateRequestedDate.plusDays(14);
		CertificateRequest certificateRequest =
			requestCertificateWithDate(certificateRequestedDate);

		// when
		certificateRequest.scheduleExam(examDate);

		// then
		assertThat(certificateRequest.isExamScheduled()).isTrue();
	}

	// @formatter:off
	@DisplayName(
		"exam cannot be scheduled on date before certificate request " +
		"date"
	)
	// @formatter:on
	@Test
	void test1() throws Exception {
		// given
		LocalDate certificateRequestDate = LocalDate.of(2019, 1, 15);
		LocalDate examDate = certificateRequestDate.minusDays(5);
		CertificateRequest certificateRequest =
			requestCertificateWithDate(certificateRequestDate);

		// when
		certificateRequest.scheduleExam(examDate);

		// then
		assertThat(certificateRequest.isExamScheduled()).isFalse();
	}
}
