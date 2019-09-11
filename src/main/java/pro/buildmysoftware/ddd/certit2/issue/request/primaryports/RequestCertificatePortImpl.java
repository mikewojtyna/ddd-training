package pro.buildmysoftware.ddd.certit2.issue.request.primaryports;


import pro.buildmysoftware.ddd.certit2.issue.request.model.CertificateRequested;
import pro.buildmysoftware.ddd.certit2.issue.request.model.Client;
import pro.buildmysoftware.ddd.certit2.issue.request.model.Office;
import pro.buildmysoftware.ddd.certit2.issue.request.model.RequestCertificateType;
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
