package adrsoft.scool.club;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Desktop;

import javax.swing.JPanel;
import adrsoft.scool.model.LeeExcel;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.UIManager;
import javax.swing.SwingConstants;

/**
 * Clase utilizada para el control de inventario del club.<br><br>
 * Se trata de la lectura de un archivo de Excel cuyos datos son cargados en un JTextPane.
 * También ofrece la oportunidad de descargar la hoja de cálculo al ordenador del usuario.
 * @author adrSoft
 * @version vAlpha10
 *
 */
public class Inventario extends JInternalFrame {

    	private static final long serialVersionUID = 1L;
    	private JPanel panelInventario;
    	private JTextPane textPaneInventario;
    	private JButton btnNewButton;
    	private JLabel lblInventario;
    	private int club;

	/**
	 * Constructor  de la clase. Se le pasa un parametro(integer) que indica el club al que pertenece el usuario.
	 * @author adrSoft
	 * @version vAlpha10
	 * @param mClub 
	 * @param tema 
	 */
	public Inventario(int mClub, String tema) {
		this.club = mClub;
		init();
		cargarExcel();
		createEvents();
		pintarTema(tema);
	}

	/**
	 * Método encargado de crear los eventos asignados a los botones y otros controles interactivos.
	 * @author adrSoft
	 * @version vAlpha10
	 */
	private void createEvents() {
		//Botón descarga
		btnNewButton.addActionListener(new ActionListener() {
			String ruta="";
			public void actionPerformed(ActionEvent arg0) {
				switch(club){
				case 1:
					ruta = "inventarioAjedrez.xls";
					break;
				case 2:
					ruta = "inventarioAjedrez.xls";
					break;
				case 3:
					ruta = "inventarioVideojuegos.xls";
					break;
				case 4:
					ruta = "inventarioLectura.xls";
					break;
				}
				
				
				try {
					
					File path = new File (ruta);
				     Desktop.getDesktop().open(path);
				}catch (IOException ex) {
				     ex.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Método que instancia un objeto de LeeExcel, la clase encargada de analizar y manejar el archivo de hoja de cálculo.
	 * @author adrSoft
	 * @version vAlpha10
	 */
	private void cargarExcel() {
	new LeeExcel(textPaneInventario,club);
	}

	/**
	 * Inicializador de los componentes en el JInternalFrame.
	 * @author adrSoft
	 * @version vAlpha10
	 */
	private void init() {

		getContentPane().setBackground(UIManager.getColor("textHighlight"));
		
		panelInventario = new JPanel();
		panelInventario.setBackground(new Color(153, 204, 255));
		
		JLabel lblNewLabel = new JLabel("Descargar archivo excel");
		lblNewLabel.setFont(new Font("Verdana", Font.ITALIC, 11));
		
		btnNewButton = new JButton("");
	
		btnNewButton.setIcon(new ImageIcon(Inventario.class.getResource("/adrsoft/scool/resources/images/high/xls_file.png")));
		btnNewButton.setContentAreaFilled(false);
		
		lblInventario = new JLabel("Inventario");
		lblInventario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblInventario.setForeground(Color.BLUE);
		lblInventario.setFont(new Font("Verdana", Font.BOLD, 20));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(panelInventario, GroupLayout.DEFAULT_SIZE, 831, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(377)
							.addComponent(btnNewButton))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(356)
							.addComponent(lblNewLabel))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap(703, Short.MAX_VALUE)
							.addComponent(lblInventario, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblInventario, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panelInventario, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel)
					.addContainerGap(14, Short.MAX_VALUE))
		);
		
		textPaneInventario = new JTextPane();
		GroupLayout gl_panelInventario = new GroupLayout(panelInventario);
		gl_panelInventario.setHorizontalGroup(
			gl_panelInventario.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelInventario.createSequentialGroup()
					.addContainerGap()
					.addComponent(textPaneInventario, GroupLayout.DEFAULT_SIZE, 831, Short.MAX_VALUE))
		);
		gl_panelInventario.setVerticalGroup(
			gl_panelInventario.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelInventario.createSequentialGroup()
					.addContainerGap()
					.addComponent(textPaneInventario, GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
					.addContainerGap())
		);
		panelInventario.setLayout(gl_panelInventario);
		getContentPane().setLayout(groupLayout);
		setBounds(100, 100, 867, 407);
		((javax.swing.plaf.basic.BasicInternalFrameUI)getUI()).setNorthPane(null);
	
	}
	
	/**
	 * Método encargado de renderizar el aspecto visual en relación con el tema escogido.
	 * @author adrSoft
	 * @version vAlpha10
	 * @param tema = Tema seleccionado en la barra de herramientas.
	 */
	private void pintarTema(String tema) {
		if(tema.equals("classic")){
			panelInventario.setBackground(new Color(153, 204, 255));
			getContentPane().setBackground(UIManager.getColor("textHighlight"));
		
		}
		else if(tema.equals("oscuro")){
			panelInventario.setBackground(Color.GRAY);
			getContentPane().setBackground(Color.BLACK);
		
		}
		else if(tema.equals("claro")){
			panelInventario.setBackground(new Color(255, 255, 204));
			getContentPane().setBackground(new Color(255, 255, 102));
		}
		
		
	}
}
