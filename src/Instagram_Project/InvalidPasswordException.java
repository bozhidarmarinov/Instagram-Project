package Instagram_Project;

public class InvalidPasswordException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 256258674587499913L;

	public InvalidPasswordException(String string) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getMessage() {
		return "Invalid Password";
	}

}
