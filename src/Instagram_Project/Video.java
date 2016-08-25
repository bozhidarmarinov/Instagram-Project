package Instagram_Project;

public class Video extends UploadableFeature {
	

	private Property properties;

	public Video(User owner, String description) throws NoValidDataException {
		super(description, owner);
	}

	@Override
	public void share() {
		// TODO Auto-generated method stub
		
	}
}
