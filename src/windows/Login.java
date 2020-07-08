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
 
 //1.定义Login类，
public class Login {
 
	
	 // 1.在类中定义主函数
	public static void main(String[] args) {
		// 2.在主函数中，实例化Login类的对象，调用初始化界面的方法。
		Login login = new Login();
		login.initUI();
	}
	// 1.在类中定义初始化界面的方法；
	 
	public void initUI() {
		JFrame frame = new JFrame();
		// 4.设置窗体对象的属性值：标题、大小、显示位置、关闭操作、布局、禁止调整大小、可见、...
		frame.setTitle("登录山东科技大学信息管理系统");// 设置窗体的标题
		frame.setSize(400, 350);// 设置窗体的大小，单位是像素
		frame.setDefaultCloseOperation(3);// 设置窗体的关闭操作；3表示关闭窗体退出程序；2、1、0
		frame.setLocationRelativeTo(null);// 设置窗体相对于另一个组件的居中位置，参数null表示窗体相对于屏幕的中央位置
		frame.setResizable(false);// 设置禁止调整窗体大小
 
		// 实例化FlowLayout流式布局类的对象，指定对齐方式为居中对齐，组件之间的间隔为5个像素
		FlowLayout fl = new FlowLayout(FlowLayout.CENTER, 10, 10);
		// 实例化流式布局类的对象
		frame.setLayout(fl);
		String text = "\t欢迎登录山东科技大学学生信息管理系统\n最新公告：无";
	    JTextArea textAreal = new JTextArea(text);
	    textAreal.setPreferredSize(new Dimension(370, 100));
	    textAreal.setLineWrap(true);
	    textAreal.setEditable(false);
	    frame.add(textAreal);
		// 5.实例化元素组件对象，将元素组件对象添加到窗体上（组件添加要在窗体可见之前完成）。
		// 实例化ImageIcon图标类的对象，该对象加载磁盘上的图片文件到内存中，这里的路径要用两个\
		//ImageIcon icon = new ImageIcon("C:\\Desktop\\蓝杰学习\\材料\\爱晚亭.gif");
		// 用标签来接收图片，实例化JLabel标签对象，该对象显示icon图标
		//JLabel labIcon = new JLabel(icon);
		//设置标签大小
		//labIcon.setSize(30,20);setSize方法只对窗体有效，如果想设置组件的大小只能用
		Dimension dim = new Dimension(400,300);
		//labIcon.setPreferredSize(dim);
		// 将labIcon标签添加到窗体上
		// 实例化JLabel标签对象，该对象显示"账号："
		JLabel labName = new JLabel("管理员账号：");
		// 将labName标签添加到窗体上
		frame.add(labName);
		JTextField textname=new JTextField();
 
		// 实例化JTextField标签对象
		JTextField textName = new JTextField();
		Dimension dim1 = new Dimension(250,30);
		//textName.setSize(dim);//setSize这方法只对顶级容器有效，其他组件使用无效。
		textName.setPreferredSize(dim1);//设置除顶级容器组件其他组件的大小
		// 将textName标签添加到窗体上
		frame.add(textName);
 
		//实例化JLabel标签对象，该对象显示"密码："
		JLabel labpass= new JLabel("管理员密码：");
		//将labpass标签添加到窗体上
		frame.add(labpass);
		//实例化JPasswordField
		JPasswordField textword=new JPasswordField();
		//设置大小
		textword.setPreferredSize(dim1);//设置组件大小
		//添加textword到窗体上
		frame.add(textword);
		//实例化JButton组件 
		JButton button=new JButton();
		//设置按钮的显示内容
		Dimension dim2 = new Dimension(100,30);
		button.setText("管理员登录");
		//设置按钮的大小
		button.setSize(dim2);
		frame.add(button);
		JButton button2 = new JButton();
		button2.setSize(300,30);
		button2.setText("学生登录");
		button2.addActionListener(new StudentLoginListener(frame));
		frame.add(button2);
		frame.setVisible(true);// 设置窗体为可见
		LoginListener ll=new LoginListener(frame,textName,textword);
		//对当前窗体添加监听方法
		button.addActionListener(ll);//监控按钮
	}
 
}