package pro.buildmysoftware.ddd.certit2;

import java.time.LocalDateTime;

public class CertificateRequest {
	private static final String JAVA = "JAVA";
	// TODO: do we allow certificate reuqest without client and
	//  cetificate?
	private Client client;
	private Certificate certificate;
	private boolean examScheduled;

	public CertificateRequest() {
		examScheduled = false;
	}

	public CertificateRequest(Client client, Certificate certificate) {
		this.client = client;
		this.certificate = certificate;
	}

	public boolean isExamScheduled() {
		return examScheduled;
	}

	public ExamScheduled scheduleExam(LocalDateTime examDate) {
		examScheduled = true;
		return new ExamScheduled(examDate);
	}

	public ExamPaid pay(ExamPriceCalculator priceCalculator) {
		return new ExamPaid(priceCalculator
			.calculate(client, certificate));
	}
}
