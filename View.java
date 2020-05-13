package SimonSays;

import javax.swing.*;

import java.awt.*;
import java.awt.*;


public class View extends JPanel{
	private JLabel title;
	JPanel a,b;
	private SequenceListener in;
	public View() {
		super();
		this.setBackground(Color.BLACK);
	}
	
	

	public void init() {	
		a=new JPanel(new GridLayout(2,1));
		title=new JLabel("Simon Says");
		title.setForeground(Color.WHITE);
	    title.setFont(new Font("Jokerman",Font.ITALIC,40));
	    
		
		a.add(title);
		a.setBackground(Color.BLACK);
		this.add(a);
				
	}
	
	public void endScreen() {
		title.setText("Incorrect Sequence ");
		repaint();
		
	}
	public void correctScreen() {
		title.setText("That is correct good jub slut");
		repaint();
	}
	

}