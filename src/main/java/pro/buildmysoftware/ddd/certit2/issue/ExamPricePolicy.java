package pro.buildmysoftware.ddd.certit2.issue;

import org.joda.money.Money;

public interface ExamPricePolicy {
	Money calculate(Client client, RequestCertificateType certificate);
}
