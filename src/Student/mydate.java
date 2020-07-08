package Student;

import java.io.Serializable;

public class mydate implements Serializable{
	int year,month,day;
	public mydate(int year,int month,int day)
	{
		this.year = year;
		this.month = month;
		this.day = day;
	}
	int getYear() { return this.year; }
	int getMonth() { return this.month; }
	int getDay() { return this.day; }
	public String toString()
	{
		return this.year+"-"+this.month+"-"+this.day;
	}
}
