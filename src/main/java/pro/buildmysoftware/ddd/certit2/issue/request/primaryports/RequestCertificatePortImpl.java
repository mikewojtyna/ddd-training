package pro.buildmysoftware.ddd.certit2.issue.request.primaryports;


import pro.buildmysoftware.ddd.certit2.issue.CertificateRequested;
import pro.buildmysoftware.ddd.certit2.issue.Office;
import pro.buildmysoftware.ddd.certit2.issue.RequestCertificateType;
import pro.buildmysoftware.ddd.certit2.issue.request.model.Client;
import pro.buildmysoftware.ddd.certit2.issue.request.secondaryports.EventPublisher;

public class RequestCertificatePortImpl implements RequestCertificatePort {
	private Office office;
	private EventPublisher eventPublisher;

	public RequestCertificatePortImpl(Office office,
					  EventPublisher eventPublisher) {
		this.office = office;
		this.eventPublisher = eventPublisher;
	}

	@Override
	public void requestCertificate(RequestCertificateType certificateType,
				       Client client) {
		CertificateRequested event = office
			.requestCertificate(client, certificateType);
		eventPublisher.publish(event);
	}
}
