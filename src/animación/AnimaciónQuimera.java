
package animación;

import dominio.Quimera;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.scene.image.Image;

/**
 *
 * @author Nicole Fonseca, Wilmer Mata
 */
public class AnimaciónQuimera extends Quimera{

    public AnimaciónQuimera() {
    }

    public AnimaciónQuimera(int x, int y) throws FileNotFoundException {
        super(x, y);
        setSprite();
    }
    
    public void setSprite() throws FileNotFoundException {
        ArrayList<Image> sprite = super.getSprite();
        sprite.add(new Image(new FileInputStream("src/quimera/quimeraDerecha.png")));
        sprite.add(new Image(new FileInputStream("src/quimera/quimeraDerechaAtaque.png")));
    }
    
    public void hiloQuimera() {   
        ArrayList<Image> sprite = super.getSprite();
        Runnable runnable = () -> {
            while (true) {
                try {
                    int j = 0; //Indice en lista de imágenes.
                    for (int i = 0; i <= 700; i += 10) { //Recorrido de la quimera.
                        if (j >= 2) {
                            j = 0;
                        }
                        super.setImage(sprite.get(j));
                        super.setX(i);
                        super.setY(300);
                        Thread.sleep(500);
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
