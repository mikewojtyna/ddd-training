package pro.buildmysoftware.ddd.certit2;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

public class ExamTest {
	// @formatter:off
	@DisplayName(
		"creating a new exam"
	)
	// @formatter:on
	@Test
	void exam0() throws Exception {
		// given
		ExamCompany examCompany = anyCompany();
		ExamScheduled examScheduled = examScheduled();

		// when
		Exam exam = examCompany.handle(examScheduled);

		// then
		assertThat(exam.getDate()).isEqualTo(examScheduled.getDate());
	}

	// @formatter:off
	@DisplayName(
		"when exam company confirms exam is passed, " +
		"then certificate is issued"
	)
	// @formatter:on
	@Test
	void exam1() throws Exception {
		// given
		CertificateIssueOffice office = office();
		ExamCompany examCompany = examCompany();
		ExamPassed examPassed = examCompany.passExam();

		// when
		Certificate certificate = office.issueCertificate(examPassed);

		// then
		assertThat(certificate).isNotNull();
	}

	private ExamCompany examCompany() {
		return new ExamCompany();
	}

	private CertificateIssueOffice office() {
		return new CertificateIssueOffice();
	}

	private ExamScheduled examScheduled() {
		return new ExamScheduled(anyDate(), anyPrice());
	}

	private Money anyPrice() {
		return Money.of(CurrencyUnit.USD, 10.00);
	}

	private LocalDateTime anyDate() {
		return LocalDateTime.of(2019, 1, 1, 10, 10);
	}

	private ExamCompany anyCompany() {
		return new ExamCompany();
	}
}
