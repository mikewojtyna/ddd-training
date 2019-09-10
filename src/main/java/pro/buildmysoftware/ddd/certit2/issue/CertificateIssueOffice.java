package pro.buildmysoftware.ddd.certit2.issue;

import java.time.LocalDate;

public class CertificateIssueOffice {
	public Certificate issueCertificate(ExamPassed examPassed) {
		// TODO: should not use system clock
		return new Certificate(LocalDate.now().plusYears(1));
	}
}
