package adrsoft.scool.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JToolBar;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import adrsoft.scool.club.Enlaces;
import adrsoft.scool.club.Fotos;
import adrsoft.scool.club.Informacion;
import adrsoft.scool.club.Inventario;
import adrsoft.scool.club.Miembros;
import adrsoft.scool.club.Normas;
import adrsoft.scool.club.Noticias;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

/**
 * Clase que recoge el club del alumno y renderiza un portal donde puede interactuar con las caracteristicas
 * del club, así como con sus miembros.
 * 
 * @author adrSoft
 *@version vAlpha10
 */
public class Club extends JInternalFrame {

    	/*
    	 * Campos
    	 */
    	private static final long serialVersionUID = 1L;
	private JButton btnInfo;
	private JButton btnNormas;
	private JButton btnNoticias;
	private JButton btnMiembros;
	private JButton btnInventario;
	private JButton btnFotos;
	private JButton btnEnlaces;
	private JDesktopPane clubDesktopPane;
	private int mClub;
	private JLabel lblNewLabel;
	private JPanel panel;
	private String tema;



	/**
	 *Constructor que inicializa la clase habiendole pasado el id del club a mostrar.
	 *@author adrSoft
	 *@version vAlpha10
	 *@param clu = idclub(identificador del club del alumno)
	 * @param tema 
	 */
	public Club(int clu, String tema) {
		this.tema = tema;
		getContentPane().setBackground(UIManager.getColor("textHighlight"));
		((javax.swing.plaf.basic.BasicInternalFrameUI) 
				getUI()).setNorthPane(null);
		this.mClub = clu;
		init();
		createEvents();
		pintarTema(tema);

	}

	
	/**
	 * Método encargado de crear los eventos asignados a los botones y otros controles interactivos.
	 * @author adrSoft
	 * @version vAlpha10
	 */
	private void createEvents() {
	    
	    	//Boton Información
		btnInfo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {

				Informacion info = new Informacion(mClub, tema);
				info.setVisible(true);
				clubDesktopPane.add(info);
					try {
						info.setMaximum(true);
					} catch (PropertyVetoException e2) {
						e2.printStackTrace();
					}
					info.setUI(null);
			
				
			}
		});
		
		//Botón normas
		btnNormas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Normas normas = new Normas(mClub,tema);
				normas.setVisible(true);
				clubDesktopPane.add(normas);
					try {
					    normas.setMaximum(true);
					} catch (PropertyVetoException e2) {
						e2.printStackTrace();
					}
					normas.setUI(null);
			
			}
		});
		
		//Botón noticias
		btnNoticias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    Noticias notis = new Noticias(mClub,tema);
			    notis.setVisible(true);
			    clubDesktopPane.add(notis);
			    try {
				notis.setMaximum(true);
			    } catch (PropertyVetoException e1) {
				e1.printStackTrace();
			    }
			    notis.setUI(null);
			}
		});
		
		//Botón miembros
		btnMiembros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    Miembros miem = new Miembros(tema);
			    miem.setVisible(true);
			   clubDesktopPane.add(miem);
			   try {
			    miem.setMaximum(true);
			} catch (PropertyVetoException e1) {
			    e1.printStackTrace();
			}
			   miem.setUI(null);
			}
		});
		
		//Botón inventario
		btnInventario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    Inventario inven = new Inventario(mClub,tema);
			    inven.setVisible(true);
			    clubDesktopPane.add(inven);
			    try {
				inven.setMaximum(true);
			    } catch (PropertyVetoException e1) {
				e1.printStackTrace();
			    }
			    inven.setUI(null);
			}
		});
		
		//Botón fotos
		btnFotos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    Fotos fots = new Fotos(mClub,tema);
			    fots.setVisible(true);
			    clubDesktopPane.add(fots);
			    try {
				fots.setMaximum(true);
			    } catch (PropertyVetoException e1) {
				e1.printStackTrace();
			    }
			    fots.setUI(null);
			}
		});
		
		//Botón enlaces
		btnEnlaces.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    Enlaces enla = new Enlaces(mClub,tema);
			    enla.setVisible(true);
			    clubDesktopPane.add(enla);
			    try {
				enla.setMaximum(true);
			    } catch (PropertyVetoException e1) {
				e1.printStackTrace();
			    }
			    enla.setUI(null);
			}
		});
	
		
	}

	/**
	 * Inicializador de los componentes en el JFrame.
	 * @author adrSoft
	 * @version vAlpha10
	 */
	private void init() {
		panel = new JPanel();
		panel.setBackground(UIManager.getColor("textHighlight"));
		
		clubDesktopPane = new JDesktopPane();
		clubDesktopPane.setBackground(new Color(153, 204, 255));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE)
				.addComponent(clubDesktopPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(clubDesktopPane, GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE))
		);
		
		lblNewLabel = new JLabel("");

	
		switch(mClub){
		case 1:
			lblNewLabel.setIcon(new ImageIcon(Club.class.getResource("/adrsoft/scool/resources/images/high/peon.gif")));
			break;
		case 2:
			lblNewLabel.setIcon(new ImageIcon(Club.class.getResource("/adrsoft/scool/resources/images/high/atletismo.gif")));
			break;
		case 3:
			lblNewLabel.setIcon(new ImageIcon(Club.class.getResource("/adrsoft/scool/resources/images/high/mando.gif")));
			break;
		case 4:
			lblNewLabel.setIcon(new ImageIcon(Club.class.getResource("/adrsoft/scool/resources/images/high/libro.gif")));
			break;
		}
		
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_clubDesktopPane = new GroupLayout(clubDesktopPane);
		gl_clubDesktopPane.setHorizontalGroup(
			gl_clubDesktopPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_clubDesktopPane.createSequentialGroup()
					.addGap(149)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 412, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(147, Short.MAX_VALUE))
		);
		gl_clubDesktopPane.setVerticalGroup(
			gl_clubDesktopPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_clubDesktopPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addContainerGap())
		);
		clubDesktopPane.setLayout(gl_clubDesktopPane);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBorder(null);
		toolBar.setBackground(UIManager.getColor("textHighlight"));
		toolBar.setFloatable(false);
		panel.add(toolBar);
		
		btnInfo = new JButton("Informaci\u00F3n");

		
		btnInfo.setFont(new Font("Verdana", Font.BOLD, 12));
		btnInfo.setBackground(UIManager.getColor("activeCaption"));
		toolBar.add(btnInfo);
		
		JSeparator separator = new JSeparator();
		toolBar.add(separator);
		
		btnNormas = new JButton("Normas");

		btnNormas.setFont(new Font("Verdana", Font.BOLD, 12));
		btnNormas.setBackground(UIManager.getColor("activeCaption"));
		toolBar.add(btnNormas);
		
		btnNoticias = new JButton("Noticias");
	
		btnNoticias.setFont(new Font("Verdana", Font.BOLD, 12));
		btnNoticias.setBackground(UIManager.getColor("activeCaption"));
		toolBar.add(btnNoticias);
		
		btnMiembros = new JButton("Miembros");
	
		btnMiembros.setFont(new Font("Verdana", Font.BOLD, 12));
		btnMiembros.setBackground(UIManager.getColor("activeCaption"));
		toolBar.add(btnMiembros);
		
		btnInventario = new JButton("Inventario");

		btnInventario.setFont(new Font("Verdana", Font.BOLD, 12));
		btnInventario.setBackground(UIManager.getColor("activeCaption"));
		toolBar.add(btnInventario);
		
		btnFotos = new JButton("Fotos");
	
		btnFotos.setFont(new Font("Verdana", Font.BOLD, 12));
		btnFotos.setBackground(UIManager.getColor("activeCaption"));
		toolBar.add(btnFotos);
		
		btnEnlaces = new JButton("Enlaces");
	
		btnEnlaces.setFont(new Font("Verdana", Font.BOLD, 12));
		btnEnlaces.setBackground(UIManager.getColor("activeCaption"));
		toolBar.add(btnEnlaces);
		getContentPane().setLayout(groupLayout);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(100, 100, 710, 523);
		
		
	}
	
	/**
	 * Método encargado de renderizar el aspecto visual en relación con el tema escogido.
	 * @author adrSoft
	 * @version vAlpha10
	 * @param tema = Tema seleccionado en la barra de herramientas.
	 */
	private void pintarTema(String tema) {
		if(tema.equals("classic")){
			
		clubDesktopPane.setBackground(new Color(153, 204, 255));
		panel.setBackground(UIManager.getColor("textHighlight"));
		getContentPane().setBackground(UIManager.getColor("textHighlight"));
		}
		else if(tema.equals("oscuro")){
			
			clubDesktopPane.setBackground(Color.GRAY);
			panel.setBackground(Color.BLACK);
			getContentPane().setBackground(Color.BLACK);
			
		}
		else if(tema.equals("claro")){
			
			clubDesktopPane.setBackground(new Color(255, 255, 204));
			panel.setBackground(new Color(255, 255, 102));
			getContentPane().setBackground(new Color(255, 255, 102));
		}
		
		
	}
	
}
