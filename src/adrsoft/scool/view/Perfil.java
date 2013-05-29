package adrsoft.scool.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;

public class Perfil extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;


	/**
	 * Create the frame.
	 */
	public Perfil() {
		setTitle("Perfil");
		setMaximizable(true);
		setClosable(true);
		setBounds(100, 100, 779, 542);
		
		JScrollPane scrollPane = new JScrollPane();
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
		scrollPane.setViewportView(panelPerfil);
		
		JPanel panelDatos = new JPanel();
		panelDatos.setBorder(new TitledBorder(null, "Datos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel panelBotones = new JPanel();
		GroupLayout gl_panelPerfil = new GroupLayout(panelPerfil);
		gl_panelPerfil.setHorizontalGroup(
			gl_panelPerfil.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelPerfil.createSequentialGroup()
					.addGap(20)
					.addComponent(panelBotones, GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE))
				.addGroup(gl_panelPerfil.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelDatos, GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
					.addGap(10))
		);
		gl_panelPerfil.setVerticalGroup(
			gl_panelPerfil.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelPerfil.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelDatos, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
					.addGap(44)
					.addComponent(panelBotones, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(245, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		
		JLabel lblApellidos = new JLabel("Apellidos");
		
		JLabel lblDireccion = new JLabel("Direccion");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JLabel lblCurso = new JLabel("Curso");
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono");
		
		JLabel lblEmail = new JLabel("Email");
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
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
						.addGroup(gl_panelDatos.createParallelGroup(Alignment.LEADING)
							.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(176)
					.addGroup(gl_panelDatos.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelDatos.createSequentialGroup()
							.addGap(6)
							.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelDatos.createSequentialGroup()
							.addGap(1)
							.addComponent(lblTelefono, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panelDatos.createSequentialGroup()
							.addComponent(lblCurso, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(249, Short.MAX_VALUE))
		);
		gl_panelDatos.setVerticalGroup(
			gl_panelDatos.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelDatos.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelDatos.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelDatos.createSequentialGroup()
							.addGroup(gl_panelDatos.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelDatos.createSequentialGroup()
									.addGap(3)
									.addComponent(lblEmail))
								.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addGroup(gl_panelDatos.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelDatos.createSequentialGroup()
									.addGap(3)
									.addComponent(lblTelefono))
								.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addGroup(gl_panelDatos.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelDatos.createSequentialGroup()
									.addGap(6)
									.addComponent(lblCurso))
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
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
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblDireccion)))))
		);
		panelDatos.setLayout(gl_panelDatos);
		
		JButton btnNewButton = new JButton("New button");
		
		JButton btnNewButton_1 = new JButton("New button");
		GroupLayout gl_panelBotones = new GroupLayout(panelBotones);
		gl_panelBotones.setHorizontalGroup(
			gl_panelBotones.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelBotones.createSequentialGroup()
					.addComponent(btnNewButton)
					.addGap(18)
					.addComponent(btnNewButton_1)
					.addContainerGap(216, Short.MAX_VALUE))
		);
		gl_panelBotones.setVerticalGroup(
			gl_panelBotones.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelBotones.createSequentialGroup()
					.addGroup(gl_panelBotones.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_1))
					.addContainerGap(12, Short.MAX_VALUE))
		);
		panelBotones.setLayout(gl_panelBotones);
		panelPerfil.setLayout(gl_panelPerfil);
		getContentPane().setLayout(groupLayout);
		init();
		createEvents();
	}
	
	private void init(){
		
	}
	private void createEvents(){
		
	}
}
