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
		if(this.score < 0) return "错误成绩";
		if(this.score >= 90) return "优秀";
		if(this.score >= 80) return "良好";
		if(this.score >= 70) return "中等";
		if(this.score >= 60) return "及格";
		if(this.score < 60) return "不及格";
		return "错误成绩";
	}
	@Override
	public boolean equals(Object o) {
		course tem = (course)o;
		if(this.name == tem.name) return true;
		return false;
	}
}
