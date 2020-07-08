package windows;

import java.util.*;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
 
//监听事件
public class LoginListener implements ActionListener{
 
	private javax.swing.JTextField jt;//账号输入框对象
	private javax.swing.JPasswordField jp;//密码输入框对象
	
	
	
	private javax.swing.JFrame login;//定义一个窗体对象
	public LoginListener(javax.swing.JFrame login,javax.swing.JTextField jt,javax.swing.JPasswordField jp) {
		this.login=login;//获取登录界面
		this.jt=jt;//获取登录界面中的账号输入框对象
		this.jp=jp;//获取登录界面中的密码输入框对象
	}
 
	public void actionPerformed(ActionEvent e) {
		//利用get方法来获取账号和密码对象的文本信息，并用equal方法进行判断。最好不要用==，用==这个地方验证不过去。
		String pass = new String(jp.getPassword());
		//String user = jt.getText();
		//System.out.print(pass);
		//System.out.print(user);
		if(jt.getText().equals("admin")&&(pass.equals("admin"))) {
		//满足条件，则生成一个新的界面
			Mainwindow.main(null);
		// 通过我们获取的登录界面对象，用dispose方法关闭它
			login.dispose();
		}
		else if(jt.getText().equals("")||(pass.equals("")))
		{
			JOptionPane.showMessageDialog(login, "用户名或密码不能为空", "警告！",JOptionPane.WARNING_MESSAGE);
		}
		else
		{
			JOptionPane.showMessageDialog(login, "用户名或密码错误", "警告！",JOptionPane.WARNING_MESSAGE);  
		}
	}
}