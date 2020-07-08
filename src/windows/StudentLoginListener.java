package windows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class StudentLoginListener implements ActionListener{

	javax.swing.JFrame login;
	public StudentLoginListener(javax.swing.JFrame frame)
	{
		login = frame;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		new Querywindow(0);
		login.dispose();
	}

}
