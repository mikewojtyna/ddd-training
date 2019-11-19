package pro.buildmysoftware.ddd.order.bad;

import java.math.BigDecimal;
import java.util.Objects;

public class OrderLine {

	private String product;
	private int quantity;
	private BigDecimal unitPrice;
	private String currency;

	@Override
	public String toString() {
		return "OrderLine{" + "product='" + product + '\'' + ", " +
			"quantity=" + quantity + ", unitPrice=" + unitPrice +
			", currency='" + currency + '\'' + '}';
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
		return quantity == orderLine.quantity && Objects
			.equals(product, orderLine.product) && Objects
			.equals(unitPrice, orderLine.unitPrice) && Objects
			.equals(currency, orderLine.currency);
	}

	@Override
	public int hashCode() {
		return Objects.hash(product, quantity, unitPrice, currency);
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
}
