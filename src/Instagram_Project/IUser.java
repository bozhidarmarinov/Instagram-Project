package Instagram_Project;

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

	void follow(IUser user);

	void unfollow(IUser user);

	void shareFeature();

	void renameFeatureDescription(UploadableFeature feature, String description);

}