package adrsoft.scool.view;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.UIManager;

/**
 * Clase visualizadora de las notas del usuario.<br><br>
 * Una vez se ha seleccionado una materia, se dá la posibilidad al usuario de contactar con el 
 * responsable de esa materia a traves del boton situado en la parte inferior.
 * @author adrSoft
 * @version vAlpha10
 *
 */
public class Notas extends JInternalFrame {
    
    	/*
    	 * Campos
    	 */
    	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JButton btnContacta;
	private JTable table;
	private JPanel panelNotas;



	/**
	 * Constructor vacio.
	 * @author adrSoft
	 * @version vAlpha10
	 * @param tema 
	 */
	public Notas(String tema) {
		setBorder(null);
		setBounds(100, 100, 710, 622);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 204, 255));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 596, Short.MAX_VALUE)
		);
		getContentPane().setLayout(groupLayout);
		((javax.swing.plaf.basic.BasicInternalFrameUI)getUI()).setNorthPane(null);
		init();
		createEvents();
		pintarTema(tema);
	}

	/**
	 * Método encargado de crear los eventos asignados a los botones y otros controles interactivos.
	 * @author adrSoft
	 * @version vAlpha10
	 */
	private void createEvents() {
	    	//Botón contactar
		btnContacta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showConfirmDialog(null, "Función no implementada aún.\nEstará disponible en un corto periodo de tiempo.","Oops..",JOptionPane.DEFAULT_OPTION);

			}
		});
		
		//Click en row
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				int row = table.getSelectedRow();
				btnContacta.setEnabled(true);
				switch(row){
				case 0:
					btnContacta.setText("Contacta con el profesor de Matemáticas");
					break;
				case 1:
					btnContacta.setText("Contacta con el profesor de Lenguaje");
					break;
				case 2:
					btnContacta.setText("Contacta con el profesor de Física");
					break;
				case 3:
					btnContacta.setText("Contacta con el profesor de Educación Física");
					break;
				case 4:
					btnContacta.setText("Contacta con el profesor de Dibujo");
					break;
				case 5:
					btnContacta.setText("Contacta con el tutor");
					break;
				}
			}
		});
	}

	/**
	 * Inicializador de los componentes en el JInternalFrame.
	 * @author adrSoft
	 * @version vAlpha10
	 */
	private void init() {
	
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("textHighlight"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		Object[][] datos = {
				{"Matemáticas", new Float(6.5), new Float(7)},
				{"Lenguaje", new Float(8), new Float(8.3) },
				{"Física", new Float(7), new Float(6.2)},
				{"Educación Física", new Float(7), new Float(6.2)},
				{"Dibujo", new Float(6.2), new Float(7)},
				};
				String[] columnNames = {"Materia","1ª Evaluación","2ª Evaluación",};
				 DefaultTableModel dtm= new DefaultTableModel(datos,columnNames);
				// Agregar nueva columna
				String[] columnaNueva1= {"4","2","7.3","6.25","10"};
				dtm.addColumn("3º Evaluación",columnaNueva1);
				// Agregar nueva fila
				Object[] newRow={"Tutoría", new String("Presentado"), new String("Presentado"), new String("No Presentado")};
				dtm.addRow(newRow);
				// Modificar celda especifica
				dtm.setValueAt("5", 3, 3); // Row/Col
				
				
			
				
				
				panelNotas = new JPanel();
				panelNotas.setBackground(new Color(153, 204, 255));
				table = new JTable(dtm);
			
//				table.setPreferredScrollableViewportSize(new Dimension(250, 100));
				scrollPane = new JScrollPane(table);
				panelNotas.add(scrollPane);
				scrollPane.setBackground(new Color(153, 204, 255));
				
				btnContacta = new JButton("Selecciona una materia");
				btnContacta.setEnabled(false);
				btnContacta.setFont(new Font("Tahoma", Font.BOLD, 11));
				GroupLayout gl_contentPane = new GroupLayout(contentPane);
				gl_contentPane.setHorizontalGroup(
					gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnContacta, GroupLayout.PREFERRED_SIZE, 700, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(107)
									.addComponent(panelNotas, GroupLayout.PREFERRED_SIZE, 520, GroupLayout.PREFERRED_SIZE)))
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
				gl_contentPane.setVerticalGroup(
					gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panelNotas, GroupLayout.PREFERRED_SIZE, 437, GroupLayout.PREFERRED_SIZE)
							.addGap(115)
							.addComponent(btnContacta, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
				);
				contentPane.setLayout(gl_contentPane);
			
				 
	}
	
	/**
	 * Método encargado de renderizar el aspecto visual en relación con el tema escogido.
	 * @author adrSoft
	 * @version vAlpha10
	 * @param tema = Tema seleccionado en la barra de herramientas.
	 */
	private void pintarTema(String tema) {
		if(tema.equals("classic")){
		contentPane.setBackground(UIManager.getColor("textHighlight"));
		panelNotas.setBackground(new Color(153, 204, 255));
		
		}
		else if(tema.equals("oscuro")){
			contentPane.setBackground(Color.GRAY);
			panelNotas.setBackground(Color.BLACK);
		
		}
		else if(tema.equals("claro")){
			contentPane.setBackground(new Color(255, 255, 102));
			panelNotas.setBackground(new Color(255, 255, 204));
		
	}

}
}
