package pro.buildmysoftware.ddd.certit.request.read;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class CertificateRequestReadModel {
	@Id
	private long id;
	private String client;
}
