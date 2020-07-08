package windows;
import compare.*;
import java.awt.Dimension;
import java.awt.FlowLayout;
 
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
 
 //1.����Login�࣬
public class Login {
 
	
	 // 1.�����ж���������
	public static void main(String[] args) {
		// 2.���������У�ʵ����Login��Ķ��󣬵��ó�ʼ������ķ�����
		Login login = new Login();
		login.initUI();
	}
	// 1.�����ж����ʼ������ķ�����
	 
	public void initUI() {
		JFrame frame = new JFrame();
		// 4.���ô�����������ֵ�����⡢��С����ʾλ�á��رղ��������֡���ֹ������С���ɼ���...
		frame.setTitle("��¼ɽ���Ƽ���ѧ��Ϣ����ϵͳ");// ���ô���ı���
		frame.setSize(400, 350);// ���ô���Ĵ�С����λ������
		frame.setDefaultCloseOperation(3);// ���ô���Ĺرղ�����3��ʾ�رմ����˳�����2��1��0
		frame.setLocationRelativeTo(null);// ���ô����������һ������ľ���λ�ã�����null��ʾ�����������Ļ������λ��
		frame.setResizable(false);// ���ý�ֹ���������С
 
		// ʵ����FlowLayout��ʽ������Ķ���ָ�����뷽ʽΪ���ж��룬���֮��ļ��Ϊ5������
		FlowLayout fl = new FlowLayout(FlowLayout.CENTER, 10, 10);
		// ʵ������ʽ������Ķ���
		frame.setLayout(fl);
		String text = "\t��ӭ��¼ɽ���Ƽ���ѧѧ����Ϣ����ϵͳ\n���¹��棺��";
	    JTextArea textAreal = new JTextArea(text);
	    textAreal.setPreferredSize(new Dimension(370, 100));
	    textAreal.setLineWrap(true);
	    textAreal.setEditable(false);
	    frame.add(textAreal);
		// 5.ʵ����Ԫ��������󣬽�Ԫ�����������ӵ������ϣ�������Ҫ�ڴ���ɼ�֮ǰ��ɣ���
		// ʵ����ImageIconͼ����Ķ��󣬸ö�����ش����ϵ�ͼƬ�ļ����ڴ��У������·��Ҫ������\
		//ImageIcon icon = new ImageIcon("C:\\Desktop\\����ѧϰ\\����\\����ͤ.gif");
		// �ñ�ǩ������ͼƬ��ʵ����JLabel��ǩ���󣬸ö�����ʾiconͼ��
		//JLabel labIcon = new JLabel(icon);
		//���ñ�ǩ��С
		//labIcon.setSize(30,20);setSize����ֻ�Դ�����Ч���������������Ĵ�Сֻ����
		Dimension dim = new Dimension(400,300);
		//labIcon.setPreferredSize(dim);
		// ��labIcon��ǩ��ӵ�������
		// ʵ����JLabel��ǩ���󣬸ö�����ʾ"�˺ţ�"
		JLabel labName = new JLabel("����Ա�˺ţ�");
		// ��labName��ǩ��ӵ�������
		frame.add(labName);
		JTextField textname=new JTextField();
 
		// ʵ����JTextField��ǩ����
		JTextField textName = new JTextField();
		Dimension dim1 = new Dimension(250,30);
		//textName.setSize(dim);//setSize�ⷽ��ֻ�Զ���������Ч���������ʹ����Ч��
		textName.setPreferredSize(dim1);//���ó��������������������Ĵ�С
		// ��textName��ǩ��ӵ�������
		frame.add(textName);
 
		//ʵ����JLabel��ǩ���󣬸ö�����ʾ"���룺"
		JLabel labpass= new JLabel("����Ա���룺");
		//��labpass��ǩ��ӵ�������
		frame.add(labpass);
		//ʵ����JPasswordField
		JPasswordField textword=new JPasswordField();
		//���ô�С
		textword.setPreferredSize(dim1);//���������С
		//���textword��������
		frame.add(textword);
		//ʵ����JButton��� 
		JButton button=new JButton();
		//���ð�ť����ʾ����
		Dimension dim2 = new Dimension(100,30);
		button.setText("����Ա��¼");
		//���ð�ť�Ĵ�С
		button.setSize(dim2);
		frame.add(button);
		JButton button2 = new JButton();
		button2.setSize(300,30);
		button2.setText("ѧ����¼");
		button2.addActionListener(new StudentLoginListener(frame));
		frame.add(button2);
		frame.setVisible(true);// ���ô���Ϊ�ɼ�
		LoginListener ll=new LoginListener(frame,textName,textword);
		//�Ե�ǰ������Ӽ�������
		button.addActionListener(ll);//��ذ�ť
	}
 
}