package adrsoft.scool.club;

import java.awt.EventQueue;

import javax.swing.GroupLayout;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.GroupLayout.Alignment;

public class Miembros extends JInternalFrame {



	/**
	 * Create the frame.
	 */
	public Miembros() {
		setBounds(100, 100, 450, 300);

		JLabel lblFotos = new JLabel("Miembros");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(164)
					.addComponent(lblFotos)
					.addContainerGap(230, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(59)
					.addComponent(lblFotos)
					.addContainerGap(192, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}

}
