package pro.buildmysoftware.ddd.certit2.issue.request.model;

import lombok.Value;
import org.joda.money.Money;

import java.time.LocalDateTime;

@Value
public class ExamScheduled {
	private LocalDateTime date;
	private Money price;
}
