package windows;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Querywindow extends JFrame{
	JTextField queryno,queryname;
	JLabel no,name;
	JButton button1,button2;
	JFrame fr;
	public Querywindow(int flag)
	{
		fr = this;
		this.setTitle("ɽ���Ƽ���ѧ��Ϣ��ѯϵͳ(ѧ����)");// ���ô���ı���
		this.setSize(400, 350);// ���ô���Ĵ�С����λ������
		this.setDefaultCloseOperation(3);// ���ô���Ĺرղ�����3��ʾ�رմ����˳�����2��1��0
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setLayout(null);
		no = new JLabel();
		name = new JLabel();
		no.setText("ѧ��");
		no.setBounds(50,50,40,30);
		name.setText("����");
		name.setBounds(50,100,40,30);
		queryno = new JTextField();
		queryno.setBounds(100, 50, 250, 30);
		queryname = new JTextField();
		queryname.setBounds(100, 100, 250, 30);
		this.add(queryno);
		this.add(no);
		button1 = new JButton();
		button1.setText("��ѯ�ɼ�");
		button1.setBounds(210,150,130,30);
		button1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	Resultwindow w = new Resultwindow(queryno.getText(),queryname.getText(),flag);      
            }
        });
		this.add(button1);
		button2 = new JButton();
		if(flag == 0)
			button2.setText("���ص�½����");
		else button2.setText("����������");
		button2.setBounds(40,150,130,30);
		button2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	if(flag == 0)
            		Login.main(null);
            	else Mainwindow.main(null);
            	fr.dispose();
            }
        });
		this.add(button2);
	}
}
