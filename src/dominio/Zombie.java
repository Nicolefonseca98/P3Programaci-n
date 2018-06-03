
package dominio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.scene.image.Image;


/**
 *
 * @author Nicole Fonseca, Wilmer Mata
 */
public class Zombie extends Personaje{

    public Zombie() {
    }

    public Zombie(int x, int y, int imgNum) throws FileNotFoundException {
        super(x, y, imgNum);
        setSprite();
    }
    
    
    public void setSprite() throws FileNotFoundException {
        ArrayList<Image> sprite = super.getSprite();
        sprite.add(new Image(new FileInputStream("zombie/zombie1.png")));
    }

    public void run() {
        ArrayList<Image> sprite = super.getSprite();
        Runnable runnable = () -> {
            while (true) {
                try {
                    for (int i = 60; i <= 190; i += 10) {

                        super.setImage(new Image("zombie/zombie1.png"));
                        super.setX(i);
                        super.setY(100);
                        Thread.sleep(500);
                    }

                } catch (InterruptedException ex) {
                }
            }
        };

        Thread t = new Thread(runnable);
        t.start();
    }
}

