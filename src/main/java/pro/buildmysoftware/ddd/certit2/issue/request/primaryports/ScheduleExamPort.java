package pro.buildmysoftware.ddd.certit2.issue.request.primaryports;

import pro.buildmysoftware.ddd.certit.request.domain.CertificateRequestId;

import java.time.LocalDate;

public interface ScheduleExamPort {
	void scheduleExam(CertificateRequestId certificateRequestId,
			  LocalDate examDate);
}
