
package dominio;

import animación.Sprite;
import javafx.scene.Node;
import javafx.scene.image.ImageView;

/**
 *
 * @author Nicole Fonseca, Wilmer Mata
 */
public class Personaje {

    private ImageView imageView = new ImageView();
    private Sprite sprite;

    public Personaje() {
    }
    
    public Personaje(Sprite sprite) {
        setSprite(sprite);
    }
  
    public final Sprite getSprite() {
        return sprite;
    }
    
    public final void setSprite(Sprite sprite) {
        this.sprite = sprite;
        imageView.setImage(sprite.getImage());
    }
    
    public final Node getNode() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }
    
  

    
}
