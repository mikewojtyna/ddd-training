package pro.buildmysoftware.ddd.certit2;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class ExamScheduled {
	private LocalDateTime date;
}
