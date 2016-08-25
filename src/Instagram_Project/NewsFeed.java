package Instagram_Project;

import java.util.LinkedList;
import java.util.List;

public abstract class NewsFeed {
	private User owner;
	private UploadableFeature feature;

	public NewsFeed() {}
	
	public NewsFeed(User owner, UploadableFeature feature) throws NoValidDataException {
		if (owner!=null&&feature!=null) {
			this.owner = feature.getOwner();
			this.feature = feature;
		}else {
			throw new NoValidDataException("Choose a valid owner and feature");
		}
		
	}

	
}
