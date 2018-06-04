
package dominio;

import javafx.scene.image.Image;

/**
 *
 * @author Nicole Fonseca, Wilmer Mata
 */
public class Cueva {
    private int tamaño;
    private Image image;
    
    private static final Cueva cueva = new Cueva();
    
    private Cueva() { }
    
    public static Cueva getCueva() {
        return cueva;
    }

    public Cueva(int tamaño, Image image) {
        this.tamaño = tamaño;
        this.image = image;
    }

    /**
     * @return the tamaño
     */
    public int getTamaño() {
        return tamaño;
    }

    /**
     * @param tamaño the tamaño to set
     */
    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    /**
     * @return the image
     */
    public Image getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(Image image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Cueva{" + "tama\u00f1o=" + tamaño + ", image=" + image + '}';
    }

   
}
