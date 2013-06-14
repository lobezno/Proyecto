package adrsoft.scool.model;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.Timer;

import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;


/**
 * Clase encargada de simular un chat.<br><br>
 * Se crea dentro de un componente JTextPane y simula un chat lanzando cada un tiempo aleatorio un 
 * mensaje lanzado por un supuesto interlocutor.<br><br>También decora las líneas de cada usuario con 
 * un color diferente, agregandole facilidad de reconocimiento de cada interlocutor.<br><br>También crea 
 * un botón y una caja de texto para que el usuario activo pueda mandar sus mensajes.
 * 
 * @author adrSoft
 * @version vAlpha10
 *
 */
public class FakeChat extends JFrame{	
	
    
	/*
	 * Campos
	 */
    	private static final long serialVersionUID = 1L;
	private int delay;
	private Timer timer;
	private JTextPane chatArea;
	private String []frases ={"Hola\n",
		    "Que tal\n",
		    "Colosal\n",
		    "Y tu que tal?\n",
		    "Fenomenal\n",
		    "Pues me alegro\n"};
	private String [] nombres = {
			"Luis: ",
			"Alvaro: ",
			"Irene: ",
			"Ataulfo: ",
			"Sandra: ",
			"Javier: "};

	/**
	 * Constructor de la clase.<br>
	 * Se le pasa como argumento el componente(un JTextPane) sobre el que vamos a inicializar el chat.
	 * @param area = El cmponente(JTextPane) sobre el que queremos ejecutar la clase.
	 * @author adrSoft
	 * @version vAlpha10
	 */
	public FakeChat(JTextPane area) {
		this.chatArea = area;
		chat(chatArea);
	}

	 /**
	  * Método encargado de simular una conversación tipo chat dentro del panelChat.
	  * Los mensajes predeterminados son establecidos con anterioridad.<br><br>
	  * 
	  * Envia un mensaje al chat en un intervalo de entre medio segundo y 6 segundos, pintando
	  * cada interlocutor con un color diferente para una facil diferenciación.
	  * @author adrSoft
	  * @version vAlpha10
	  * @param chatArea = Componente(TextPane) sobre el que queremos ejecutar el método  chat.
	  */
	protected void chat(final JTextPane chatArea) {

		ActionListener taskPerformer = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
		    	Random rand = new Random();
		    	float r = rand.nextFloat();
		    	float g = rand.nextFloat();
		    	float b = rand.nextFloat();
		    	Color randomColor = new Color(r, g, b);
				    delay = (int)Math.floor(Math.random()*(6000-500+1)+500);
				    appendToPane(chatArea,nombres[(int)Math.floor(Math.random()*frases.length)] + frases[(int)Math.floor(Math.random()*frases.length)], randomColor);
			  timer.stop();
			  chat(chatArea);

			}
		};
		  timer = new Timer(delay, taskPerformer);
		  timer.start();
		
		
	}

	/**
	 * Método encargado de añadir un mensaje personalizado al componente indicado.
	 * Se encarga de aplicarle un color y de añadir un salto de línea despues de añadirlo.
	 * @author adrSoft
	 * @version vAlpha10
	 * @param tp = Componente al que añadir el mensaje.
	 * @param msg = El mensaje a añadir.
	 * @param c = Color deseado para el mensaje.
	 */
	public void appendToPane(JTextPane tp, String msg, Color c) {

        StyleContext sc = StyleContext.getDefaultStyleContext();
        AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, c);

        aset = sc.addAttribute(aset, StyleConstants.FontFamily, "Lucida Console");
        aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);

        int len = tp.getDocument().getLength();
        tp.setCaretPosition(len);
        tp.setCharacterAttributes(aset, false);
        tp.replaceSelection(msg);
    
		
	}

}
