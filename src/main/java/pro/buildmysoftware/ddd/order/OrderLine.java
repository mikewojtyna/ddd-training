package pro.buildmysoftware.ddd.order;

import java.util.Objects;

public class OrderLine {
	private final String product;
	private final int quantity;
	private final int unitCost;

	public OrderLine(String product, int quantity, int unitCost) {
		this.product = product;
		this.quantity = quantity;
		this.unitCost = unitCost;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		OrderLine orderLine = (OrderLine) o;
		return quantity == orderLine.quantity && unitCost == orderLine.unitCost && Objects
			.equals(product, orderLine.product);
	}

	@Override
	public int hashCode() {
		return Objects.hash(product, quantity, unitCost);
	}

	int cost() {
		return quantity * unitCost;
	}
}
