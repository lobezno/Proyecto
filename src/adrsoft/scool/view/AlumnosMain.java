package adrsoft.scool.view;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import java.awt.Color;
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
import javax.swing.SwingConstants;
import adrsoft.scool.pojos.Alumnos;
import com.toedter.calendar.JCalendar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyVetoException;
import java.util.List;
import java.awt.Font;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.GridLayout;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JScrollPane;

public class AlumnosMain extends JFrame {

	
	/**
     * 
     */
    private static final long serialVersionUID = 1L;
	/**
     * 
     */

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
	private JButton btnPerfil;
	private JButton btnMensajes;
	private JButton btnNotas;
	private JButton btnWebs;
	private JButton btnClub;
	private JCalendar mCalendario;
	private JDesktopPane mDesktopPane;
	private Perfil perfil;
	private Mensajes mMensajes;
	private Club mClub;
	private Session session;
	private String email;
	private int idalumno;
	private String nombre;
	private String apellidos;
	private JLabel lblMouseOver;
	private Notas mNotas;
	private int mIdClub;
	private JToolBar toolBar;
	private String tema = "classic";
	private JButton btnMaxMin;
	private boolean maximizada;
	private JButton button;
	private JPanel panelChat;
	private JTextField textField;
	private JButton btnChatEnviar;
	private JTextField chatArea;


	/**
	 * Create the frame.
	 */
	public AlumnosMain() {
		setBackground(UIManager.getColor("activeCaption"));
		init();
		createEvents();
		createConnection();
	}
	
	public AlumnosMain(String mail, String nom, String ape, int clu, int idalu) {
		setBackground(UIManager.getColor("activeCaption"));
		this.email = mail;
		this.idalumno = idalu;
		this.nombre = nom;
		this.apellidos = ape;
		this.mIdClub = clu;
		System.out.print("Alumnosmain Club: " + mIdClub);
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

		setTitle("Bienvenido, " + nombre + " " + apellidos);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1069, 800);
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
		
		toolBar = new JToolBar();
		toolBar.setOrientation(SwingConstants.VERTICAL);
		toolBar.setFloatable(false);
		toolBar.setBackground(UIManager.getColor("textHighlight"));
		
		mDesktopPane = new JDesktopPane();
		mDesktopPane.setBackground(new Color(153, 204, 255));
		contentPane.add(mDesktopPane);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 204, 255));
		panel.add(mCalendario);
		
		lblMouseOver = new JLabel("");
		lblMouseOver.setHorizontalAlignment(SwingConstants.CENTER);
		lblMouseOver.setForeground(new Color(0, 0, 128));
		lblMouseOver.setFont(new Font("Verdana", Font.BOLD, 20));
		lblMouseOver.setFocusable(false);
		
		btnMaxMin = new JButton("");
		btnMaxMin.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnMaxMin.setContentAreaFilled(false);
		btnMaxMin.setIcon(new ImageIcon(AlumnosMain.class.getResource("/adrsoft/scool/resources/images/mid/max.png")));
		
		button = new JButton("");
		button.setIcon(new ImageIcon(AlumnosMain.class.getResource("/adrsoft/scool/resources/images/mid/salirMid.png")));
		button.setContentAreaFilled(false);
		button.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		panelChat = new JPanel();
		panelChat.setBackground(new Color(153, 204, 255));
	
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnMaxMin, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblMouseOver, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 707, Short.MAX_VALUE)
						.addComponent(mDesktopPane, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 707, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panelChat, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 204, Short.MAX_VALUE)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(4)
					.addComponent(lblMouseOver, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 246, Short.MAX_VALUE)
							.addComponent(btnMaxMin, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
							.addGap(55)
							.addComponent(panelChat, GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
						.addComponent(mDesktopPane, GroupLayout.DEFAULT_SIZE, 675, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		btnChatEnviar = new JButton("Enviar");
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panelChat = new GroupLayout(panelChat);
		gl_panelChat.setHorizontalGroup(
			gl_panelChat.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelChat.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnChatEnviar, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addGap(38))
				.addGroup(gl_panelChat.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panelChat.setVerticalGroup(
			gl_panelChat.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelChat.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelChat.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
						.addComponent(btnChatEnviar, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
		chatArea = new JTextField();
		scrollPane.setViewportView(chatArea);
		chatArea.setColumns(10);
		panelChat.setLayout(gl_panelChat);
		
		btnPerfil = new JButton("");
	
		btnPerfil.setBackground(UIManager.getColor("textHighlight"));
		btnPerfil.setToolTipText("Perfil");
		btnPerfil.setIcon(new ImageIcon(AlumnosMain.class.getResource("/adrsoft/scool/resources/images/high/male_user_info.png")));
		toolBar.add(btnPerfil);
		
		btnMensajes = new JButton("");
	
		
		btnMensajes.setToolTipText("Mensajeria");
		btnMensajes.setBackground(UIManager.getColor("textHighlight"));
		btnMensajes.setIcon(new ImageIcon(AlumnosMain.class.getResource("/adrsoft/scool/resources/images/high/yellow_mail.png")));
		toolBar.add(btnMensajes);
		
		btnNotas = new JButton("");

		btnNotas.setBackground(UIManager.getColor("textHighlight"));
		btnNotas.setIcon(new ImageIcon(AlumnosMain.class.getResource("/adrsoft/scool/resources/images/high/tablet.png")));
		toolBar.add(btnNotas);
		
		btnWebs = new JButton("");
		
		btnWebs.setBackground(UIManager.getColor("textHighlight"));
		btnWebs.setIcon(new ImageIcon(AlumnosMain.class.getResource("/adrsoft/scool/resources/images/high/office_folders.png")));
		toolBar.add(btnWebs);
		
		btnClub = new JButton("");

	
		btnClub.setBackground(UIManager.getColor("textHighlight"));
		btnClub.setIcon(new ImageIcon(AlumnosMain.class.getResource("/adrsoft/scool/resources/images/high/package.png")));
		toolBar.add(btnClub);
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
		btnPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			perfil = new Perfil(idalumno,tema);
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
		btnMensajes.addActionListener(new ActionListener() {
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
		btnClub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mClub = new Club(mIdClub);
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
		
		//boton de notas
		btnNotas.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent arg0) {
				mNotas = new Notas();
				mNotas.setVisible(true);
				mNotas.setBorder(null);
				mDesktopPane.add(mNotas);
				try {
					mNotas.setMaximum(true);
				} catch (PropertyVetoException e) {
					e.printStackTrace();
				}
				mNotas.setUI(null);
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
		btnWebs.addActionListener(new ActionListener() {
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
		btnPerfil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblMouseOver.setText("Perfil");
			}
			@Override
			public void mouseExited(MouseEvent e) {
			lblMouseOver.setText("");
				
			}
		});
		
		btnMensajes.addMouseListener(new MouseAdapter() {
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
		btnNotas.addMouseListener(new MouseAdapter() {
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
		btnClub.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblMouseOver.setText("Club");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblMouseOver.setText("");
			}
		});
		
		//mouseover webs
		btnWebs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblMouseOver.setText("Web / Intranet");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblMouseOver.setText("");
			}
		});
		
		//Tema oscuro
	
		mntmDark.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tema = "oscuro";
				mDesktopPane.setBackground(Color.GRAY);
				contentPane.setBackground(Color.BLACK);
				toolBar.setBackground(Color.GRAY);
				btnPerfil.setBackground(Color.GRAY);
				btnMensajes.setBackground(Color.GRAY);
				btnNotas.setBackground(Color.GRAY);
				btnWebs.setBackground(Color.GRAY);
				btnClub.setBackground(Color.GRAY);
			}
		});
		
		//Tema classico
		mntmClassic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tema = "classic";	
				mDesktopPane.setBackground(new Color(153, 204, 255));
				contentPane.setBackground(UIManager.getColor("textHighlight"));
				toolBar.setBackground(UIManager.getColor("textHighlight"));
				btnPerfil.setBackground(UIManager.getColor("textHighlight"));
				btnMensajes.setBackground(UIManager.getColor("textHighlight"));
				btnNotas.setBackground(UIManager.getColor("textHighlight"));
				btnWebs.setBackground(UIManager.getColor("textHighlight"));
				btnClub.setBackground(UIManager.getColor("textHighlight"));
			}
		});
		
		//Tema claro
		
		mntmLight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tema = "claro";
			}
		});
		
		//Botón Expand/Collapse
		btnMaxMin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(maximizada){
					setBounds(100, 100, 1069, 800);
					maximizada = false;
					btnMaxMin.setIcon(new ImageIcon(AlumnosMain.class.getResource("/adrsoft/scool/resources/images/mid/max.png")));
				}
				else{
					setExtendedState(JFrame.MAXIMIZED_BOTH);
					maximizada = true;
					btnMaxMin.setIcon(new ImageIcon(AlumnosMain.class.getResource("/adrsoft/scool/resources/images/mid/min.png")));
				}
				
			}
		});
		
		//Botón cerrar inferior derecho
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		btnChatEnviar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				chatArea.setText("hola!");
			}
		});
	}
}
