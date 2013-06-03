package adrsoft.scool.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import java.awt.Color;

import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.JToolBar;
import javax.swing.JDesktopPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTree;
import javax.swing.SwingConstants;

import sun.rmi.runtime.Log;

import adrsoft.scool.pojos.Alumnos;

import com.toedter.calendar.JCalendar;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyVetoException;
import java.util.List;
import java.awt.Font;
import javax.swing.JScrollBar;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AlumnosMain extends JFrame {

	/*
	 * Campos
	 */
	private JPanel contentPane;
	private JMenuItem mntmInformacin;
	private JMenuItem mntmDocumentacin;
	private JMenuItem mntmClassic;
	private JMenuItem mntmDark;
	private JMenuItem mntmLight;
	private JMenuItem mntmLogin;
	private JMenuItem mntmSalir;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JCalendar mCalendario;
	private JDesktopPane mDesktopPane;
	private JInternalFrame internalFrame;
	private Perfil perfil;
	private Mensajes mMensajes;
	private Club mClub;
	private Session session;
	private String email;
	private String nombre;
	private JLabel lblMouseOver;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public AlumnosMain() {
		setBackground(UIManager.getColor("activeCaption"));
		init();
		createEvents();
		createConnection();
	}
	
	public AlumnosMain(String mail, String nom) {
		setBackground(UIManager.getColor("activeCaption"));
		this.email = mail;
		this.nombre = nom;
		init();
		createEvents();
		createConnection();
		
	}
	
	private void createConnection() {
	     	
			SessionFactory sessionFactory;
	        Configuration configuration = new Configuration();
	        configuration.configure();
	        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
	        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	        session = sessionFactory.openSession();
		
	}

	private void init() {

		setTitle("Bienvenido, " + nombre);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1069, 600);
		mCalendario = new JCalendar();
		
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Verdana", Font.PLAIN, 12));
		menuBar.setBackground(UIManager.getColor("activeCaption"));
		setJMenuBar(menuBar);
		
		JMenu mnAplicacin = new JMenu("Aplicaci\u00F3n");
		menuBar.add(mnAplicacin);
		
		mntmLogin = new JMenuItem("Login");
	
		mntmLogin.setIcon(new ImageIcon(AlumnosMain.class.getResource("/adrsoft/scool/resources/images/mid/key.png")));
		mnAplicacin.add(mntmLogin);
		
		mntmSalir = new JMenuItem("Salir");
		
		mnAplicacin.add(mntmSalir);
		
		JMenu mnTema = new JMenu("Tema");
		menuBar.add(mnTema);
		
		mntmClassic = new JMenuItem("Classic");
		mntmClassic.setIcon(new ImageIcon(AlumnosMain.class.getResource("/adrsoft/scool/resources/images/mid/50_percent_off.png")));
		mnTema.add(mntmClassic);
		
		mntmDark = new JMenuItem("Dark");
		mntmDark.setIcon(new ImageIcon(AlumnosMain.class.getResource("/adrsoft/scool/resources/images/mid/50_percent_off.png")));
		mnTema.add(mntmDark);
		
		mntmLight = new JMenuItem("Light");
		mntmLight.setIcon(new ImageIcon(AlumnosMain.class.getResource("/adrsoft/scool/resources/images/mid/50_percent_off.png")));
		mnTema.add(mntmLight);
		
		JMenu mnInformacin = new JMenu("Ayuda");
		menuBar.add(mnInformacin);
		
		mntmDocumentacin = new JMenuItem("Documentaci\u00F3n");
		mntmDocumentacin.setIcon(new ImageIcon(AlumnosMain.class.getResource("/adrsoft/scool/resources/images/mid/full_page.png")));
		mnInformacin.add(mntmDocumentacin);
		
		mntmInformacin = new JMenuItem("Informaci\u00F3n");
	
		mntmInformacin.setIcon(new ImageIcon(AlumnosMain.class.getResource("/adrsoft/scool/resources/images/mid/info.png")));
		mnInformacin.add(mntmInformacin);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("textHighlight"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setOrientation(SwingConstants.VERTICAL);
		toolBar.setFloatable(false);
		toolBar.setBackground(UIManager.getColor("textHighlight"));
		
		mDesktopPane = new JDesktopPane();
		mDesktopPane.setBackground(UIManager.getColor("textHighlight"));
		contentPane.add(mDesktopPane);
		JPanel panel = new JPanel();
		panel.add(mCalendario);
		
		lblMouseOver = new JLabel("");
		lblMouseOver.setHorizontalAlignment(SwingConstants.CENTER);
		lblMouseOver.setForeground(new Color(0, 0, 128));
		lblMouseOver.setFont(new Font("Verdana", Font.BOLD, 20));
		lblMouseOver.setFocusable(false);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblMouseOver, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(mDesktopPane, GroupLayout.DEFAULT_SIZE, 707, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(4)
					.addComponent(lblMouseOver, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
						.addComponent(mDesktopPane, GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		btnNewButton = new JButton("");
	
		btnNewButton.setBackground(UIManager.getColor("textHighlight"));
		btnNewButton.setToolTipText("Perfil");
		btnNewButton.setIcon(new ImageIcon(AlumnosMain.class.getResource("/adrsoft/scool/resources/images/high/male_user_info.png")));
		toolBar.add(btnNewButton);
		
		btnNewButton_1 = new JButton("");
	
		
		btnNewButton_1.setToolTipText("Mensajeria");
		btnNewButton_1.setBackground(UIManager.getColor("textHighlight"));
		btnNewButton_1.setIcon(new ImageIcon(AlumnosMain.class.getResource("/adrsoft/scool/resources/images/high/yellow_mail.png")));
		toolBar.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("");
	
		btnNewButton_2.setBackground(UIManager.getColor("textHighlight"));
		btnNewButton_2.setIcon(new ImageIcon(AlumnosMain.class.getResource("/adrsoft/scool/resources/images/high/tablet.png")));
		toolBar.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("");
		btnNewButton_3.setBackground(UIManager.getColor("textHighlight"));
		btnNewButton_3.setIcon(new ImageIcon(AlumnosMain.class.getResource("/adrsoft/scool/resources/images/high/office_folders.png")));
		toolBar.add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("");

	
		btnNewButton_4.setBackground(UIManager.getColor("textHighlight"));
		btnNewButton_4.setIcon(new ImageIcon(AlumnosMain.class.getResource("/adrsoft/scool/resources/images/high/package.png")));
		toolBar.add(btnNewButton_4);
		contentPane.setLayout(gl_contentPane);
	
		
	}

	/**
	 * Método encargado de crear los eventos asignados a los botones y otros controles interactivos.
	 */
	private void createEvents(){
		mntmInformacin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showConfirmDialog(null, "Proyecto de CFGS DAM 2013 \nCreado por: Adrian Peña Gomez\nProyecto de fin de ciclo del grado superior Desarrollo de Aplicaciones Multiplataforma\nI.E.S. Miguel Herrero Pereda 2013","Acerca de..",JOptionPane.DEFAULT_OPTION);
				
			}
		});
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		//Botón de Perfil
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			perfil = new Perfil();
			perfil.setVisible(true);
		
			mDesktopPane.add(perfil);
		
				try {
					perfil.setMaximum(true);
				} catch (PropertyVetoException e) {
					e.printStackTrace();
				}
				perfil.setUI(null);
				rellenarPerfil();
		
			}

			private void rellenarPerfil() {

	            System.out.println("----------- Uso de list() -----------");
	            Query query = session.createQuery("SELECT a FROM Alumnos a WHERE a.email='"+email+"'");
	            List<Alumnos> alumnos = query.list();
	            for (Alumnos alumno : alumnos) {
	                perfil.setNombreText(alumno.getNombre());
	                perfil.setApellidosText(alumno.getApellidos());
	                perfil.setDireccionText(alumno.getDireccion());
	                perfil.setEmailText(alumno.getEmail());
	                perfil.setCursoText(alumno.getCurso());
	                perfil.setTelefonoText(String.valueOf(alumno.getTelefono()));
	            }
			
			}
		});
		
		//Boton de Mensajes
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mMensajes = new Mensajes();
				mMensajes.setVisible(true);
				
				mDesktopPane.add(mMensajes);
			
				try {
					mMensajes.setMaximum(true);
				} catch (PropertyVetoException e1) {
					e1.printStackTrace();
				}
				mMensajes.setUI(null);
			}
		});
		
		//Boton de Club
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mClub = new Club();
				mClub.setVisible(true);
				mClub.setBorder(null);
				
				mDesktopPane.add(mClub);
				try {
					mClub.setMaximum(true);
				} catch (PropertyVetoException e1) {
					e1.printStackTrace();
				}
				mClub.setUI(null);
		
			}
		});

		//Boton de login 
		mntmLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Inicio ini = new Inicio();
				ini.setVisible(true);
				
			}
		});
		
		//Boton de webs
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
//	            System.out.println("----------- Uso de list() -----------");
//	            Query query = session.createQuery("SELECT a FROM Alumnos a");
//	            List<Alumnos> alumnos = query.list();
//	            for (Alumnos alumno : alumnos) {
//	                System.out.println(alumno.toString());
//	                System.out.println("\n*********");
//	            }
				Webs mWebs = new Webs();
				mWebs.setVisible(true);
				mWebs.setBorder(null);
				mDesktopPane.add(mWebs);
				try {
					mWebs.setMaximum(true);
				} catch (PropertyVetoException e1) {
					e1.printStackTrace();
				}
				mWebs.setUI(null);
	            
			}
		});
		
		//Mouseover Perfil
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblMouseOver.setText("Perfil");
			}
			@Override
			public void mouseExited(MouseEvent e) {
			lblMouseOver.setText("");
				
			}
		});
		
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				lblMouseOver.setText("Mensajes");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblMouseOver.setText("");
				
			}
		});
		
		//Mouseover Notas
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblMouseOver.setText("Notas");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblMouseOver.setText("");
			}
		});
		
		//Mouseover Club
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblMouseOver.setText("Club");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblMouseOver.setText("");
			}
		});
		
	}
}
