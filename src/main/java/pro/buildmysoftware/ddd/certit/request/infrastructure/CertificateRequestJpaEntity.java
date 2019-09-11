package pro.buildmysoftware.ddd.certit.request.infrastructure;

import lombok.Data;
import org.hibernate.annotations.NaturalId;
import pro.buildmysoftware.ddd.certit.request.domain.CertificateRequestId;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class CertificateRequestJpaEntity {
	@NaturalId
	@Embedded
	private CertificateRequestId requestId;
	@Id
	private long id;
	private Date date;
	private Date examDate;
}
