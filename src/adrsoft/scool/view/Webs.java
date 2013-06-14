package adrsoft.scool.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

/**
 * Clase encargada de cargar la web y la intranet del instituto del alumno
 * @author adrSoft
 * @version vAlpha10
 *
 */
public class Webs extends JInternalFrame {
    
    /*
     * Campos
     */
    private static final long serialVersionUID = 1L;
    private JEditorPane editorPane;
    @SuppressWarnings("unused")
    private JScrollPane scrollPane;
    private String ruta =  "http://www.iesmiguelherrero.com/";
    private JButton mWeb;
    private JButton mIntra;
    private JPanel buttonPane;
	
	/**
	 * Constructor vacio. Se encarga de inicializar los componentes del frame.
	 * @author adrSoft
	 * @version vAlpha10
	 * @param tema 
	 */
	public Webs(String tema) {
		init();
		cargarWeb(ruta);
		createEvents();
		pintarTema(tema);
	  }

	/**
	 * Método que carga una web en un JEditorPane. La ruta de la web se pasa como argumento.
	 * @author adrSoft
	 * @version vAlpha10
	 * @param rut = Ruta o URL de la web a mostrar.
	 */
	private void cargarWeb(String rut) {
		editorPane = new JEditorPane();
		editorPane.setBackground(UIManager.getColor("textHighlight"));
		editorPane.setEditable(false);
		try {
		    editorPane.setPage(new URL(rut));
		} catch (MalformedURLException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		}
		scrollPane = new JScrollPane();
		this.getContentPane().add(editorPane);
	
	}

	/**
	 * Método encargado de crear los eventos asignados a los botones y otros controles interactivos.
	 * @author adrSoft
	 * @version vAlpha10
	 */
	private void createEvents() {
	    
	    	//Botón WEB
		mWeb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cargarWeb("http://www.iesmiguelherrero.com/");
				
			}
		});
		
		//Botón INTRANET
		mIntra.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cargarWeb("http://chamilo.iesmiguelherrero.com/");
				
			}
		});
		
	}

	/**
	 * Inicializador de los componentes en el JFrame.
	 * @author adrSoft
	 * @version vAlpha10
	 */
	private void init() {
		setBounds(100, 100, 710, 612);
		((javax.swing.plaf.basic.BasicInternalFrameUI) 
				getUI()).setNorthPane(null);
		 buttonPane = new JPanel();
		 buttonPane.setBackground(UIManager.getColor("textHighlight"));
		    buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		    getContentPane().add(buttonPane, BorderLayout.SOUTH);
		    {
			mWeb = new JButton("WEB");
			mWeb.setActionCommand("WEB");
			buttonPane.add(mWeb);
			getRootPane().setDefaultButton(mWeb);
		    }
		    {
			mIntra = new JButton("INTRANET");
			mIntra.setActionCommand("INTRANET");
			buttonPane.add(mIntra);
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
		editorPane.setBackground(UIManager.getColor("textHighlight"));
		buttonPane.setBackground(UIManager.getColor("textHighlight"));
		}
		else if(tema.equals("oscuro")){
			editorPane.setBackground(Color.GRAY);
			buttonPane.setBackground(Color.GRAY);
		}
		else if(tema.equals("claro")){
			editorPane.setBackground(new Color(255, 255, 102));
			buttonPane.setBackground(new Color(255, 255, 102));
			
		}
		
		
	}
}

