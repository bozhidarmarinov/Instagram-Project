package Instagram_Project;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

public abstract class Feature implements IFeature{

	private LocalDateTime timeStamp;
	
	public Feature(){
		timeStamp=LocalDateTime.now();
	}
	
	public LocalDateTime getTimeStamp(){
		return timeStamp;
	}

}
