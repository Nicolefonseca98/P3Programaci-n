
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
    private int imgNum;
    private Image image;
    private ArrayList<Image> sprite;

    public Personaje() {
    }

    public Personaje(int x, int y, int imgNum) {
        this.x = x;
        this.y = y;
        this.imgNum = imgNum;
//        this.image = image;
        this.sprite = sprite;
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
     * @return the imgNum
     */
    public int getImgNum() {
        return imgNum;
    }

    /**
     * @param imgNum the imgNum to set
     */
    public void setImgNum(int imgNum) {
        this.imgNum = imgNum;
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
        return "Personaje{" + "x=" + x + ", y=" + y + ", imgNum=" + imgNum + ", image=" + image + ", sprite=" + sprite + '}';
    }

}
