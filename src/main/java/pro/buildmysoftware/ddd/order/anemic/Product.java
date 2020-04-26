package pro.buildmysoftware.ddd.order.anemic;

import lombok.Data;
import org.joda.money.Money;

@Data
public class Product {

	private String name;
	private Money price;
	private int quantity;
}
