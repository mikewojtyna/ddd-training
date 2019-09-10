package pro.buildmysoftware.ddd.certit2;

import org.joda.money.Money;

public interface ExamPricePolicy {
	Money calculate(Client client, RequestCertificateType certificate);
}
