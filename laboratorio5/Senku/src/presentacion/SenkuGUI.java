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
	private JMenu nuevo;
	private JMenuItem abrir;
	private JMenuItem guardar;
	private JMenuItem salir;
	private JMenuItem escogerColor;
	private JTextField height,width;
	private JPanel b;
	private Senku senku;
	private ArrayList<Integer> elements;
	private Color colorC;
	private Stack<Integer> pilaX,pilaY;
	private boolean state;
	private int defectH=7,defectW=3;
	private JButton b7;

	public SenkuGUI(){
		super("Senku"); 
		pilaX =  new Stack<Integer>();
		pilaY =  new Stack<Integer>();
		state = false;
		colorC=Color.BLUE;
		prepareElementos();
		prepareElementosMenu();
		prepareElementosTablero();
		prepareAcciones();
	}
	
	private void prepareElementosMenu(){
		menuBar = new JMenuBar();
		menu = new JMenu("Menu");
		nuevo = new JMenu("Nuevo");
		abrir = new JMenuItem("Abrir");
		guardar = new JMenuItem("Guardar");
		salir = new JMenuItem("Salir");
		height = new JTextField(); 
		width = new JTextField();
		menu.add(nuevo);
		menu.add(abrir);
		menu.add(guardar);
		menu.add(salir);
		menuBar.add(menu);
		menu2 = new JMenu("Visual");
<<<<<<< HEAD

		
=======
>>>>>>> 4a16e1679f3285bc7f3c3e117fc0f0ab1e3f2e49
		escogerColor = new JMenuItem("Escoja un Color");
		menu2.add(escogerColor);
		menuBar.add(menu2);
		setJMenuBar(menuBar);
		b7  = new JButton("Aceptar");
		height.setBounds(120,18,90,30);
		nuevo.add(height);
		nuevo.add(width);
		nuevo.add(b7);
		
	}
	
	private void prepareElementos() {
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(screenSize.width/2, screenSize.height/2);
		setLocationRelativeTo(null);
<<<<<<< HEAD

=======
		
>>>>>>> 4a16e1679f3285bc7f3c3e117fc0f0ab1e3f2e49
	}
	
	private void prepareAcciones(){
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE );
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) { 
				salga();
			}
		});
		b7.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				nuevo();
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

		b.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e){
				int x = e.getX();
				int y = e.getY();
				printPos(x,y);
				JPanel canica = (JPanel) b.getComponentAt(x);
				//System.out.println(canica.getNum());
			}
			public void mouseExited(MouseEvent e){
				int x = e.getX();
				int y = e.getY();
				//printPos(x,y);	
			}

			public void mouseReleased(MouseEvent e){
				int x = e.getX();
				int y = e.getY();
				//printPos(x,y);
			}
			public void mousePressed(MouseEvent e){
				int x = e.getX();
				int y = e.getY();
				//printPos(x,y);	
			}
			public void mouseEntered(MouseEvent e){
				int x = e.getX();
				int y = e.getY();
				Ficha canica = (Ficha) getComponentAt(x,y);
				
				//printPos(x,y);	
			}
		});		
	}	
 
	private void prepareElementosTablero() {
<<<<<<< HEAD
		senku = new Senku();
		b = new JPanel();
=======
		senku = new Senku(defectH,defectW);
>>>>>>> 4a16e1679f3285bc7f3c3e117fc0f0ab1e3f2e49
		grid();
		revalidate();
	}
	
	private void nuevo(){
		int solicitadoH = Integer.parseInt(height.getText());
		int solicitadoW = Integer.parseInt(width.getText());
		if(solicitadoH>1 && solicitadoW>1 && solicitadoH> solicitadoW ){
			defectH = solicitadoH;
			defectW = solicitadoW;
			this.remove(b);
			prepareElementos();
			prepareElementosMenu();
			prepareAcciones();
			prepareElementosTablero();
			refresque();
			repaint();

		}
		else{
			JOptionPane.showMessageDialog(null,"cambie el numero de canicas");
		}
	}

	private void printPos(int x, int y){
		System.out.println(x+" "+y);
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
		//prepareElementosTablero();
		grid();
		this.revalidate();
		repaint();
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
			refresque();
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
<<<<<<< HEAD
		
		elements = senku.getElements();
		b.setLayout(new GridLayout(7,7,10,10));
		for(Integer value: elements){
			switch(value){
				case 0:{ visible =false;}
				case 1:{ visible = false;}
				case 2:{visible = true;}
				Ficha canica= new Ficha(colorC,visible,value); 
	        	b.add(canica);
=======
		b = new JPanel();
		b.setLayout(new GridLayout(defectH,defectH,10,10));
		for (int row=0; row < senku.getRows(); row++)
			{
			    for (int col=0; col < senku.getCols(); col++)
			    {
			        int value = senku.getPos(row,col);
			        if(value==1) {
			        	visible=false;
			        	Ficha canica= new Ficha(colorC,visible,value,row,col,this); 
			        	//canica.setBackground(Color.YELLOW);
			        	b.add(canica);
			        }
			        else if (value==2)
			        {
			        	visible=true;
			        	Ficha canica= new Ficha(colorC,visible,value,row,col,this); 
			        	b.add(canica);
			        }
			        else if(value==0)
			        {
			        	visible=false;
			        	Ficha canica= new Ficha( colorC,visible,value,row,col,this); 
				        b.add(canica,BorderLayout.CENTER);
			        }
				}
>>>>>>> 4a16e1679f3285bc7f3c3e117fc0f0ab1e3f2e49
			}
			
		this.add(b,BorderLayout.CENTER);
	}
	
	
	public static void main(String[] args) {

		SenkuGUI se= new SenkuGUI();
		se.setVisible(true);
	}	
}
