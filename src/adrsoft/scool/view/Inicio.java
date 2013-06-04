package adrsoft.scool.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridLayout;
import javax.swing.UIManager;
import java.awt.Frame;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import java.awt.Font;
import java.util.List;

import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import adrsoft.scool.pojos.Alumnos;

public class Inicio extends JFrame {

	private JPanel contentPane;
	private final Action action = new SwingAction();
	private JButton btnNewButton;
	private JTextField textField;
	private JPasswordField passwordField;
	private JButton btnNewButton_1;
	private String textmail;
	private Session session;
	private String textpass;
	/**
	 * Launch the application.
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
		setTitle("sCooL");
		createConnection();
		init();
		createEvents();
	
	}
	
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	
	/**
	 * Inicializador
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
		
		btnNewButton = new JButton("");
		
		btnNewButton.setToolTipText("Salir");
		btnNewButton.setBackground(UIManager.getColor("textHighlight"));
		btnNewButton.setIcon(new ImageIcon(Inicio.class.getResource("/adrsoft/scool/resources/images/high/exit.gif")));
		
		JLabel lblUsuario = new JLabel("Email");
		lblUsuario.setFont(new Font("Verdana", Font.BOLD, 18));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setFont(new Font("Verdana", Font.BOLD, 18));
		
		passwordField = new JPasswordField();
		btnNewButton_1 = new JButton("");
		btnNewButton_1.setBackground(UIManager.getColor("textHighlight"));
		btnNewButton_1.setToolTipText("Entar");
		btnNewButton_1.setIcon(new ImageIcon(Inicio.class.getResource("/adrsoft/scool/resources/images/high/accept.png")));
	
	
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(633, Short.MAX_VALUE)
					.addComponent(btnNewButton))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnNewButton_1))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(225)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblUsuario)
								.addComponent(lblContrasea))
							.addGap(38)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
								.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE))))
					.addGap(215))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(266, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUsuario))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblContrasea))
					.addGap(18)
					.addComponent(btnNewButton_1)
					.addGap(74)
					.addComponent(btnNewButton))
		);
		contentPane.setLayout(gl_contentPane);
	
	}
	
	/**
	 * Creador de eventos
	 */
	private void createEvents(){
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		btnNewButton_1.addActionListener(new ActionListener() {
		

			

			public void actionPerformed(ActionEvent arg0) {
				//mail tiene que contener un mail de la base de datos
				textmail = textField.getText();
				textpass = passwordField.getText();
		            Query query = session.createQuery("SELECT a FROM Alumnos a");
		            List<Alumnos> alumnos = query.list();
		            for (Alumnos alumno : alumnos) {
		            	if(textmail.equals(alumno.getEmail()) && textpass.equals(alumno.getPassword())){
		            		AlumnosMain alu = new AlumnosMain(textmail, alumno.getNombre());
							alu.setVisible(true);
							contentPane.setEnabled(false);
							contentPane.setVisible(false);	
						
		            	}
		            }

			}
		});
		
	
		
		
	}
	
	private void createConnection() {
     	
		SessionFactory sessionFactory;
        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        session = sessionFactory.openSession();
	
}

}
