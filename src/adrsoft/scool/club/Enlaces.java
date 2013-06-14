package adrsoft.scool.club;


import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;

import adrsoft.scool.model.AbrirUrl;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.SwingConstants;

/**
 * Clase encargada de instanciar unos botones que contienen links a páginas interesantes relevantes al club.
 * @author adrSoft
 *@version vAlpha10
 */
public class Enlaces extends JInternalFrame {

    /*
     * Campos
     */
    private static final long serialVersionUID = 1L;
    private int club;
    private JButton botonWiki;
    private JPanel panel;
    private JButton botonPagina;
    private JButton botonMisc;

	/**
	 * Constructor vacio.
	 * @author adrSoft
	 * @version vAlpha10
	 * @param mClub 
	 * @param tema 
	 */
	public Enlaces(int mClub, String tema) {
		this.club = mClub;
		getContentPane().setBackground(UIManager.getColor("textHighlight"));
		setBounds(100, 100, 710, 300);
		init();
		createButtons();
		pintarTema(tema);
	}

	

	/**
	 * Método encargado de renderizar el aspecto visual en relación con el tema escogido.
	 * @author adrSoft
	 * @version vAlpha10
	 * @param tema = Tema seleccionado en la barra de herramientas.
	 */
	private void pintarTema(String tema) {
		if(tema.equals("classic")){
			panel.setBackground(new Color(153, 204, 255));
			getContentPane().setBackground(UIManager.getColor("textHighlight"));
		}
		else if(tema.equals("oscuro")){
			panel.setBackground(Color.GRAY);
			getContentPane().setBackground(Color.BLACK);
		
		}
		else if(tema.equals("claro")){
			panel.setBackground(new Color(255, 255, 204));
			getContentPane().setBackground(new Color(255, 255, 102));
		}
		
		
	}



	/**
	 * Inicializador de los componentes en el JFrame.
	 * @author adrSoft
	 * @version vAlpha10
	 */
	private void init() {
			
			panel = new JPanel();
			panel.setBackground(new Color(153, 204, 255));
			botonWiki = new JButton();
			botonWiki.setContentAreaFilled(false);
		
			botonPagina = new JButton();
			botonPagina.setContentAreaFilled(false);
		
			botonMisc = new JButton();
			botonMisc.setContentAreaFilled(false);
			
			
			JLabel lblEnlaces = new JLabel("Enlaces");
			lblEnlaces.setHorizontalAlignment(SwingConstants.RIGHT);
			lblEnlaces.setForeground(Color.BLUE);
			lblEnlaces.setFont(new Font("Verdana", Font.BOLD, 20));
			GroupLayout groupLayout = new GroupLayout(getContentPane());
			groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addGap(31)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addComponent(lblEnlaces, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 618, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(45, Short.MAX_VALUE))
			);
			groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addComponent(lblEnlaces, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addGap(5)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(28, Short.MAX_VALUE))
			);
			
			
				GroupLayout gl_panel = new GroupLayout(panel);
				gl_panel.setHorizontalGroup(
					gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(botonPagina, GroupLayout.PREFERRED_SIZE, 618, GroupLayout.PREFERRED_SIZE)
								.addComponent(botonMisc, GroupLayout.PREFERRED_SIZE, 618, GroupLayout.PREFERRED_SIZE)
								.addComponent(botonWiki, GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE))
							.addContainerGap())
				);
				gl_panel.setVerticalGroup(
					gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(34)
							.addComponent(botonWiki)
							.addGap(18)
							.addComponent(botonPagina)
							.addGap(18)
							.addComponent(botonMisc)
							.addContainerGap(93, Short.MAX_VALUE))
				);
				panel.setLayout(gl_panel);
			getContentPane().setLayout(groupLayout);

	}
	
	/**
	 * Método encargado de la creación de los botones de la sección enlaces, así como de <br>sus eventos.
	 * @author adrSoft
	 * @version vAlpha10
	 */
	private void createButtons() {
		switch(club){
		case 1:
			botonWiki.setText("Enlace a Wikipedia sobre el Ajedrez");
			botonPagina.setText("Portal sobre ajedrez");
			botonMisc.setText("Reglas del juego");
			botonWiki.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					new AbrirUrl("http://es.wikipedia.org/wiki/Ajedrez");
				}
			});
		
			botonPagina.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new AbrirUrl("http://www.jaquemate.org/");
				}
			});
			
			botonMisc.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new AbrirUrl("http://www.flyordie.com/games/help/chess/es/games_rules_chess.html");
				}
			});
			break;
		case 2:
			botonWiki.setText("Enlace a Wikipedia sobre el Atletismo");
			botonPagina.setText("Pagina de la federación Cantabra de Atletismo");
			botonMisc.setText("Planes de entrenamiento");
				
			botonWiki.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					new AbrirUrl("http://es.wikipedia.org/wiki/Ajedrez");
				}
			});
		
			botonPagina.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new AbrirUrl("http://www.fcatle.com/");
				}
			});
			
			botonMisc.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new AbrirUrl("http://www.everyoneweb.es/planesdeentrenamiento/");
				}
			});
			break;
		case 3:
			botonWiki.setText("Enlace a Meristation");
			botonPagina.setText("Enlace a Gamasutra");
			botonMisc.setText("Tutorial: Como crear un juego desde cero.");

			botonWiki.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					new AbrirUrl("http://www.meristation.com/");
				}
			});
		
			botonPagina.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new AbrirUrl("http://www.gamasutra.com/");
				}
			});
			
			botonMisc.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new AbrirUrl("http://www.javacodegeeks.com/2012/05/android-game-development-with-libgdx.html");
				}
			});
			break;
		case 4:
			botonWiki.setText("Recomendaciones de libros");
			botonPagina.setText("Círculo de Lectores");
			botonMisc.setText("Libros gratis en castellano");
				
			botonWiki.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					new AbrirUrl("http://recomendacionesdelibros.com/");
				}
			});
		
			botonPagina.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new AbrirUrl("http://www.circulo.es/");
				}
			});
			
			botonMisc.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new AbrirUrl("http://www.libros-gratis.com.ar/");
				}
			});
			break;
			
		}
	}
}
