package pro.buildmysoftware.ddd.certit.request.domain.model;

import java.util.Objects;

public class CertificateRequested {
	private Client client;

	public CertificateRequested(Client client) {
		this.client = client;
	}

	public Client getClient() {
		return client;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		CertificateRequested that = (CertificateRequested) o;
		return Objects.equals(client, that.client);
	}

	@Override
	public int hashCode() {
		return Objects.hash(client);
	}
}
