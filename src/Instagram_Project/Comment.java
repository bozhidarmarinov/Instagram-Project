package Instagram_Project;

public class Comment extends Feature{
	
	
	
	@Override
	public void add(Comment comment,UploadableFeature feature) {
		if (feature!=null) {
			feature.comments.add(comment);
		}
		
	}

	@Override
	public void share() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void like() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unlike() {
		// TODO Auto-generated method stub
		
	}

}
