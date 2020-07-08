package Student;

import java.io.*;
import java.util.*;

public class Student implements Serializable,Comparable{
	int no;
	String name;
	int age;
	mydate birthdate;
	List<course> courses;
	double averscore;
	
	public Student(int no, String name, mydate birthdate)
	{
		super();
		this.no = no;
		this.name = name;
		this.birthdate = birthdate;
		courses = new ArrayList<course>();
	}
	
	public int getNo() {return this.no;}
	public String getName() {return this.name;}
	public int getAge() {return this.age;}
	public mydate getBirthdate() {return this.birthdate;}
	public List<course> getCourses() {return this.courses;}
	public double getAverscore() {return this.averscore;}
	
	public void docalculateAverscore()
	{
		double sum = 0;
		for(course i : courses)
		{
			sum+=i.getScore();
		}
		this.averscore = sum/courses.size();
	}
	
	public void setNo(int no) {this.no = no;}
	public void setName(String name) {this.name = name;}
	public void setAge(int age) {this.age = age;}
	public void setBirthdate(mydate birthdate) {this.birthdate = birthdate;}
	public void setCourses(List<course> courses) {this.courses = courses; docalculateAverscore();}
	public void addCourses(course course) { delCourses(course); courses.add(course); docalculateAverscore();}
	public void delCourses(course course) { 
		Iterator<course> it = courses.iterator();
		while(it.hasNext())
		{
			course tem = it.next();
			if(tem.name.equalsIgnoreCase(course.name)) it.remove();
		} 
		docalculateAverscore();}
	@Override
	public boolean equals(Object o) {
		Student tem = (Student)o;
		if(this.no == tem.no) return true;
		return false;
	}
	public String toString() {
		return "编号为"+this.no+"、姓名为"+this.name+"、年龄为"+this.age+"的学生";
	}

	@Override
	public int compareTo(Object o) {
		Student tem = (Student)o;
		return this.no-tem.no;
	}
}
