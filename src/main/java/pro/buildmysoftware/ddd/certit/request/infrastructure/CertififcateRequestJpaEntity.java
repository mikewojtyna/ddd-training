package pro.buildmysoftware.ddd.certit.request.infrastructure;

import lombok.Data;
import org.hibernate.annotations.NaturalId;
import pro.buildmysoftware.ddd.certit.request.domain.CertificateRequestId;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class CertififcateRequestJpaEntity {
	@NaturalId
	private CertificateRequestId requestId;
	@Id
	private long id;
	private Date date;
	private Date examDate;
}
