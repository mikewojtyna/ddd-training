package pro.buildmysoftware.ddd.certit2;

import lombok.Value;
import org.joda.money.Money;

@Value
public class ExamPaid {
	private Money price;
}
