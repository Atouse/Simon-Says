package SimonSays;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
import javax.swing.JComponent;

public class ColourSquare extends JComponent implements MouseListener {
	private Color colour;
	private Color glowColour;
	Color mainColour;
	int id;
	SequenceGenerator in;
	public ColourSquare(Color colour, int id, SequenceGenerator in, View view) {
		super();
		this.in=in;
		this.id = id;
		view.add(this,BorderLayout.CENTER);
		this.setPreferredSize(new Dimension(100,100));
		this.addMouseListener(this);
		this.colour=colour;
		this.mainColour=colour;
		this.glowColour=new Color((int) ((255-colour.getRed())*0.5)+colour.getRed(),(int) ((255-colour.getGreen())*0.5)+colour.getGreen(),(int) ((255-colour.getBlue())*0.5)+colour.getBlue());
	}
	

	@Override
	public void mouseClicked(MouseEvent m) {
		// TODO Auto-generated method stub	
	}
	

	@Override
	public void mousePressed(MouseEvent a) {
		// TODO Auto-generated method stub
		glow();
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		unglow();
		
		//id which square was clicked and append that to global sequence var in view
		for(int i = 0; i < this.in.sequenceInput.length; ++i) {
			if(this.in.sequenceInput[i] == 5) {
				this.in.sequenceInput[i] = this.id;
				break;
			}
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {

		// TODO Auto-generated method stub
		
	}
	

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(colour);
		g.fillRect(1, 1, 100, 100);
	}
	public void glow() {
		colour=glowColour;
		repaint();

	}
	
	public void unglow() {
		colour=mainColour;
		repaint();
	}
}
