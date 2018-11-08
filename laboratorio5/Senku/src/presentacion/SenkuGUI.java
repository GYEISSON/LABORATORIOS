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
	private Stack<Integer> pilaX,pilaY;
	private boolean state;
	

	public SenkuGUI(){
		super("Senku"); 
		pilaX =  new Stack<Integer>();
		pilaY =  new Stack<Integer>();
		state = false;
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
	private void actualizar(){
		this.remove(b);
		grid();
		repaint();
		revalidate();
	}
	public void mover(int x, int y){
		System.out.println("vamo a movernos");
		if(state){
			int[] s = {pilaX.pop(),pilaY.pop()};
			int[] t = {x,y};
			senku.moveTo(s,t);
			state = false;
			System.out.println(s[0]+" "+s[1]+" "+t[0]+" "+t[1]+" ya movimos");
			senku.printM();
			actualizar();
		}
		else{
			pilaX.push(x);
			pilaY.push(y);
			state = true;
		}
	}
	public void grid() 
	{
		boolean visible=false;
		b = new JPanel();
		
		b.setLayout(new GridLayout(7,7,10,10));
		for (int row=0; row < senku.getRows(); row++)
			{
			    for (int col=0; col < senku.getCols(); col++)
			    {
			        int value = senku.getPos(row,col);
			        if(value==1) {
			        	visible=false;
			        	Ficha canica= new Ficha(Color.BLUE,visible,value,row,col,this); 
			        	//canica.setBackground(Color.YELLOW);
			        	b.add(canica);
			        }
			        else if (value==2)
			        {
			        	visible=true;
			        	Ficha canica= new Ficha(Color.BLUE,visible,value,row,col,this); 
			        	b.add(canica);
			        }
			        else if(value==0)
			        {
			        	visible=false;
			        	Ficha canica= new Ficha(Color.BLUE,visible,value,row,col,this); 
				        b.add(canica,BorderLayout.CENTER);
			        }
				}
			}
			
		this.add(b,BorderLayout.CENTER);
	}
	
	
	public static void main(String[] args) {
		SenkuGUI se= new SenkuGUI();
		se.setVisible(true);
	}	
}
