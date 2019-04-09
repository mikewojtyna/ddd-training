package pro.buildmysoftware.ddd.certit.request;

public class RequestCertificateCommand {

	private Client client;

	public RequestCertificateCommand(Client client) {
		this.client = client;
	}

	public Client getClient() {
		return client;
	}
}
