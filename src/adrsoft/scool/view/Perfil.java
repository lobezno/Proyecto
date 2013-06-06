package adrsoft.scool.view;

<<<<<<< HEAD
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.beans.PropertyVetoException;
import java.io.File;
import java.util.List;

import javax.imageio.ImageIO;
=======

>>>>>>> 8c373a3df131013fcf04fc1d20e0fe1764e902a6
import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
<<<<<<< HEAD
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
=======
import javax.swing.JLabel;
>>>>>>> 8c373a3df131013fcf04fc1d20e0fe1764e902a6
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.ScrollPaneConstants;
<<<<<<< HEAD

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import adrsoft.scool.pojos.Alumnos;
=======
>>>>>>> 8c373a3df131013fcf04fc1d20e0fe1764e902a6
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
<<<<<<< HEAD
import java.awt.SystemColor;

public class Perfil extends JInternalFrame {
=======


public class Perfil extends JInternalFrame {

    	private static final long serialVersionUID = 1L;
>>>>>>> 8c373a3df131013fcf04fc1d20e0fe1764e902a6
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JButton btnNewButton;
	private JButton btnNewButton_1;


	/**
	 * Create the frame.
	 */
	public Perfil() {
		setBackground(UIManager.getColor("activeCaption"));
		setBorder(null);
		setBounds(100, 100, 710, 622);
		((javax.swing.plaf.basic.BasicInternalFrameUI) 
				getUI()).setNorthPane(null);
		init();
<<<<<<< HEAD
//		conexion();
		createEvents();
	}

	private void conexion() {
		SessionFactory sessionFactory;
		Configuration configuration = new Configuration();
		configuration.configure();
		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session session=sessionFactory.openSession();

	}
=======
		createEvents();
	}

>>>>>>> 8c373a3df131013fcf04fc1d20e0fe1764e902a6

	private void init(){
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
		);

		JPanel panelPerfil = new JPanel();
		panelPerfil.setBackground(UIManager.getColor("activeCaption"));
		scrollPane.setViewportView(panelPerfil);

		JPanel panelDatos = new JPanel();
		panelDatos.setBackground(UIManager.getColor("activeCaption"));
		panelDatos.setBorder(new TitledBorder(null, "Datos", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		JPanel panelBotones = new JPanel();
		panelBotones.setBackground(UIManager.getColor("activeCaption"));
		GroupLayout gl_panelPerfil = new GroupLayout(panelPerfil);
		gl_panelPerfil.setHorizontalGroup(
			gl_panelPerfil.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelPerfil.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelPerfil.createParallelGroup(Alignment.LEADING)
						.addComponent(panelDatos, GroupLayout.PREFERRED_SIZE, 659, GroupLayout.PREFERRED_SIZE)
						.addComponent(panelBotones, GroupLayout.PREFERRED_SIZE, 651, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(1495, Short.MAX_VALUE))
		);
		gl_panelPerfil.setVerticalGroup(
			gl_panelPerfil.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelPerfil.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelDatos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelBotones, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(676, Short.MAX_VALUE))
		);

		JLabel lblNewLabel = new JLabel("Nombre");

		JLabel lblApellidos = new JLabel("Apellidos");

		JLabel lblDireccion = new JLabel("Direccion");

		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBackground(UIManager.getColor("activeCaption"));
		textField.setEditable(false);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setBackground(UIManager.getColor("activeCaption"));
		textField_1.setEditable(false);
		textField_1.setColumns(10);

		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setBackground(UIManager.getColor("activeCaption"));
		textField_2.setEditable(false);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setBackground(UIManager.getColor("activeCaption"));
		textField_3.setEditable(false);
		textField_3.setColumns(10);

		JLabel lblCurso = new JLabel("Curso");

		textField_4 = new JTextField();
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setBackground(UIManager.getColor("activeCaption"));
		textField_4.setEditable(false);
		textField_4.setColumns(10);

		JLabel lblTelefono = new JLabel("Telefono");

		JLabel lblEmail = new JLabel("Email");

		textField_5 = new JTextField();
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setBackground(UIManager.getColor("activeCaption"));
		textField_5.setEditable(false);
		textField_5.setColumns(10);

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
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE))
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
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(87)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(115, Short.MAX_VALUE))
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
											.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(gl_panelDatos.createParallelGroup(Alignment.BASELINE)
											.addComponent(lblApellidos)
											.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addGroup(gl_panelDatos.createParallelGroup(Alignment.TRAILING)
											.addComponent(lblDireccion)
											.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
								.addGroup(gl_panelDatos.createSequentialGroup()
									.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(11)
									.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(11)
									.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(36, Short.MAX_VALUE))
		);
		panelDatos.setLayout(gl_panelDatos);

		btnNewButton = new JButton("Editar Perfil");
		btnNewButton.setBackground(UIManager.getColor("textHighlight"));
		btnNewButton.setIcon(new ImageIcon(Perfil.class.getResource("/adrsoft/scool/resources/images/low/edit.png")));

		btnNewButton_1 = new JButton("Guardar");
		btnNewButton_1.setBackground(UIManager.getColor("textHighlight"));
		btnNewButton_1.setMaximumSize(new Dimension(87, 23));
		btnNewButton_1.setIcon(new ImageIcon(Perfil.class.getResource("/adrsoft/scool/resources/images/low/save.png")));

		btnNewButton_1.setVisible(false);


		GroupLayout gl_panelBotones = new GroupLayout(panelBotones);
		gl_panelBotones.setHorizontalGroup(
			gl_panelBotones.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelBotones.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(510, Short.MAX_VALUE))
		);
		gl_panelBotones.setVerticalGroup(
			gl_panelBotones.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelBotones.createSequentialGroup()
					.addGroup(gl_panelBotones.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panelBotones.setLayout(gl_panelBotones);
		panelPerfil.setLayout(gl_panelPerfil);
		getContentPane().setLayout(groupLayout);

		rellenarPerfil();
	}
	private void rellenarPerfil() {

      
        }



	private void createEvents(){

		//Botón Editar
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setEditable(true);
				textField_1.setEditable(true);
				textField_2.setEditable(true);
				textField_3.setEditable(true);
				textField_4.setEditable(true);
				textField_5.setEditable(true);
				btnNewButton_1.setVisible(true);
			}
		});

		//Botón guardar
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setEditable(false);
				textField_1.setEditable(false);
				textField_2.setEditable(false);
				textField_3.setEditable(false);
				textField_4.setEditable(false);
				textField_5.setEditable(false);
				btnNewButton_1.setVisible(false);
			}
		});

	}

	public void setNombreText(String nombre){
		this.textField.setText(nombre);
	}

	public void setApellidosText(String ape){
		this.textField_2.setText(ape);
	}

	public void setDireccionText(String dire){
		this.textField_1.setText(dire);
	}
	public void setEmailText(String mail){
		this.textField_5.setText(mail);
	}

	public void setTelefonoText(String tele){
		this.textField_4.setText(tele);
	}
	public void setCursoText(String curso){
		this.textField_3.setText(curso);
	}
}