package adrsoft.scool.club;


import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.UIManager;
import javax.swing.JLabel;

import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Insets;

public class Informacion extends JInternalFrame {

    /*
     * Campos
     */
    private static final long serialVersionUID = 1L;
    private int mIdClub;
    private JTextArea textArea;

	/**
	 * Constructor de la clase con un argumento, idClub, que es el club del usuario activo.
	 * @author adrSoft
	 * @version 1.0
	 * @param idClub = Identificador del club al que pertenece el usuario activo.
	 */
	public Informacion(int idClub) {
	    this.mIdClub = idClub;
	    ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).setNorthPane(null);
		init();
		
	}

	

	/**
	 * Inicializador de los componentes en el JFrame.
	 * @author adrSoft
	 * @version 1.0
	 */
	private void init() {
	    getContentPane().setBackground(UIManager.getColor("textHighlight"));
		setBounds(100, 100, 710, 300);
		((javax.swing.plaf.basic.BasicInternalFrameUI) 
				getUI()).setNorthPane(null);
		
		JLabel lblNewLabel = new JLabel("Informaci\u00F3n");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 20));
		lblNewLabel.setForeground(Color.BLUE);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Verdana", Font.PLAIN, 15));
		textArea.setLineWrap(true);
		textArea.setColumns(1);
		textArea.setBackground(new Color(153, 204, 255));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(41)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 616, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addContainerGap(37, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);
		rellenarInfo();
	}

	/**
	 * Método encargado de rellenar la información relevante del club seleccionado.
	 * <br>
	 * Dependiendo del parámetro idClub recogido en el constructor, mostrará un texto u otro.
	 * 
	 * @author adrSoft
	 * @version 1.0
	 */
	private void rellenarInfo() {
	    textArea.setEditable(false);
	   
	    String ajedrez = "Bienvenido al club de ajedrez.\nAquí podras jaquear y matear.\nLa calidad humana es una virtud escasa a pesar de encontrarnos en la era de la cibernética; no obstante, me llena de entusiasmo descubrir a un grupo de amigos que han reunido todo su esfuerzo para transmitir la esperanza de que es posible aunar nobleza y corazón, junto a la honestidad deportiva presente siempre en el Ajedrez.";
	    String lectura = "Leyendo se conoce gente!";
	    String videojuegos = "Panyum Panyum, derecha, derecha, izquierda, abajo, circulo, triangulo";
	    String atletismo = "Corre Corre.. que te pillo. Atletas unidos!";
	    
	   switch(mIdClub){
	       case 1:	    
	    textArea.setText(ajedrez);
		   break;
	       case 2:
		   textArea.setText(atletismo);
		   break;
	       case 3:
		   textArea.setText(videojuegos);
		   break;
	       case 4:
		   textArea.setText(lectura);
		   break;
	      
		   
	   }
	    
	}
}
