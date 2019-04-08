package pro.buildmysoftware.ddd.order;

import java.util.HashSet;
import java.util.Set;

public class Order {
	private String uniqueId;
	private Set<OrderLine> orderLineItems;
	private int totalCost;

	public Order() {
		totalCost = 0;
		orderLineItems = new HashSet<>();
	}

	public void addItem(OrderLine item) {
		totalCost += item.cost();
		orderLineItems.add(item);
	}

	public int totalCost() {
		return totalCost;
	}
}
