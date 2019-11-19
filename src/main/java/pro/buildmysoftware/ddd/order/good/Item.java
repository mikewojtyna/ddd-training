package pro.buildmysoftware.ddd.order.good;

import java.math.BigDecimal;

public class Item {

	private BigDecimal unitPrice;

	public Item(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public BigDecimal cost() {
		return unitPrice;
	}
}
