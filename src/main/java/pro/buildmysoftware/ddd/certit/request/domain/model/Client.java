package pro.buildmysoftware.ddd.certit.request.domain.model;

import java.util.Objects;

public class Client {
	private final String name;

	public Client(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Client client = (Client) o;
		return Objects.equals(name, client.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}
}
