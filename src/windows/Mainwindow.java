package windows;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.table.*;

import Student.Student;
import Student.mydate;

import javax.swing.*;

public class Mainwindow {
	static Set<Student> stdata;
	public Object[][] data = {};
	JTable table;
	public static void main(String[] args) {
		// 2.在主函数中，实例化Login类的对象，调用初始化界面的方法。
		Mainwindow tempwindow = new Mainwindow();
		stdata = Main.Main.getData();
		tempwindow.initUI();
	}
	public void initUI() {
		JFrame frame = new JFrame();
		// 4.设置窗体对象的属性值：标题、大小、显示位置、关闭操作、布局、禁止调整大小、可见、...
		frame.setTitle("山东科技大学信息管理系统");// 设置窗体的标题
		frame.setSize(1030, 800);// 设置窗体的大小，单位是像素
		frame.setDefaultCloseOperation(3);// 设置窗体的关闭操作；3表示关闭窗体退出程序；2、1、0
		frame.setLocationRelativeTo(null);// 设置窗体相对于另一个组件的居中位置，参数null表示窗体相对于屏幕的中央位置
		frame.setResizable(false);// 设置禁止调整窗体大小
		// 实例化流式布局类的对象
		frame.setLayout(null);
		
		JButton button4=new JButton();
		//设置按钮的显示内容
		button4.setText("查询");
		button4.setBounds(100, 50, 100, 30);
		button4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	new Querywindow(1);
            	frame.dispose();
            }
        });
		frame.add(button4);
		//实例化JButton组件 
		JButton button1=new JButton();
		//设置按钮的显示内容
		button1.setText("添加");
		button1.setBounds(320, 50, 100, 30);
		frame.add(button1);
		button1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	new Addwindow(frame);
            }
        });
		JButton button2=new JButton();
		//设置按钮的显示内容
		button2.setText("刷新");
		button2.setBounds(500, 50, 100, 30);
		button2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	Mainwindow.main(null);
            	frame.dispose();
            }
        });
		JButton button3=new JButton();
		frame.add(button2);
		//设置按钮的显示内容
		button3.setText("删除选中格");
		button3.setBounds(700, 50, 100, 30);
		button3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	int [] rows = table.getSelectedRows();
            	for(int i : rows)
            	{
            		Iterator<Student> it = stdata.iterator();
            		while(it.hasNext())
            		{
            			Student tem = it.next();
            			if(tem.getNo() == Integer.parseInt((String)data[i][0]))
            			{
            				it.remove();
            			}
            		}
            	}
            	try {
					Main.Main.preservationData();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					
				}
            	Mainwindow.main(null);
            	frame.dispose();
            }
            
        });
		frame.add(button3);
		
		final JScrollPane scrollPane = new JScrollPane();
		String[] columnNames = {"学号","姓名","生日","平均成绩","详细信息"};
		
		int con = 0;
		data = new Object[stdata.size()][];
		for(Student i : stdata)
		{
			data[con] = new Object[5];
			data[con][0] = (Object)(i.getNo()+"");
			data[con][1] = (Object)(i.getName());
			data[con][2] = (Object)(i.getBirthdate());
			data[con][3] = (Object)(i.getAverscore());
			data[con][4] = (Object)("单击此处查看/修改学生详细信息");
			con++;
		}
		
		DefaultTableModel tableModel = new DefaultTableModel(data,columnNames) {
			@Override  
            public boolean isCellEditable(int row,int column){  
                if(column == 4) return true;
                return false;
            }
			public Class getColumnClass(int column) {//返回真正的类以进行排序
                Class returnValue;  
                if ((column >= 0) && (column < getColumnCount())) {  
                	return getValueAt(0, column).getClass();  
                } else {
                	return Object.class; 
                }
            }
		};
		RowSorter sorter = new TableRowSorter(tableModel);
		
		table = new JTable(tableModel);
		//Object[] rowValues = {"学号","姓名","生日","平均成绩","详细成绩"};
		//tableModel.addRow(rowValues);
		table.setRowSorter(sorter);
		scrollPane.setViewportView(table);
		table.setRowHeight(20);
		table.addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent e) { 
			int row =((JTable)e.getSource()).rowAtPoint(e.getPoint());
			int col=((JTable)e.getSource()).columnAtPoint(e.getPoint());
			//System.out.println(row+""+col);
			if(col == 4)
			{
				new Resultwindow((String)data[row][0],(String)data[row][1],1);
			}
		}});
		scrollPane.setBounds(10,100,1000,600);
		frame.add(scrollPane);
		
		frame.setVisible(true);
	}
}
