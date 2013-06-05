package adrsoft.scool.club;


import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

public class Fotos extends JInternalFrame {
 
    	private static final long serialVersionUID = 1L;

	/**
	 * Create the frame.
	 */
	public Fotos() {
		setBounds(100, 100, 710, 300);
		((javax.swing.plaf.basic.BasicInternalFrameUI)getUI()).setNorthPane(null);
		init();
	}

	private void init() {
		JLabel lblFotos = new JLabel("Fotos");
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
