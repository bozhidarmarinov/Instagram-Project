package Instagram_Project;

public interface IFeature {

	
	public void share();
	public void like(UploadableFeature feature);
	public void unlike(UploadableFeature feature);
	Comment add(String comment, UploadableFeature feature);
	
	
}
