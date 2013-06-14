package adrsoft.scool.club;


import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextPane;

/**
 * Clase encargada de instanciar la seccion de Noticias del club. Son paneles estáticos con la información<br>
 * de la noticia en su interior, que cambian según el club al que pertenezca el usuario.
 * @author adrSoft
 * @version vAlpha10
 *
 */
public class Noticias extends JInternalFrame {

    private static final long serialVersionUID = 1L;
    private int mIdClub;
    private JPanel panel;
    private JLabel header1;
    private JLabel header2;
    private JLabel header3;
    private JTextPane body3;
    private JTextPane body2;
    private JTextPane body1;
    private JPanel panelNoticia1;
    private JPanel panelNoticia2;
    private JPanel PanelNoticia3;

    /**
	 * Constructor de la clase con un argumento, idClub, que es el club del usuario activo.
	 * @author adrSoft
	 * @version vAlpha10
	 * @param idClub = Identificador del club al que pertenece el usuario activo.
     * @param tema 
	 */
	public Noticias(int idClub, String tema) {
	    this.mIdClub = idClub;
	    ((javax.swing.plaf.basic.BasicInternalFrameUI) getUI()).setNorthPane(null);
		init();
		cargarNoticias();
		pintarTema(tema);
	}

	/**
	 * Método encargado de, según el club del usuario activo, cargar las noticias referentes a su club extraescolar.
	 * @author adrSoft
	 * @version vAlpha10
	 */
	private void cargarNoticias() {

		String haje1 = "Torneo a la vista!";
		String baje1 = "Se acerca el torneo mensual del club. Esta vez contamos con la participación de 6 miembros. En unos pocos dias colgaremos los emparejamientos.";
		String haje2 = "Nuevo numero de la revista Check!";
		String baje2 = "Ha salido a la venta el nuevo numero de la revista Check! Nuevas entrevistas, consejos para principiantes y articulos exquisitos!";
		String haje3 = "Se acerca el festival de Verano!";
		String baje3 = "Ya queda menos para que dé comienzo el festival de verano. Antes de acabar las clases, todos los clubs tendran que organizar sus aulas para la recepción a jornada de puertas abiertas para ver sus trabajos.";
		
		String hatle1 = "Nuestra compañera Elisa ha ganado su primer campeonato!";
		String batle1 = "Elisa, miembro de este club, participó y ganó el día de ayer el torneo de atletismo de la ciudad de Torrelavega. Enhorabuena!";
		String hatle2 = "Id calentando motores: Maratón Torrelavega";
		String batle2 = "En unos días se celebra el Maratón de Torrelavega. Id preparandoos que nos vamos a presentar todos. Ánimo!";
		String hatle3 = "Se acerca el festival de Verano!";
		String batle3 = "Ya queda menos para que dé comienzo el festival de verano. Antes de acabar las clases, todos los clubs tendran que organizar sus aulas para la recepción a jornada de puertas abiertas para ver sus trabajos.";
		
		String hvid1 = "Nuevas noticias referentes a PS4";
		String bvid1 = "Nuevos rumores sobre la nueva consola de Sony. Si quereis información, pasaros por el club despues de las clases.";
		String hvid2 = "Quedada consolera";
		String bvid2 = "El viernes despues de clase vamos a reunirnos en el aula del club para jugar unas partidas. Pasad los que querais.";
		String hvid3 = "Se acerca el festival de Verano!";
		String bvid3 = "Ya queda menos para que dé comienzo el festival de verano. Antes de acabar las clases, todos los clubs tendran que organizar sus aulas para la recepción a jornada de puertas abiertas para ver sus trabajos.";
		
		String hlec1 = "Nuevo Libro de Robert Rothfuss.";
		String blec1 = "'El tercer día' , así se llamará la nueva obra de Robert Rothfuss. Este es el último volumen de la trilogia 'La historia de Kvothe'";
		String hlec2 = "Intercambio de libros";
		String blec2 = "Este jueves en la hora del club (a la salida de las clases) tendremos un intercambio entre miembros de libros. Pasate y tendrás algo nuevo que llevarte al cerebro!";
		String hlec3 = "Se acerca el festival de Verano!";
		String blec3 = "Ya queda menos para que dé comienzo el festival de verano. Antes de acabar las clases, todos los clubs tendran que organizar sus aulas para la recepción a jornada de puertas abiertas para ver sus trabajos.";
		
		
	   switch(mIdClub){
	       case 1:
	    	   header1.setText(haje1);
	    	   body1.setText(baje1);
	    	   header2.setText(haje2);
	    	   body2.setText(baje2);
	    	   header3.setText(haje3);
	    	   body3.setText(baje3);
	    	   break;
	       case 2:
	    	   header1.setText(hatle1);
	    	   body1.setText(batle1);
	    	   header2.setText(hatle2);
	    	   body2.setText(batle2);
	    	   header3.setText(hatle3);
	    	   body3.setText(batle3);
	    	   break;
	       case 3:
	    	   header1.setText(hvid1);
	    	   body1.setText(bvid1);
	    	   header2.setText(hvid2);
	    	   body2.setText(bvid2);
	    	   header3.setText(hvid3);
	    	   body3.setText(bvid3);
	    	   break;
	       case 4:
	    	   header1.setText(hlec1);
	    	   body1.setText(blec1);
	    	   header2.setText(hlec2);
	    	   body2.setText(blec2);
	    	   header3.setText(hlec3);
	    	   body3.setText(blec3);
	    	   break;
	   }
		
	       
		
	}


	/**
	 * Inicializador de los componentes en el JFrame.
	 * @author adrSoft
	 * @version vAlpha10
	 */
	private void init() {
	    getContentPane().setBackground(UIManager.getColor("textHighlight"));
		setBounds(100, 100, 710, 400);
		((javax.swing.plaf.basic.BasicInternalFrameUI) 
				getUI()).setNorthPane(null);
		
		JLabel lblNoticias = new JLabel("Noticias");
		lblNoticias.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNoticias.setForeground(Color.BLUE);
		lblNoticias.setFont(new Font("Verdana", Font.BOLD, 20));
		
		panel = new JPanel();
		panel.setBackground(UIManager.getColor("textHighlight"));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(34)
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(519)
							.addComponent(lblNoticias, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(37, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblNoticias)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 331, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		panelNoticia1 = new JPanel();
		panelNoticia1.setEnabled(false);
		panelNoticia1.setBackground(new Color(153, 204, 255));
		GridBagConstraints gbc_panelNoticia1 = new GridBagConstraints();
		gbc_panelNoticia1.insets = new Insets(0, 0, 10, 0);
		gbc_panelNoticia1.fill = GridBagConstraints.BOTH;
		gbc_panelNoticia1.gridx = 0;
		gbc_panelNoticia1.gridy = 0;
		panel.add(panelNoticia1, gbc_panelNoticia1);
		
		header1 = new JLabel("Torneo a la vista!");
		header1.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		
		body1 = new JTextPane();
		body1.setFont(new Font("Verdana", Font.PLAIN, 13));
		body1.setEditable(false);
		body1.setBackground(new Color(153, 204, 255));
		body1.setText("Se acerca el torneo mensual del club. Esta vez contamos con la participaci\u00F3n de 6 miembros. En unos pocos dias colgaremos los emparejamientos. ");
		GroupLayout gl_panelNoticia1 = new GroupLayout(panelNoticia1);
		gl_panelNoticia1.setHorizontalGroup(
			gl_panelNoticia1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelNoticia1.createSequentialGroup()
					.addGroup(gl_panelNoticia1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelNoticia1.createSequentialGroup()
							.addContainerGap()
							.addComponent(header1, GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE))
						.addGroup(gl_panelNoticia1.createSequentialGroup()
							.addGap(20)
							.addComponent(body1, GroupLayout.PREFERRED_SIZE, 556, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panelNoticia1.setVerticalGroup(
			gl_panelNoticia1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelNoticia1.createSequentialGroup()
					.addComponent(header1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(body1, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
					.addContainerGap())
		);
		panelNoticia1.setLayout(gl_panelNoticia1);
		
		panelNoticia2 = new JPanel();
		panelNoticia2.setBackground(new Color(153, 204, 255));
		GridBagConstraints gbc_panelNoticia2 = new GridBagConstraints();
		gbc_panelNoticia2.insets = new Insets(0, 0, 10, 0);
		gbc_panelNoticia2.fill = GridBagConstraints.BOTH;
		gbc_panelNoticia2.gridx = 0;
		gbc_panelNoticia2.gridy = 1;
		panel.add(panelNoticia2, gbc_panelNoticia2);
		
		header2 = new JLabel("Torneo a la vista!");
		header2.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		
		body2 = new JTextPane();
		body2.setFont(new Font("Verdana", Font.PLAIN, 13));
		body2.setEditable(false);
		body2.setText("Se acerca el torneo mensual del club. Esta vez contamos con la participaci\u00F3n de 6 miembros. En unos pocos dias colgaremos los emparejamientos. ");
		body2.setBackground(new Color(153, 204, 255));
		GroupLayout gl_panelNoticia2 = new GroupLayout(panelNoticia2);
		gl_panelNoticia2.setHorizontalGroup(
			gl_panelNoticia2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelNoticia2.createSequentialGroup()
					.addGroup(gl_panelNoticia2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelNoticia2.createSequentialGroup()
							.addContainerGap()
							.addComponent(header2, GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE))
						.addGroup(gl_panelNoticia2.createSequentialGroup()
							.addGap(20)
							.addComponent(body2, GroupLayout.PREFERRED_SIZE, 556, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panelNoticia2.setVerticalGroup(
			gl_panelNoticia2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelNoticia2.createSequentialGroup()
					.addComponent(header2, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(body2, GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
					.addContainerGap())
		);
		panelNoticia2.setLayout(gl_panelNoticia2);
		
		PanelNoticia3 = new JPanel();
		PanelNoticia3.setBackground(new Color(153, 204, 255));
		GridBagConstraints gbc_PanelNoticia3 = new GridBagConstraints();
		gbc_PanelNoticia3.fill = GridBagConstraints.BOTH;
		gbc_PanelNoticia3.gridx = 0;
		gbc_PanelNoticia3.gridy = 2;
		panel.add(PanelNoticia3, gbc_PanelNoticia3);
		
		header3 = new JLabel("Torneo a la vista!");
		header3.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		
		body3 = new JTextPane();
		body3.setFont(new Font("Verdana", Font.PLAIN, 13));
		body3.setEditable(false);
		body3.setText("Se acerca el torneo mensual del club. Esta vez contamos con la participaci\u00F3n de 6 miembros. En unos pocos dias colgaremos los emparejamientos. ");
		body3.setBackground(new Color(153, 204, 255));
		GroupLayout gl_PanelNoticia3 = new GroupLayout(PanelNoticia3);
		gl_PanelNoticia3.setHorizontalGroup(
			gl_PanelNoticia3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_PanelNoticia3.createSequentialGroup()
					.addGroup(gl_PanelNoticia3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_PanelNoticia3.createSequentialGroup()
							.addContainerGap()
							.addComponent(header3, GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE))
						.addGroup(gl_PanelNoticia3.createSequentialGroup()
							.addGap(20)
							.addComponent(body3, GroupLayout.PREFERRED_SIZE, 556, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_PanelNoticia3.setVerticalGroup(
			gl_PanelNoticia3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_PanelNoticia3.createSequentialGroup()
					.addComponent(header3, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(body3, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
					.addContainerGap())
		);
		PanelNoticia3.setLayout(gl_PanelNoticia3);
		getContentPane().setLayout(groupLayout);
		
	}
	
	/**
	 * Método encargado de renderizar el aspecto visual en relación con el tema escogido.
	 * @author adrSoft
	 * @version vAlpha10
	 * @param tema = Tema seleccionado en la barra de herramientas.
	 */
	private void pintarTema(String tema) {
		if(tema.equals("classic")){
			getContentPane().setBackground(UIManager.getColor("textHighlight"));
			panel.setBackground(UIManager.getColor("textHighlight"));
			panelNoticia1.setBackground(new Color(153, 204, 255));
			panelNoticia2.setBackground(new Color(153, 204, 255));
			PanelNoticia3.setBackground(new Color(153, 204, 255));
			body1.setBackground(new Color(153, 204, 255));
			body2.setBackground(new Color(153, 204, 255));
			body3.setBackground(new Color(153, 204, 255));
		}
		else if(tema.equals("oscuro")){
			getContentPane().setBackground(Color.BLACK);
			panel.setBackground(Color.BLACK);
			panelNoticia1.setBackground(Color.GRAY);
			panelNoticia2.setBackground(Color.GRAY);
			PanelNoticia3.setBackground(Color.GRAY);
			body1.setBackground(Color.GRAY);
			body2.setBackground(Color.GRAY);
			body3.setBackground(Color.GRAY);
		
		}
		else if(tema.equals("claro")){
			getContentPane().setBackground(new Color(255, 255, 102));
			panel.setBackground(new Color(255, 255, 102));
			panelNoticia1.setBackground(new Color(255, 255, 204));
			panelNoticia2.setBackground(new Color(255, 255, 204));
			PanelNoticia3.setBackground(new Color(255, 255, 204));
			body1.setBackground(new Color(255, 255, 204));
			body2.setBackground(new Color(255, 255, 204));
			body3.setBackground(new Color(255, 255, 204));
		}
		
		
	}

	    
	}
