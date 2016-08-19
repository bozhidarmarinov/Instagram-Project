package Instagram_Project;

import java.util.*;
import java.util.regex.*;

public class User implements IUser {

	private Photo photo;
	private Set<Video> videos;
	private Set<Photo> photos;
	private Set<User> weFollow;
	private Set<User> theyFollow;
	private Set<FollowersNewsFeed> newFeeds = new LinkedHashSet<FollowersNewsFeed>();
	private boolean isLiked = false;
	private String userName;
	private String password;
	private String biography;
	private String email;
	private String name;
	private Gender gender;

	protected static Set<User> registeredUsers = new HashSet<User>();

	public User(String userName, String password, String email) throws NoValidDataException {
		this(userName, password);
		if (isValidEmail(email)) {
			this.email = email;
		} else {
			throw new NoValidDataException("This is not a valid e-mail address");
		}
	}

	public User(String userName, String password) throws NoValidDataException {
		if (userName != null && password != null && !userName.equals("") && !password.equals("")) {
			this.userName = userName;
			this.password = password;
		} else {
			throw new NoValidDataException("Provide a valid username or password");
		}

	}

	public void registerUser() throws NoValidDataException {
		if (registeredUsers.contains(this)) {
			System.out.println("User already registered!Please,try again");
		} else {
			registeredUsers.add(this);
			System.out.println("Registration successful");

		}
	}

	public boolean isValidEmail(String email) {

		if (email != null && !email.equals("")) {
			String regexEmail="^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}$";
			boolean isMatch=email.matches(regexEmail);
			return isMatch;
			
		}else {
			return false;
		}
		

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Instagram_Project.IUser#uploadPicture()
	 */
	@Override
	public void uploadFeature(UploadableFeature feature) {
		
		

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Instagram_Project.IUser#showProfile()
	 */
	@Override
	public void showProfile() {
		for (IUser weFollows : weFollow) {
			System.out.println(weFollows);
		}
		for (IUser theyFollows : theyFollow) {
			System.out.println(theyFollows);
		}
		for (Photo photo : photos) {
			System.out.println(photo);
		}
		for (Video video : videos) {
			System.out.println(video);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Instagram_Project.IUser#searchForPeople(java.lang.String)
	 */
	@Override
	public void searchForPeople(String name) {
		for (User user : registeredUsers) {
			if (user.name.equals(name)) {
				user.showProfile();
			} else {
				System.out.println("User not found!");
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Instagram_Project.IUser#serchForPlaces(java.lang.String)
	 */
	@Override
	public List<UploadableFeature> serchForPlaces(String place) throws NoValidDataException {

		List<UploadableFeature> matchCity = new LinkedList<UploadableFeature>();
		if (place != null && !place.equals("")) {
			for (IUser user : registeredUsers) {
				for (Photo photo : photos) {
					if (place.equals(photo.getCity())) {
						matchCity.add(photo);
					}
				}
			}
		} else {
			throw new NoValidDataException("Enter a place to search!");
		}

		return matchCity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Instagram_Project.IUser#searchWithHashtag(java.lang.String)
	 */
	@Override
	public void searchWithHashtag(String hashTag) { // izqsnqvane na sluchaq

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Instagram_Project.IUser#login(java.lang.String, java.lang.String)
	 */
	@Override
	public void login(String name, String password) {
		for (User user : registeredUsers) {
			if ((name.equals(user.userName) && password.equals(user.password))) {
				if (!newFeeds.isEmpty()) {
					for (FollowersNewsFeed f : newFeeds) {
						System.out.println(f);
					}
				}else{
					System.out.println("NO available newfeeds");
				}
				
			} else {
				if (!name.equals(user.userName)) {
					System.out.println("Invalid name");
				} else {
					if (!name.equals(user.password)) {
						System.out.println("Invalid password");
					}
				}
			}
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Instagram_Project.IUser#logOut()
	 */
	@Override
	public void logOut() {
		System.out.println("Home page");
	}

	// public void download(){
	//
	// }

	/*
	 * (non-Javadoc)
	 * 
	 * @see Instagram_Project.IUser#like(Instagram_Project.UploadableFeature)
	 */
	@Override
	public void like(UploadableFeature feature) {
		if (feature != null) {
			feature.setNumberOfLikes(feature.getNumberOfLikes() + 1);
			System.out.println(" Number of Likes : " + feature.getNumberOfLikes());
			isLiked = true;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Instagram_Project.IUser#unlike(Instagram_Project.UploadableFeature)
	 */
	@Override
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see Instagram_Project.IUser#follow(Instagram_Project.User)
	 */
	@Override
	public void follow(IUser user) {
		for (IUser follower : weFollow) {
			if (weFollow.contains(user)) {
				System.out.println("You already follow this person");
			} else {
				weFollow.add((User) user);
			}
		}
	}

	@Override
	public void unfollow(IUser user) {
		for (IUser follower : weFollow) {
			if (weFollow.contains(user)) {
				weFollow.remove(user);
			} else {
				System.out.println("You do not follow this person");
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Instagram_Project.IUser#shareFeature()
	 */
	@Override
	public void shareFeature() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Instagram_Project.IUser#renameFeatureDescription(Instagram_Project.
	 * UploadableFeature, java.lang.String)
	 */
	@Override
	public void renameFeatureDescription(UploadableFeature feature, String description) {
		feature.rename(description);
	}

}
