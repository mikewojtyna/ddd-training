package pro.buildmysoftware.ddd.certit;

import java.time.LocalDate;

public class CertificateRequest {
	private LocalDate examDate;
	private boolean examPaid;

	public void scheduleExam(LocalDate currentDate) {
		examDate = currentDate.plusMonths(1);
		examPaid = false;
	}

	public LocalDate examDate() {
		return examDate;
	}

	public boolean canCustomerTakeExam() {
		return examPaid;
	}

	public void pay() {
		examPaid = true;
	}
}
