package adrsoft.scool.club;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

public class Informacion extends JInternalFrame {


	/**
	 * Create the frame.
	 */
	public Informacion() {
		getContentPane().setBackground(UIManager.getColor("textHighlight"));
		setBounds(100, 100, 710, 300);
		((javax.swing.plaf.basic.BasicInternalFrameUI) 
				getUI()).setNorthPane(null);
		
		JButton btnNewButton = new JButton("New button");
		
		JLabel lblNewLabel = new JLabel("Informacion");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(360, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(251))
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(49)
					.addComponent(lblNewLabel)
					.addContainerGap(605, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(33)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(92))
		);
		getContentPane().setLayout(groupLayout);
		init();
		createEvents();
	}

	private void createEvents() {
	
		
	}

	private void init() {
		
	}
}
