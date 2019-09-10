package pro.buildmysoftware.ddd.scrum.monolith;

import java.util.Collection;
import java.util.UUID;

public class Product {
	private String name;
	private String description;
	private UUID id;
	private Collection<BacklogItem> items;
	private Collection<Sprint> sprints;
	private Collection<Release> release;

	public void planForRelease(BacklogItem item, Release release) {
		// TODO: plan for release
	}

	public void commitToSprint(BacklogItem item, Sprint sprint) {

	}
}
