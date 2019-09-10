package pro.buildmysoftware.ddd.scrum.disjoint.product;

import pro.buildmysoftware.ddd.scrum.disjoint.release.ReleaseId;

public class BacklogItemId {
	private ReleaseId release;

	public BacklogItemId getId() {
		return null;
	}

	public void planForRelease(ReleaseId id) {
		release = id;
	}
}
