package Instagram_Project;

import java.net.MalformedURLException;
import java.util.List;

public interface IUser {

	void uploadFeature(UploadableFeature feature);

	void showProfile();

	void searchForPeople(String name);

	List<UploadableFeature> serchForPlaces(String place) throws NoValidDataException;

	void searchWithHashtag(String hashTag);

	void login(String name, String password);

	void logOut();

	void like(UploadableFeature feature);

	void unlike(UploadableFeature feature);

	void follow(User user) throws NoValidDataException;

	void unfollow(User user) throws NoValidDataException;

	void shareFeature() throws MalformedURLException;

	void renameFeatureDescription(UploadableFeature feature, String description) throws NoValidDataException;

}