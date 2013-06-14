package adrsoft.scool.view;


import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import adrsoft.scool.pojos.Alumnos;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.util.List;
import java.awt.Color;


/**
 * Clase instanciadora del perfil del usuario activo.<br><br>
 * Dentro de esta vista, podemos ver los datos del usuario, editarlos y actualizarlos en la 
 * base de datos y cambiar la contraseña de acceso del usuario.
 * @author adrSoft
 * @version vAlpha10
 *
 */
public class Perfil extends JInternalFrame {
    	
    	/*
    	 * Campos
    	 */
    	private static final long serialVersionUID = 1L;
	private JTextField cajaNombre;
	private JTextField cajaDireccion;
	private JTextField cajaApellidos;
	private JTextField cajaCurso;
	private JTextField cajaTelefono;
	private JTextField cajaEmail;
	private JButton btnEditar;
	private JButton btnGuardar;
	private Session session;
	private int idalumno;
	private JLabel lblWarning;
	private JButton btnPassword;
	private String newPass = null;
	private String tema;
	private JPanel panelPerfil;
	private JPanel panelDatos;
	private JPanel panelBotones;
	private JButton btnCancelar;
	
	/**
	 * Constructor de la clase. Se encarga de inicializar los argumentos y los demás componentes del frame.
	 * @author adrSoft
	 * @version vAlpha10
	 */
	public Perfil(int id, String tem) {
		setFrameIcon(new ImageIcon(Perfil.class.getResource("/adrsoft/scool/resources/images/high/milogo3.png")));
		setBackground(UIManager.getColor("textHighlight"));
		setBorder(null);
		
//		setBounds(100, 100, 710, 622);
		this.idalumno = id;
		this.tema = tem;
		((javax.swing.plaf.basic.BasicInternalFrameUI)getUI()).setNorthPane(null);
		init();
		pintarTema(tema);
		createEvents();
	}


	/**
	 * Método encargado de renderizar el aspecto visual en relación con el tema escogido.
	 * @author adrSoft
	 * @version vAlpha10
	 * @param tema = Tema seleccionado en la barra de herramientas.
	 */
	private void pintarTema(String tema) {
		if(tema.equals("classic")){
			panelPerfil.setBackground(UIManager.getColor("textHighlight"));
			panelDatos.setBackground(new Color(153, 204, 255));
			panelBotones.setBackground(UIManager.getColor("textHighlight"));
			getContentPane().setBackground(UIManager.getColor("textHighlight"));
		}
		else if(tema.equals("oscuro")){
			panelPerfil.setBackground(Color.BLACK);
			panelDatos.setBackground(Color.GRAY);
			panelBotones.setBackground(Color.BLACK);
			getContentPane().setBackground(Color.BLACK);
		
		}
		else if(tema.equals("claro")){
			panelPerfil.setBackground(new Color(255, 255, 102));
			panelDatos.setBackground(new Color(255, 255, 204));
			panelBotones.setBackground(new Color(255, 255, 102));
			getContentPane().setBackground(new Color(255, 255, 102));
		}
		
		
	}


	/**
	 * Inicializador de los componentes en el JInternalFrame.
	 * @author adrSoft
	 * @version vAlpha10
	 */
	private void init(){
		
				panelPerfil = new JPanel();
				panelPerfil.setBackground(UIManager.getColor("textHighlight"));
				
						panelDatos = new JPanel();
						panelDatos.setBackground(UIManager.getColor("activeCaption"));
						panelDatos.setBorder(new TitledBorder(null, "Datos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
						
								panelBotones = new JPanel();
								panelBotones.setBackground(UIManager.getColor("activeCaption"));
								
								lblWarning = new JLabel(" ");
								lblWarning.setForeground(Color.RED);
								
										JLabel lblNewLabel = new JLabel("Nombre");
										
												JLabel lblApellidos = new JLabel("Apellidos");
												
														JLabel lblDireccion = new JLabel("Direccion");
														
																cajaNombre = new JTextField();
																cajaNombre.setHorizontalAlignment(SwingConstants.CENTER);
																cajaNombre.setBackground(UIManager.getColor("activeCaption"));
																cajaNombre.setEditable(false);
																cajaNombre.setColumns(10);
																
																		cajaDireccion = new JTextField();
																		cajaDireccion.setHorizontalAlignment(SwingConstants.CENTER);
																		cajaDireccion.setBackground(UIManager.getColor("activeCaption"));
																		cajaDireccion.setEditable(false);
																		cajaDireccion.setColumns(10);
																		
																				cajaApellidos = new JTextField();
																				cajaApellidos.setHorizontalAlignment(SwingConstants.CENTER);
																				cajaApellidos.setBackground(UIManager.getColor("activeCaption"));
																				cajaApellidos.setEditable(false);
																				cajaApellidos.setColumns(10);
																				
																						cajaCurso = new JTextField();
																						cajaCurso.setHorizontalAlignment(SwingConstants.CENTER);
																						cajaCurso.setBackground(UIManager.getColor("activeCaption"));
																						cajaCurso.setEditable(false);
																						cajaCurso.setColumns(10);
																						
																								JLabel lblCurso = new JLabel("Curso");
																								
																										cajaTelefono = new JTextField();
																										cajaTelefono.setHorizontalAlignment(SwingConstants.CENTER);
																										cajaTelefono.setBackground(UIManager.getColor("activeCaption"));
																										cajaTelefono.setEditable(false);
																										cajaTelefono.setColumns(10);
																										
																												JLabel lblTelefono = new JLabel("Telefono");
																												
																														JLabel lblEmail = new JLabel("Email");
																														
																																cajaEmail = new JTextField();
																																cajaEmail.setHorizontalAlignment(SwingConstants.CENTER);
																																cajaEmail.setBackground(UIManager.getColor("activeCaption"));
																																cajaEmail.setEditable(false);
																																cajaEmail.setColumns(10);
																																
																																		JLabel lblNewLabel_1 = new JLabel("");
																																		lblNewLabel_1.setIcon(new ImageIcon(Perfil.class.getResource("/adrsoft/scool/resources/images/high/user.png")));
																																		GroupLayout gl_panelDatos = new GroupLayout(panelDatos);
																																		gl_panelDatos.setHorizontalGroup(
																																			gl_panelDatos.createParallelGroup(Alignment.LEADING)
																																				.addGroup(gl_panelDatos.createSequentialGroup()
																																					.addContainerGap()
																																					.addGroup(gl_panelDatos.createParallelGroup(Alignment.LEADING)
																																						.addComponent(lblDireccion, Alignment.TRAILING)
																																						.addComponent(lblApellidos, Alignment.TRAILING)
																																						.addComponent(lblNewLabel, Alignment.TRAILING))
																																					.addGap(18)
																																					.addGroup(gl_panelDatos.createParallelGroup(Alignment.LEADING)
																																						.addComponent(cajaApellidos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																																						.addComponent(cajaNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																																						.addComponent(cajaDireccion, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE))
																																					.addGap(10)
																																					.addGroup(gl_panelDatos.createParallelGroup(Alignment.LEADING)
																																						.addGroup(gl_panelDatos.createSequentialGroup()
																																							.addGap(6)
																																							.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
																																						.addGroup(gl_panelDatos.createSequentialGroup()
																																							.addGap(1)
																																							.addComponent(lblTelefono, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
																																						.addComponent(lblCurso, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
																																					.addGap(47)
																																					.addGroup(gl_panelDatos.createParallelGroup(Alignment.LEADING)
																																						.addComponent(cajaEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																																						.addComponent(cajaTelefono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																																						.addComponent(cajaCurso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
																																					.addGap(34)
																																					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
																																					.addContainerGap(70, Short.MAX_VALUE))
																																		);
																																		gl_panelDatos.setVerticalGroup(
																																			gl_panelDatos.createParallelGroup(Alignment.LEADING)
																																				.addGroup(gl_panelDatos.createSequentialGroup()
																																					.addGroup(gl_panelDatos.createParallelGroup(Alignment.LEADING)
																																						.addGroup(gl_panelDatos.createSequentialGroup()
																																							.addContainerGap()
																																							.addGroup(gl_panelDatos.createParallelGroup(Alignment.LEADING)
																																								.addGroup(gl_panelDatos.createParallelGroup(Alignment.TRAILING)
																																									.addGroup(gl_panelDatos.createSequentialGroup()
																																										.addComponent(lblEmail)
																																										.addGap(14)
																																										.addComponent(lblTelefono)
																																										.addGap(17)
																																										.addComponent(lblCurso))
																																									.addGroup(gl_panelDatos.createSequentialGroup()
																																										.addGroup(gl_panelDatos.createParallelGroup(Alignment.BASELINE)
																																											.addComponent(lblNewLabel)
																																											.addComponent(cajaNombre, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
																																										.addPreferredGap(ComponentPlacement.UNRELATED)
																																										.addGroup(gl_panelDatos.createParallelGroup(Alignment.BASELINE)
																																											.addComponent(lblApellidos)
																																											.addComponent(cajaApellidos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
																																										.addPreferredGap(ComponentPlacement.UNRELATED)
																																										.addGroup(gl_panelDatos.createParallelGroup(Alignment.TRAILING)
																																											.addComponent(lblDireccion)
																																											.addComponent(cajaDireccion, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
																																								.addGroup(gl_panelDatos.createSequentialGroup()
																																									.addComponent(cajaEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																																									.addGap(11)
																																									.addComponent(cajaTelefono, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																																									.addGap(11)
																																									.addComponent(cajaCurso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
																																						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
																																					.addContainerGap(36, Short.MAX_VALUE))
																																		);
																																		panelDatos.setLayout(gl_panelDatos);
																																		
																																				btnEditar = new JButton("Editar Perfil");
																																				btnEditar.setBackground(UIManager.getColor("textHighlight"));
																																				btnEditar.setIcon(new ImageIcon(Perfil.class.getResource("/adrsoft/scool/resources/images/low/edit.png")));
																																				
																																						btnGuardar = new JButton("Guardar");
																																						
																																								btnGuardar.setBackground(UIManager.getColor("textHighlight"));
																																								btnGuardar.setMaximumSize(new Dimension(87, 23));
																																								btnGuardar.setIcon(new ImageIcon(Perfil.class.getResource("/adrsoft/scool/resources/images/low/save.png")));
																																								
																																										btnGuardar.setVisible(false);
																																										
																																										btnPassword = new JButton("Cambiar Contrase\u00F1a");
																																										btnPassword.setIcon(new ImageIcon(Perfil.class.getResource("/adrsoft/scool/resources/images/mid/key.png")));
																																										btnPassword.setVisible(false);
																																										
																																										btnCancelar = new JButton("Cancelar");
																																										btnCancelar.setVisible(false);
																																										
																																												btnCancelar.setIcon(new ImageIcon(Perfil.class.getResource("/adrsoft/scool/resources/images/low/cancel.png")));
																																												GroupLayout gl_panelPerfil = new GroupLayout(panelPerfil);
																																												gl_panelPerfil.setHorizontalGroup(
																																													gl_panelPerfil.createParallelGroup(Alignment.LEADING)
																																														.addGroup(gl_panelPerfil.createSequentialGroup()
																																															.addGap(10)
																																															.addGroup(gl_panelPerfil.createParallelGroup(Alignment.LEADING)
																																																.addComponent(panelDatos, GroupLayout.PREFERRED_SIZE, 644, GroupLayout.PREFERRED_SIZE)
																																																.addComponent(panelBotones, GroupLayout.PREFERRED_SIZE, 644, GroupLayout.PREFERRED_SIZE)
																																																.addComponent(lblWarning, GroupLayout.PREFERRED_SIZE, 409, GroupLayout.PREFERRED_SIZE)))
																																												);
																																												gl_panelPerfil.setVerticalGroup(
																																													gl_panelPerfil.createParallelGroup(Alignment.LEADING)
																																														.addGroup(gl_panelPerfil.createSequentialGroup()
																																															.addGap(11)
																																															.addComponent(panelDatos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																																															.addGap(6)
																																															.addComponent(panelBotones, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																																															.addGap(6)
																																															.addComponent(lblWarning, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))
																																												);
																																												GroupLayout gl_panelBotones = new GroupLayout(panelBotones);
																																												gl_panelBotones.setHorizontalGroup(
																																													gl_panelBotones.createParallelGroup(Alignment.LEADING)
																																														.addGroup(gl_panelBotones.createSequentialGroup()
																																															.addComponent(btnEditar, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
																																															.addComponent(btnGuardar, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
																																															.addComponent(btnPassword, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE)
																																															.addComponent(btnCancelar, GroupLayout.PREFERRED_SIZE, 161, GroupLayout.PREFERRED_SIZE))
																																												);
																																												gl_panelBotones.setVerticalGroup(
																																													gl_panelBotones.createParallelGroup(Alignment.LEADING)
																																														.addComponent(btnEditar)
																																														.addComponent(btnGuardar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																																														.addComponent(btnPassword)
																																														.addComponent(btnCancelar)
																																												);
																																												panelBotones.setLayout(gl_panelBotones);
																																												panelPerfil.setLayout(gl_panelPerfil);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(22)
					.addComponent(panelPerfil, GroupLayout.PREFERRED_SIZE, 673, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(663, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelPerfil, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(54, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	
	}



	/**
	 * Método encargado de crear los eventos asignados a los botones y otros controles interactivos.
	 * @author adrSoft
	 * @version vAlpha10
	 */
	private void createEvents(){

		//Botón Editar
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cajaNombre.setEditable(true);
				cajaApellidos.setEditable(true);
				cajaDireccion.setEditable(true);
				cajaEmail.setEditable(true);
				cajaCurso.setEditable(true);
				cajaTelefono.setEditable(true);
				btnGuardar.setVisible(true);
				btnPassword.setVisible(true);
				btnEditar.setVisible(false);
				btnCancelar.setVisible(true);
				
			}
		});

		//Botón guardar
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cajaNombre.setEditable(false);
				cajaApellidos.setEditable(false);
				cajaDireccion.setEditable(false);
				cajaEmail.setEditable(false);
				cajaCurso.setEditable(false);
				cajaTelefono.setEditable(false);
				btnGuardar.setVisible(false);
				btnPassword.setVisible(false);
				btnEditar.setVisible(true);
				btnCancelar.setVisible(false);
				conexion();
				String newNombre = cajaNombre.getText();
				String newApe = cajaApellidos.getText();
				String newDire = cajaDireccion.getText();
				String newMail = cajaEmail.getText();
				String newCurso = cajaCurso.getText();
				String newTele = cajaTelefono.getText();
				
				  Query query = session.createQuery("SELECT a FROM Alumnos a WHERE idalumno="+  idalumno);
		            @SuppressWarnings("unchecked")
			    List<Alumnos> alumnos = query.list();
		            for (Alumnos alumno : alumnos) {
		            	
		            	alumno.setNombre(newNombre);
		            	alumno.setApellidos(newApe);
		            	alumno.setDireccion(newDire);
		            	alumno.setEmail(newMail);
		            	alumno.setCurso(newCurso);
		            	alumno.setTelefono(Integer.parseInt(newTele));
		            	if(newPass!=null){
		            		alumno.setPassword(newPass);	
		            	}
		            	
		            	Transaction tx = session.beginTransaction();
		            	session.saveOrUpdate(alumno);
		            	tx.commit();
		            	
		            }
		            lblWarning.setText("Debes volver a logearte para ver tus datos modificados.");
		     
						}
			
				
		});
		
		//Boton de cambio de Password
		btnPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 newPass = JOptionPane.showInputDialog("Introduce la nueva contraseña");

			}
		});

		//Boton Cancelar
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cajaNombre.setEditable(false);
				cajaApellidos.setEditable(false);
				cajaDireccion.setEditable(false);
				cajaEmail.setEditable(false);
				cajaCurso.setEditable(false);
				cajaTelefono.setEditable(false);
				btnGuardar.setVisible(false);
				btnPassword.setVisible(false);
				btnCancelar.setVisible(false);
				btnEditar.setVisible(true);
				rellenarPerfil();
				
			}
		});
	}

	/**
	 * Método encargado de rellenar los campos de texto de la ficha de perfil del usuario.
	 * 
	 * El usuario es filtrado por su id.
	 * @author adrSoft
	 * @version vAlpha10
	 * @param idalumno = Número entero identificador del usuario activo
	 */
	protected void rellenarPerfil() {

        conexion();
        Query query = session.createQuery("SELECT a FROM Alumnos a WHERE idalumno="+  idalumno);
        @SuppressWarnings("unchecked")
	List<Alumnos> alumnos = query.list();
        for (Alumnos alumno : alumnos) {
            setNombreText(alumno.getNombre());
            setApellidosText(alumno.getApellidos());
            setDireccionText(alumno.getDireccion());
            setEmailText(alumno.getEmail());
            setCursoText(alumno.getCurso());
            setTelefonoText(String.valueOf(alumno.getTelefono()));
        }
	
	}


	/**
	 * Inicializador de la conexión entre la aplicación y la base de datos.
	 * @author adrSoft
	 * @version vAlpha10
	 */
	protected void conexion() {
		SessionFactory sessionFactory;
        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        session = sessionFactory.openSession();
		
	}


	/*
	 * Getters y Setters
	 */
	public void setNombreText(String nombre){
		this.cajaNombre.setText(nombre);
	}

	public void setApellidosText(String ape){
		this.cajaApellidos.setText(ape);
	}

	public void setDireccionText(String dire){
		this.cajaDireccion.setText(dire);
	}
	public void setEmailText(String mail){
		this.cajaEmail.setText(mail);
	}

	public void setTelefonoText(String tele){
		this.cajaTelefono.setText(tele);
	}
	public void setCursoText(String curso){
		this.cajaCurso.setText(curso);
	}
}