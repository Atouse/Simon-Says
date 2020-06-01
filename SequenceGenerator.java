package SimonSays;

import java.awt.Color;
import java.util.Random;
import java.awt.*;
import javax.swing.*;

public class SequenceGenerator {

	private Screen b;
	private int delay;
	private Random rand = new Random();
	private int[] sequence=new int[] {rand.nextInt(4)};
	
	public SequenceGenerator(Screen view) {
		b=view;
		if(view.hard)
			this.delay = 1000;
		else
			this.delay = 500;
		
	}
	
	public int[] generateSequence(int length) {
		int temp;
		int[] sequence = new int[length];
		

		b.pause();
		for(int i = 0; i < length; ++i) {
			temp = this.rand.nextInt(4);
			sequence[i] = temp;
			b.changeTitle(b.squares[temp].name);
			b.squares[temp].glow();
			Utils.play("Flash");
			Utils.delay(this.delay);
			b.squares[temp].unglow();
			Utils.delay(this.delay);
		}
		
		b.resume();
		
		b.changeTitle("Simon Says");
		return sequence;
	}
	
	public void changeDelay(int time) {
		delay=time;
	}
	
	public int[] easySequence() {
		int temp;
		sequence=Utils.increased(sequence);
		
		sequence[sequence.length-1]=rand.nextInt(4);

		b.pause();
		for(int i=0;i<sequence.length;i++) {
			temp=sequence[i];
			b.changeTitle(b.squares[temp].name);
			b.squares[temp].glow();
			Utils.play("Flash");
			Utils.delay(this.delay);
			b.squares[temp].unglow();
			Utils.delay(this.delay);
		}
		
		b.resume();
		
		b.changeTitle("Simon Says");
		
		return sequence;
		
	}
	
	
	
	
}
