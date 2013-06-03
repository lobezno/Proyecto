package adrsoft.scool.view;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.JTable;

public class Mensajes extends JInternalFrame {
	private JTable table;


	/**
	 * Create the frame.
	 */
	public Mensajes() {
		setBackground(UIManager.getColor("textHighlight"));
		getContentPane().setBackground(UIManager.getColor("textHighlight"));
		setBounds(100, 100, 710, 410);
		
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
		
		panel.setBackground(UIManager.getColor("activeCaption"));
		tabbedPane.addTab("Buzón de entrada", null, panel, null);
		
		table = new JTable();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(table, GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addGap(20)
					.addComponent(table, GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		tabbedPane.setIconAt(0,new ImageIcon(Mensajes.class.getResource("/adrsoft/scool/resources/images/low/mail_receive.png")));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(UIManager.getColor("activeCaption"));
		
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

		

		getContentPane().setLayout(groupLayout);

	
	}
}
