
package animación;

import javafx.scene.image.Image;

/**
 *
 * @author Nicole Fonseca, Wilmer Mata
 */
public enum Sprite {
    
    STARLORD_DERECHA("/starlord/derecha.png"),
    STARLORD_IZQUIERDA("/starlord/izquierda.png"),
    STARLORD_DERECHA_ESPADA("/starlord/derechaEspada.png"),
    STARLORD_IZQUIERDA_ESPADA("/starlord/izquierdaEspada.png"),
    STARLORD_DERECHA_LATIGO("/starlord/derechaLatigo.png"),
    STARLORD_IZQUIERDA_LATIGO("/starlord/izquierdaLatigo.png"),
    STARLORD_DERECHA_PALA("/starlord/derechaPala.png"),
    STARLORD_IZQUIERDA_PALA("/starlord/izquierdaPala.png"),
    CORAZÓN_LLENO("/starlord/heart.png"),
    CORAZÓN_VACÍO("/starlord/emptyHeart.png"),
    FONDO("/cueva/fondo.png");
    
    private final Image image;
    
    private Sprite(String path) {
        image = new Image(getClass().getResource(path).toExternalForm());
    }
    
    public Image getImage() {
        return image;
    }
}
