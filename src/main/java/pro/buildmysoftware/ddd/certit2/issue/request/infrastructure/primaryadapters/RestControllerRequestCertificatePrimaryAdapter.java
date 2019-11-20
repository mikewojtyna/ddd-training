package pro.buildmysoftware.ddd.certit2.issue.request.infrastructure.primaryadapters;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.buildmysoftware.ddd.certit2.issue.request.model.Client;
import pro.buildmysoftware.ddd.certit2.issue.request.model.RequestCertificateType;
import pro.buildmysoftware.ddd.certit2.issue.request.primaryports.RequestCertificatePort;

@RestController
@RequestMapping("/api/requests")
public class RestControllerRequestCertificatePrimaryAdapter {

	private RequestCertificatePort requestCertificatePort;

	public RestControllerRequestCertificatePrimaryAdapter(RequestCertificatePort requestCertificatePort) {
		this.requestCertificatePort = requestCertificatePort;
	}

	@PostMapping
	public void requestCertificate(@RequestBody RequestCertificateDtoCommand command) {
		requestCertificatePort
			.requestCertificate(new RequestCertificateType(command
				.getType()), new Client(true));
	}
}
