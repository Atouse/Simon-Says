package SimonSays;

import java.awt.Color;
import java.util.Random;
import java.awt.*;
import javax.swing.*;

public class SequenceGenerator {
	View g=new View();
	ColourSquare[] squares=new ColourSquare[4];
	private final int LENGTH = 4;
	private int level;
	private Random rand = new Random();
	int[] sequenceInput = {5,5,5,5};
	
	public SequenceGenerator(int level,View view) {
		this.level = level;
		g.setLayout(new GridLayout(2,2));
		squares[0]=new ColourSquare(Color.RED,0,this,g);
		squares[1]=new ColourSquare(Color.YELLOW,1,this,g);
		squares[2]=new ColourSquare(Color.BLUE,2,this,g);
		squares[3]=new ColourSquare(Color.GREEN,3,this,g);
		view.init();
		view.a.add(g);
		
	}
	
	public int[] generateSequence() {
		int temp;
		int[] sequence = new int[this.LENGTH];
		for(int i = 0; i < this.LENGTH; ++i) {
			temp = this.rand.nextInt(this.LENGTH);
			sequence[i] = temp;
			this.squares[temp].glow();
			delay(500);
			this.squares[temp].unglow();
			delay(500);
		}
		return sequence;
	}
	
	public void delay(int ms) {
		try {
			Thread.sleep(ms);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
