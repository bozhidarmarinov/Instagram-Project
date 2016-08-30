package Instagram_Project;

public class InvalidUserException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1918104479780350435L;

	public InvalidUserException(String string) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getMessage() {
		return "Invalid User Name ";
	}

}
