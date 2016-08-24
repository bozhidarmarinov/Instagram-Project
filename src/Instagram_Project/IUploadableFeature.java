package Instagram_Project;

public interface IUploadableFeature extends IFeature {

	public void rename(String descriptio) throws NoValidDataException;

	public void tag(User user) throws NoValidDataException;

	public void share();

	public void like(UploadableFeature feature);

	public void unlike(UploadableFeature feature);

	Comment add(String comment, UploadableFeature feature);

}
