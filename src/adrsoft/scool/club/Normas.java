package adrsoft.scool.club;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

public class Normas extends JInternalFrame {

	/**
	 * Create the frame.
	 */
	public Normas() {
		setBounds(100, 100, 450, 300);
		
		JLabel lblNormas = new JLabel("Normas");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(137)
					.addComponent(lblNormas)
					.addContainerGap(257, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(71)
					.addComponent(lblNormas)
					.addContainerGap(180, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}

}
