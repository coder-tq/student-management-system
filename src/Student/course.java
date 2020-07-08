package Student;

import java.io.Serializable;

public class course implements Serializable{
	String name;
	double score;
	public course(String name,double score)
	{
		this.name = name;
		this.score = score;
	}
	public void setScore(double score) {this.score = score;}
	public double getScore() {return this.score;}
	public String getName() {return this.name;}
	public String getLevel()
	{
		if(this.score < 0) return "����ɼ�";
		if(this.score >= 90) return "����";
		if(this.score >= 80) return "����";
		if(this.score >= 70) return "�е�";
		if(this.score >= 60) return "����";
		if(this.score < 60) return "������";
		return "����ɼ�";
	}
	@Override
	public boolean equals(Object o) {
		course tem = (course)o;
		if(this.name == tem.name) return true;
		return false;
	}
}
