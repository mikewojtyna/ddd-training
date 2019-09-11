package pro.buildmysoftware.ddd.certit2.catalogue;

import pro.buildmysoftware.ddd.certit2.issue.exam.Certificate;

public interface CertificateCatalogue {
	Iterable<Certificate> allCertificates();
}
