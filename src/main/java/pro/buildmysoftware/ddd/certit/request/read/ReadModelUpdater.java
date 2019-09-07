package pro.buildmysoftware.ddd.certit.request.read;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pro.buildmysoftware.ddd.certit.request.model.CertificateRequested;

@Component
public class ReadModelUpdater {
	private CertificateRequestReadModelRepository repository;

	public ReadModelUpdater(CertificateRequestReadModelRepository repository) {
		this.repository = repository;
	}

	@EventListener
	public void handle(CertificateRequested certificateRequested) {
		CertificateRequestReadModel request =
			new CertificateRequestReadModel();
		request.setClient(certificateRequested.getClient().getName());
		repository.save(request);
	}
}
