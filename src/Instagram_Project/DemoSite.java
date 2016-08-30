package Instagram_Project;

import java.util.List;
import java.util.LinkedList;

public class DemoSite {

	public static void main(String[] args) throws NoValidDataException, NewsFeedException {

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
		try {
			profile1.login("georgi", "123");
			profile2.login("georgi", "123");

		} catch (UserException | InvalidUserException | InvalidPasswordException e) {
			System.out.println(e.getMessage());
		}

		// upload photo
		System.out.println("UPLOAD PHOTO:\n");
		try {
			profile1.login("georgi", "123");
		} catch (UserException | InvalidUserException | InvalidPasswordException e) {
			System.out.println(e.getMessage());
		}

		Photo photo1 = new Photo(profile1, "hello");
		profile1.uploadFeature(photo1);
		Photo photo2 = new Photo(profile1, "In the jungle");
		profile1.uploadFeature(photo2);

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

		try {
			profile3.login("pesho", "abc");
			profile4.login("ani", "abc");
		} catch (UserException | InvalidUserException | InvalidPasswordException e) {
			System.out.println(e.getMessage());
		}
		try {
			profile3.like(photo1);
			profile4.like(photo1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		// addComment
		profile1.addComment(photo1, "#snimka");
		profile1.tagPerson(profile3, photo1);
		profile1.tagPerson(profile2, photo1);
		profile1.tagPerson(profile4, photo1);
		System.out.println(photo1);

		try {
			profile4.login("ani", "abc");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		profile2.addComment(photo2, "snimka 2");
		System.out.println(photo2);
		System.out.println(profile1.showProfile());
		System.out.println(profile1.showRegistredUsers());

	}
}
