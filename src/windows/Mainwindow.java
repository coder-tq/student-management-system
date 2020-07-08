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
		// 2.���������У�ʵ����Login��Ķ��󣬵��ó�ʼ������ķ�����
		Mainwindow tempwindow = new Mainwindow();
		stdata = Main.Main.getData();
		tempwindow.initUI();
	}
	public void initUI() {
		JFrame frame = new JFrame();
		// 4.���ô�����������ֵ�����⡢��С����ʾλ�á��رղ��������֡���ֹ������С���ɼ���...
		frame.setTitle("ɽ���Ƽ���ѧ��Ϣ����ϵͳ");// ���ô���ı���
		frame.setSize(1030, 800);// ���ô���Ĵ�С����λ������
		frame.setDefaultCloseOperation(3);// ���ô���Ĺرղ�����3��ʾ�رմ����˳�����2��1��0
		frame.setLocationRelativeTo(null);// ���ô����������һ������ľ���λ�ã�����null��ʾ�����������Ļ������λ��
		frame.setResizable(false);// ���ý�ֹ���������С
		// ʵ������ʽ������Ķ���
		frame.setLayout(null);
		
		JButton button4=new JButton();
		//���ð�ť����ʾ����
		button4.setText("��ѯ");
		button4.setBounds(100, 50, 100, 30);
		button4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	new Querywindow(1);
            	frame.dispose();
            }
        });
		frame.add(button4);
		//ʵ����JButton��� 
		JButton button1=new JButton();
		//���ð�ť����ʾ����
		button1.setText("���");
		button1.setBounds(320, 50, 100, 30);
		frame.add(button1);
		button1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	new Addwindow(frame);
            }
        });
		JButton button2=new JButton();
		//���ð�ť����ʾ����
		button2.setText("ˢ��");
		button2.setBounds(500, 50, 100, 30);
		button2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	Mainwindow.main(null);
            	frame.dispose();
            }
        });
		JButton button3=new JButton();
		frame.add(button2);
		//���ð�ť����ʾ����
		button3.setText("ɾ��ѡ�и�");
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
		String[] columnNames = {"ѧ��","����","����","ƽ���ɼ�","��ϸ��Ϣ"};
		
		int con = 0;
		data = new Object[stdata.size()][];
		for(Student i : stdata)
		{
			data[con] = new Object[5];
			data[con][0] = (Object)(i.getNo()+"");
			data[con][1] = (Object)(i.getName());
			data[con][2] = (Object)(i.getBirthdate());
			data[con][3] = (Object)(i.getAverscore());
			data[con][4] = (Object)("�����˴��鿴/�޸�ѧ����ϸ��Ϣ");
			con++;
		}
		
		DefaultTableModel tableModel = new DefaultTableModel(data,columnNames) {
			@Override  
            public boolean isCellEditable(int row,int column){  
                if(column == 4) return true;
                return false;
            }
			public Class getColumnClass(int column) {//�������������Խ�������
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
		//Object[] rowValues = {"ѧ��","����","����","ƽ���ɼ�","��ϸ�ɼ�"};
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
