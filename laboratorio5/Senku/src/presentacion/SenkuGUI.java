package presentacion;



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class SenkuGUI extends JFrame{
	
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem nuevo;
	private JMenuItem abrir;
	private JMenuItem guardar;
	private JMenuItem salir;


	public SenkuGUI(){
		super("Senku"); 
		prepareElementos();
		prepareElementosMenu();
		prepareAcciones();
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

}
