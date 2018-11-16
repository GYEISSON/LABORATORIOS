package presentacion;
import aplicacion.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

import javax.swing.*;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.io.*;
import java.util.*;

public class AutomataGUI extends JFrame{    

    private JButton botonReloj;
    
    private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem abrir;
	private JMenuItem iniciar;
	private JMenuItem guardarb;
	private JMenuItem salir;
	private JMenuItem importe;
	private JMenuItem exporte;
	private JMenuItem reinicio;
	private JPanel b;
    private FotoAutomata foto;
    private static AutomataCelular automata;
    private static AutomataGUI ca;

    public AutomataGUI(AutomataCelular ac) {
        super("Automata celular");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        automata=ac;
        foto=new FotoAutomata(automata);
        JPanel b= (JPanel) foto;
        setSize(new Dimension(700,770)); 
        prepareElementos();
        prepareAcciones();
        prepareElementosMenu();
        prepareAccionesMenu();

    }
    private void prepareElementosMenu() {
    	menuBar = new JMenuBar();
		menu = new JMenu("Menu");
		iniciar = new JMenuItem("Iniciar");
		abrir = new JMenuItem("Abrir");
		guardarb = new JMenuItem("Guardar");
		salir = new JMenuItem("Salir");
		reinicio = new JMenuItem("Reinicio :)");
		importe = new JMenuItem("Importar");
		exporte = new JMenuItem("Exportar");
    	
    	menu.add(iniciar);
		menu.add(abrir);
		menu.add(guardarb);
		menu.add(salir);
		menu.add(reinicio);
		menu.add(importe);
		menu.add(exporte);
		menuBar.add(menu);
		setJMenuBar(menuBar);
		
    }

    
    private void prepareElementos() {
    	setResizable(false);

        botonReloj=new JButton("Tic-tac");

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(foto,BorderLayout.NORTH);
        getContentPane().add(botonReloj,BorderLayout.SOUTH);

        foto.repaint();
    }

    private void prepareAcciones(){
        botonReloj.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    botonRelojAccion();
                }
            });
    }
    
    private void prepareAccionesMenu() {
    setDefaultCloseOperation(AutomataGUI.DISPOSE_ON_CLOSE);
//    	setDefaultCloseOperation(DO_NOTHING_ON_CLOSE );
//		addWindowListener(new WindowAdapter() {
//			public void windowClosing(WindowEvent e) { 
//				opcionSalir();
//			}
//		});
		iniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				opcionIniciar();
			}
		});
		abrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrir();
			}
		});
				
		guardarb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
	
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				opcionSalir();
			}
		}); 
		reinicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//			automata=new AutomataCelular();
//	        new AutomataGUI(automata);
//	        ca.setVisible(true);
			dispose();
			new AutomataGUI(automata);
			}
		});
    }
    
    private void botonRelojAccion() {
        automata.ticTac();
        foto.repaint();
    }
    
    private void reiniciar(){
    	automata.opcionIniciar();
    	this.remove(foto);
    	foto = new FotoAutomata(this);
    	this.add(foto)
//		foto=null;
//		ca = new AutomataGUI(automata);
//		this.remove(b);
//		this.remove(reinicio); 
//		prepareElementos();
//        prepareAcciones();
//        prepareElementosMenu();
//        prepareAccionesMenu();
//	ca.revalidate();
//	ca.repaint();
	}
    private void opcionSalir(){
//	       int c = JOptionPane.showConfirmDialog(null,"Desea salir?","EXIT",JOptionPane.YES_NO_OPTION);
//	       if (JOptionPane.YES_OPTION == c) {
	   	   System.exit(1);
//	       }
	}

	private void abrir() {
		JFileChooser file = new JFileChooser();
		int result = file.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
		    File selectedFile = file.getSelectedFile();

		    JOptionPane.showMessageDialog(this, "La funcionalidad abrir esta en construccion");
		}	
	}
	
	private void guardar() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Specify a file to save");   
		int userSelection = fileChooser.showSaveDialog(guardarb);
		if (userSelection == JFileChooser.APPROVE_OPTION) {
		    File fileToSave = fileChooser.getSelectedFile();
		    JOptionPane.showMessageDialog(this, "La funcionalidad guardar esta en construccion");
		}
	}
	 public static void main(String[] args) {
	        automata=new AutomataCelular();
	        ca=new AutomataGUI(automata);
	        ca.setVisible(true);

	    } 
}



class FotoAutomata extends JPanel{
    public static int TAMANO=40;
    private AutomataCelular automata;

    public FotoAutomata(AutomataCelular ac) {
        setBackground(Color.white);
        automata=ac;
        setPreferredSize(new Dimension(800,800));       

    }

    public void setAutomata(AutomataCelular automata){
        this.automata=automata;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for (int f=0;f<=automata.getLongitud();f++){
            g.drawLine(f*TAMANO,0,f*TAMANO,automata.getLongitud()*TAMANO);
        }
        for (int c=0;c<=automata.getLongitud();c++){
            g.drawLine(0,c*TAMANO,automata.getLongitud()*TAMANO,c*TAMANO);
        }       
        for (int f=0;f<automata.getLongitud();f++){
            for(int c=0;c<automata.getLongitud();c++){
                
                if (automata.getElemento(f,c)!=null){
                    g.setColor(automata.getElemento(f,c).getColor());
                    if (automata.getElemento(f,c) instanceof Barrera){                       
                       g.setColor(automata.getElemento(f,c).getColor());  
                       
                       g.fillRoundRect(TAMANO*c+3,TAMANO*f+3,16,16,5,5); 
                       g.fillRoundRect(TAMANO*c+3+18,TAMANO*f+3,16,16,5,5); 
                       g.fillRoundRect(TAMANO*c+3,TAMANO*f+3+18,16,16,5,5); 
                       g.fillRoundRect(TAMANO*c+3+18,TAMANO*f+3+18,16,16,5,5); 
                        
                       if (automata.getElemento(f,c).isVivo()){
                           g.fillRoundRect(TAMANO*c+6,TAMANO*f+3,35,35,5,5);
                        }
                    }
                    else if(automata.getElemento(f,c) instanceof Manzana){
                       g.setColor(automata.getElemento(f,c).getColor());  
                       g.setFont(new Font("Baskerville Old Face",Font.PLAIN,40));
                       g.drawString("",TAMANO*c+1,TAMANO*f+30);
                    }
                    
                    else {
                        if (automata.getElemento(f,c).isVivo()){
                            g.setColor(automata.getElemento(f,c).getColor());
                            g.fillOval(TAMANO*c+10,TAMANO*f+10,20,20);
                        } else {
                            g.setColor(automata.getElemento(f,c).getColor());
                            g.drawOval(TAMANO*c+10,TAMANO*f+10,20,20);
                        }
                    }
                }
            }
        }
    }
    

    
    
    
}