package pro.buildmysoftware.ddd.order.domain;

import lombok.Value;
import org.joda.money.Money;

@Value
public class Product {

	private final Money unitPrice;
}
