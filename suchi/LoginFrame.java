/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package suchi;

/**
 *
 * @author HP
 */





import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
public class LoginFrame extends JFrame implements ActionListener{
	JButton b1;
	JButton b2;
	JPanel newPanel;
	JLabel userlabel,passlabel;
	final JTextField textfield1,textfield2;
		
	LoginFrame(){
		userlabel = new JLabel();
		userlabel.setText("USERNAME");
		
		textfield1 = new JTextField(15);
		
		passlabel = new JLabel();
		passlabel.setText("PASSWORD");
		textfield2= new JPasswordField(15);
		
		b1=new JButton("SIGN-IN");
		b2=new JButton("SIGN-UP");
		
		newPanel = new JPanel(new GridLayout(3,1));
		newPanel.add(userlabel);
		newPanel.add(textfield1);
		newPanel.add(passlabel);
		newPanel.add(textfield2);
		newPanel.add(b1);
		newPanel.add(b2);
		
		add(newPanel,BorderLayout.CENTER);
		setTitle("LOGIN FORM");
		b1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String userValue = textfield1.getText();
				String passValue = textfield2.getText();
				try {
                                    
                                    
                                    Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/info","root","123");
					Statement stmt = con.createStatement();
					String sql = String.format("select * from user where Name ='%s' and Password = '%s'",userValue,passValue);
					ResultSet rs = stmt.executeQuery(sql);
				
					
				    if(rs.next()==true) {
					   NewPage page = new NewPage();
					   page.setVisible(true);
					   JLabel welcome = new JLabel("WELCOME "+userValue+", TO OUR SYSTEM! ");
					   page.getContentPane().add(welcome);
				    }
				    else {
					   JFrame f = new JFrame();
					   JOptionPane.showMessageDialog(f, "NOT FOUND!","ALERT",JOptionPane.WARNING_MESSAGE);
				    }
				    }catch(Exception e1) {
					   System.out.println(e1);
				}
				
				
				
			}
			
		});
		
		b2.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Signup s = new Signup();
		
	}
}

