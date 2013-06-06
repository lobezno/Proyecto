package adrsoft.scool.club;

import java.awt.Dimension;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Galeria {

    private ArrayList<ImageIcon> fotos = new ArrayList<ImageIcon>();
    private ImageIcon nofoto;

    public Galeria(){
        cargarFotos();
        
    }

    /**
     * M�todo encargado de cargar las fotos desde la carpeta "assets"
     */
    private void cargarFotos() {
    	
    	nofoto = new javax.swing.ImageIcon(getClass().getResource("/fotos/nophoto.jpg"));
        fotos.add(new javax.swing.ImageIcon(getClass().getResource("/fotos/clubs/lectura/0.jpg")));
        fotos.add(new javax.swing.ImageIcon(getClass().getResource("/fotos/clubs/lectura/1.jpg")));
        fotos.add(new javax.swing.ImageIcon(getClass().getResource("/fotos/clubs/lectura/2.jpg")));
        fotos.add(new javax.swing.ImageIcon(getClass().getResource("/fotos/clubs/lectura/3.jpg")));
        fotos.add(new javax.swing.ImageIcon(getClass().getResource("/fotos/clubs/lectura/4.jpg")));
 
	}

	/* devuelve una imagen de tama�o 100x100 VISTA PREVIA */
    public Icon getPreview(int num){
        if( num>=0 & num<fotos.size() )
        {
            Image mini = fotos.get(num).getImage().getScaledInstance(100, 100, Image.SCALE_AREA_AVERAGING);
            return new ImageIcon(mini);
        }
        else
        {
            Image mini = nofoto.getImage().getScaledInstance(100, 100, Image.SCALE_AREA_AVERAGING);
            return new ImageIcon(mini);
        }
    }

   /* devuelve la foto original, pero si el tama�o es mayor al contenedor, lo redimensiona */
   public Icon getFoto(int num, Dimension d){
        if( num>=0 & num<fotos.size() )
        {
            //si la foto es mas grande que el contendor -> redimensionar
            if(fotos.get(num).getIconWidth()>d.getWidth()){
                float v = getValor(fotos.get(num).getIconWidth(),d.width);
                return Disminuir(fotos.get(num),v);
            }else if(fotos.get(num).getIconHeight()>d.getHeight()){
                float v = getValor(fotos.get(num).getIconHeight(),d.height);
                return Disminuir(fotos.get(num),v);
            }else{
                return fotos.get(num);
            }
        }
        else
        {
            Image mini = nofoto.getImage().getScaledInstance(400, 400, Image.SCALE_AREA_AVERAGING);
            return new ImageIcon(mini);
        }
    }

   /* redimensiona la imagen en para que ingrese al contendor pero manteniendo sus proporciones*/
    private ImageIcon Disminuir(ImageIcon i, float v){
        int valEscalaX = (int) (i.getIconWidth() * v );
        int valEscalaY = (int) (i.getIconHeight() * v );
        Image mini = i.getImage().getScaledInstance(valEscalaX, valEscalaY, Image.SCALE_AREA_AVERAGING);
        return new ImageIcon(mini);
     }

    /* devuelve el valor de escala para redimensionar la imagen*/
    private float getValor(int a, int b){
        return Math.abs((a/new Float(b))-2f);
    }
}