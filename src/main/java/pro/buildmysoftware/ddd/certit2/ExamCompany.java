package pro.buildmysoftware.ddd.certit2;

public class ExamCompany {
	public Exam handle(ExamScheduled examPaidEvent) {
		return new Exam(examPaidEvent.getDate());
	}

	public ExamPassed passExam() {
		return null;
	}
}
