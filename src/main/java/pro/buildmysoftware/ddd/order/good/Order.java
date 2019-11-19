package pro.buildmysoftware.ddd.order.good;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

public class Order {

	private final Collection<Item> items;
	private BigDecimal limit = BigDecimal.valueOf(Double.MAX_VALUE);

	public Order() {
		items = new ArrayList<>();
	}

	public static Order limited(BigDecimal limit) {
		Order order = new Order();
		order.limit = limit;
		return order;
	}

	public void addItem(Item item) {
		if (totalCost().add(item.cost()).compareTo(limit) > 0) {
			throw new MaxLimitExceededException();
		}
		items.add(item);
	}

	public Collection<Item> items() {
		return items;
	}

	public BigDecimal totalCost() {
		return items.stream().map(Item::cost).reduce(BigDecimal::add)
			.orElse(BigDecimal.ZERO);
	}
}
