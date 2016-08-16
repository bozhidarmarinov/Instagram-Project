package Instagram_Project;

import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public abstract class UploadableFeature implements IUploadableFeature {

	private String name;
	private String description;
	private int numberOfLikes;
	private User owner;
	private String city;
	private Set<User> commenters;
	private Set<User> likers;

}
