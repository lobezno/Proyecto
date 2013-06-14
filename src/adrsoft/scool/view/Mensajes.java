package adrsoft.scool.view;



import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import adrsoft.scool.model.ButtonColumn;
import java.awt.FlowLayout;

/**
 * Clase encargada de incializar una interfaz de mensajeria para el usuario.
 * @author adrSoft
 * @version vAlpha10
 *
 */
public class Mensajes extends JInternalFrame {
    
        /*
         * Campos
         */
    	private static final long serialVersionUID = 1L;
    	private JButton btnNewButton;
    	private JButton btnContactarConTutor;
    	private JPanel panelEntrada;
    	private JTable tableEntrada;
    	private JTable tableSalida;
    	private JPanel panelTablaEntrada;
    	private JPanel panelContacto;
    	private JScrollPane scrollPaneEntrada;
    	private JScrollPane scrollPaneSalida;
    	private JPanel panelTablaSalida;
    	private JTabbedPane tabbedPane;
    	private JPanel panelSalida;
   
   
    	

	/**
	 * Constructor vacío de la clase.
	 * @author adrSoft
	 * @version vAlpha10
	 * @param mTema 
	 */
	public Mensajes(String tema) {
		init();
		rellenarTablas();
		createEvents();
		((javax.swing.plaf.basic.BasicInternalFrameUI)getUI()).setNorthPane(null);
		pintarTema(tema);
	}

	/**
	 * Método encargado de crear y rellenar las tablas de los tabuladores de mensajes.
	 * 
	 * Tambien crea los botones para poder responder a estos
	 * @author adrSoft
	 * @version vAlpha10
	 */
	private void rellenarTablas() {
	
		
		//Tabla tab Entrada
		Object[][] datosEntrada = {
				{"francisco@gmail.com", "Revisa el proyecto"},
				{"fran@mail.com", "Mañana tarea" },
				{"profesores@mail.com", "Nueva reunión"},
				};

		
			
			String[] columnNamesEntrada = {"Remitente","Asunto","Responder",};
			DefaultTableModel dtmEntrada= new DefaultTableModel(datosEntrada,columnNamesEntrada);
			panelTablaEntrada.setBackground(new Color(153, 204, 255));
			tableEntrada = new JTable(dtmEntrada);
			scrollPaneEntrada = new JScrollPane(tableEntrada);
			panelTablaEntrada.add(scrollPaneEntrada);
			scrollPaneEntrada.setBackground(new Color(153, 204, 255));
		
		//Tabla tab Salida
			Object[][] datosSalida = {
					{"juan@gmail.com", "RE: Revisa el proyecto"},
					{"fedegarcia@mail.com", "RE: trabajo sociales" },
					{"profesores@mail.com", "RE: nuevo club"},
					};

			
				
				String[] columnNamesSalida = {"Destinatario","Asunto","Reenviar",};
				DefaultTableModel dtmSalida= new DefaultTableModel(datosSalida,columnNamesSalida);
				panelTablaSalida.setBackground(new Color(153, 204, 255));
				tableSalida = new JTable(dtmSalida);
				scrollPaneSalida = new JScrollPane(tableSalida);
				panelTablaSalida.add(scrollPaneSalida);
				scrollPaneSalida.setBackground(new Color(153, 204, 255));

			
	
	
	}

	/**
	 * Método encargado de crear los eventos asignados a los botones y otros controles interactivos.
	 * @author adrSoft
	 * @version vAlpha10
	 */
	private void createEvents() {
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showConfirmDialog(null, "Función no implementada aún.\nEstará disponible en un corto periodo de tiempo.","Oops..",JOptionPane.DEFAULT_OPTION);
			}
		});
		
		btnContactarConTutor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showConfirmDialog(null, "Función no implementada aún.\nEstará disponible en un corto periodo de tiempo.","Oops..",JOptionPane.DEFAULT_OPTION);
			}
		});
		
		@SuppressWarnings("unused")
		ButtonColumn botEntrada = new ButtonColumn(tableEntrada, null, 2);
		@SuppressWarnings("unused")
		ButtonColumn botSalida = new ButtonColumn(tableSalida, null, 2);
		
	}

	/**
	 * Inicializador de los componentes en el JFrame.
	 * @author adrSoft
	 * @version vAlpha10
	 */
	private void init() {
		setBackground(UIManager.getColor("textHighlight"));
		getContentPane().setBackground(UIManager.getColor("textHighlight"));
		setBounds(100, 100, 710, 410);
		setBorder(null);
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(UIManager.getColor("textHighlight"));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(tabbedPane, GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
		);
		
		tabbedPane.setBackground(UIManager.getColor("activeCaption"));
		panelEntrada = new JPanel();
		
		panelEntrada.setBackground(new Color(153, 204, 255));
		tabbedPane.addTab("Buzón de entrada", null, panelEntrada, null);
		
		panelTablaEntrada = new JPanel();

		GroupLayout gl_panelEntrada = new GroupLayout(panelEntrada);
		gl_panelEntrada.setHorizontalGroup(
			gl_panelEntrada.createParallelGroup(Alignment.LEADING)
				.addComponent(panelTablaEntrada, GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE)
		);
		gl_panelEntrada.setVerticalGroup(
			gl_panelEntrada.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panelEntrada.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelTablaEntrada, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(164, Short.MAX_VALUE))
		);
		panelEntrada.setLayout(gl_panelEntrada);
		tabbedPane.setIconAt(0,new ImageIcon(Mensajes.class.getResource("/adrsoft/scool/resources/images/low/mail_receive.png")));
		
		panelSalida = new JPanel();
		panelSalida.setBackground(new Color(153, 204, 255));
		
		tabbedPane.addTab("Mensajes enviados", null, panelSalida, null);
		
		panelTablaSalida = new JPanel();
		GroupLayout gl_panelSalida = new GroupLayout(panelSalida);
		gl_panelSalida.setHorizontalGroup(
			gl_panelSalida.createParallelGroup(Alignment.LEADING)
				.addComponent(panelTablaSalida, GroupLayout.DEFAULT_SIZE, 705, Short.MAX_VALUE)
		);
		gl_panelSalida.setVerticalGroup(
			gl_panelSalida.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelSalida.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelTablaSalida, GroupLayout.PREFERRED_SIZE, 170, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(278, Short.MAX_VALUE))
		);
		panelTablaSalida.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panelSalida.setLayout(gl_panelSalida);
		tabbedPane.setIconAt(1,new ImageIcon(Mensajes.class.getResource("/adrsoft/scool/resources/images/low/mail_send.png")));
		
		panelContacto = new JPanel();
		panelContacto.setBackground(new Color(153, 204, 255));
		tabbedPane.addTab("", null, panelContacto, null);
		
		btnNewButton = new JButton("Enviar Mensaje");

		btnContactarConTutor = new JButton("Contactar con Tutor");
	
		GroupLayout gl_panelContacto = new GroupLayout(panelContacto);
		gl_panelContacto.setHorizontalGroup(
			gl_panelContacto.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelContacto.createSequentialGroup()
					.addGap(121)
					.addGroup(gl_panelContacto.createParallelGroup(Alignment.LEADING)
						.addComponent(btnContactarConTutor, GroupLayout.PREFERRED_SIZE, 413, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 413, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(171, Short.MAX_VALUE))
		);
		gl_panelContacto.setVerticalGroup(
			gl_panelContacto.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelContacto.createSequentialGroup()
					.addGap(69)
					.addComponent(btnNewButton)
					.addGap(18)
					.addComponent(btnContactarConTutor)
					.addContainerGap(213, Short.MAX_VALUE))
		);
		panelContacto.setLayout(gl_panelContacto);
		tabbedPane.setIconAt(2,new ImageIcon(Mensajes.class.getResource("/adrsoft/scool/resources/images/low/mail.png")));
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
			panelEntrada.setBackground(new Color(153, 204, 255));
			panelSalida.setBackground(new Color(153, 204, 255));
			panelTablaSalida.setBackground(new Color(153, 204, 255));
			panelTablaEntrada.setBackground(new Color(153, 204, 255));
			panelContacto.setBackground(new Color(153, 204, 255));
		
		}
		else if(tema.equals("oscuro")){
		
			getContentPane().setBackground(Color.BLACK);
			panelEntrada.setBackground(Color.GRAY);
			panelSalida.setBackground(Color.GRAY);
			panelTablaSalida.setBackground(Color.GRAY);
			panelTablaEntrada.setBackground(Color.GRAY);
			panelContacto.setBackground(Color.GRAY);
		
		
		}
		else if(tema.equals("claro")){
			getContentPane().setBackground(new Color(255, 255, 102));
			panelEntrada.setBackground(new Color(255, 255, 204));
			panelSalida.setBackground(new Color(255, 255, 204));
			panelTablaSalida.setBackground(new Color(255, 255, 204));
			panelTablaEntrada.setBackground(new Color(255, 255, 204));
			panelContacto.setBackground(new Color(255, 255, 204));
		}
		
		
	}
}
