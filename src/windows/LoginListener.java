package windows;

import java.util.*;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
 
//�����¼�
public class LoginListener implements ActionListener{
 
	private javax.swing.JTextField jt;//�˺���������
	private javax.swing.JPasswordField jp;//������������
	
	
	
	private javax.swing.JFrame login;//����һ���������
	public LoginListener(javax.swing.JFrame login,javax.swing.JTextField jt,javax.swing.JPasswordField jp) {
		this.login=login;//��ȡ��¼����
		this.jt=jt;//��ȡ��¼�����е��˺���������
		this.jp=jp;//��ȡ��¼�����е�������������
	}
 
	public void actionPerformed(ActionEvent e) {
		//����get��������ȡ�˺ź����������ı���Ϣ������equal���������жϡ���ò�Ҫ��==����==����ط���֤����ȥ��
		String pass = new String(jp.getPassword());
		//String user = jt.getText();
		//System.out.print(pass);
		//System.out.print(user);
		if(jt.getText().equals("admin")&&(pass.equals("admin"))) {
		//����������������һ���µĽ���
			Mainwindow.main(null);
		// ͨ�����ǻ�ȡ�ĵ�¼���������dispose�����ر���
			login.dispose();
		}
		else if(jt.getText().equals("")||(pass.equals("")))
		{
			JOptionPane.showMessageDialog(login, "�û��������벻��Ϊ��", "���棡",JOptionPane.WARNING_MESSAGE);
		}
		else
		{
			JOptionPane.showMessageDialog(login, "�û������������", "���棡",JOptionPane.WARNING_MESSAGE);  
		}
	}
}