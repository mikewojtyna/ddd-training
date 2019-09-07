package pro.buildmysoftware.ddd.certit.request.model;

import java.time.LocalDate;

public class CertificateRequest {
	private final LocalDate date;
	private LocalDate examDate;

	public CertificateRequest(LocalDate certificateRequestedDate) {
		date = certificateRequestedDate;
	}

	public LocalDate getDate() {
		return date;
	}

	public void scheduleExam(LocalDate examDate) {
		if (examDate.isAfter(date)) {
			this.examDate = examDate;
		}
	}

	public boolean isExamScheduled() {
		return examDate != null;
	}
}
