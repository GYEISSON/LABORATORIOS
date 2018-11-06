package presentacion;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.io.*;

class Ficha extends JPanel {
	private Color color;
	public Ficha(Color color) {
		super();
		this.color=color;
	} 
	
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int x = this.getWidth() / 2;
		int y = this.getHeight() / 2;
		System.out.println(x);
		System.out.println(y);
		g.setColor(color);
		g.fillOval(x, y, 60, 60);
		}
}
