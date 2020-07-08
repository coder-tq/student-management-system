package windows;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Student.*;
public class Resultwindow extends JFrame{
	int loginflag;
	int con;
	JTable table;
	Student searchst;
	JFrame fr;
	public Resultwindow(String no,String name,int flag)
	{
		fr = this;
		loginflag = flag;
		Set<Student> data = Main.Main.getData();
		Student tem = null;
		this.setVisible(false);
		try {
			tem = new Student(Integer.parseInt(no),name,new mydate(2000,0,0));
			//tem = new Student(1,"aa",0,new mydate(2000,1,1));
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "未查询到该学号对应的学生，请检查您的输入", "出错啦！", JOptionPane.ERROR_MESSAGE);
			this.dispose();
			return;
		}
		
		if(!data.contains(tem))
		{
			JOptionPane.showMessageDialog(null, "未查询到该学号对应的学生，请检查您的输入", "出错啦！", JOptionPane.ERROR_MESSAGE);
			this.dispose();
		}
		else
		{
			searchst = null;
			for(Student i : data)
			{
				if(i.getNo() == Integer.parseInt(no)) {searchst = i;break;}
			}
			this.setTitle("查询结果");
			this.setSize(820, 600);
			this.setLocationRelativeTo(null);
			this.setVisible(true);
			this.setLayout(null);
			JLabel label = new JLabel();
			label.setText("查询结果");
			label.setBounds(320, 50, 100, 30);
			this.add(label);
			final JScrollPane scrollPane = new JScrollPane();
			String[] columnNames = {"项目","数据(双击修改数据)"};
			
			
			Object[][] tabeldata = new Object[5+searchst.getCourses().size()][2];
			tabeldata[0][0] = (Object)("学号");
			tabeldata[0][1] = (Object)(""+searchst.getNo());
			tabeldata[1][0] = (Object)("姓名");
			tabeldata[1][1] = (Object)(""+searchst.getName());
			tabeldata[2][0] = (Object)("出生日期");
			tabeldata[2][1] = (Object)(""+searchst.getBirthdate().toString());
			tabeldata[3][0] = (Object)("平均分");
			tabeldata[3][1] = (Object)(""+searchst.getAverscore());
			con = 4;
			List<course> li = searchst.getCourses();
			for(course i : li)
			{
				tabeldata[con][0] = (Object)(i.getName()+"成绩");
				tabeldata[con][1] = (Object)(i.getScore()+"");
				con++;
			}
			DefaultTableModel tableModel = new DefaultTableModel(tabeldata,columnNames) {
				@Override  
	            public boolean isCellEditable(int row,int column){
	                if(column == 0) return false;
	                if(row < 2) return false;
	                return true;
	            }
			};
			table = new JTable(tableModel);
			//Object[] rowValues = {"学号","姓名","生日","平均成绩","详细成绩"};
			//tableModel.addRow(rowValues);
			scrollPane.setViewportView(table);
			table.setRowHeight(20);
			table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) { 
				int row =((JTable)e.getSource()).rowAtPoint(e.getPoint());
				int col=((JTable)e.getSource()).columnAtPoint(e.getPoint());
				if(col == 4)
				{
					new Resultwindow((String)tabeldata[row][0],(String)tabeldata[row][1],1);
				}
			}});
			scrollPane.setBounds(10,100,700,400);
			this.add(scrollPane);
			
			JButton button1 = new JButton();
			button1.setText("保存");
			button1.setBounds(720,520,70,30);
			button1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	try {
            		if(loginflag==0) {
            			JOptionPane.showMessageDialog(null, "请先登录", "出错啦！", JOptionPane.ERROR_MESSAGE);
            			return;
            		}
            		String [] arr = ((String)table.getValueAt(2, 1)).split("-");
            		Student changest = new Student(Integer.parseInt((String)tabeldata[0][1]),(String)tabeldata[1][1],new mydate(Integer.parseInt(arr[0]),Integer.parseInt(arr[1]),Integer.parseInt(arr[2])));
            		List<course> changeli = new ArrayList<course>();
            		for(int i = 4; i < con; i++)
            		{
            			//changeli.add(new course(((String)table.getValueAt(i, 0)).replaceAll("成绩", ""),(Double)table.getValueAt(i, 1)));
            			changeli.add(new course(((String)table.getValueAt(i, 0)).replaceAll("成绩", ""),Double.parseDouble((String)table.getValueAt(i, 1))));
            		}
            		changest.setCourses(changeli);
            		data.remove(changest);
            		data.add(changest);
            		Main.Main.preservationData();
            		fr.dispose();
            	}
            	catch(Exception E)
            	{
            		//System.out.println((String)table.getValueAt(4, 0)+" " +(String)table.getValueAt(4, 1));
            		E.printStackTrace();
            		JOptionPane.showMessageDialog(null, "部分信息输入有误，保存失败", "出错啦！", JOptionPane.ERROR_MESSAGE);
            	}
            }
			});
			this.add(button1);
			JButton button2 = new JButton();
			button2.setText("添加/修改课程");
			button2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	try {
            		if(loginflag==0) {
            			JOptionPane.showMessageDialog(null, "请先登录", "出错啦！", JOptionPane.ERROR_MESSAGE);
            			return;
            		}
            		String name = JOptionPane.showInputDialog("请输入课程名称：");
            		Double score = Double.parseDouble(JOptionPane.showInputDialog("请输入该课程分数："));
            		searchst.addCourses(new course(name,score));
              		data.remove(searchst);
            		data.add(searchst);
            		Main.Main.preservationData();
            		fr.dispose();
            		new Resultwindow(searchst.getNo()+"",searchst.getName(),loginflag);
            	}
            	catch(Exception E)
            	{
            		JOptionPane.showMessageDialog(null, "部分信息输入有误，保存失败", "出错啦！", JOptionPane.ERROR_MESSAGE);
            	}
            }
			});
			button2.setBounds(500,520,150,30);
			this.add(button2);
			JButton button3 = new JButton();
			button3.setText("删除课程及成绩");
			button3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	try {
            		if(loginflag==0) {
            			JOptionPane.showMessageDialog(null, "请先登录", "出错啦！", JOptionPane.ERROR_MESSAGE);
            			return;
            		}
            		int [] rows = table.getSelectedRows();
                	for(int i : rows)
                	{
                		List<course> li = searchst.getCourses();
                		Iterator<course> it = li.iterator();
                		while(it.hasNext())
                		{
                			course tem = it.next();
                			if(tem.getName().equalsIgnoreCase(((String)table.getValueAt(i, 0)).replaceAll("成绩", "")))
                			{
                				it.remove();
                			}
                		}
                		searchst.setCourses(li);
                	}
                	Main.Main.preservationData();
                	fr.dispose();
            		new Resultwindow(searchst.getNo()+"",searchst.getName(),loginflag);
            	}
            	catch(Exception E)
            	{
            		JOptionPane.showMessageDialog(null, "未知问题，请联系管理员处理", "出错啦！", JOptionPane.ERROR_MESSAGE);
            	}
            }
			});
			button3.setBounds(300,520,150,30);
			this.add(button3);
		}
	}
}
