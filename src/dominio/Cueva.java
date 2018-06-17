
package dominio;

import javafx.scene.image.Image;

/**
 *
 * @author Nicole Fonseca, Wilmer Mata
 */
public class Cueva {
    private int x;
    private int y;
    private Image image;
    
    private static Cueva cueva = new Cueva();
    
    private Cueva() { }

    public Cueva(int x, int y, Image image) {
        this.x = x;
        this.y = y;
        this.image = image;
    }
    
    public static Cueva getCueva() {
        return cueva;
    }

    public Cueva(int xTierra, int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Cueva(Cueva cuevaO) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
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

    /**
     * @param aCueva the cueva to set
     */
    public static void setCueva(Cueva aCueva) {
        cueva = aCueva;
    }

    
   
}
