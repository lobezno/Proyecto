package adrsoft.scool.club;


import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JButton;

import adrsoft.scool.model.Galeria;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

/**
 * Clase encargada de instanciar una galer�a de im�genes. Cada club tiene sus propias
 * <br>im�genes, que se autocargar�n una vez el usuario se haya logeado y se conozca a qu� club pertenece.
 * @author adrSoft
 * @version vAlpha10
 *
 */
public class Fotos extends JInternalFrame {
 
    	private static final long serialVersionUID = 1L;
    	private JPanel panelFoto;
    	private JPanel pFoto1;
    	private JPanel pFoto2;
    	private JPanel pFoto3;
    	private JPanel pFoto4;
    	private JPanel panelGaleria;
    	private JButton btnAnterior;
    	private JButton btnSiguiente;
    	private JLabel lblFotoGrande;
    	private JLabel lblFoto1;
    	private JLabel lblFoto2;
    	private JLabel lblFoto4;
    	private JLabel lblFoto3;
    	private Galeria galeria;
    	private int a = 0;
    	private int b = 1;
    	private int c = 2;
    	private int d = 3;
    	private int club;

	/**
	 * Constructor de clase vacio.
	 * @author adrSoft
	 * @version vAlpha10
	 * @param mClub 
	 * @param tema 
	 */
	public Fotos(int mClub, String tema) {
		this.club = mClub;
		getContentPane().setBackground(UIManager.getColor("textHighlight"));
		setBounds(100, 100, 710, 300);
		((javax.swing.plaf.basic.BasicInternalFrameUI)getUI()).setNorthPane(null);
		init();
		createEvents();
		pintarTema(tema);
			
	}

	/**
	 * M�todo encargado de crear los eventos asignados a los botones y otros controles interactivos.
	 * @author adrSoft
	 * @version vAlpha10
	 */
	private void createEvents() {
	    
	    	//Pulsaci�n sobre thumbnail 1
		lblFoto1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				lblFotoGrande.setIcon(galeria.getFoto(a, lblFotoGrande.getSize()));
			}
		});
		
		//Pulsaci�n sobre thumbnail 2
		lblFoto2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				lblFotoGrande.setIcon(galeria.getFoto(b, lblFotoGrande.getSize()));
			}
		});
		
	    	//Pulsaci�n sobre thumbnail 3
		lblFoto3.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				lblFotoGrande.setIcon(galeria.getFoto(c, lblFotoGrande.getSize()));
			}
		});
		
	    	//Pulsaci�n sobre thumbnail 4
		lblFoto4.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				lblFotoGrande.setIcon(galeria.getFoto(d, lblFotoGrande.getSize()));
			}
		});
		
		//Bot�n Anterior
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			     a-=1;b-=1;c-=1;d-=1;
			        lblFoto1.setIcon(galeria.getPreview(a));
			        lblFoto2.setIcon(galeria.getPreview(b));
			        lblFoto3.setIcon(galeria.getPreview(c));
			        lblFoto4.setIcon(galeria.getPreview(d));
			}
		});
		
		//Bot�n Siguiente
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			     a+=1;b+=1;c+=1;d+=1;
			        lblFoto1.setIcon(galeria.getPreview(a));
			        lblFoto2.setIcon(galeria.getPreview(b));
			        lblFoto3.setIcon(galeria.getPreview(c));
			        lblFoto4.setIcon(galeria.getPreview(d));
			}
		});
		
	}

	/**
	 * Inicializador de los componentes en el JFrame.
	 * @author adrSoft
	 * @version vAlpha10
	 */
	private void init() {
		getContentPane().setLayout(new GridLayout(2,1, 20, 20));
		
		panelFoto = new JPanel();
		panelFoto.setBackground(UIManager.getColor("textHighlight"));
		getContentPane().add(panelFoto);
		panelFoto.setLayout(new GridLayout(1, 0, 0, 0));
		
		lblFotoGrande = new JLabel("");
		lblFotoGrande.setHorizontalAlignment(SwingConstants.CENTER);
		panelFoto.add(lblFotoGrande,BorderLayout.CENTER);
		
		panelGaleria = new JPanel();
		panelGaleria.setBackground(UIManager.getColor("textHighlight"));
		getContentPane().add(panelGaleria);
		panelGaleria.setLayout(new GridLayout(1, 6, 10, 10));
		
		btnAnterior = new JButton("");
		btnAnterior.setIcon(new ImageIcon(Fotos.class.getResource("/adrsoft/scool/resources/images/mid/back.png")));
		btnAnterior.setContentAreaFilled(false);
		btnAnterior.setBorderPainted(false);
		btnAnterior.setBorder(null);
	
		panelGaleria.add(btnAnterior);
		
		pFoto1 = new JPanel();
		pFoto1.setBackground(new Color(153, 204, 255));
		panelGaleria.add(pFoto1);
		pFoto1.setLayout(new GridLayout(1, 0, 0, 0));
		
		lblFoto1 = new JLabel("");
		lblFoto1.setHorizontalAlignment(SwingConstants.CENTER);
		lblFoto1.setBackground(new Color(153, 204, 255));
	
		pFoto1.add(lblFoto1);
		
		pFoto2 = new JPanel();
		pFoto2.setBackground(new Color(153, 204, 255));
		panelGaleria.add(pFoto2);
		pFoto2.setLayout(new GridLayout(1, 0, 0, 0));
		
		lblFoto2 = new JLabel("");
		lblFoto2.setHorizontalAlignment(SwingConstants.CENTER);
		lblFoto2.setBackground(new Color(153, 204, 255));
		pFoto2.add(lblFoto2);
		
		pFoto3 = new JPanel();
		pFoto3.setBackground(new Color(153, 204, 255));
		panelGaleria.add(pFoto3);
		pFoto3.setLayout(new GridLayout(1, 0, 0, 0));
		
		lblFoto3 = new JLabel("");
		lblFoto3.setHorizontalAlignment(SwingConstants.CENTER);
		lblFoto3.setBackground(new Color(153, 204, 255));
		pFoto3.add(lblFoto3);
		
		pFoto4 = new JPanel();
		pFoto4.setBackground(new Color(153, 204, 255));
		panelGaleria.add(pFoto4);
		pFoto4.setLayout(new GridLayout(1, 0, 0, 0));
		
		lblFoto4 = new JLabel("");
		lblFoto4.setHorizontalAlignment(SwingConstants.CENTER);
		lblFoto4.setBackground(new Color(153, 204, 255));
		pFoto4.add(lblFoto4);
		
		btnSiguiente = new JButton("");
		btnSiguiente.setIcon(new ImageIcon(Fotos.class.getResource("/adrsoft/scool/resources/images/mid/back2.png")));
		btnSiguiente.setContentAreaFilled(false);
		btnSiguiente.setBorderPainted(false);
		btnSiguiente.setBorder(null);
		panelGaleria.add(btnSiguiente);
		galeria = new Galeria(club);
		
		lblFoto1.setIcon(galeria.getPreview(0));
		lblFoto2.setIcon(galeria.getPreview(1));
		lblFoto3.setIcon(galeria.getPreview(2));
		lblFoto4.setIcon(galeria.getPreview(3));

	}
	
	/**
	 * M�todo encargado de renderizar el aspecto visual en relaci�n con el tema escogido.
	 * @author adrSoft
	 * @version vAlpha10
	 * @param tema = Tema seleccionado en la barra de herramientas.
	 */
	private void pintarTema(String tema) {
		if(tema.equals("classic")){
			getContentPane().setBackground(UIManager.getColor("textHighlight"));
			panelFoto.setBackground(UIManager.getColor("textHighlight"));
			panelGaleria.setBackground(UIManager.getColor("textHighlight"));
			panelFoto.setBackground(UIManager.getColor("textHighlight"));
			lblFoto1.setBackground(new Color(153, 204, 255));
			lblFoto2.setBackground(new Color(153, 204, 255));
			lblFoto3.setBackground(new Color(153, 204, 255));
			lblFoto4.setBackground(new Color(153, 204, 255));
		
		}
		else if(tema.equals("oscuro")){
			getContentPane().setBackground(Color.BLACK);
			panelFoto.setBackground(Color.BLACK);
			panelGaleria.setBackground(Color.BLACK);
			panelFoto.setBackground(Color.BLACK);
			pFoto1.setBackground(Color.GRAY);
			pFoto2.setBackground(Color.GRAY);
			pFoto3.setBackground(Color.GRAY);
			pFoto4.setBackground(Color.GRAY);
		
		
		}
		else if(tema.equals("claro")){
			getContentPane().setBackground(new Color(255, 255, 102));
			panelFoto.setBackground(new Color(255, 255, 102));
			panelGaleria.setBackground(new Color(255, 255, 102));
			panelFoto.setBackground(new Color(255, 255, 102));
			pFoto1.setBackground(new Color(255, 255, 204));
			pFoto2.setBackground(new Color(255, 255, 204));
			pFoto3.setBackground(new Color(255, 255, 204));
			pFoto4.setBackground(new Color(255, 255, 204));
		
		}
		
		
	}

}
