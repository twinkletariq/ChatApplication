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
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import static java.awt.image.ImageObserver.ABORT;
import static java.awt.image.ImageObserver.ALLBITS;
import static java.awt.image.ImageObserver.HEIGHT;
import java.io.File;
import java.io.IOException;

import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import static java.awt.image.ImageObserver.ABORT;
import static java.awt.image.ImageObserver.ALLBITS;
import static java.awt.image.ImageObserver.HEIGHT;
import javax.swing.JFrame;

public class NewPage extends JFrame{
	NewPage(){
		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
		setTitle("WELCOME");
		setSize(400,200);
		
		
		Frame f = new Frame("CHECKBOX");
		f.setBackground(Color.getHSBColor(HEIGHT, ALLBITS, ABORT));
		final Label label = new Label();
		label.setAlignment(Label.CENTER);
		label.setSize(400,100);
		
		Checkbox c= new Checkbox("Personal chat");
		c.setBounds(100,100,100,100);
	
		Checkbox c1=new Checkbox("Groupchat");
		c1.setBounds(100,200,100,100);
		Checkbox c2=new Checkbox("Games");
		c2.setBounds(100,300,100,100);
		
		
		c.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				personalChat p = new personalChat();
				

				
			}
		});
		c1.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				label.setText("Groupchat:"+(e.getStateChange()==1?"checked":"unchecked"));
				
			}
		

			
		
	});
		
		c2.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				
				Games g = new Games();
			}
		

			
		
	});
		
		
		f.add(c);
		f.add(c1);
		f.add(c2);
		f.add(label);
		f.setSize(400,500);
		f.setLayout(null);
		f.setVisible(true);
		

}
}


