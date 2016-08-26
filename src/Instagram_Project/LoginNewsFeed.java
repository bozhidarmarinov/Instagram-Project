package Instagram_Project;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LoginNewsFeed extends NewsFeed {
	private static List<UploadableFeature> entryPageNewFeeds = new LinkedList<UploadableFeature>();

	public LoginNewsFeed() {
		super();
	}

	public UploadableFeature addedToNewsFeed(UploadableFeature feature, User user) throws NoValidDataException {
		if (feature != null && user != null) {
			entryPageNewFeeds.add(feature);
		} else {
			throw new NoValidDataException("This user or photo/video does not exist!");
		}
		return feature;

	}

	public List<UploadableFeature> showNewsFeed() {
		for (UploadableFeature feature : entryPageNewFeeds) {
			System.out.println(feature);
		}
		return Collections.unmodifiableList(entryPageNewFeeds);
	}
}
