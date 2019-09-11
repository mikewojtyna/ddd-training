package pro.buildmysoftware.ddd.certit2.issue.exam;

import pro.buildmysoftware.ddd.certit2.issue.request.model.ExamScheduled;

public class ExamCompany {
	public Exam handle(ExamScheduled examPaidEvent) {
		return new Exam(examPaidEvent.getDate());
	}

	public ExamPassed passExam() {
		return null;
	}
}
