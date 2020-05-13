package SimonSays;

import javax.swing.*;
import java.awt.*;
import java.awt.*;
public class View extends JPanel{
	private JLabel title;
	private ColourSquare[] boxes=new ColourSquare[4];
	JPanel a,b;
	public View() {
		super();
		this.setBackground(Color.BLACK);
		init();
	}
	private void init() {
		a=new JPanel(new GridLayout(2,1));
		b=new JPanel(new GridLayout(2,2));
		
		title=new JLabel("Simon Says");
		title.setForeground(Color.WHITE);
	    title.setFont(new Font("Jokerman",Font.ITALIC,40));
	    
		boxes[0]=new ColourSquare(Color.RED);
		boxes[1]=new ColourSquare(Color.YELLOW);
		boxes[2]=new ColourSquare(Color.BLUE);
		boxes[3]=new ColourSquare(Color.GREEN);
		
		a.setBackground(Color.BLACK);
		a.add(title);
		
		b.setBackground(Color.BLACK);
		b.add(boxes[0]);
		b.add(boxes[1]);
		b.add(boxes[2]);
		b.add(boxes[3]);
		
		a.add(b);
		
		this.add(a);
	}
	
	private void endScreen() {
		title.setText("Game Over");
		a.remove(b);
		
	}
	

}
