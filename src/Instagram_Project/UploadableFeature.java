package Instagram_Project;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public abstract class UploadableFeature implements IUploadableFeature {

	// private String name; // ako ne ni posluji, da iztriem
	private String description;
	private int numberOfLikes;
	private User owner;
	private String city;
	private Set<User> commenters;
	private Set<User> likers;

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
