package pro.buildmysoftware.ddd.certit.request.domain;

import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class CertificateRequestId {
	private long value;
}
