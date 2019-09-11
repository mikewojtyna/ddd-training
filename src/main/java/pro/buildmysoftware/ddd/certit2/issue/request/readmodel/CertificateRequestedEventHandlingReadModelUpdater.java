package pro.buildmysoftware.ddd.certit2.issue.request.readmodel;

import org.springframework.context.event.EventListener;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Component;
import pro.buildmysoftware.ddd.certit2.issue.request.model.CertificateRequested;

@Component
public class CertificateRequestedEventHandlingReadModelUpdater {
	private MongoOperations mongoOperations;

	public CertificateRequestedEventHandlingReadModelUpdater(MongoOperations mongoOperations) {
		this.mongoOperations = mongoOperations;
	}

	@EventListener
	public void handle(CertificateRequested certificateRequested) {
		mongoOperations
			.save(new RequestedCertificateTypeReadModel(certificateRequested
				.getCertificate().getName()));
	}
}
