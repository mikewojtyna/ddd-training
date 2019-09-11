package pro.buildmysoftware.ddd.certit2.issue.request.model;

import org.joda.money.Money;
import pro.buildmysoftware.ddd.certit2.issue.CannotRescheduleExamException;
import pro.buildmysoftware.ddd.certit2.issue.RequestCertificateType;

import java.time.LocalDateTime;

public class CertificateRequest {
	private Client client;
	private RequestCertificateType certificate;
	private boolean examScheduled;

	public CertificateRequest(Client client,
				  RequestCertificateType certificate) {
		this.client = client;
		this.certificate = certificate;
	}

	public boolean isExamScheduled() {
		return examScheduled;
	}

	public ExamScheduled scheduleExam(LocalDateTime examDate,
					  ExamPricePolicy priceCalculator) {
		if (examScheduled) {
			throw new CannotRescheduleExamException("Exam is " +
				"already scheduled");
		}
		examScheduled = true;
		return new ExamScheduled(examDate, examPrice(priceCalculator));
	}

	private Money examPrice(ExamPricePolicy priceCalculator) {
		return priceCalculator.calculate(client, certificate);
	}
}
