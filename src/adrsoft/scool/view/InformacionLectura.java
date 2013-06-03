package adrsoft.scool.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;

public class InformacionLectura extends JInternalFrame {


	/**
	 * Create the frame.
	 */
	public InformacionLectura() {
		setBounds(100, 100, 710, 300);
		
		JButton btnNewButton = new JButton("New button");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(354, Short.MAX_VALUE)
					.addComponent(btnNewButton)
					.addGap(251))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(156, Short.MAX_VALUE)
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
