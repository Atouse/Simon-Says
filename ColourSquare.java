package SimonSays;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import javax.sound.sampled.AudioInputStream;
import javax.swing.*;
import javax.swing.JComponent;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class ColourSquare extends JComponent implements MouseListener {
	private Color colour;
	private Color glowColour;
	String name;
	Color mainColour;
	int id;
	private Screen view;
	Clip c;
	final static int YELLOW=1;
	final static int RED=0;
	final static int GREEN=3;
	final static int BLUE=2;
	public ColourSquare(Color colour, JPanel j, Screen view) {
		super();
		j.add(this);
		this.view=view;


		
		this.setPreferredSize(new Dimension(100,100));
		this.addMouseListener(this);
		this.colour=colour;
		this.mainColour=colour;
		if(mainColour==Color.YELLOW) {
			id=YELLOW;
		}
		else if(mainColour==Color.RED) {
			id=RED;
		}
		else if(mainColour==Color.GREEN) {
			id=GREEN;
		}
		else {//mainColour is blue
			id=BLUE;
		}
		name=getColour();
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
		
		Utils.play("Mouse");

		//id which square was clicked and append that to global sequence var in view
		for(int i = 0; i < this.view.sequenceInput.length; ++i) {
			if(this.view.sequenceInput[i] == 5) {
				this.view.sequenceInput[i] = id;
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
	
	public String getColour() {
		if(mainColour==Color.YELLOW) {
			return "Yellow";
		}
		else if(mainColour==Color.RED) {
			return "Red";
		}
		else if(mainColour==Color.GREEN) {
			return "Green";
		}
		else {
			return "Blue";
		}
	}
	
	public int getID() {
		return id;
	}
}
