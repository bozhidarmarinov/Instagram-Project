package Instagram_Project;

import java.util.Set;

public class User extends UserProfile {
	private Photo p;
	private UserProfile detail;
	private Set<Video> videos;
	private Set<Photo> photos;
	private Set<User> weFollow;
	private Set<User> theyFollow;
	private Set<User> users;
	private Set<FollowersNewsFeed> newFeeds;

	public void uploadPicture() {

	}

	public void showProfile() {
		for (User weFollows : weFollow) {
			System.out.println(weFollows);
		}
		for (User theyFollows : theyFollow) {
			System.out.println(theyFollows);
		}
		for (Photo photo : photos) {
			System.out.println(photo);
		}
		for (Video video : videos) {
			System.out.println(video);
		}
	}

	public void searchForPeople(String name) {
		for (User user : users) {
			if (user.getName().equals(name)) {
				user.showProfile();
			}
		}
	}

	public void serchForPlaces(String place) {

	}

	public void searchWithHashtag(String hashTag) {

	}

	public void login(String name, String password) {
		for (User user : users) {
			if ((name.equals(user.getUserName()) && password.equals(user.getPassword()))) {
				for (FollowersNewsFeed f : newFeeds) {
					System.out.println(f);
				}
			}
		}
	}

	public void logOut() {
		System.out.println("Home page");
	}

	// public void download(){
	//
	// }

	public void like() {

	}

	public void unlike() {

	}

	public void follow() {

	}

	public void unfollow() {

	}

	public void sharePhoto() {

	}

	public void shareVideo() {

	}
}
