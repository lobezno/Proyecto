package adrsoft.scool.club;


import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.UIManager;
import javax.swing.JLabel;

import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

/**
 * Clase instanciadora de las normas del club del usuario. Depende de a que club pertenezca,
 * aparecerán unas normas u otras.
 * @author adrSoft
 * @version vAlpha10
 *
 */
public class Normas extends JInternalFrame {

    private static final long serialVersionUID = 1L;
    private int mIdClub;
    private JTextArea textArea;

    /**
	 * Constructor de la clase con un argumento, idClub, que es el club del usuario activo.
	 * @author adrSoft
	 * @version vAlpha10
	 * @param idClub = Identificador del club al que pertenece el usuario activo.
     * @param tema 
	 */
	public Normas(int idClub, String tema) {
	    this.mIdClub = idClub;
	    ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).setNorthPane(null);
		init();
		pintarTema(tema);
	}

	
	/**
	 * Inicializador de los componentes en el JFrame.
	 * @author adrSoft
	 * @version vAlpha10
	 */
	private void init() {
	    getContentPane().setBackground(UIManager.getColor("textHighlight"));
		setBounds(100, 100, 710, 300);
		((javax.swing.plaf.basic.BasicInternalFrameUI) 
				getUI()).setNorthPane(null);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Verdana", Font.PLAIN, 15));
		textArea.setBackground(new Color(153, 204, 255));
		
		JLabel lblNormas = new JLabel("Normas");
		lblNormas.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNormas.setForeground(Color.BLUE);
		lblNormas.setFont(new Font("Verdana", Font.BOLD, 20));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(41)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 616, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNormas, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(37, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblNormas, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);
		rellenarInfo();
	}

	/**
	 * Método encargado de rellenar las normas del club del usuario.
	 * <br>
	 * Dependiendo del parámetro idClub recogido en el constructor, mostrará unas normas u otras.
	 * 
	 * @author adrSoft
	 * @version vAlpha10
	 */
	private void rellenarInfo() {
	    textArea.setEditable(false);
	   
	    String ajedrez = "\nNormas del club Jaque Mate:\n\n\t- Sé respetuoso con todo el mundo.\n\n\t- Cuida el material que manejas.\n\n\t- No te alteres por el resultado de las partidas. Es solo un juego.\n\n\t- Hazte responsable de tus obligaciones relacionadas con tu rango.\n\n\t- Disfruta!!";
	    String lectura = "\nNormas del club MundoLibro:\n\n\t- Respeta a todas las personas.\n\n\t- Cuida bien los libros, son tus amigos!\n\n\t- Si te llevas un libro, hazselo saber a su propietario.\n\n\t- Lleva un registro concienzudo de las entradsa y salidas de libros.\n\n\t- Respeta las criticas de los demás.";
	    String videojuegos = "\nNormas del club ExtraLife:\n\n\t- Sé respetuoso con las demás personas. Tratalas como te\n\t gustaría que te tratasen a tí.\n\n\t- No te ofusques con los juegos. No son más que eso, juegos.\n\n\t- No incites al malestar a las demás personas. \n\n\t- Si quieres llevarte algun juego, actializa la hoja de inventario\n\t y comunicaselo al presidente y al propietario. \n\n\t- Disfruta!";
	    String atletismo = "\nNormas del club MundoLibro:\n\n\t- Respeta a todo el mundo.\n\n\t- Ayuda a los lesionados.\n\n\t- Duchate una vez acabada la actividad física. \n\n\t- Habla con tu superior si quieres retar a alguien a una carrera.";
	    
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
	
	 /**
	 * Método encargado de renderizar el aspecto visual en relación con el tema escogido.
	 * @author adrSoft
	 * @version vAlpha10
	 * @param tema = Tema seleccionado en la barra de herramientas.
	 */
	private void pintarTema(String tema) {
		if(tema.equals("classic")){
			textArea.setBackground(new Color(153, 204, 255));
			getContentPane().setBackground(UIManager.getColor("textHighlight"));
		
		}
		else if(tema.equals("oscuro")){
			textArea.setBackground(Color.GRAY);
			getContentPane().setBackground(Color.BLACK);
		
		}
		else if(tema.equals("claro")){
			textArea.setBackground(new Color(255, 255, 204)	);
			getContentPane().setBackground(new Color(255, 255, 102)	);
		}
		
		
	}
    
}
