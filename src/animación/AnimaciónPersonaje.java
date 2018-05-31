
package animación;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

/**
 *
 * @author Nicole Fonseca, Wilmer Mata
 */
public class AnimaciónPersonaje {
    
    public void moverPersonaje(Scene escena) {
        escena.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.UP) {
                System.out.println("arriba");
            }
            if (e.getCode() == KeyCode.RIGHT) {
                System.out.println("derecha");
            }
            if (e.getCode() == KeyCode.LEFT) {
                System.out.println("izquierda");
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
