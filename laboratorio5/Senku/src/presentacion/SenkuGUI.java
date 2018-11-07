package presentacion;
import aplicacion.Senku;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.io.*;
import java.util.*;
public class SenkuGUI extends JFrame{
	
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenu menu2;
	private JMenuItem nuevo;
	private JMenuItem abrir;
	private JMenuItem guardar;
	private JMenuItem salir;
	private JMenuItem escogerColor;
	private JPanel b;
	private Senku senku;
	private ArrayList<Integer> elements;
	private Color colorC;

	//private int[][] m = {{0,0,1,1,1,0,0},{0,0,1,1,1,0,0},{1,1,1,1,1,1,1},{1,1,1,2,1,1,1},{1,1,1,1,1,1,1},{0,0,1,1,1,0,0},{0,0,1,1,1,0,0}};

	public SenkuGUI(){
		super("Senku"); 
		colorC=Color.BLUE;
		prepareElementos();
		prepareElementosMenu();
		prepareAcciones();
		prepareElementosTablero();
		
	}
	
	private void prepareElementosMenu(){
		menuBar = new JMenuBar();
		menu = new JMenu("Menu");
		nuevo = new JMenuItem("Nuevo");
		abrir = new JMenuItem("Abrir");
		guardar = new JMenuItem("Guardar");
		salir = new JMenuItem("Salir");
		menu.add(nuevo);
		menu.add(abrir);
		menu.add(guardar);
		menu.add(salir);
	
		menuBar.add(menu);
		
		menu2 = new JMenu("Visual");
		
		escogerColor = new JMenuItem("Escoja un Color");
		menu2.add(escogerColor);
		
		menuBar.add(menu2);
		
		setJMenuBar(menuBar);
		
		
	}
	
	private void prepareElementos() {
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize.width/2, screenSize.height/2);
		setLocationRelativeTo(null);
	}
	
	private void prepareAcciones(){
		
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE );
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) { 
				salga();
			}
		});
		
		abrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrir();
			}
			
		});
				
		guardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
	
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salga();
			}
		}); 
 
		escogerColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chooseColor();
			}
		});
				
	}	
 
	private void prepareElementosTablero() {
		senku = new Senku();
		grid();
	}
	
	private void chooseColor() {
		colorC = JColorChooser.showDialog(null, "Choose a color",Color.BLUE);
		refresque();
	}
		
	private void salga(){
	       int c = JOptionPane.showConfirmDialog(null,"Desea salir?","EXIT",JOptionPane.YES_NO_OPTION);
	       if (JOptionPane.YES_OPTION == c) {
	    	   System.exit(1);
	       }
	}
	
	private void abrir() {
		JFileChooser file = new JFileChooser();
		int result = file.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
		    File selectedFile = file.getSelectedFile();
		    //System.out.println("Selected file: " + selectedFile.getAbsolutePath());
		    JOptionPane.showMessageDialog(this, "La funcionalidad abrir esta en construccion");
		}	
	}
	
	private void guardar() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Specify a file to save");   
		int userSelection = fileChooser.showSaveDialog(guardar);
		if (userSelection == JFileChooser.APPROVE_OPTION) {
		    File fileToSave = fileChooser.getSelectedFile();
		    JOptionPane.showMessageDialog(this, "La funcionalidad guardar esta en construccion");
		}
	}
	
	private void refresque() {
		b.removeAll();
		this.remove(b);
		prepareElementosTablero();
		this.revalidate();
	}
	
	public void grid() {
		boolean visible=false;
		b = new JPanel();
		elements = senku.getElements();
		b.setLayout(new GridLayout(7,7,10,10));
		for(Integer value: elements){
			switch(value){
				case 0:{ visible =false;}
				case 1:{ visible = false;}
				case 2:{visible = true;}
				Ficha canica= new Ficha(colorC,visible,value); 
	        	b.add(canica);
			}
			this.add(b,BorderLayout.CENTER);
		}    
	}        
	
	public static void main(String[] args) {
		SenkuGUI se= new SenkuGUI();
		se.setVisible(true);
	}	
}
