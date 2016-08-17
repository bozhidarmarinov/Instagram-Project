package Instagram_Project;

import java.util.*;

public class User extends UserProfile {
	private Photo photo;
	private UserProfile detail;
	private Set<Video> videos;
	private Set<Photo> photos;
	private Set<User> weFollow;
	private Set<User> theyFollow;
	private Set<User> users; // promeni na registredUsers
	private Set<FollowersNewsFeed> newFeeds;
	private boolean isLiked = false;

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

	public List<UploadableFeature> serchForPlaces(String place) {

		List<UploadableFeature> matchCity = new LinkedList<UploadableFeature>();
		if (place != null && !place.equals("")) {
			for (User user : users) {
				for (Photo photo : photos) {
					if (place.equals(photo.getCity())) {
						matchCity.add(photo);
					}
				}
			}
		}

		return matchCity;
	}

	public void searchWithHashtag(String hashTag) { // izqsnqvane na sluchaq

	}

	public void login(String name, String password) {
		for (User user : users) {
			if ((name.equals(user.getUserName()) && password.equals(user.getPassword()))) {
				for (FollowersNewsFeed f : newFeeds) {
					System.out.println(f);
				}
			} else {
				if (!name.equals(user.getUserName())) {
					System.out.println("Invalid name");
				} else {
					if (!name.equals(user.getPassword())) {
						System.out.println("Invalid password");
					}
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

	public void like(UploadableFeature feature) {
		if (feature != null) {
			feature.setNumberOfLikes(feature.getNumberOfLikes() + 1);
			System.out.println(" Number of Likes : " + feature.getNumberOfLikes());
			isLiked = true;
		}
	}

	public void unlike(UploadableFeature feature) {
		if (feature != null) {
			if (isLiked == true) {
				feature.setNumberOfLikes(feature.getNumberOfLikes() - 1);
				System.out.println(" Number of Likes : " + feature.getNumberOfLikes());
			} else {
				System.out.println("Snimkata ne e haresana");
			}
		}
	}

	public void follow(User user) {
		for (User follower : weFollow) {
			if (weFollow.contains(user)) {
				System.out.println("You already follow this person");
			} else {
				weFollow.add(user);
			}
		}
	}

	public void unfollow(User user) {
		for (User follower : weFollow) {
			if (weFollow.contains(user)) {
				weFollow.remove(user);
			} else {
				System.out.println("You do not follow this person");
			}
		}
	}

	public void shareFeature() {

	}
	public void renameFeatureDescription(UploadableFeature feature, String description){
		feature.rename(description);
	}

}
