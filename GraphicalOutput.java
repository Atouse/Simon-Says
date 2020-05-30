package SimonSays;

import javax.swing.JFrame;
import java.awt.*;

public class GraphicalOutput {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		View view = new View();
		SequenceGenerator gen = new SequenceGenerator(view); //enter level here for testing

		
		frame.setPreferredSize(new Dimension(600,600));
		frame.setContentPane(view);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
		
		//somewhere here
		SequenceListener in = new SequenceListener(gen,view);
		in.start();
	}

}