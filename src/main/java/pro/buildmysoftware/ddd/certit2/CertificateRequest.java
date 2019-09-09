package pro.buildmysoftware.ddd.certit2;

import java.time.LocalDateTime;

public class CertificateRequest {
	private boolean examScheduled;

	public CertificateRequest() {
		examScheduled = false;
	}

	public boolean isExamScheduled() {
		return examScheduled;
	}

	public ExamScheduled scheduleExam(LocalDateTime examDate) {
		examScheduled = true;
		return new ExamScheduled(examDate);
	}

	public ExamPaid pay() {
		return new ExamPaid();
	}
}
