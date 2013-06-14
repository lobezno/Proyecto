package adrsoft.scool.model;


import java.awt.Desktop;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

/**
 * Clase que se ocupa de abrir el manual de usuario, dando a elegir entre abrirlo con el notepad como texto plano
 * o abrirlo con Microsoft Word como texto enriquecido.<br>
 * Para ello, abre un jframe con dos botones para escoger la opción deseada.
 * @author adrSoft
 * @version vAlpha10
 *
 */
public class AbreDocumento extends JFrame {

	/**
	 * Campos
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnWord;
	private JButton btnPlain;
	private JPanel panel;


	/**
	 * Constructor de clase vacío.
	 */
	public AbreDocumento() {
		init();
		createEvents();
			}

	/**
	 * Método encargado de crear los eventos asignados a los botones y otros controles interactivos.
	 * @author adrSoft
	 * @version vAlpha10
	 */
	private void createEvents() {
		btnPlain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				     File path = new File ("manualdeusuario.txt");
				     Desktop.getDesktop().open(path);
				}catch (IOException ex) {
				     ex.printStackTrace();
				}
				setVisible(false);
			}
		});
		btnWord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				     File path = new File ("manualdeusuario.docx");
				     Desktop.getDesktop().open(path);
				}catch (IOException ex) {
				     ex.printStackTrace();
				}
				setVisible(false);
			}
		});
		
	}

	/**
	 * Inicializador de los componentes en el JInternalFrame.
	 * @author adrSoft
	 * @version vAlpha10
	 */
	private void init() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 363, 188);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("textHighlight"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		panel = new JPanel();
		panel.setBackground(new Color(153, 204, 255));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		btnPlain = new JButton("");
	
	
	
		btnPlain.setContentAreaFilled(false);
		btnPlain.setIcon(new ImageIcon(AbreDocumento.class.getResource("/adrsoft/scool/resources/images/mid/text_page.png")));
		
		btnWord = new JButton("");
		
	
		btnWord.setContentAreaFilled(false);
		btnWord.setIcon(new ImageIcon(AbreDocumento.class.getResource("/adrsoft/scool/resources/images/mid/doc_file.png")));
		
		JLabel lblNewLabel = new JLabel("Texto plano");
		lblNewLabel.setFont(new Font("Verdana", Font.ITALIC, 13));
		
		JLabel lblTextoEnriquecido = new JLabel("Texto Enriquecido");
		lblTextoEnriquecido.setFont(new Font("Verdana", Font.ITALIC, 13));
		
		JLabel lblNewLabel_1 = new JLabel("Elige el tipo de documento");
		lblNewLabel_1.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 13));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(31)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnPlain)
								.addComponent(lblNewLabel))
							.addGap(69)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGap(19)
									.addComponent(btnWord))
								.addComponent(lblTextoEnriquecido)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(65)
							.addComponent(lblNewLabel_1)))
					.addContainerGap(33, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(19)
					.addComponent(lblNewLabel_1)
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnPlain)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnWord)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblTextoEnriquecido, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(22, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
}
