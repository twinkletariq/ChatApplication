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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
public class Games extends JFrame{
	Games(){
		Frame f = new Frame("CHECKBOX");
		final Label label = new Label();
		label.setAlignment(Label.CENTER);
		label.setSize(400,100);
		
		Checkbox c= new Checkbox("TicTacToe");
		c.setBounds(100,100,100,100);
		Checkbox c1=new Checkbox("Snake Game");
		c1.setBounds(100,200,100,100);
		
		c.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				TicTacToe t = new TicTacToe();
			}
		});
		c1.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				new GameFrame();
				
			}
		

			
		
	});
		f.add(c);
		f.add(c1);
		f.add(label);
		f.setSize(400,500);
		f.setLayout(null);
		f.setVisible(true);
		
	}

}


