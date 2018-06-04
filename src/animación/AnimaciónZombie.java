
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

public class AnimaciónZombie extends Zombie{

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
    
    public void hiloZombie() {   
        ArrayList<Image> sprite = super.getSprite();
        Runnable runnable = () -> {
            while (true) {
                try {
                    int j = 0; //Indice en lista de imágenes.
                    for (int i = 0; i <= 700; i += 10) { //Recorrido del zombie.
                        if (j >= 2) {
                            j = 0;
                        }
                        super.setImage(sprite.get(j));
                        super.setX(i);
                        super.setY(100);
                        Thread.sleep(900);
                        j++;
                    }

                } catch (InterruptedException ex) {
                }
            }
        };
        
        Thread hiloZombie = new Thread(runnable);
        hiloZombie.start();
    }
    
}
