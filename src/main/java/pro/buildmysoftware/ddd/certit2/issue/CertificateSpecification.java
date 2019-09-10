package pro.buildmysoftware.ddd.certit2.issue;

public interface CertificateSpecification {
	boolean isSatisfiedBy(Certificate certificate);

	default CertificateSpecification and(CertificateSpecification certificateSpecification) {
		return certificate -> isSatisfiedBy(certificate) && certificateSpecification
			.isSatisfiedBy(certificate);
	}

	default CertificateSpecification or(CertificateSpecification certificateSpecification) {
		return certificate -> isSatisfiedBy(certificate) || certificateSpecification
			.isSatisfiedBy(certificate);
	}
}
