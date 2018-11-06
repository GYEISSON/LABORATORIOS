package presentacion;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.io.*;

public class SenkuGUI extends JFrame{
	
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem nuevo;
	private JMenuItem abrir;
	private JMenuItem guardar;
	private JMenuItem salir;
	private JPanel b;
	private int[][] m = {{0,1,0},{1,2,1},{0,1,0}};

	public SenkuGUI(){
		super("Senku"); 
		prepareElementos();
		prepareElementosMenu();
		prepareAcciones();
		prepareElementosGrid();
		
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
		
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salga();
			}
		});
		
		guardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
	}	

	private void prepareElementosGrid() {
		grid();
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
//		    System.out.println("Save as file: " + fileToSave.getAbsolutePath());
		    JOptionPane.showMessageDialog(this, "La funcionalidad guardar esta en construccion");
		}
	}
	
	private void refresque() {
		this.revalidate();
	}
	
	public void grid() {
		
		boolean visible=false;
		b = new JPanel();
		b.setLayout(new GridLayout(3,3,10,10));

			for (int row=0; row < m.length; row++)
			{
			    for (int col=0; col < m[row].length; col++)
			    {
			        int value = m[row][col];
			        if(value==1) {
			        	visible=true;
			        	Ficha canica= new Ficha(Color.BLUE,visible,value); 
			        	//canica.setBackground(Color.YELLOW);
			        	b.add(canica);
			        }
			        else if (value==2)
			        {
			        	visible=false;
			        	Ficha canica= new Ficha(Color.BLUE,visible,value); 
			        	b.add(canica);
			        }
			        else if(value==0)
			        {
			        	visible=false;
			        	Ficha canica= new Ficha(Color.BLUE,visible,value); 
				        b.add(canica,BorderLayout.CENTER);
			        }
		this.add(b,BorderLayout.CENTER);
			    }
			}
			
	}        
	
	public static void main(String[] args) {
		SenkuGUI se= new SenkuGUI();
		se.setVisible(true);
	}
	
	}
