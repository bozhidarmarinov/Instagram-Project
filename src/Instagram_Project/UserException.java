package Instagram_Project;

public class UserException extends Exception {

	public UserException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UserException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public UserException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -4775057760843229165L;
	
	@Override
	public String getMessage() {
		return "This is not a registered User";
	}

}
