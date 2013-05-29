package adrsoft.scool.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import java.awt.Color;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.JToolBar;
import javax.swing.JDesktopPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTree;
import javax.swing.SwingConstants;

import com.toedter.calendar.JCalendar;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Alumnos extends JFrame {

	/*
	 * Campos
	 */
	private JPanel contentPane;
	private JMenuItem mntmInformacin;
	private JMenuItem mntmDocumentacin;
	private JMenuItem mntmClassic;
	private JMenuItem mntmDark;
	private JMenuItem mntmLight;
	private JMenuItem mntmLogin;
	private JMenuItem mntmSalir;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JCalendar calendario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Alumnos frame = new Alumnos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Alumnos() {
		init();
		createEvents();
	}
	
	private void init() {

		setTitle("Bienvenido, Alumno");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1069, 600);
		calendario = new JCalendar();
		
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.GRAY);
		setJMenuBar(menuBar);
		
		JMenu mnAplicacin = new JMenu("Aplicaci\u00F3n");
		menuBar.add(mnAplicacin);
		
		mntmLogin = new JMenuItem("Login");
		mntmLogin.setIcon(new ImageIcon(Alumnos.class.getResource("/adrsoft/scool/resources/images/mid/key.png")));
		mnAplicacin.add(mntmLogin);
		
		mntmSalir = new JMenuItem("Salir");
		
		mnAplicacin.add(mntmSalir);
		
		JMenu mnTema = new JMenu("Tema");
		menuBar.add(mnTema);
		
		mntmClassic = new JMenuItem("Classic");
		mntmClassic.setIcon(new ImageIcon(Alumnos.class.getResource("/adrsoft/scool/resources/images/mid/50_percent_off.png")));
		mnTema.add(mntmClassic);
		
		mntmDark = new JMenuItem("Dark");
		mntmDark.setIcon(new ImageIcon(Alumnos.class.getResource("/adrsoft/scool/resources/images/mid/50_percent_off.png")));
		mnTema.add(mntmDark);
		
		mntmLight = new JMenuItem("Light");
		mntmLight.setIcon(new ImageIcon(Alumnos.class.getResource("/adrsoft/scool/resources/images/mid/50_percent_off.png")));
		mnTema.add(mntmLight);
		
		JMenu mnInformacin = new JMenu("Ayuda");
		menuBar.add(mnInformacin);
		
		mntmDocumentacin = new JMenuItem("Documentaci\u00F3n");
		mntmDocumentacin.setIcon(new ImageIcon(Alumnos.class.getResource("/adrsoft/scool/resources/images/mid/full_page.png")));
		mnInformacin.add(mntmDocumentacin);
		
		mntmInformacin = new JMenuItem("Informaci\u00F3n");
	
		mntmInformacin.setIcon(new ImageIcon(Alumnos.class.getResource("/adrsoft/scool/resources/images/mid/info.png")));
		mnInformacin.add(mntmInformacin);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("textHighlight"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setOrientation(SwingConstants.VERTICAL);
		toolBar.setFloatable(false);
		toolBar.setBackground(UIManager.getColor("textHighlight"));
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(153, 204, 255));
		
		JPanel panel = new JPanel();
		panel.add(calendario);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(desktopPane, GroupLayout.PREFERRED_SIZE, 699, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(51, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(toolBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(desktopPane, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(29)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(141, Short.MAX_VALUE))
		);
		
		btnNewButton = new JButton("");
		btnNewButton.setBackground(UIManager.getColor("textHighlight"));
		btnNewButton.setToolTipText("Perfil");
		btnNewButton.setIcon(new ImageIcon(Alumnos.class.getResource("/adrsoft/scool/resources/images/high/male_user_info.png")));
		toolBar.add(btnNewButton);
		
		btnNewButton_1 = new JButton("");
		btnNewButton_1.setToolTipText("Mensajeria");
		btnNewButton_1.setBackground(UIManager.getColor("textHighlight"));
		btnNewButton_1.setIcon(new ImageIcon(Alumnos.class.getResource("/adrsoft/scool/resources/images/high/yellow_mail.png")));
		toolBar.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("");
		btnNewButton_2.setBackground(UIManager.getColor("textHighlight"));
		btnNewButton_2.setIcon(new ImageIcon(Alumnos.class.getResource("/adrsoft/scool/resources/images/high/tablet.png")));
		toolBar.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("");
		btnNewButton_3.setBackground(UIManager.getColor("textHighlight"));
		btnNewButton_3.setIcon(new ImageIcon(Alumnos.class.getResource("/adrsoft/scool/resources/images/high/office_folders.png")));
		toolBar.add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("");
		btnNewButton_4.setBackground(UIManager.getColor("textHighlight"));
		btnNewButton_4.setIcon(new ImageIcon(Alumnos.class.getResource("/adrsoft/scool/resources/images/high/package.png")));
		toolBar.add(btnNewButton_4);
		contentPane.setLayout(gl_contentPane);
	
		
	}

	
	private void createEvents(){
		mntmInformacin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showConfirmDialog(null, "Proyecto de CFGS DAM 2013 \nCreado por: Adrian Peña Gomez\nProyecto de fin de ciclo del grado superior Desarrollo de Aplicaciones Multiplataforma\nI.E.S. Miguel Herrero Pereda 2013","Acerca de..",JOptionPane.DEFAULT_OPTION);
				
			}
		});
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
}
