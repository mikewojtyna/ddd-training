package pro.buildmysoftware.ddd.tea;

import java.util.ArrayList;
import java.util.Collection;

public class Order {
	private boolean ready;
	private Collection<Tea> items;

	public Order() {
		ready = false;
		items = new ArrayList<>();
	}

	public void chooseTea(Tea blackTea, Tea greenTea) {
		items.add(blackTea);
		items.add(greenTea);
	}

	public void submit() {
		ready = true;
	}

	public boolean isPlaced() {
		return !items.isEmpty();
	}
}
