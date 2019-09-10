package pro.buildmysoftware.ddd.scrum.disjoint.product;

import pro.buildmysoftware.ddd.scrum.disjoint.release.ReleaseId;
import pro.buildmysoftware.ddd.scrum.disjoint.sprint.SprintId;

import java.util.Collection;

public class Product {
	private ProductId id;
	private Collection<BacklogItem> items;

	public void planForRelease(BacklogItemId itemToRelease,
				   ReleaseId release) {
		items.stream().filter(item -> itemToRelease.getId()
			.equals(item.getId())).findAny()
			.ifPresent(itemInternal -> itemToRelease
				.planForRelease(release));
	}

	public void commitToSprint(BacklogItemId itemToSprint,
				   SprintId sprintId) {
		// similar as in planForRelease
	}
}
