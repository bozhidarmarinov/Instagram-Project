package Instagram_Project;

import java.util.LinkedList;
import java.util.List;

public class MyNewsFeed extends NewsFeed {

	private static List<String> myNewFeeds = new LinkedList<String>();

	public void addToMyNewsFeed(String result) {
		myNewFeeds.add(result);
	}
	
	public void showMyNewsFeed(){
		for(String myNewsFeed : myNewFeeds){
			System.out.println(myNewsFeed);
		}
	}

}
