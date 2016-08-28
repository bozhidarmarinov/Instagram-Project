package Instagram_Project;

public interface IUploadableFeature extends IFeature {

	public String rename(String descriptio) throws NoValidDataException;

	public void tag(User user) throws NoValidDataException;

	public int like(UploadableFeature feature) throws NoValidDataException;

	public int unlike(UploadableFeature feature) throws NoValidDataException;

	Comment add(String comment, UploadableFeature feature) throws NoValidDataException;

}
