package Instagram_Project;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public abstract class Feature implements IFeature{

	private IUser creator;
	private String text;
	private Calendar timeStamp;
	
	private List<Feature> features=new LinkedList<Feature>();
	
	
	
	
}
