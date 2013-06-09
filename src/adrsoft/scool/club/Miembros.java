package adrsoft.scool.club;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import adrsoft.scool.model.ButtonColumn;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;


public class Miembros extends JInternalFrame {

        /*
         *Campos 
         */
    	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    	private JScrollPane scrollPane;
    	private JPanel panel;
    	private JPanel panelTabla;
    	private JLabel lblMiembros;


	/**
	 * Constructor vacío de la clase.
	 * @author adrSoft
	 * @version 1.0
	 */
	public Miembros() {
		setBorder(null);
		setBounds(100, 100, 710, 622);
		
		((javax.swing.plaf.basic.BasicInternalFrameUI) 
		getUI()).setNorthPane(null);
		init();
	}


	/**
	 * Inicializador de los componentes en el JFrame.
	 * @author adrSoft
	 * @version 1.0
	 */
	private void init() {
	    
	        panel = new JPanel();
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
		
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("textHighlight"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		Object[][] datos = {
				{"Andres", "Lopez", "Presidente"},
				{"Juan", "De Dios", "Tesorero" },
				{"Marta", "Sanchez", "Miembro"},
				};
				String[] columnNames = {"Nombre","Apellidos","Cometido", "Contacto"};
				 DefaultTableModel dtm= new DefaultTableModel(datos,columnNames);
	
				
				panelTabla = new JPanel();
				panelTabla.setBackground(new Color(153, 204, 255));
				final JTable table = new JTable(dtm);

				table.setEnabled(true);
				scrollPane = new JScrollPane(table);
				scrollPane.setBackground(new Color(153, 204, 255));
				
				@SuppressWarnings("unused")
				ButtonColumn bot = new ButtonColumn(table, null, 3);
				GroupLayout gl_panelTabla = new GroupLayout(panelTabla);
				gl_panelTabla.setHorizontalGroup(
					gl_panelTabla.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelTabla.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
							.addContainerGap())
				);
				gl_panelTabla.setVerticalGroup(
					gl_panelTabla.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panelTabla.createSequentialGroup()
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 427, GroupLayout.PREFERRED_SIZE))
				);
				panelTabla.setLayout(gl_panelTabla);
				
				lblMiembros = new JLabel("Miembros");
				lblMiembros.setHorizontalAlignment(SwingConstants.RIGHT);
				lblMiembros.setForeground(Color.BLUE);
				lblMiembros.setFont(new Font("Verdana", Font.BOLD, 20));
				GroupLayout gl_contentPane = new GroupLayout(contentPane);
				gl_contentPane.setHorizontalGroup(
					gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addContainerGap(45, Short.MAX_VALUE)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(panelTabla, GroupLayout.PREFERRED_SIZE, 608, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblMiembros, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE))
							.addGap(47))
				);
				gl_contentPane.setVerticalGroup(
					gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblMiembros, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panelTabla, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(116, Short.MAX_VALUE))
				);
				contentPane.setLayout(gl_contentPane);
	
	}

}

