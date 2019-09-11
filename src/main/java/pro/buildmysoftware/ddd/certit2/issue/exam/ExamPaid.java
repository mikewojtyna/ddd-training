package pro.buildmysoftware.ddd.certit2.issue.exam;

import lombok.Value;
import org.joda.money.Money;

@Value
public class ExamPaid {
	private Money price;
}
