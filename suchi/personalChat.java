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


/**
 *
 * @author HP
 */
import javax.swing.*;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class personalChat extends Frame implements ActionListener,Runnable{

	
	personalChat(){
	
	JFrame frame = new JFrame();
    JPanel panel = new JPanel();

    JButton button1 = new JButton("Person 1");
    panel.add(button1);
    
    JButton button2 = new JButton("Person 2");
    panel.add(button2);
    frame.add(panel);
    
    frame.setSize(300,150);
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    frame.setVisible(true);
    
	
	button1.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			personalChat p = new personalChat();
			Thread t = new Thread(p) {
				public void run() {
					new Server().startRunning();
				}
			};
			t.start();
			
		}
	
	});
	button2.addActionListener(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		personalChat p = new personalChat();
		Thread t = new Thread(p);
		t.start();
		
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		Client cl;
		cl = new Client("127.0.0.1");
		cl.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cl.startRunning();
	}


	

}


