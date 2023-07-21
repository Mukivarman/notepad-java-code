

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;

public class Notepads implements ActionListener{

	JScrollPane rol;
	String str;
	JFrame f;
	JTextField tf;
	JButton btn,btn1,btn2,btn3;
	JTextArea ta;
	public Notepads() {
//text area		
		ta=new JTextArea();
		ta.setVisible(true);
		ta.setBounds(15,50,750,700);
		ta.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		rol=new JScrollPane(ta);
		rol.setBounds(15, 50, 750, 700);
//button -new file
		btn=new JButton("NEW FILE");
		btn.setVisible(true);
		btn.setBounds(15, 5, 100, 45);
		
//btn-OPEN
	btn1=new JButton("OPEN");
	btn1.setVisible(true);
	btn1.setBounds(115, 5, 100, 45);
	
//BTN-SAVE	
		btn2=new JButton("Save");
		btn2.setVisible(true);
		btn2.setBounds(215, 5, 100, 45);
//btn--close
		btn3=new JButton("close");
		btn3.setVisible(true);
		btn3.setBounds(315, 5, 100, 45);
		  
		
		
		
			f=new JFrame("SIMPLE NOTEPAD");
			f.setVisible(true);
			f.setSize(800,800);
			f.setLayout(null);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.add(btn);
			f.add(btn1);
			f.add(btn2);
			f.add(btn3);
			btn.addActionListener(this);
			btn1.addActionListener(this);
			btn2.addActionListener(this);
			btn3.addActionListener(this);
			f.add(rol); 
			    
	
	
	
	
	}
	public static void main(String[]args) {
		Notepads n=new Notepads();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn) {
			ta.setText(null);
		}
		if(e.getSource()==btn1) {
			JFileChooser ch=new JFileChooser();
			ch.showOpenDialog(ch);
			ch.getSelectedFile();
			File ref=ch.getSelectedFile();
			try {
				FileReader r=new FileReader(ref);
				StringBuilder sb=new StringBuilder();
				int output=r.read();
				while(output!=-1) {
					output=r.read();
					char st=(char)output;
					sb.append(st);
				}
				str=sb.toString();
				ta.setText(str);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			}
		if(e.getSource()==btn2) {
			JFileChooser ch=new JFileChooser();
			ch.showOpenDialog(ch);
			int result=ch.showSaveDialog(ta);
			if(result==JFileChooser.APPROVE_OPTION) {
			File file=	ch.getSelectedFile();
			try {
				FileWriter w=new FileWriter(file);
				w.write(ta.getText());
				w.flush();
				w.close();
			} catch (Exception e1) {
				e1.printStackTrace();
				
			}
			}
			}
		if(e.getSource()==btn3) {
			System.exit(0);
		}
			}
	}

