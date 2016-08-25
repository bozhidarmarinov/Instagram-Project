package Instagram_Project;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MyNewsFeed extends NewsFeed {

	private static List<String> myNewFeeds = new LinkedList<String>();

	public MyNewsFeed() {
		super();
	}

	public void addToMyNewsFeed(String result) {
		myNewFeeds.add(result);
	}

	public List<String> showMyNewsFeed() {
		for (String myNewsFeed : myNewFeeds) {
			System.out.println(myNewsFeed);
		}
		return Collections.unmodifiableList(myNewFeeds);
	}

}
