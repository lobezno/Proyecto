package adrsoft.scool.model;
import java.awt.Color;
import java.io.File;
import java.io.IOException;

import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;




public class LeeExcel {

	private JTextPane panel;
	private String textoanterior = "";
    
    
    public LeeExcel(JTextPane panelo){
    	this.panel = panelo;
    	init();
    }



	private String init() {

			//Ubicaci�n del archivo XLS
	        String archivo="inventarioLectura.xls";
	 
	        //Creamos un Workbook para cargar el XLS en memoria 
	        Workbook workbook = null;
	        try {
		    workbook = Workbook.getWorkbook(new File(archivo));
	        } catch (BiffException e) {
		    e.printStackTrace();
	        } catch (IOException e) {
		    e.printStackTrace();
	        }
	        //Elegimos la primera hoja
	        Sheet sheet = workbook.getSheet(0);
	        //inicializo el objeto que leer� el valor de la celda
	        Cell celdaCurso = null;
	        //Este String guardar� el valor de la celda
	        String valorCeldaCurso=null;
	 
	        //Obtengo el n�mero de filas ocupadas en la hoja
	        int rows=sheet.getRows();
	        //Obtengo el n�mero de columnas ocupadas en la hoja
	        int cols=sheet.getColumns();
	 
	        //Para efectos de ejemplo recorremos las columnas de cada fila
	        for(int x=0;x<rows;x++){
	            for(int y=0; y<cols; y++){
	                //Obtenemos el valor de la celda de la columna Y y fila X
	                celdaCurso= sheet.getCell(y,x);
	                //Obtenemos el valor de la celda
	                 valorCeldaCurso= celdaCurso.getContents();
	                 if(y==1)
	                	 appendToPane(panel, valorCeldaCurso + "\t\t", Color.BLACK);
	                 else
	                	 appendToPane(panel, valorCeldaCurso + "\t", Color.BLACK);
	              
	        
	            }
	           appendToPane(panel, "\n", Color.RED);
	 
	        }
	 
	        workbook.close();
	    
	    return valorCeldaCurso;
	}
	
	/**
	 * M�todo encargado de a�adir un mensaje personalizado al componente indicado.
	 * Se encarga de aplicarle un color y de a�adir un salto de l�nea despues de a�adirlo.
	 * @param tp = Componente al que a�adir el mensaje.
	 * @param msg = El mensaje a a�adir.
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
