package Instagram_Project;

import java.util.LinkedList;
import java.util.List;

public class NewsFeed {
	private User owner;
	private UploadableFeature feature;

	public NewsFeed() {}
	
	public NewsFeed(User owner, UploadableFeature feature) {
		this.owner = feature.getOwner();
		this.feature = feature;
	}

	
}
