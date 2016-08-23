package Instagram_Project;

import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public abstract class UploadableFeature implements IUploadableFeature {

	// private String name; // ako ne ni posluji, da iztriem
	private Comment comment1;
	private String description;
	private static int numberOfLikes;
	private User owner;
	private String city;
	private boolean isLiked;
	protected Set<User> commenters;
	protected Set<User> likers;
	protected static List<Comment> comments = new LinkedList<Comment>();
	protected static List<User> taggedUsers = new LinkedList<User>();

	public User getOwner() {
		return owner;
	}

	
	
	@Override
	public void tag(User user) throws NoValidDataException {
		if (user != null && user.isRegistered() == true) {
			this.taggedUsers.add(user);
		} else {
			throw new NoValidDataException("This user cannot be tag");
		}
	}

	@Override
	public void like(UploadableFeature feature) {
		feature.numberOfLikes += 1;
		System.out.println(" Number of Likes : " + feature.numberOfLikes);
		isLiked = true;
	}

	@Override
	public void unlike(UploadableFeature feature) {
		if (isLiked == true) {
			feature.numberOfLikes -= 1;
			System.out.println(" Number of Likes : " + feature.numberOfLikes);
		}
	}

	@Override
	public Comment add(String comment, UploadableFeature feature) {
		Comment c = new Comment(comment, feature);
		feature.getComments().add(c);
		return c;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public UploadableFeature(String description) {
		if (description != null && !description.equals("")) {
			this.description = description;
		}
	}

	@Override
	public String toString() {
		return description + taggedUsers;
	}

	@Override
	public void rename(String description) {
		this.description = description;
	}

	public int getNumberOfLikes() {
		return numberOfLikes;
	}

	public void setNumberOfLikes(int numberOfLikes) {
		this.numberOfLikes = numberOfLikes;

	}

	public String getCity() {
		return city;
	}

}
