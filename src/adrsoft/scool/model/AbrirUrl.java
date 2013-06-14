package adrsoft.scool.model;

import java.io.IOException;

/**
 * Clase encargada de abrir un explorador de internet y mostrar la dirección solicitada.<br><br>
 * Funciona con Windows y con Mac OS X
 * @author adrSoft
 * @version vAlpha10
 *
 */
public class AbrirUrl {

    	/**
    	 * Constructor al que se le pasa como parámetro un string con la dirección de la página a mostrar.
    	 * @author adrSoft
    	 * @version vAlpha10
    	 * @param url
    	 */
	public AbrirUrl(String url){
		String osName = System.getProperty("os.name");
	    try {
	        if (osName.startsWith("Windows")) {
	            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
	        } else if (osName.startsWith("Mac OS X")) {
	            // Runtime.getRuntime().exec("open -a safari " + url);
	            // Runtime.getRuntime().exec("open " + url + "/index.html");
	            Runtime.getRuntime().exec("open " + url);
	        } else {
	            System.out.println("Please open a browser and go to "+ url);
	        }
	    } catch (IOException e) {
	        System.out.println("Failed to start a browser to open the url " + url);
	        e.printStackTrace();
	    }	
	}
    

}
