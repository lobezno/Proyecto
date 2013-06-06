package adrsoft.scool.club;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

public class Inventario extends JInternalFrame {

    	private static final long serialVersionUID = 1L;

	/**
	 * Create the frame.
	 */
	public Inventario() {
		setBounds(100, 100, 710, 300);
		((javax.swing.plaf.basic.BasicInternalFrameUI)getUI()).setNorthPane(null);
		
		init();
	}

	private void init() {
	    JLabel lblNewLabel = new JLabel("Inventario");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(124)
					.addComponent(lblNewLabel)
					.addContainerGap(270, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(71)
					.addComponent(lblNewLabel)
					.addContainerGap(180, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	    
	}

}
