package windows;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.*;

import Student.Student;
import Student.mydate;

public class Addwindow extends JFrame{
	JTextField addno,addname,adddate;
	JLabel no,name,date;
	JButton button1;
	JFrame close;
	Set<Student> data;
	public Addwindow(JFrame frame)
	{
		close = this;
		frame.dispose();
		data = Main.Main.getData();
		this.setTitle("���ѧ����Ϣ");
		this.setVisible(true);
		this.setSize(500, 400);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		no = new JLabel();
		name = new JLabel();
		date = new JLabel();
		no.setText("ѧ��ѧ��");
		no.setBounds(50,50,150,30);
		name.setText("ѧ������");
		name.setBounds(50,100,150,30);
		date.setText("��������(2000-1-1)");
		date.setBounds(20,150,150,30);
		addno = new JTextField();
		addno.setBounds(200, 50, 250, 30);
		addname = new JTextField();
		addname.setBounds(200, 100, 250, 30);
		adddate = new JTextField();
		adddate.setBounds(200, 150, 250, 30);
		this.add(no);
		this.add(name);
		this.add(date);
		this.add(addno);
		this.add(addname);
		this.add(adddate);
		button1 = new JButton();
		button1.setText("�����Ϣ");
		button1.setBounds(180,250,100,30);
		button1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	try {
	            	String [] arr = adddate.getText().split("-");
	            	if(data.add(new Student(Integer.parseInt(addno.getText()),addname.getText(),new mydate(Integer.parseInt(arr[0]),Integer.parseInt(arr[1]),Integer.parseInt(arr[2])))))
	            	{
	            		JOptionPane.showInternalMessageDialog(null, "��ӳɹ�","ѧ����Ϣ��ӳɹ�", JOptionPane.INFORMATION_MESSAGE);
	            		Mainwindow.main(null);
	            	}
	            	else {
	            		JOptionPane.showMessageDialog(null, "����������Ϣ�Ƿ���ȷ�����Ѵ��ڸ�ѧ���������޸Ľ����޸�ѧ����Ϣ", "���ʧ��", JOptionPane.ERROR_MESSAGE); 
	            		Mainwindow.main(null);
	            	}
	            	try {
						Main.Main.preservationData();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						//e1.printStackTrace();
					}
            	}
            	catch(Exception e3)
            	{
            		JOptionPane.showMessageDialog(null, "δ֪��������ϵ����Ա����", "����", JOptionPane.ERROR_MESSAGE); 
            		Mainwindow.main(null);
            	}
            	close.dispose();
            }
        });
		this.add(button1);
	}
}
