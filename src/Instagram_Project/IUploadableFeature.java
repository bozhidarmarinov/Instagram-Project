package Instagram_Project;

public interface IUploadableFeature extends IFeature{
	//ako imame vreme 
	//public void download();
	
	public void rename(String descriptio)throws NoValidDataException;
	public void tag();
}
