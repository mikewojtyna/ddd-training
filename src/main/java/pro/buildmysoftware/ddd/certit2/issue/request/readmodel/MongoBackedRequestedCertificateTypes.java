package pro.buildmysoftware.ddd.certit2.issue.request.readmodel;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MongoBackedRequestedCertificateTypes implements RequestedCertificateTypes {
	private MongoOperations mongoOperations;

	public MongoBackedRequestedCertificateTypes(MongoOperations mongoOperations) {
		this.mongoOperations = mongoOperations;
	}

	@Override
	public Collection<RequestedCertificateTypeReadModel> findAllRequestedTypes() {
		return mongoOperations
			.findAll(RequestedCertificateTypeReadModel.class);
	}
}
