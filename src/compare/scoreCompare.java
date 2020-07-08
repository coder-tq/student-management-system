package compare;

import java.util.Comparator;
import Student.*;
public class scoreCompare implements Comparator<Student>
{
	@Override
	public int compare(Student o1,Student o2) {
		// TODO Auto-generated method stub
		if(o1.getAverscore()>o2.getAverscore()) return 1;
		else return -1;
	}
}
