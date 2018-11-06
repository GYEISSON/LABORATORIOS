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
	private FondoSenku  foto;


	public SenkuGUI(){
		super("Senku"); 
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
		getContentPane().setLayout(new BorderLayout());
        getContentPane().add(foto,BorderLayout.NORTH);
		foto.repaint();
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