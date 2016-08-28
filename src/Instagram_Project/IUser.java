package Instagram_Project;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Set;

public interface IUser {

	UploadableFeature uploadFeature(UploadableFeature feature) throws NoValidDataException;

	String showProfile();

	void searchForPeople(String name) throws NoValidDataException;

	List<UploadableFeature> serchForPlaces(String place) throws NoValidDataException;

	Set<IFeature> searchWithHashtag(String hashTag);

	User login(String name, String password) throws NoValidDataException;

	void logOut();

	int like(UploadableFeature feature) throws NoValidDataException;

	int unlike(UploadableFeature feature) throws NoValidDataException;

	void follow(User user) throws NoValidDataException;

	void unfollow(User user) throws NoValidDataException;

	void shareFeature() throws MalformedURLException;

	UploadableFeature renameFeatureDescription(UploadableFeature feature, String description) throws NoValidDataException;

	String registerUser() throws NoValidDataException;

}