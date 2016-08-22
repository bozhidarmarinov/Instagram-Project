package Instagram_Project;

public class Comment {

	private String comment;
	private UploadableFeature feature;


	public Comment(String comment, UploadableFeature feature) {
		this.comment = comment;
		this.feature = feature;
	}


	@Override
	public String toString() {
		return "Comment [comment=" + comment + ", feature=" + feature + "]";
	}


	
}
