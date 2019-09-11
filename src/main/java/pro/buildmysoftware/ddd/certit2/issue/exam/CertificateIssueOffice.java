package pro.buildmysoftware.ddd.certit2.issue.exam;

import pro.buildmysoftware.ddd.certit2.issue.request.model.CertificateIssued;

import java.time.LocalDate;

public class CertificateIssueOffice {
	public CertificateIssued issueCertificate(ExamPassed examPassed) {
		// TODO: should not use system clock
		return new CertificateIssued(LocalDate.now().plusYears(1));
	}
}
