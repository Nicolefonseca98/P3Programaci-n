package animación;

import dominio.Quimera;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.image.Image;

/**
 *
 * @author Nicole Fonseca, Wilmer Mata
 */
public class AnimaciónQuimera extends Quimera {
    Thread hiloQuimera;
    int j = 0; //Indice en lista de imágenes.

    public AnimaciónQuimera() {
    }

    public AnimaciónQuimera(int x, int y) throws FileNotFoundException {
        super(x, y);
        setSprite();
    }

    public void setSprite() throws FileNotFoundException {
        ArrayList<Image> sprite = super.getSprite();
        sprite.add(new Image(new FileInputStream("src/quimera/quimeraIzquierda.png")));
        sprite.add(new Image(new FileInputStream("src/quimera/quimeraIzquierdaAtaque.png")));
    }

    public void hiloQuimera() {
        ArrayList<Image> sprite = super.getSprite();
        Runnable runnable = () -> {
            while (true) {
                try {
                    for (int x = super.getX(); x >= 0; x -= 15) { //Recorrido de la quimera.
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
        hiloQuimera = new Thread(runnable);
        hiloQuimera.start();

    }
    
    public void duermeQuimera() throws InterruptedException{
        Thread.currentThread().getName();
    }

    public Boolean llamarada() {
        if (j == 1) {
            return true;
        } else {
            return false;
        }
    }

}
