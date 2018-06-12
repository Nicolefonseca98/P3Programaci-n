
package dominio;


import java.util.ArrayList;
import javafx.scene.image.Image;

/**
 *
 * @author Nicole Fonseca, Wilmer Mata
 */
public class Personaje {

    private int x;
    private int y;
    private Image imagen;
    private ArrayList<Image> sprite;
    private int heart;

    public Personaje() {
    }

    public Personaje(int x, int y) {
        this.x = x;
        this.y = y;
        this.sprite = new ArrayList<>();

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
        return imagen;
    }

    /**
     * @param image the image to set
     */
    public void setImage(Image image) {
        this.imagen = image;
    }

    /**
     * @return the sprite
     */
    public ArrayList<Image> getSprite() {
        return sprite;
    }

    /**
     * @param sprite the sprite to set
     */
    public void setSprite(ArrayList<Image> sprite) {
        this.sprite = sprite;
    }

    @Override
    public String toString() {
        return "Personaje{" + "x=" + x + ", y=" + y + ", image=" + imagen + ", sprite=" + sprite + ", heart=" + heart + '}';
    }

}
