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
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.net.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.*;

import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


public class Server extends JFrame  {
	private JTextField userText;
	private JTextArea chatWindow;
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private ServerSocket server;
	private Socket connection;//socket is the connection between me & another computer.
	//constructor
	
	static JFrame f = new JFrame();
	public static String sname = JOptionPane.showInputDialog(f,"Enter Name");
	
	
	
	public Server() {
		
		super ("Chatroom");
		userText = new JTextField ();
		userText.setEditable(false);
		userText.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				sendMessage(event.getActionCommand());//passing the text we typed into the text Field
				userText.setText(" ");
			}
		}
		);
		add(userText,BorderLayout.NORTH);
		chatWindow = new JTextArea();
		add(new JScrollPane(chatWindow));
		setSize(300,150);
		setVisible(true);
	}
	public void startRunning() {
		try {
			server = new ServerSocket(6789,100);
		    while(true) {
		    	try {
		    		waitForConnection();
		    		setupStreams();//this is gonna set our input & output streams
		    		whileChatting();
		    	}catch(EOFException eofException) {
		    		showMessage("\n Server ended the connection!");//when I'm sick of talking to people :3
		    	}finally {
		    		closeCrap();//gonna end the streams & close the sockets
		    	}
		    }
	}catch(IOException ioException) {
		ioException.printStackTrace();
	}
 }
	//wait for connection, then display connection information
	private void waitForConnection() throws IOException{
		showMessage("Waiting for someone to connect.....\n");
		connection= server.accept();//when someone wants to have a conversation then their machine gonna accept a connection to the socket & that's gonna wait on our server & the loop is gonna go over & over again, every milisecond it's gonna be waiting for someone to connect. When server finally finds some1 to connect with a socket or a connection is made
		showMessage("Now connected to "+connection.getInetAddress().getHostName());//returns the server the address of the computer that it gets connected with & convert the ip address to string as the method takes only string :(
	}
	//get Stream to send & receive data
	private void setupStreams() throws IOException {
		output = new ObjectOutputStream(connection.getOutputStream());//setup the pathway to connect to some1 else
		output.flush();
		input = new ObjectInputStream(connection.getInputStream());//setup the pathway where others can  send msg to me
		showMessage("\n Streams are now setup!! \n");//streams are setup. Now start having a convo
	}
	// during the conversation 
	private void whileChatting() throws IOException{
		String message ="U are now conected!";
		sendMessage(message);
		ableToType(true);// allow user to type into that textbox
		do {
			//have a conversation
			try {
				message = (String)input.readObject();// they can send msg to me through input
	           showMessage("\n"+ message);// ever message they send should be in a new line
			}catch(ClassNotFoundException classNotfoundException) {
				showMessage("\n idk what that user send! ");//if user send some object that can't be converted to string this will popup :3
			}
		}while(!message.equals(Client.clientname+" - END"));
}
	//close streams & sockets after done chatting
	private void closeCrap() {
		showMessage("\n Closing connections...\n");
		ableToType(false);
		try {
			output.close();
			input.close();
		    connection.close();
		}catch(IOException ioException) {
			ioException.printStackTrace();
		}
	}
	//send a message to client
	private void sendMessage(String message) {
		try {
			output.writeObject(sname+" - "+message);//writeObject method sends a msg through the output
			output.flush();
			showMessage("\n"+sname+" - "+ message);
			//if you're
		}catch(IOException ioException) {
			chatWindow.append("\n ERROR: Can't send message");
		}
	}
	//updates window 
	private void showMessage(final String text) {
		SwingUtilities.invokeLater(
				new Runnable() {
					public void run() {
						chatWindow.append(text);
					}
				}
				);
	}
	//let the user type msg into their box
	private void ableToType(final boolean tof) {
		SwingUtilities.invokeLater(
				new Runnable() {
					public void run() {
						userText.setEditable(tof);
					}
				}
	);
	}

}


