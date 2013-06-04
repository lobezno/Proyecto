package adrsoft.scool.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JToolBar;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyVetoException;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;

public class Club extends JInternalFrame {
	private JButton btnNewButton;
	private JButton btnNewButton_6;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;
	private JDesktopPane clubDesktopPane;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public Club() {
		getContentPane().setBackground(new Color(153, 204, 255));
		((javax.swing.plaf.basic.BasicInternalFrameUI) 
				getUI()).setNorthPane(null);
		init();
		createEvents();


	}

	private void createEvents() {
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InformacionLectura info = new InformacionLectura();
				info.setVisible(true);
				clubDesktopPane.add(info);
					try {
						info.setMaximum(true);
					} catch (PropertyVetoException e2) {
						e2.printStackTrace();
					}
					info.setUI(null);
			}
		});
	
		
	}

	private void init() {
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 204, 255));
		
		clubDesktopPane = new JDesktopPane();
		clubDesktopPane.setBackground(new Color(153, 204, 255));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE)
				.addComponent(clubDesktopPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 708, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(clubDesktopPane, GroupLayout.DEFAULT_SIZE, 439, Short.MAX_VALUE))
		);
		GroupLayout gl_clubDesktopPane = new GroupLayout(clubDesktopPane);
		gl_clubDesktopPane.setHorizontalGroup(
			gl_clubDesktopPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 708, Short.MAX_VALUE)
		);
		gl_clubDesktopPane.setVerticalGroup(
			gl_clubDesktopPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 439, Short.MAX_VALUE)
		);
		clubDesktopPane.setLayout(gl_clubDesktopPane);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBackground(UIManager.getColor("textHighlight"));
		toolBar.setFloatable(false);
		panel.add(toolBar);
		
		btnNewButton = new JButton("Informaci\u00F3n");

		
		btnNewButton.setFont(new Font("Verdana", Font.BOLD, 12));
		btnNewButton.setBackground(UIManager.getColor("activeCaption"));
		toolBar.add(btnNewButton);
		
		JSeparator separator = new JSeparator();
		toolBar.add(separator);
		
		btnNewButton_6 = new JButton("Normas");
		btnNewButton_6.setFont(new Font("Verdana", Font.BOLD, 12));
		btnNewButton_6.setBackground(UIManager.getColor("activeCaption"));
		toolBar.add(btnNewButton_6);
		
		btnNewButton_1 = new JButton("Noticias");
		btnNewButton_1.setFont(new Font("Verdana", Font.BOLD, 12));
		btnNewButton_1.setBackground(UIManager.getColor("activeCaption"));
		toolBar.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Miembros");
		btnNewButton_2.setFont(new Font("Verdana", Font.BOLD, 12));
		btnNewButton_2.setBackground(UIManager.getColor("activeCaption"));
		toolBar.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("Inventario");
		btnNewButton_3.setFont(new Font("Verdana", Font.BOLD, 12));
		btnNewButton_3.setBackground(UIManager.getColor("activeCaption"));
		toolBar.add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("Fotos");
		btnNewButton_4.setFont(new Font("Verdana", Font.BOLD, 12));
		btnNewButton_4.setBackground(UIManager.getColor("activeCaption"));
		toolBar.add(btnNewButton_4);
		
		btnNewButton_5 = new JButton("Enlaces");
		btnNewButton_5.setFont(new Font("Verdana", Font.BOLD, 12));
		btnNewButton_5.setBackground(UIManager.getColor("activeCaption"));
		toolBar.add(btnNewButton_5);
		getContentPane().setLayout(groupLayout);
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(100, 100, 710, 523);
		
	}
}
