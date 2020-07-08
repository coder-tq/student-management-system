package Main;
import java.io.*;
import java.util.*;

import Student.*;
import compare.*;
import windows.*;
 //1.����Login�࣬
public class Main {
	static Set<Student> data;
	 // 1.�����ж���������
	public static void main(String[] args) throws Exception {
		// 2.���������У�ʵ����Login��Ķ��󣬵��ó�ʼ������ķ�����
		data = new TreeSet<Student>();
		File file = new File("record.txt");
		if (!file.exists())
		{
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			loadData();
		}
		catch(Exception e)
		{
			
		}
		//data.add(new Student(1,"aa",0,new mydate(2000,1,1)));
		for(Student i : data) System.out.println(i);
		Login.main(args);
	}
	public static void preservationData() throws Exception
	{
		ObjectOutputStream os=new ObjectOutputStream(new FileOutputStream("record.txt"));
		os.writeObject(data);
		os.close();
	}
	public static void loadData() throws Exception
	{
		ObjectInputStream osi=new ObjectInputStream(new FileInputStream("record.txt"));
		data=(TreeSet<Student>) osi.readObject();
		osi.close();
	}
	public static Set<Student> getData() {return data;}
}