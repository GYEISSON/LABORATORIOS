package presentacion;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.io.*;

class Ficha extends JPanel {
	private Color color;
	private boolean visible;
	private int value;
	public Ficha(Color color,boolean visible,int value) {
		super();
		this.visible=visible;
		this.color=color;
		this.value=value;
	} 
	
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int x = this.getWidth() / 2;
		int y = this.getHeight() / 2;
		System.out.println(x);
		System.out.println(y);
		g.setColor(color);
		if(visible && (value==1)) {
			g.fillOval(x, y, 60, 60);
			this.setBackground(Color.DARK_GRAY);
		}
		else if (!visible && (value==2)){
			this.setBackground(Color.DARK_GRAY);
		}
		else {
			this.setBackground(Color.BLACK);
		}
	}
}
