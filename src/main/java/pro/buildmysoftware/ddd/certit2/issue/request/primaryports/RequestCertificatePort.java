package pro.buildmysoftware.ddd.certit2.issue.request.primaryports;

import pro.buildmysoftware.ddd.certit2.issue.RequestCertificateType;
import pro.buildmysoftware.ddd.certit2.issue.request.model.Client;

public interface RequestCertificatePort {
	void requestCertificate(RequestCertificateType certificateType,
				Client client);
}
