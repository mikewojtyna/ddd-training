package pro.buildmysoftware.ddd.certit2.issue;

import lombok.Value;

@Value
public class CertificateRequested {
	private final Client client;
	private final RequestCertificateType certificate;
}
