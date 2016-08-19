package Instagram_Project;

import java.util.List;
import java.util.LinkedList;

public class DemoSite {

	public static void main(String[] args) throws NoValidDataException {

		User profile = new User("georgi", "123", "gosho@abv.bg");
		User profile2 = new User("georgi", "123", "gosho@abv.bg");
		User profile3 = new User("pesho", "abc", "pesho@abv.bg");

		try {
			profile.registerUser();
			profile2.registerUser();
			profile3.registerUser();

		} catch (NoValidDataException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		profile.login("georgi", "123");

	}
}
