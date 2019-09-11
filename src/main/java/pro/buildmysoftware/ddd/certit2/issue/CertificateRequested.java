package pro.buildmysoftware.ddd.certit2.issue;

import lombok.Value;
import pro.buildmysoftware.ddd.certit2.issue.request.model.Client;

@Value
public class CertificateRequested {
	private final Client client;
	private final RequestCertificateType certificate;
}
