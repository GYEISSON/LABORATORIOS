package presentacion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

@SuppressWarnings("serial")
public class SenkuGUI extends JFrame{
	
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem nuevo;
	private JMenuItem abrir;
	private JMenuItem guardar;
	private JMenuItem salir;
	private FondoSenku  foto;

	private tablero t;
	public SenkuGUI(){
		super("Senku"); 
		t = new tablero();
		prepareElementos();
		prepareElementosMenu();
		prepareAcciones();
		foto = new FondoSenku();
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
<<<<<<< HEAD
		getContentPane().setLayout(new BorderLayout());
        getContentPane().add(foto,BorderLayout.NORTH);
		foto.repaint();
=======
		
		getContentPane().setLayout(new BorderLayout());
        getContentPane().add(t,BorderLayout.CENTER);
        t.repaint();
>>>>>>> 78a9ebab50d815a2256db3397e2e1b114cc41b67
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
		    System.out.println("Selected file: " + selectedFile.getAbsolutePath());
		}
		
	}
	
	private void guardar() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Specify a file to save");   
		 
		int userSelection = fileChooser.showSaveDialog(guardar);
		 
		if (userSelection == JFileChooser.APPROVE_OPTION) {
		    File fileToSave = fileChooser.getSelectedFile();
		    System.out.println("Save as file: " + fileToSave.getAbsolutePath());
		}
	}
	
	public static void main(String[] args) {
		SenkuGUI se= new SenkuGUI();
		se.setVisible(true);
	}
	
	
	
class tablero extends JPanel{
	
	    public int TAMANO=40;

	    public tablero() {
	        setBackground(Color.white);
	        setPreferredSize(new Dimension(200,200));       

	    }


	    public void paintComponent(Graphics g){
	    	
	    	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			int x=(screenSize.width/2)/2;
			int y=(screenSize.height/2)/2;
			y=y-y/2;
			x=x-x/3;

	    	int largo,ancho;
	    	largo=7;
	    	ancho=3;
	        super.paintComponent(g);
	        //eje horizontal
	        for (int f=0;f<=largo;f++){
	            g.drawLine(f*TAMANO+x,80+y,f*TAMANO+x,ancho*TAMANO+80+y);
	        }
	        //eje vertical
	        for (int cc=0;cc<=ancho;cc++){
	            g.drawLine(0+x,cc*TAMANO+80+y,largo*TAMANO+0+x,cc*TAMANO+80+y);
	        }
	        
	        
	      //eje horizontal
	        for (int f=0;f<=ancho;f++){
	            g.drawLine(f*TAMANO+80+x,0+y,f*TAMANO+80+x,largo*TAMANO+y);
	        }
	        //eje vertical
	        for (int cb=0;cb<=largo;cb++){
	            g.drawLine(80+x,cb*TAMANO+y,ancho*TAMANO+80+x,cb*TAMANO+y);
	        }
	    }
	}
	        
}
class FondoSenku extends JPanel{
    public static int TAMANO=40;
  
    public FondoSenku() {
        setBackground(Color.white);
        setPreferredSize(new Dimension(800,800));       
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for (int f=0;f<=3;f++){
            g.drawLine(f*TAMANO,0,f*TAMANO,TAMANO*3);
        }/*
        for (int c=0;c<=3;c++){
            g.drawLine(0,c*TAMANO,automata.getLongitud()*TAMANO,c*TAMANO);
        }*/
    }
    
}