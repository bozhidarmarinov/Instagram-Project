package Instagram_Project;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.regex.*;

public class User implements IUser {

	private Photo photo;
	private Comment comment;
	private Set<Video> videos = new HashSet<Video>();
	private Set<Photo> photos = new HashSet<Photo>();
	private Set<User> weFollow = new HashSet<User>();
	private Set<User> theyFollow = new HashSet<User>();
	private Set<FollowersNewsFeed> newFeeds = new LinkedHashSet<FollowersNewsFeed>();
	private String userName;
	private String password;
	private String biography;
	private String email;
	private String name;
	private Gender gender;
	private boolean isRegistered = false;
	

	// map username-->password
	protected static Map<String, String> loginDetails = Collections.synchronizedMap(new HashMap<String, String>());
	protected static Set<User> registeredUsers = Collections.synchronizedSet(new HashSet<User>());
	protected static Set<User> loginUsers = Collections.synchronizedSet(new HashSet<User>());

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
			loginDetails.put(this.userName, this.password);
			isRegistered = true;
			System.out.println("Registration successful");

		}
	}

	public boolean isValidEmail(String email) {

		if (email != null && !email.equals("")) {
			String regexEmail = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}$";
			boolean isMatch = email.matches(regexEmail);
			return isMatch;

		} else {
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
		if (loginUsers.contains(this) && feature != null) {
			if (feature instanceof Photo) {
				photos.add((Photo) feature);
			}
			if (feature instanceof Video) {
				videos.add((Video) feature);
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Instagram_Project.IUser#showProfile()
	 */
	@Override
	public void showProfile() {

		System.out.println("I follow:");
		for (User weFollows : weFollow) {
			System.out.print("\t" + weFollows + " ");
		}
		System.out.println("\nMy followers are:");
		for (User theyFollows : theyFollow) {
			System.out.print("\t" + theyFollows + " ");
		}
		System.out.println("\nMy photos");
		for (Photo photo : photos) {
			System.out.print("\t" + photo + " ");
			System.out.println(photo.getComments());
		}
		System.out.println("\nMy videos\n");
		for (Video video : videos) {
			System.out.println("\t" + video + " ");
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
		if (name != null && !name.equals("") && password != null && !password.equals("")) {
			if (isRegistered == true && loginDetails.containsKey(name) && loginDetails.get(name).equals(password)) {
				loginUsers.add(this);
				if (!newFeeds.isEmpty()) {
					for (FollowersNewsFeed f : newFeeds) {
						System.out.println(f);
					}
				} else {
					System.out.println("NO available newsfeed");
				}
			} else {
				if (!isRegistered) {
					System.out.println("This is not a registered user");
				} else {
					if (!loginDetails.containsKey(name)) {
						System.out.println("Invalid user name");
					} else {
						System.out.println("Invalid password");
					}
				}

			}
		}
	}

	// for (User user : registeredUsers) {
	// if ((name.equals(user.userName) && password.equals(user.password))) {
	// loginUsers.add(this);
	// if (!newFeeds.isEmpty()) {
	// for (FollowersNewsFeed f : newFeeds) {
	// System.out.println(f);
	// }
	// } else {
	// System.out.println("NO available newfeeds");
	// }
	//
	// } else {
	// if (!name.equals(user.userName)) {
	// System.out.println("Invalid name");
	// } else {
	// if (!name.equals(user.password)) {
	// System.out.println("Invalid password");
	// }
	// }
	// }
	// }

	@Override
	public int hashCode() {
		return (this.email.hashCode()) * (this.userName.hashCode());
	}

	@Override
	public boolean equals(Object obj) {
		if (obj != null && this != null) {
			User user = (User) obj;
			return this.email.equals(user.email) && this.userName.equals(user.userName);

		} else {
			return false;
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Instagram_Project.IUser#logOut()
	 */
	@Override
	public void logOut() {
		if (loginUsers.contains(this)) {
			loginUsers.remove(this);
			System.out.println("Home page");
		} else {
			System.out.println("You are not logged on!");
		}

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
	public void like(UploadableFeature feature) throws NoValidDataException {
		try {
			if (feature != null && loginUsers.contains(this)) {
				feature.like(feature);
			} else {
				throw new NoValidDataException("You are not login and you cannot like");
			}
		} catch (Exception e) {
			System.out.println("You are not login and you cannot like");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Instagram_Project.IUser#unlike(Instagram_Project.UploadableFeature)
	 */
	@Override
	public void unlike(UploadableFeature feature) {
		if (feature != null && loginUsers.contains(this)) {
			feature.unlike(feature);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Instagram_Project.IUser#follow(Instagram_Project.User)
	 */
	@Override
	public void follow(User user) throws NoValidDataException {
		if (user != null && user.isRegistered == true) {
			if (weFollow.contains(user)) {
				System.out.println("You already follow this person");
			} else {
				weFollow.add(user);
				user.theyFollow.add(this);
			}
		} else {
			throw new NoValidDataException("Provide a valid or registered user");
		}

	}

	@Override
	public void unfollow(User user) throws NoValidDataException {
		if (user != null && user.isRegistered == true) {
			if (weFollow.contains(user)) {
				weFollow.remove(user);
				user.theyFollow.remove(this);
			} else {
				System.out.println("You do not follow this person");
			}
		} else {
			throw new NoValidDataException("Provide a valid or registered user");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Instagram_Project.IUser#shareFeature()
	 */
	@Override
	public void shareFeature() throws MalformedURLException {
		URL featureURL = new URL("This will be a real photo or video url");

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Instagram_Project.IUser#renameFeatureDescription(Instagram_Project.
	 * UploadableFeature, java.lang.String)
	 */
	@Override
	public void renameFeatureDescription(UploadableFeature feature, String description) throws NoValidDataException {
		if (feature != null) {
			feature.rename(description);
		} else {
			throw new NoValidDataException("This photo/video does not exist");
		}

	}

	public void showRegistredUsers() {
		for (User user : registeredUsers) {
			System.out.println(user);
		}
	}

	
	public boolean isRegistered() {
		return isRegistered;
	}

	@Override
	public String toString() {
		return userName;
	}
	
	

	public Comment addComment(UploadableFeature feature, String comment1) throws NoValidDataException {
		if (!(feature != null && comment1 != null && !comment1.equals(""))) {
			throw new NoValidDataException("Invalid posting of coment");
		}
		return feature.add(comment1, feature);

	}
	public void tagPerson(User user, UploadableFeature feature) {
		try {
			feature.tag(user);
		} catch (NoValidDataException e) {
			System.out.println("This user cannot be tag");
		}
	}
	
	// TODO public void editProfile(){
		

}
