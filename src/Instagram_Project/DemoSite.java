package Instagram_Project;

import java.util.List;
import java.util.LinkedList;

public class DemoSite {

	public static void main(String[] args) throws NoValidDataException {

		// Create user to register

		System.out.println("REGISTER USERS:\n");

		User profile1 = new User("georgi", "123", "gosho@abv.bg");
		User profile2 = new User("georgi", "123", "gosho@abv.bg");
		User profile3 = new User("pesho", "abc", "pesho@abv.bg");
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

		// profile.showRegistredUsers();

		// login and logout

		System.out.println("LOGIN USERS:\n");

		profile1.login("georgi", "123");
		profile2.login("georgi", "123");

		System.out.println("LOGOUT USERS");
		profile1.logOut();
		profile2.logOut();

		// upload photo
		System.out.println("UPLOAD PHOTO:\n");
		Photo photo1 = new Photo("On the beach");
		profile1.login("georgi", "123");
		profile1.uploadFeature(photo1);

		// follow someone
		System.out.println("FOLLOW:");
		profile1.follow(profile3);
		profile1.follow(profile4);
		
		//follow me
		System.out.println("FOLLOW ME:");
		profile4.follow(profile1);

		// show profile
		System.out.println("SHOW PROFILE");
		profile1.showProfile();

	}
}
