package Instagram_Project;

import java.util.LinkedList;
import java.util.List;

public class LoginNewsFeed extends NewsFeed{
	private static List<UploadableFeature> entryPageNewFeeds = new LinkedList<UploadableFeature>();

	public void addedToNewsFeed(UploadableFeature feature, User user) {
		entryPageNewFeeds.add(feature);
	}

	public void showNewsFeed() {
		for (UploadableFeature feature : entryPageNewFeeds) {
			System.out.println(feature);
		}
	}
}
