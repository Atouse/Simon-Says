package SimonSays;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;


public class Screen extends JPanel{
	private JLabel title;
	public JPanel a,g,b,c;
	ColourSquare[] squares=new ColourSquare[4];
	int[] sequenceInput=Utils.RESET_4;
	int[] reset=Utils.RESET_4;
	boolean hard=false;	
	
	public Screen() {
		super();
		this.setBackground(Color.BLACK);
		int n = JOptionPane.showConfirmDialog(null,"Hard Mode","Simon Says",JOptionPane.YES_NO_OPTION);

		if (n==JOptionPane.YES_OPTION) 
			hard=true;
		
		game();
	}
	
	
	public void game() {
		a=new JPanel(new GridLayout(2,1));
		g=new JPanel(new GridLayout(2,2));
		g.setBackground(Color.BLACK);
		
		title=new JLabel("Simon Says");
		title.setForeground(Color.WHITE);
	    title.setFont(new Font("Jokerman",Font.ITALIC,40));	
	    
		squares[0]=new ColourSquare(Color.RED,g,this);
		squares[1]=new ColourSquare(Color.YELLOW,g,this);
		squares[2]=new ColourSquare(Color.BLUE,g,this);
		squares[3]=new ColourSquare(Color.GREEN,g,this);
	    
		
		a.add(title);
		a.add(g);
		a.setBackground(Color.BLACK);
		
		this.add(a);
	}
	
	public void startScreen() {
		title.setText("Simon Says");
		repaint();
	}
	
	public void pause() {
		for(int i=0;i<4;i++) {
			squares[i].removeMouseListener(squares[i]);
		}
	}
	public void resume() {
		for(int i=0;i<4;i++) {
			squares[i].addMouseListener(squares[i]);
		}
	}

	public void changeTitle(String text) {
		title.setText(text);
	}
	

}//ssalc