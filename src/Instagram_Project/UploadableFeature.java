package Instagram_Project;

import java.util.List;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public abstract class UploadableFeature implements IUploadableFeature {

	// private String name; // ako ne ni posluji, da iztriem
	private String description;
	private int numberOfLikes;
	private IUser owner;
	private String city;
	protected Set<User> commenters;
	protected Set<User> likers;
	protected List<Comment> comments = new LinkedList<Comment>();

	public UploadableFeature(String description) {
		if (description != null && !description.equals("")) {
			this.description = description;
		}
	}

	@Override
	public String toString() {
		return  description;
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
