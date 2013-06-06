package adrsoft.scool.club;


import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.UIManager;
import javax.swing.JLabel;

import javax.swing.JTextArea;

public class Informacion extends JInternalFrame {

    private static final long serialVersionUID = 1L;
    private int mIdClub;
    private JTextArea textArea;

	/**
	 * Create the frame.
	 */
	public Informacion(int idClub) {
	    this.mIdClub = idClub;
	    ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).setNorthPane(null);
		init();
		
	}

	

	private void init() {
	    getContentPane().setBackground(UIManager.getColor("textHighlight"));
		setBounds(100, 100, 710, 300);
		((javax.swing.plaf.basic.BasicInternalFrameUI) 
				getUI()).setNorthPane(null);
		
		JLabel lblNewLabel = new JLabel("Informacion del club"  + mIdClub);
		
		textArea = new JTextArea();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(49)
							.addComponent(lblNewLabel))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(41)
							.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 336, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(323, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(33)
					.addComponent(lblNewLabel)
					.addGap(18)
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(45, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		rellenarInfo();
	}

	private void rellenarInfo() {
	    textArea.setEditable(false);
	   
	    String ajedrez = "Bienvenido al club de ajedrez.\nAquí podras jaquear y matear";
	    String lectura = "Leyendo se conoce gente!";
	    String videojuegos = "Panyum Panyum, derecha, derecha, izquierda, abajo, circulo, triangulo";
	    String atletismo = "Corre Corre.. que te pillo. Atletas unidos!";
	    
	   switch(mIdClub){
	       case 1:	    
	    textArea.setText(ajedrez);
		   break;
	       case 2:
		   textArea.setText(lectura);
		   break;
	       case 3:
		   textArea.setText(videojuegos);
		   break;
	       case 4:
		   textArea.setText(atletismo);
		   break;
	      
		   
	   }
	    
	}
}
