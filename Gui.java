package edu.cuny.csi.csc330.project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.sound.sampled.LineUnavailableException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Gui implements ActionListener{
	
	private JFrame frame;
	public JPanel panel;
//	private JButton yesButton;
//	private JButton noButton;
	private JButton submitButton;
	private JButton submitButton2;
	private JLabel title;
	private Container con;
	
	
	private String text[] = {"Please enter your name", "You are lost, find your way home"};
	
	public Gui(){
		
		frame = new JFrame();
		submitButton = new JButton("Submit");
		panel = new JPanel();
		con = frame.getContentPane();
		
		
		//yesButton = new JButton("Yes");
		//noButton = new JButton("No");
		
		
		submitButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		     //Change string from text box to players name
		      }});
		
		
		title = new JLabel();
		title.setLayout(null);
		title.setBounds(100,100, 600, 150);
		title.setBackground(Color.white);
		//label.setFont(new Font("Arial", 0 , 16));
	//	label.setText(texts[count]);
		//label.setBounds(0,0,200,50);
		

		
		
		panel.setBorder(BorderFactory.createEmptyBorder(350,350,150,350));
		panel.setLayout(new GridLayout(0,1));
		panel.setBackground(Color.DARK_GRAY);
		//panel.add(title);
		//panel.add(yesButton);
		//panel.add(noButton);
		
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setTitle("A Journey Home");
		frame.pack();
		frame.setVisible(true);
		con.add(title);
	}	
	

	
 	public static void main (String[] args)
	{
		
		new Gui();
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
	}
}
