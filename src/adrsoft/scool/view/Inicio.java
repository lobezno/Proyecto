package adrsoft.scool.view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import java.awt.Font;
import java.util.List;
import javax.swing.JPasswordField;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import adrsoft.scool.pojos.Alumnos;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Toolkit;
import javax.swing.SwingConstants;

/**
 * Clase de login inicial
 * @author adrSoft
 * @version 1.0
 *
 */
public class Inicio extends JFrame {

    	/*
    	 * Campos
    	 */
    	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	@SuppressWarnings("unused")
	private final Action action = new SwingAction();
	private JButton btnSalir;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btnGo;
	private String textmail;
	private Session session;
	private String textpass;
	private JLabel labelError;
	
	/**
	 * Clase Lanzadera de la aplicación
	 * @author adrSoft
	 * @version 1.0
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inicio frame = new Inicio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Inicio() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Inicio.class.getResource("/adrsoft/scool/resources/images/high/milogo3.png")));
		setLocationRelativeTo(null);
		setTitle(" %&%%&% sCooL %&%%&% ");
		createConnection();
		init();
		createEvents();
	
	}
	
	private class SwingAction extends AbstractAction {

	    private static final long serialVersionUID = 1L;
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	
	/**
	 * Inicializador de los componentes en el JFrame.
	 * @author adrSoft
	 * @version 1.0
	 */
	private void init(){
		setUndecorated(true);
		setForeground(new Color(0, 0, 51));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();

		contentPane.setBackground(UIManager.getColor("textHighlight"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		btnSalir = new JButton("");
		btnSalir.setBorder(null);
		btnSalir.setContentAreaFilled(false);
		
		btnSalir.setToolTipText("Salir");
		btnSalir.setBackground(UIManager.getColor("textHighlight"));
		btnSalir.setIcon(new ImageIcon(Inicio.class.getResource("/adrsoft/scool/resources/images/high/exit.gif")));
		
		JLabel lblUsuario = new JLabel("Email");
		lblUsuario.setFont(new Font("Verdana", Font.BOLD, 18));
		
		textField = new JTextField();
	
		textField.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Verdana", Font.BOLD, 18));
		
		passwordField = new JPasswordField();
	
		btnGo = new JButton("");
		btnGo.setBorder(null);
		btnGo.setContentAreaFilled(false);
		btnGo.setBackground(null);
		btnGo.setToolTipText("Entar");
		btnGo.setIcon(new ImageIcon(Inicio.class.getResource("/adrsoft/scool/resources/images/high/accept.png")));
		
		labelError = new JLabel("");
		labelError.setHorizontalAlignment(SwingConstants.RIGHT);
		labelError.setForeground(new Color(255, 0, 0));
		labelError.setFont(new Font("Verdana", Font.BOLD, 9));
	
	
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(665, Short.MAX_VALUE)
					.addComponent(btnSalir))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(labelError, GroupLayout.PREFERRED_SIZE, 410, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addContainerGap()
								.addComponent(btnGo))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGap(225)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addComponent(lblUsuario)
									.addComponent(lblContrasea))
								.addGap(38)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
									.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)))))
					.addGap(215))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(233, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUsuario))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblContrasea))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(labelError, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnGo)
					.addGap(50)
					.addComponent(btnSalir))
		);
		contentPane.setLayout(gl_contentPane);
	
	}
	
	/**
	 * Método encargado de crear los eventos asignados a los botones y otros controles interactivos.
	 * @author adrSoft
	 * @version 1.0
	 */
	private void createEvents(){
	    
	    	//Botón salir
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		//Botón login
		btnGo.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				check();
			}
		});
		
		//Pulsación de enter
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
	            {
	               check();
	            }
			}
		});
		
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				labelError.setText("");
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
	            {
	               check();
	            }
			}
		});
		
		
	}
	
	/**Método que comprueba si el Email y la Contraseña introducidos corresponden con algún usuario
	 * existente en la base de datos.
	 *  @author adrSoft
	 * @version 1.0
	 */
	@SuppressWarnings("deprecation")
	protected void check() {
		//mail tiene que contener un mail de la base de datos
		textmail = textField.getText();
		textpass = passwordField.getText();
            Query query = session.createQuery("SELECT a FROM Alumnos a");
            
            try{
            	@SuppressWarnings("unchecked")
            	List<Alumnos> alumnos = query.list();    	
         
    	
            
            
	    
            for (Alumnos alumno : alumnos) {
            	if(textmail.equals(alumno.getEmail()) && textpass.equals(alumno.getPassword())){
            		AlumnosMain alu = new AlumnosMain(textmail, alumno.getNombre(), alumno.getApellidos(), alumno.getClub(), alumno.getIdalumno());
					alu.setVisible(true);
					setVisible(false);
            	}
            	else{
            		//Si el login es fallido
            		labelError.setText("El email o la contraseña introducidos no son válidos.");
            	}
            }
            }catch(Exception e){
         		labelError.setText("Error con la conexión a la base de datos.");
         		e.printStackTrace();
         	}
	}

	/**
	 * Inicializador de la conexión entre la aplicación y la base de datos.
	 * @author adrSoft
	 * @version 1.0
	 */
	private void createConnection() {

		SessionFactory sessionFactory;
        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        session = sessionFactory.openSession();
 
   
	
}
}
