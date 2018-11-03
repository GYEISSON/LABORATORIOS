package presentacion;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class SenkuGUI extends JFrame{
	
	private JMenu menu;  
	private JMenuItem nuevo,guardar,guardarc,salir;
	private JMenuBar MB;
	
	public SenkuGUI() {
		super("Senku");
		 prepareElementos();
		 prepareAcciones();
		 prepareElementosMenu();
	}
	
	public void prepareElementosMenu() {
		MB = new JMenuBar();
 		menu=new JMenu("Menu");  
		nuevo=new JMenuItem("Nuevo");
		guardar=new JMenuItem("Guardar");
		guardarc=new JMenuItem("Guardar como");
		salir=new JMenuItem("Salir");
		 menu.add(nuevo);
		 menu.add(guardar); 
		 menu.add(guardarc); 
		 menu.add(salir);
		 MB.add(menu);
		 setJMenuBar(MB); 
	}
	
	public void prepareElementos() {

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize.width/2, screenSize.height/2);
		
		setLocationRelativeTo(null);
	}
	
	public void prepareAcciones() {
		addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent evt){
            	salga();}});
		salir.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent ae) {
		       salga();}
		});
	}
	
	 public void salga(){
	       int c = JOptionPane.showConfirmDialog(null,"Desea salir?","EXIT",JOptionPane.YES_NO_OPTION);
	       if (JOptionPane.YES_OPTION == c) {
	    	   System.exit(0);
	       }
	       else setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	 }
		
	public static void main(String[] args) {
		SenkuGUI se = new SenkuGUI();
		se.setVisible(true);
	}
}
