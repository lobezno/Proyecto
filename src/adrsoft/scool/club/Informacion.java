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


/**
 * Clase instanciadora de la informaci�n general del club.
 * @author adrSoft
 * @version vAlpha10
 *
 */
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
	 * @version vAlpha10
	 * @param idClub = Identificador del club al que pertenece el usuario activo.
	 * @param tema 
	 */
	public Informacion(int idClub, String tema) {
	    this.mIdClub = idClub;
	    ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).setNorthPane(null);
		init();
		pintarTema(tema);
		
	}

	

	/**
	 * M�todo encargado de renderizar el aspecto visual en relaci�n con el tema escogido.
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
			getContentPane().setBackground(new Color(255, 255, 102));
		}
		
		
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
	 * M�todo encargado de rellenar la informaci�n relevante del club seleccionado.
	 * <br>
	 * Dependiendo del par�metro idClub recogido en el constructor, mostrar� un texto u otro.
	 * 
	 * @author adrSoft
	 * @version vAlpha10
	 */
	private void rellenarInfo() {
	    textArea.setEditable(false);
	   
	    String ajedrez = "Bienvenido al club de ajedrez.\n\nAqu� podras jaquear y matear.\nLa calidad humana es una virtud escasa a pesar de encontrarnos en la era de la cibern�tica; no obstante, me llena de entusiasmo descubrir a un grupo de amigos que han reunido todo su esfuerzo para transmitir la esperanza de que es posible aunar nobleza y coraz�n, junto a la honestidad deportiva presente siempre en el Ajedrez.";
	    String lectura = "Leyendo creas tus propias aventuras, entras en mundos que otros ni imaginan, luchas contra el malo malisimo y sales ganando, e incluso te llevas a la chica guapa del cuento. Por que leyendo se disfruta como con pocas cosas de la vida. Y si adem�s lo puedes hacer en compa�ia mejor, verdad? Pues no lo dudes m�s. Entra a  formar parte de nuestro club. Conoceras a amantes de la lectura como tu, podr�s compartir opiniones, criticas e incluso intercambiar libros para nunca tener que parar de leer. Te esperamos :)";
	    String videojuegos = "Circulo Triangulo Derecha Derecha y A dentro!!\n\nBienvenido a nuestro club de videojuegos! Un sitio donde podr�s hacer grandes amigos y charlar sobre lo que m�s te gusta.. Los videojuegos! Podr�s tambien participar en diferentes eventos, como competiciones a los variados titulos que poseemos, pruebas de conocimiento con nuestro 'TriviaGame', participar en nuestra aportaci�n al festival de verano, etc.. Si te gustan los videojuegos y disfrutas con la compa�ia de la gente, no lo dudes m�s! Te esperamos en el aula 3 todos los martes y jueves despues de las clases.";
	    String atletismo = "Bienvenidos al club de atletismo CorreCorre!\n\n Aqu� podr�s encontrar a otros muchos alumnos y compa�eros que comparten tu misma afici�n. Nos encanta el deporte, en concreto el atletismo y siempre tendr�s a algun compa�ero cerca con tus mismos gustos.\n\nTambi�n participamos en torneos extraescolares, asi como en nuestros propios torneos internos de club.\t\t\tAsi que ya no tienes excusa... Ven y unete al club de amigos y compa�eros que estabas deseando!";
	    
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
