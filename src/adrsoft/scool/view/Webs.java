package adrsoft.scool.view;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;

public class Webs extends JInternalFrame {


	/**
	 * Create the frame.
	 */
	public Webs() {
		setBounds(100, 100, 710, 612);
		JEditorPane jep = new JEditorPane();
	     jep.setEditable(false);   

	     try {
	       jep.setPage("http://www.oreilly.com");
	     }
	     catch (IOException e) {
	       jep.setContentType("text/html");
	       jep.setText("<html>Could not load http://www.oreilly.com </html>");
	     } 

	     
	     //Necesito que se cargue dentro del main desktoppane
	     JScrollPane scrollPane = new JScrollPane(jep);     
	     JFrame f = new JFrame("O'Reilly & Associates");
	     // Next line requires Java 1.3
	     f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     f.getContentPane().add(scrollPane);
	     f.setSize(512, 342);
	     f.show();

	  }


	}

