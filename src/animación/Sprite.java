
package animación;

import javafx.scene.image.Image;

/**
 *
 * @author Nicole Fonseca, Wilmer Mata
 */
public enum Sprite {
    
    STARLORD_DERECHA("/starlord/derecha.png"),
    STARLORD_IZQUIERDA("starlord/izquierda.png");
    
    private final Image image;
    
    private Sprite(String path) {
        image = new Image(getClass().getResource(path).toExternalForm());
    }
    
    public Image getImage() {
        return image;
    }
}
