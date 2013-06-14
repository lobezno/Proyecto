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
import adrsoft.scool.model.AbreDocumento;
import adrsoft.scool.model.AbrirUrl;
import adrsoft.scool.model.FakeChat;
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
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Toolkit;

/**
 * Clase encargada de renderizar el menú principal de los alumnos.
 * @author adrSoft
 *@version vAlpha10
 */
public class AlumnosMain extends JFrame {

	/*
	 * Campos
	 */
    	private static final long serialVersionUID = 1L;
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
	private JScrollPane scrollPane_1;
	private JTextField textChat;
	private JButton btnChatEnviar;
	private JTextPane chatArea;
	private FakeChat fakeChat;
	private JLabel lblNewLabel;
	private JPanel panelCalendario;
	private JMenuItem mntmApi;


	/**
	 * Constructor de clase sin parametros.
	 * @author adrSoft
	 * @version vAlpha10
	 */
	public AlumnosMain() {
		
		setBackground(UIManager.getColor("activeCaption"));
		init();
		createEvents();
		createConnection();
		setIconImage(Toolkit.getDefaultToolkit().getImage(AlumnosMain.class.getResource("/adrsoft/scool/resources/images/high/milogo3.png")));
	}
	
	/**
	 * Constructor que necesita varios parametros para la posterior personalización de  
	 * las caracteristicas de la vista.
	 * @author adrSoft
	 * @version vAlpha10
	 * @param mail = Email del alumno
	 * @param nom = Nombre del alumno
	 * @param ape = Apellidos del alumno	
	 * @param clu = Entero que indica a qué club pertenece el alumno
	 * @param idalu = Identificador del alumno
	 */
	public AlumnosMain(String mail, String nom, String ape, int clu, int idalu) {
		setBackground(UIManager.getColor("activeCaption"));
		this.email = mail;
		this.idalumno = idalu;
		this.nombre = nom;
		this.apellidos = ape;
		this.mIdClub = clu;
		
		init();
		createEvents();
		createConnection();
		fakeChat = new FakeChat(chatArea);
		
		
	}
	
	/**
	 * Inicializador de la conexión entre la aplicación y la base de datos.
	 * @author adrSoft
	 * @version vAlpha10
	 */
	private void createConnection() {
	     	
		SessionFactory sessionFactory;
	        Configuration configuration = new Configuration();
	        configuration.configure();
	        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
	        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	        session = sessionFactory.openSession();
	}
	
	/**
	 * Inicializador de los componentes en el JFrame.
	 * @author adrSoft
	 * @version 
	 */
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

		mntmClassic.setIcon(new ImageIcon(AlumnosMain.class.getResource("/adrsoft/scool/resources/images/low/classic.png")));
		mnTema.add(mntmClassic);
		
		mntmDark = new JMenuItem("Dark");

		mntmDark.setIcon(new ImageIcon(AlumnosMain.class.getResource("/adrsoft/scool/resources/images/low/dark.png")));
		mnTema.add(mntmDark);
		
		mntmLight = new JMenuItem("Light");
		mntmLight.setIcon(new ImageIcon(AlumnosMain.class.getResource("/adrsoft/scool/resources/images/low/light.png")));
		mnTema.add(mntmLight);
		
		JMenu mnInformacin = new JMenu("Ayuda");
		menuBar.add(mnInformacin);
		
		mntmDocumentacin = new JMenuItem("Documentaci\u00F3n");
	
		mntmDocumentacin.setIcon(new ImageIcon(AlumnosMain.class.getResource("/adrsoft/scool/resources/images/mid/full_page.png")));
		mnInformacin.add(mntmDocumentacin);
		
		mntmApi = new JMenuItem("API sCooL");
	
		mntmApi.setIcon(new ImageIcon(AlumnosMain.class.getResource("/adrsoft/scool/resources/images/low/process.png")));
		mnInformacin.add(mntmApi);
		
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
		panelCalendario = new JPanel();
		panelCalendario.setBackground(new Color(153, 204, 255));
		panelCalendario.add(mCalendario);
		
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
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		textChat = new JTextField();
		textChat.setColumns(10);
		
		btnChatEnviar = new JButton("Enviar");
		btnChatEnviar.setFont(new Font("Verdana", Font.PLAIN, 5));
	
		GroupLayout gl_panelChat = new GroupLayout(panelChat);
		gl_panelChat.setHorizontalGroup(
			gl_panelChat.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelChat.createSequentialGroup()
					.addGroup(gl_panelChat.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panelChat.createSequentialGroup()
							.addComponent(textChat, GroupLayout.PREFERRED_SIZE, 148, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnChatEnviar, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE))
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 199, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panelChat.setVerticalGroup(
			gl_panelChat.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelChat.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addGroup(gl_panelChat.createParallelGroup(Alignment.BASELINE)
						.addComponent(textChat, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnChatEnviar, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
					.addGap(2))
		);
		
		chatArea = new JTextPane();
		chatArea.setFocusable(false);
		scrollPane_1.setViewportView(chatArea);
		panelChat.setLayout(gl_panelChat);
		
		lblNewLabel = new JLabel("---------------------------------");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 20));
	
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblMouseOver, GroupLayout.PREFERRED_SIZE, 336, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 336, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnMaxMin, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
							.addGap(22)
							.addComponent(mDesktopPane, GroupLayout.PREFERRED_SIZE, 707, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addComponent(panelChat, GroupLayout.PREFERRED_SIZE, 207, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(panelCalendario, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
								.addContainerGap()))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)
							.addGap(18))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(12)
					.addComponent(lblMouseOver, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(mDesktopPane, GroupLayout.DEFAULT_SIZE, 657, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 228, Short.MAX_VALUE)
							.addComponent(btnMaxMin, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panelCalendario, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(panelChat, GroupLayout.PREFERRED_SIZE, 305, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		
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
		btnWebs.setIcon(new ImageIcon(AlumnosMain.class.getResource("/adrsoft/scool/resources/images/high/search_globe.png")));
		toolBar.add(btnWebs);
		
		btnClub = new JButton("");

	
		btnClub.setBackground(UIManager.getColor("textHighlight"));
		btnClub.setIcon(new ImageIcon(AlumnosMain.class.getResource("/adrsoft/scool/resources/images/high/club2.png")));
		toolBar.add(btnClub);
		contentPane.setLayout(gl_contentPane);
	
	}

	

	
	/**
	 * Método encargado de rellenar los campos de texto de la ficha de perfil del usuario.
	 * 
	 * El usuario es filtrado por su email.
	 * @author adrSoft
	 * @version vAlpha10
	 * @param email = email del usuario activo
	 */
	private void rellenarPerfil() {

            Query query = session.createQuery("SELECT a FROM Alumnos a WHERE a.email='"+email+"'");
	    @SuppressWarnings("unchecked")
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

	/**
	 * Método encargado de crear los eventos asignados a los botones y otros controles interactivos.
	 * @author adrSoft
	 * @version vAlpha10
	 */
	private void createEvents(){
	    	//Botón Información
		mntmInformacin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showConfirmDialog(null, "Proyecto de CFGS DAM 2013 \nCreado por: Adrian Peña Gomez\nProyecto de fin de ciclo del grado superior Desarrollo de Aplicaciones Multiplataforma\nI.E.S. Miguel Herrero Pereda 2013","Acerca de..",JOptionPane.DEFAULT_OPTION);
				
			}
		});
		
		//Botón salir
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

	
		});
		
		//Boton de Mensajes
		btnMensajes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mMensajes = new Mensajes(tema);
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
				mClub = new Club(mIdClub,tema);
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
				mNotas = new Notas(tema);
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
//				dispose();
				setVisible(false);
				Inicio ini = new Inicio();
				ini.setVisible(true);
				
			}
		});
		
		//Boton de webs
		btnWebs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Webs mWebs = new Webs(tema);
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
				panelChat.setBackground(Color.GRAY);
				panelCalendario.setBackground(Color.GRAY);
				invalidate();

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
				panelCalendario.setBackground(new Color(153, 204, 255));
				panelChat.setBackground(new Color(153, 204, 255));
				invalidate();
			
			}
		});
		
		//Tema claro
		mntmLight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tema = "claro";
				mDesktopPane.setBackground(new Color(255, 255, 204));
				contentPane.setBackground(new Color(255, 255, 102));
				toolBar.setBackground(new Color(255, 255, 102));
				btnPerfil.setBackground(new Color(255, 255, 102));
				btnMensajes.setBackground(new Color(255, 255, 102));
				btnNotas.setBackground(new Color(255, 255, 102));
				btnWebs.setBackground(new Color(255, 255, 102));
				btnClub.setBackground(new Color(255, 255, 102));
				panelCalendario.setBackground(new Color(255, 255, 204));
				panelChat.setBackground(new Color(255, 255, 204));
				invalidate();
				
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
		
		//Botón enviar del chat
		btnChatEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    String mensaje = nombre + ": " +textChat.getText() + "\n";
			    
			  fakeChat.appendToPane(chatArea, mensaje, Color.RED);
			  textChat.setText("");
			}
		});
		
		//Mouseover Expand
		btnMaxMin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if(maximizada)
				lblMouseOver.setText("Restaurar");
				else
				lblMouseOver.setText("Maximizar");	
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblMouseOver.setText("");
			}
		});
		
		//Mouseover Salida
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblMouseOver.setText("Salir");
			}
			@Override
			public void mouseExited(MouseEvent e){
				lblMouseOver.setText("");
			}
		});
		
		//Botón de documentación
		mntmDocumentacin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				
			AbreDocumento docu = new AbreDocumento();
			docu.setVisible(true);
			}
		});
		
		//Botón API
		mntmApi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new AbrirUrl("http://arreat.es/scool/doc/");
			}
		});
	}
}
