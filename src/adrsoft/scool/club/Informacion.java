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
 * Clase instanciadora de la información general del club.
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
	 * Método encargado de rellenar la información relevante del club seleccionado.
	 * <br>
	 * Dependiendo del parámetro idClub recogido en el constructor, mostrará un texto u otro.
	 * 
	 * @author adrSoft
	 * @version vAlpha10
	 */
	private void rellenarInfo() {
	    textArea.setEditable(false);
	   
	    String ajedrez = "Bienvenido al club de ajedrez.\n\nAquí podras jaquear y matear.\nLa calidad humana es una virtud escasa a pesar de encontrarnos en la era de la cibernética; no obstante, me llena de entusiasmo descubrir a un grupo de amigos que han reunido todo su esfuerzo para transmitir la esperanza de que es posible aunar nobleza y corazón, junto a la honestidad deportiva presente siempre en el Ajedrez.";
	    String lectura = "Leyendo creas tus propias aventuras, entras en mundos que otros ni imaginan, luchas contra el malo malisimo y sales ganando, e incluso te llevas a la chica guapa del cuento. Por que leyendo se disfruta como con pocas cosas de la vida. Y si además lo puedes hacer en compañia mejor, verdad? Pues no lo dudes más. Entra a  formar parte de nuestro club. Conoceras a amantes de la lectura como tu, podrás compartir opiniones, criticas e incluso intercambiar libros para nunca tener que parar de leer. Te esperamos :)";
	    String videojuegos = "Circulo Triangulo Derecha Derecha y A dentro!!\n\nBienvenido a nuestro club de videojuegos! Un sitio donde podrás hacer grandes amigos y charlar sobre lo que más te gusta.. Los videojuegos! Podrás tambien participar en diferentes eventos, como competiciones a los variados titulos que poseemos, pruebas de conocimiento con nuestro 'TriviaGame', participar en nuestra aportación al festival de verano, etc.. Si te gustan los videojuegos y disfrutas con la compañia de la gente, no lo dudes más! Te esperamos en el aula 3 todos los martes y jueves despues de las clases.";
	    String atletismo = "Bienvenidos al club de atletismo CorreCorre!\n\n Aquí podrás encontrar a otros muchos alumnos y compañeros que comparten tu misma afición. Nos encanta el deporte, en concreto el atletismo y siempre tendrás a algun compañero cerca con tus mismos gustos.\n\nTambién participamos en torneos extraescolares, asi como en nuestros propios torneos internos de club.\t\t\tAsi que ya no tienes excusa... Ven y unete al club de amigos y compañeros que estabas deseando!";
	    
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
