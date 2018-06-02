
package dominio;

import animación.Sprite;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Transform;

/**
 *
 * @author Nicole Fonseca, Wilmer Mata
 */
public class Personaje {

    private final ImageView imageView = new ImageView();
    private Sprite sprite;
    private boolean horizontal = false;
//    private final NodeBinding binding; 
    
    public Personaje(Sprite sprite) {
//        this.binding = binding;
        setSprite(sprite);
    }
    
    //Sprite 
    public final Sprite getSprite() {
        return sprite;
    }
    
    public final void setSprite(Sprite sprite) {
        this.sprite = sprite;
        imageView.setImage(sprite.getImage());
//        binding.bind(node, x, y);
        
        boolean volteadoHorizontalmenete = horizontal;
        quitarTransformación();
        if (volteadoHorizontalmenete) {
            horizontal();
        }
    }
    
    public final Node getNode() {
        return imageView;
    }
    
    public final void horizontal() {
        imageView.getTransforms().add(Transform.scale(-1, 1, imageView.getBoundsInLocal().getWidth() / 2, imageView.getBoundsInLocal().getHeight() / 2));
        horizontal = true;
    }
    
    public final void quitarTransformación() {
        imageView.getTransforms().clear();
        horizontal = false;
    }
    
//     /* POSITION, VELOCITY & ACCELERATION */
//    
//    private final DoubleProperty x = new SimpleDoubleProperty(0);
//    private final DoubleProperty y = new SimpleDoubleProperty(0);    
//    
//    private Vector2D p = Vector2D.ZERO;
//    private Vector2D v = Vector2D.ZERO;
//    private Vector2D a = Vector2D.ZERO;
//    
//    public final Vector2D getPosition() {
//        return p;
//    }
//
//    public final void setPosition(Vector2D p) {
//        this.p = p;
//        x.set(p.getX());
//        y.set(p.getY());
//    }
//    
//    public final Vector2D getVelocity() {
//        return v;
//    }
//    
//    public final void setVelocity(Vector2D v) {
//        this.v = v;
//    }
//    
//    public final Vector2D getAcceleration() {
//        return a;
//    }
//    
//    public final void setAcceleration(Vector2D a) {
//        this.a = a;
//    }
    
}
