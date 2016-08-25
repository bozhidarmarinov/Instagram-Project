package Instagram_Project;

public class Comment extends Feature{

	private String comment;
	private UploadableFeature feature;


	public Comment(String comment, UploadableFeature feature) throws NoValidDataException {
		super();
		if (feature!=null) {
			this.comment = comment;
			this.feature = feature;
			
		}else {
			throw new NoValidDataException("Please, choose a photo/video to comment");
		}
	}

	@Override
	public String toString() {
		return "Comment "+ comment +" "+ feature + " "+getTimeStamp();
	}


	
}
