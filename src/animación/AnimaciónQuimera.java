
package animación;

import dominio.Quimera;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Nicole Fonseca, Wilmer Mata
 */
public class AnimaciónQuimera extends Quimera{

    public AnimaciónQuimera() {
    }

    public AnimaciónQuimera(int x, int y, int heart) throws FileNotFoundException {
        super(x, y, heart);
        setSprite();
    }
    
    public void setSprite() throws FileNotFoundException {
        ArrayList<Image> sprite = super.getSprite();
        sprite.add(new Image(new FileInputStream("src/quimera/quimeraIzquierda.png")));
        sprite.add(new Image(new FileInputStream("src/quimera/quimeraIzquierdaAtaque.png")));
    }

    public void hiloQuimera()  {
       ArrayList<Image> sprite = super.getSprite();
        Runnable runnable = () -> {
            while (true) {
                try {
                    int j = 0; //Indice en lista de imágenes.
                    for (int x = super.getX(); x >= 0; x -= 10) { //Recorrido de la quimera.
                        if (j >= 2) {
                            j = 0;
                        }
                        super.setImage(sprite.get(j));
                        super.setX(x);
                        super.setY(super.getY());
                        Thread.sleep(1000);
                        j++;
                    }

                } catch (InterruptedException ex) {
                }
            }
        };
        Thread hiloQuimera = new Thread(runnable);
        hiloQuimera.start();
    }
   
}
