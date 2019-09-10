package pro.buildmysoftware.ddd.certit2;

import org.joda.money.Money;

public interface ExamPriceCalculator {
	Money calculate(Client client, Certificate certificate);
}
