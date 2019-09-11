package pro.buildmysoftware.ddd.certit2.issue.request.primaryports;

import pro.buildmysoftware.ddd.certit2.issue.request.model.Client;
import pro.buildmysoftware.ddd.certit2.issue.request.model.RequestCertificateType;

public interface RequestCertificatePort {
	void requestCertificate(RequestCertificateType certificateType,
				Client client);
}
