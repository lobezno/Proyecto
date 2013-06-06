package adrsoft.scool.club;


import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

public class Enlaces extends JInternalFrame {


    private static final long serialVersionUID = 1L;

	/**
	 * Create the frame.
	 */
	public Enlaces() {
		setBounds(100, 100, 710, 300);
		
		init();
	}

	private void init() {

		JLabel lblEnlaces = new JLabel("Enlaces");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(20)
					.addComponent(lblEnlaces)
					.addContainerGap(374, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(78)
					.addComponent(lblEnlaces)
					.addContainerGap(173, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	    
	}

}
