package adrsoft.scool.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

public class Webs extends JInternalFrame {

    private JEditorPane editorPane;
    private JScrollPane scrollPane;
    private String ruta =  "http://www.iesmiguelherrero.com/";
    private JButton mWeb;
    private JButton mIntra;
	
	/**
	 * Create the frame.
	 */
	public Webs() {
		init();
		cargarWeb(ruta);
		createEvents();

	  }

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

	private void createEvents() {
		mWeb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cargarWeb("http://www.iesmiguelherrero.com/");
				
			}
		});
		
		mIntra.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				cargarWeb("http://chamilo.iesmiguelherrero.com/");
				
			}
		});
		
	}

	private void init() {
		setBounds(100, 100, 710, 612);
		((javax.swing.plaf.basic.BasicInternalFrameUI) 
				getUI()).setNorthPane(null);
		 JPanel buttonPane = new JPanel();
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


	}

