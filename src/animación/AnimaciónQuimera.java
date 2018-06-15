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
public class AnimaciónQuimera extends Quimera implements Runnable{
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

    @Override
    public void run() {
       ArrayList<Image> sprite = super.getSprite();
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
    }
  
    public Boolean llamarada() {
        if (j == 1) {
            return true;
        } else {
            return false;
        }
    }

    

}
