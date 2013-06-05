package adrsoft.scool.view;
import java.awt.BorderLayout;
import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;
import java.awt.Color;

public class Notas extends JInternalFrame {
    	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane scrollPane;



	/**
	 * Create the frame.
	 */
	public Notas() {
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
		((javax.swing.plaf.basic.BasicInternalFrameUI) 
		getUI()).setNorthPane(null);
		init();
		createEvents();
	}

	private void createEvents() {
	
		
	}

	private void init() {
	
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		Object[][] datos = {
				{"Matemáticas", new Float(6.5), new Float(7)},
				{"Lenguaje", new Float(8), new Float(8.3) },
				{"Física", new Float(7), new Float(6.2)},
				{"Educación Física", new Float(7), new Float(6.2)},
				{"Tutoría", new String("Presentado"), new String("Presentado")},
				};
				String[] columnNames = {"Materia","1ª Evaluación","2ª Evaluación",};
				 DefaultTableModel dtm= new DefaultTableModel(datos,columnNames);
				// Agregar nueva columna
				String[] columnaNueva1= {"4","2","7.3","6.25",};
				dtm.addColumn("3º Evaluación",columnaNueva1);
				// Agregar nueva fila
				Object[] newRow={"Dibujo",new Integer(55),new Float(3)};
				dtm.addRow(newRow);
				// Modificar celda especifica
				dtm.setValueAt("5", 3, 3); // Row/Col
				
			
				
				
				JPanel panel = new JPanel();
				panel.setBackground(new Color(153, 204, 255));
				contentPane.add(panel, BorderLayout.NORTH);
				final JTable table = new JTable(dtm);
//				table.setPreferredScrollableViewportSize(new Dimension(250, 100));
				scrollPane = new JScrollPane(table);
				panel.add(scrollPane);
				scrollPane.setBackground(new Color(153, 204, 255));
			
				 
	}

}
