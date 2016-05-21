package project;

import java.awt.event.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.*;

public class Reaction extends Game implements ActionListener{
	
	private ImageIcon pic,blu,red;
	private JLabel score_v=new JLabel();
	private JButton[] point=new JButton[10];
	private int score=0;
	public Reaction (){
		frame.setSize(500,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);					
		frame.setLayout(null);
		frame.setLocation(700, 300);
		frame.getContentPane().setBackground(Color.white);
		
		
		
		Image img=null;
		try {
			img = ImageIO.read (new File("D:\\course/java/project/src/project/img/pic.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pic=new ImageIcon(img);
		try {
			img = ImageIO.read (new File("D:\\course/java/project/src/project/img/red.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		red=new ImageIcon(img);
		try {
			img = ImageIO.read (new File("D:\\course/java/project/src/project/img/blue.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		blu=new ImageIcon(img);
		score_v.setSize(150,50);
		score_v.setLocation(0,0);
		score_v.setText("Score:"+score);
		frame.add(score_v);
		for(int i=0;i<10;i++){
		if(i<3){point[i]=new JButton(red);}
		else if(i<6){point[i]=new JButton(blu);}
		else {point[i]=new JButton(pic);}
			
		point[i].setSize(50,50);
		point[i].setLocation((int)(Math.random()*1000)%400,(int)(Math.random()*1000)%400);
		point[i].addActionListener(this);
		point[i].setActionCommand(""+i);
		frame.add(point[i]);
		point[i].setVisible(false);
		}		
	}
	
	public void run(){
		running=true;				
		frame.setVisible(true);
		int c;
		int t1=0,t2=0,t3=0;
		for(int i=0;i <300;i++){
			c=(int) (Math.random()*100);
			switch(i%20){
			case 1:
				t1=c%3;
				point[c%3].setVisible(true);				
				break;
			case 7:
				t2=c%3+3;
				point[c%3+3].setVisible(true);	
				break;
			case 15:
				t3=c%4+6;
				point[c%4+6].setVisible(true);	
				break;
			default:
				break;
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(i%20==5)point[t1].setVisible(false);
			if(i%20==14)point[t3].setVisible(false);
			if(i%20==17)point[t2].setVisible(false);
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	public void actionPerformed(ActionEvent e){
		int state=Integer.valueOf(e.getActionCommand());
		point[state].setVisible(false);
		if(state<3)score+=10;
		else if(state<6)score+=5;
		else score++;
		score_v.setText("Score:"+score);
		
	}
	
	
	
	
	
	
	
	public String result(){
		String res="";
		System.out.println("Scole="+score);
		if(score>120){
			res="Clear";
		}
		else res="Failed";
		
		return res;
	}
	

}
