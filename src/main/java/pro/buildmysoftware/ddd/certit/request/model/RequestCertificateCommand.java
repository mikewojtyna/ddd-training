package pro.buildmysoftware.ddd.certit.request.model;

import java.time.LocalDate;

public class RequestCertificateCommand {
	private final LocalDate date;
	private Client client;

	public RequestCertificateCommand(Client client, LocalDate date) {
		this.client = client;
		this.date = date;
	}

	public LocalDate getDate() {
		return date;
	}

	public Client getClient() {
		return client;
	}
}
