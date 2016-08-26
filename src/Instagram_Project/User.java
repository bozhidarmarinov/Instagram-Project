package Instagram_Project;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
import java.util.regex.*;

import javax.swing.CellEditor;

public class User implements IUser {

	private String userName;
	private String password;
	private String biography;
	private String email;
	private String name;
	private Gender gender;
	private Photo photo;
	private Comment comment;
	private Set<Video> videos = new HashSet<Video>();
	private Set<Photo> photos = new HashSet<Photo>();
	private Set<User> weFollow = new HashSet<User>();
	private Set<User> theyFollow = new HashSet<User>();
	private LoginNewsFeed loginNewsFeed = new LoginNewsFeed();
	private MyNewsFeed myNewsFeed = new MyNewsFeed();
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

	@Override
	public String registerUser() throws NoValidDataException {
		if (registeredUsers.contains(this)) {
			System.out.println("User already registered!Please,try again");
			return "User already registered!Please,try again";
		} else {
			registeredUsers.add(this);
			loginDetails.put(this.userName, this.password);
			isRegistered = true;
			System.out.println("Registration successful");
			return "Registration successful";
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
	public void uploadFeature(UploadableFeature feature) throws NoValidDataException {
		if (loginUsers.contains(this) && feature != null) {
			if (feature instanceof Photo) {
				photos.add((Photo) feature);
			}
			if (feature instanceof Video) {
				videos.add((Video) feature);
			}
			for (User followers : theyFollow) {
				followers.loginNewsFeed.addedToNewsFeed(feature, followers);
			}

		} else {
			throw new NoValidDataException("Photo/video you try to upload does not exist ");
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Instagram_Project.IUser#showProfile()
	 */
	@Override
	public String showProfile() {
		StringBuilder builder = new StringBuilder();
		builder.append("I follow:");
		for (User weFollows : weFollow) {
			builder.append("\t" + weFollows + " ");
		}
		builder.append("\nMy followers are:");
		for (User theyFollows : theyFollow) {
			builder.append("\t" + theyFollows + " ");
		}
		builder.append("\nMy photos");
		for (Photo photo : photos) {
			builder.append("\t" + photo + " ");
			builder.append(photo.getComments());
		}
		builder.append("\nMy videos\n");
		for (Video video : videos) {
			builder.append("\t" + video + " ");
			builder.append(video.getComments());
		}
		return builder.toString();

	}

	/*
	 * 
	 * 
	 * @see Instagram_Project.IUser#searchForPeople(java.lang.String)
	 */
	@Override
	public void searchForPeople(String userName) {
		if (userName != null && !userName.equals(" ")) {
			for (User user : registeredUsers) {
				if (user.userName != null) {
					if (user.userName.equals(userName)) {
						System.out.println(user.showProfile());
					}
				}
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
	public void searchWithHashtag(String hashTag) {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Instagram_Project.IUser#login(java.lang.String, java.lang.String)
	 */
	@Override
	public User login(String name, String password) {
		if (name != null && !name.equals("") && password != null && !password.equals("")) {
			if (isRegistered == true && loginDetails.containsKey(name) && loginDetails.get(name).equals(password)) {
				loginUsers.add(this);
				if (loginNewsFeed != null) {
					loginNewsFeed.showNewsFeed();
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
		return this;
	}

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
				String addToNewsFeed;
				if (feature.getOwner() != null) {
					if (feature instanceof Photo) {
						addToNewsFeed = this + " like your photo " + feature;
						feature.getOwner().myNewsFeed.addToMyNewsFeed(addToNewsFeed);
					} else {
						addToNewsFeed = this + " like your video " + feature;
						feature.getOwner().myNewsFeed.addToMyNewsFeed(addToNewsFeed);
					}

				} else {
					throw new NoValidDataException("Invalid picture");
				}
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
	public void unlike(UploadableFeature feature) throws NoValidDataException {
		if (feature != null && loginUsers.contains(this)) {
			feature.unlike(feature);
			String addToNewsFeed;
			if (feature.getOwner() != null) {
				if (feature instanceof Photo) {
					addToNewsFeed = this + " unlike your photo " + feature;
					feature.getOwner().myNewsFeed.addToMyNewsFeed(addToNewsFeed);
				} else {
					addToNewsFeed = this + " unlike your video " + feature;
					feature.getOwner().myNewsFeed.addToMyNewsFeed(addToNewsFeed);
				}

			} else {
				throw new NoValidDataException("Invalid picture");
			}
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

	public Comment addComment(UploadableFeature feature, String comment1) throws NoValidDataException {
		if (!(feature != null && comment1 != null && !comment1.equals(""))) {
			throw new NoValidDataException("Invalid posting of coment");
		}

		String addToNewsFeed;
		if (feature.getOwner() != null) {
			if (feature instanceof Photo) {
				addToNewsFeed = this + " comment your photo " + feature;
				feature.getOwner().myNewsFeed.addToMyNewsFeed(addToNewsFeed);
			} else {
				addToNewsFeed = this + " comment your video " + feature;
				feature.getOwner().myNewsFeed.addToMyNewsFeed(addToNewsFeed);
			}

		} else {
			throw new NoValidDataException("Invalid picture");
		}
		return feature.add(comment1, feature);

	}

	public void showMyNewsFeed() {
		myNewsFeed.showMyNewsFeed();
	}

	public void tagPerson(User user, UploadableFeature feature) {
		try {
			feature.tag(user);
		} catch (NoValidDataException e) {
			System.out.println("This user cannot be tag");
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

	public void changePassword(String newPassword) throws NoValidDataException {
		if (password != null && !password.equals("")) {
			this.password = newPassword;
		} else {
			throw new NoValidDataException("Please, enter a valid password");
		}
	}

	public void changeBiography(String biography) {
		this.biography = biography;

	}

}
