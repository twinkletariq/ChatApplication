/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

/**
 *
 * @author HP
 */

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Dbtester extends Frame implements ActionListener{
	public static Connection con = null;
	TextField userText;
	Label userlabel ;
	Dbtester(){
		Label userlabel =new Label("Enter Username");
		userlabel.setBounds(60, 50, 80, 40);
		TextField userText = new TextField();
		userText.setBounds(150,50,170,40);
		Button b= new Button("submit");
		b.setBounds(30, 100, 80, 30);
		b.addActionListener(this);//kon event e jabe bujhate
		add(b);
		setSize(500,500);
		add(userlabel);
		add(userText);
		setLayout(null);
		setVisible(true);
	}
	//public Connection con = null;
	//Statement stmt=null;
	//String str = null;
	/*public Connection getDbConnection() throws SQLException, ClassNotFoundException{
		String str = this.userText.getText();
		Class.forName("com.mysql.cj.jdbc.Driver");
		//if (con==null) 
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/myapp","root", "b108");
		//}
		return con;
	}*/
	public void actionPerformed(ActionEvent e) {// interface use korsi ei method ta k pete
		// TODO Auto-generated method stub
		System.out.println("Button clicked");//actionPerformed method e likhbo button click hoile jta ami korte chai
		try {
		
			//String str = userText.getText();
			String str;
			str = userText.getText();
			Class.forName("com.mysql.jdbc.Driver");
                        if (con==null) {
		Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/myapp","root", "123");
               
                        }
                
  
	
		/*Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/myapp","root", "123");*/
			
               /* PreparedStatement stmt=con.prepareStatement("select * from user where firstName= '%s'");
			stmt.setString(1,str);
			ResultSet rs=stmt.executeQuery();*/
               Statement st = con.createStatement();
            String query =String.format("select*from user where firstname='%s'",str);
            ResultSet rs=st.executeQuery(query);
	        if(rs.equals(st)) {
	        	System.out.println("Welcome");
	        }else {
	        	System.out.println("Name not found");  
	        }
		}catch(Exception e1) {
				System.out.println(e1);
			}
}

public static void main(String[] args) throws ClassNotFoundException, SQLException {
	// TODO Auto-generated method stub
  Dbtester db = new Dbtester();
  
                
}
}