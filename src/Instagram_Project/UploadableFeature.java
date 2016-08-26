package Instagram_Project;

import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public abstract class UploadableFeature extends Feature implements IUploadableFeature, IFeature {

	// private String name; // ako ne ni posluji, da iztriem
	private String description;
	private static int numberOfLikes;
	private User owner;
	private String city;
	private boolean isLiked;
	protected static List<Comment> comments = new LinkedList<Comment>();
	protected static List<User> taggedUsers = new LinkedList<User>();

	public User getOwner() {
		return owner;
	}

	public UploadableFeature(String description, User owner) throws NoValidDataException {
		this(description);
		if (owner != null) {
			this.owner = owner;
		} else {
			throw new NoValidDataException("Please chose a valid user");
		}
	}

	public UploadableFeature(String description) throws NoValidDataException {
		if (description != null && !description.equals("")) {
			this.description = description;
		} else {
			throw new NoValidDataException("Please chose a valid user");
		}
	}

	@Override
	public void tag(User user) throws NoValidDataException {
		if (user != null && user.isRegistered() == true) {
			UploadableFeature.taggedUsers.add(user);
		} else {
			throw new NoValidDataException("This user cannot be tag");
		}
	}

	@Override
	public int like(UploadableFeature feature) throws NoValidDataException {
		if (feature != null) {
			UploadableFeature.numberOfLikes += 1;
			System.out.println(" Number of Likes : " + UploadableFeature.numberOfLikes);
			isLiked = true;

		} else {

			throw new NoValidDataException("Please, choose a valid feature to like");
		}
		return numberOfLikes;

	}

	@Override
	public int unlike(UploadableFeature feature) throws NoValidDataException {
		if (feature != null) {
			if (isLiked == true) {
				UploadableFeature.numberOfLikes -= 1;
				System.out.println(" Number of Likes : " + UploadableFeature.numberOfLikes);
			}
		} else {
			throw new NoValidDataException("Please, choose a valid feature to unlike");
		}
		return numberOfLikes;

	}

	@Override
	public Comment add(String comment, UploadableFeature feature) throws NoValidDataException {
		Comment myComment = new Comment(comment, feature);
		feature.getComments().add(myComment);
		return myComment;
	}

	public List<Comment> getComments() {
		return comments;
	}

	@Override
	public void rename(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return description + taggedUsers;
	}

	public int getNumberOfLikes() {
		return numberOfLikes;
	}

	public void setNumberOfLikes(int numberOfLikes) {
		UploadableFeature.numberOfLikes = numberOfLikes;

	}

	public String getCity() {
		return city;
	}

}
