package animación;

import dominio.Zombie;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.scene.image.Image;

/**
 *
 * @author Nicole Fonseca, Wilmer Mata
 */
public class AnimaciónZombie extends Zombie implements Runnable{

    int j = 0; //Indice en lista de imágenes.

    public AnimaciónZombie() {
    }

    public AnimaciónZombie(int x, int y) throws FileNotFoundException {
        super(x, y);
        setSprite();
    }

    public void setSprite() throws FileNotFoundException {
        ArrayList<Image> sprite = super.getSprite();
        sprite.add(new Image(new FileInputStream("src/zombie/zombie1.png")));
        sprite.add(new Image(new FileInputStream("src/zombie/zombieDerechaAtaque.png")));
    }

    @Override
    public void run() {
        ArrayList<Image> sprite = super.getSprite();
        while (true) {
            try {
                for (int x = super.getX(); x <= 700; x += 2) { //Recorrido del zombie.
                    if (j >= 2) {
                        j = 0;
                    }
                    super.setImage(sprite.get(j));
                    super.setX(x);
                    super.setY(super.getY());
                    Thread.sleep(400);
                    j++;
                }
            } catch (InterruptedException ex) {
            }
        }
    }
 
    public Boolean muerdeCerebro() {
        if (j == 1) {
            return true;
        } else {
            return false;
        }
    }

    
}
