package pro.buildmysoftware.ddd.certit.request;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pro.buildmysoftware.ddd.certit.request.model.*;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class RequestACertificateTest {

	private DomainEventPublisher eventPublisher;

	@BeforeEach
	void beforeEach() {
		eventPublisher = Mockito.mock(DomainEventPublisher.class);
	}

	// @formatter:off
	@DisplayName(
		"client requests a certificate"
	)
	// @formatter:on
	@Test
	void test0() throws Exception {
		// given
		RequestCertificateCommand requestCertificate = anyCommand();
		CertificatesOffice office = defaultOffice();

		// when
		CertificateRequest request =
			office.request(requestCertificate);

		// then
		assertThat(request).isNotNull();
	}

	// @formatter:off
	@DisplayName(
		"when client 'goobar' requests a certificate, then " +
		"certificate requested event for this client is published"
	)
	// @formatter:on
	@Test
	void test1() throws Exception {
		// given
		CertificatesOffice office = defaultOffice();
		Client client = clientWithName("goobar");
		RequestCertificateCommand request =
			requestCertificateCommandFor(client);
		CertificateRequested expectedEvent =
			certificateRequestedBy(client);

		// when
		office.request(request);

		// then
		verify(eventPublisher, times(1)).publish(expectedEvent);
	}

	@DisplayName("certificate request has date")
	@Test
	void test2() throws Exception {
		// given
		CertificatesOffice office = defaultOffice();
		LocalDate date = LocalDate.of(2010, 10, 15);
		RequestCertificateCommand requestCertificate =
			requestCertificateCommandWithDate(date);

		// when
		CertificateRequest request =
			office.request(requestCertificate);

		// then
		assertThat(request.getDate()).isEqualTo(date);
	}

	// @formatter:off
	@DisplayName(
		"here we should also probably write a simple integration test" +
		" (maybe in different class), where we would check is " +
		"certificate request aggregate is persisted in the db through" +
		" repository pattern"
	)
	// @formatter:on
	@Test
	void repositoryIntegrationTest() throws Exception {
		// TODO: add this test
	}

	private RequestCertificateCommand requestCertificateCommandWithDate(LocalDate date) {
		return new RequestCertificateCommand(anyClient(), date);
	}

	private CertificateRequested certificateRequestedBy(Client client) {
		return new CertificateRequested(client);
	}

	private RequestCertificateCommand requestCertificateCommandFor(Client client) {
		return new RequestCertificateCommand(client, anyDate());
	}

	private LocalDate anyDate() {
		return LocalDate.now();
	}

	private Client clientWithName(String name) {
		return new Client(name);
	}

	private RequestCertificateCommand anyCommand() {
		return new RequestCertificateCommand(anyClient(), anyDate());
	}

	private Client anyClient() {
		return new Client("noname");
	}

	private CertificatesOffice defaultOffice() {
		return new CertificatesOffice(eventPublisher);
	}
}
