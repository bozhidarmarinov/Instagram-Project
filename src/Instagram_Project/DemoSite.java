package Instagram_Project;

import java.util.List;
import java.util.LinkedList;

public class DemoSite {

	public static void main(String[] args) throws NoValidDataException {

		// Create user to register

		System.out.println("REGISTER USERS:\n");

		User profile1 = new User("georgi", "123", "gosho@abv.bg");
		User profile2 = new User("georgi2", "123", "gosho1@abv.bg");
		User profile3 = new User("georgi", "123", "gosho@abv.bg");
		User profile4 = new User("ani", "abc", "ani@abv.bg");

		try {

			profile1.registerUser();
			profile2.registerUser();
			profile3.registerUser();
			profile4.registerUser();

		} catch (NoValidDataException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		profile1.login("georgi", "123");
		profile2.login("georgi", "123");

	
		// upload photo
		System.out.println("UPLOAD PHOTO:\n");
		profile1.login("georgi", "123");
		Photo photo1 = new Photo(profile1, "hello");
		profile1.uploadFeature(photo1);
		Photo photo2 = new Photo(profile1, "In the jungle");
		profile1.uploadFeature(photo1);

		// follow someone
		System.out.println("FOLLOW:");
		profile1.follow(profile2);
		profile1.follow(profile4);

		// follow me
		System.out.println("FOLLOW ME:");
		profile2.follow(profile1);

		// show profile
		System.out.println("SHOW PROFILE");
		profile1.showProfile();
		profile1.like(photo1);
		System.out.println(photo1.getNumberOfLikes());
		profile1.unlike(photo1);
		System.out.println(photo1.getNumberOfLikes());
		profile3.login("pesho", "abc");
		profile3.like(photo1);

		profile4.login("ani", "abc");
		profile4.like(photo1);

		// addComment
		profile1.addComment(photo1, "#snimka");
		profile1.tagPerson(profile3, photo1);
		profile1.tagPerson(profile2, photo1);
		profile1.tagPerson(profile4, photo1);
		System.out.println(photo1);
		profile4.login("ani", "abc");
		profile2.addComment(photo2, "snimka 2");
		System.out.println(photo2);
		System.out.println(profile1.showProfile());
	
		
		System.out.println(profile2.searchWithHashtag("#hello"));

		System.out.println(profile1.showRegistredUsers());
	}
}
