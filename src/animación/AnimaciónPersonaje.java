
package animación;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Nicole Fonseca, Wilmer Mata
 */
public class AnimaciónPersonaje {
    ImageView imageViewPersonaje1;
    public void moverPersonaje(AnchorPane anchorPane) {

        anchorPane.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.UP) {
                imageViewPersonaje1 = new ImageView(new Image("/starlord/derecha.png"));
                anchorPane.getChildren().add(imageViewPersonaje1);
            }
            if (e.getCode() == KeyCode.RIGHT) {
               
            }
            if (e.getCode() == KeyCode.LEFT) {
            }
            if (e.getCode() == KeyCode.A) {
                System.out.println("espada");
            }
            if (e.getCode() == KeyCode.S) {
                System.out.println("látigo");
            }
            if (e.getCode() == KeyCode.D) {
                System.out.println("pala");
            }
        });

    }
}
