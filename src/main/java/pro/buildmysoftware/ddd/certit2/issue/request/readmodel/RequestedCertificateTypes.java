package pro.buildmysoftware.ddd.certit2.issue.request.readmodel;

import java.util.Collection;

public interface RequestedCertificateTypes {
	Collection<RequestedCertificateTypeReadModel> findAllRequestedTypes();
}
