package adrsoft.scool.view;



import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Mensajes extends JInternalFrame {
    	private static final long serialVersionUID = 1L;
    	private JButton btnNewButton;
    	private JButton btnContactarConTutor;
    	

	/**
	 * Create the frame.
	 */
	public Mensajes() {
		init();
		createEvents();
		((javax.swing.plaf.basic.BasicInternalFrameUI) 
				getUI()).setNorthPane(null);

	
	}


	private void createEvents() {
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showConfirmDialog(null, "Funci�n no implementada a�n.\nEstar� disponible en un corto periodo de tiempo.","Oops..",JOptionPane.DEFAULT_OPTION);
			}
		});
		
		btnContactarConTutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showConfirmDialog(null, "Funci�n no implementada a�n.\nEstar� disponible en un corto periodo de tiempo.","Oops..",JOptionPane.DEFAULT_OPTION);
			}
		});
		
	}


	private void init() {
		setBackground(UIManager.getColor("textHighlight"));
		getContentPane().setBackground(UIManager.getColor("textHighlight"));
		setBounds(100, 100, 710, 410);
		setBorder(null);
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(UIManager.getColor("textHighlight"));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
		);
		
		tabbedPane.setBackground(UIManager.getColor("activeCaption"));
		JPanel panel = new JPanel();
		
		panel.setBackground(new Color(153, 204, 255));
		tabbedPane.addTab("Buz�n de entrada", null, panel, null);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 705, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 346, Short.MAX_VALUE)
		);
		panel.setLayout(gl_panel);
		tabbedPane.setIconAt(0,new ImageIcon(Mensajes.class.getResource("/adrsoft/scool/resources/images/low/mail_receive.png")));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(153, 204, 255));
		
		tabbedPane.addTab("Mensajes enviados", null, panel_1, null);
		
		JButton btnNewButton_1 = new JButton("New button");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap(420, Short.MAX_VALUE)
					.addComponent(btnNewButton_1)
					.addGap(74))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(109)
					.addComponent(btnNewButton_1)
					.addContainerGap(211, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		tabbedPane.setIconAt(1,new ImageIcon(Mensajes.class.getResource("/adrsoft/scool/resources/images/low/mail_send.png")));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(153, 204, 255));
		tabbedPane.addTab("", null, panel_2, null);
		
		btnNewButton = new JButton("Enviar Mensaje");

		btnContactarConTutor = new JButton("Contactar con Tutor");
	
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(121)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addComponent(btnContactarConTutor, GroupLayout.PREFERRED_SIZE, 413, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 413, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(171, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(69)
					.addComponent(btnNewButton)
					.addGap(18)
					.addComponent(btnContactarConTutor)
					.addContainerGap(213, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		tabbedPane.setIconAt(2,new ImageIcon(Mensajes.class.getResource("/adrsoft/scool/resources/images/low/mail.png")));
		

		getContentPane().setLayout(groupLayout);

		
	}
}
