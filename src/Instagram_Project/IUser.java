package Instagram_Project;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Set;

public interface IUser {

	UploadableFeature uploadFeature(UploadableFeature feature) throws NoValidDataException;

	String showProfile();

	List<User> searchForPeople(String name) throws NoValidDataException;

	List<UploadableFeature> serchForPlaces(String place) throws NoValidDataException;

	Set<IFeature> searchWithHashtag(String hashTag);

	User login(String name, String password) throws NoValidDataException, NewsFeedException, UserException, InvalidUserException, InvalidPasswordException;

	void logOut();

	int like(UploadableFeature feature) throws NoValidDataException;

	int unlike(UploadableFeature feature) throws NoValidDataException;

	String follow(User user) throws NoValidDataException;

	String unfollow(User user) throws NoValidDataException;

	void shareFeature() throws MalformedURLException;

	UploadableFeature renameFeatureDescription(UploadableFeature feature, String description) throws NoValidDataException;

	String registerUser() throws NoValidDataException;

}