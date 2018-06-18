package animación;

import dominio.Quimera;
import dominio.Zombie;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;
import static minerider.CuevaController.arrayListPersonaje;
import static minerider.CuevaController.arrayListZombie;

/**
 *
 * @author Nicole Fonseca, Wilmer Mata
 */
public class AnimaciónZombie extends Zombie implements Runnable{

    int indiceImagenesDerecha = 0; 
    int indiceImagenesIzquierda = 2; 
    int x = super.getX();
    
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
        sprite.add(new Image(new FileInputStream("src/zombie/zombie2.png")));
        sprite.add(new Image(new FileInputStream("src/zombie/zombieIzquierdaAtaque.png")));
    }

    @Override
    public void run() {
        ArrayList<Image> sprite = super.getSprite();
        
        while (true) {
            try {
                if (x <= 770) {
                        int contador = x;
                        while(contador <= 770) {
                        if (indiceImagenesDerecha >= 2) {
                            indiceImagenesDerecha = 0;
                        }
                        super.setImage(sprite.get(indiceImagenesDerecha));
                        if(getBoundsZombie()) {
                            super.setX(contador);
                        }
                        if(!getBoundsZombie()) {
                            super.setX(contador += 2);
                        }
                        super.setY(super.getY());
                        Thread.sleep(400);
                        indiceImagenesDerecha++;

                        if (contador >= 770) {
                                while(contador > 0) {
                                if (indiceImagenesIzquierda >= 4) {
                                    indiceImagenesIzquierda = 2;
                                    }
                                    super.setImage(sprite.get(indiceImagenesIzquierda));
                                    if (getBoundsZombie()) {
                                        super.setX(contador);
                                    }
                                    if (!getBoundsZombie()) {
                                        super.setX(contador -= 2);
                                    }
                                super.setY(super.getY());
                                Thread.sleep(400);
                                indiceImagenesIzquierda++;
                            }
                        }
                    }
                }
              
            } catch (InterruptedException ex) {
            }
        }
    }
 
    public Boolean muerdeCerebro() {
        if (indiceImagenesDerecha == 1 || indiceImagenesIzquierda == 3) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean getBoundsZombie() {
        try {
            for (int i = 0; i < arrayListZombie.size(); i++) {
                Zombie zombieAux = arrayListZombie.get(i);
                Rectangle zombie = new Rectangle(zombieAux.getX(), zombieAux.getY(), 35, 40);
                if (zombie.intersects(arrayListPersonaje.get(0).getX(), arrayListPersonaje.get(0).getY(), 35, 40)) {
                    return true;
                }
            }
        } catch (Exception e) {   
        }
        return false;
    }
    
    public Rectangle boundsZombie() {
        Rectangle zombie = null;
        for (int i = 0; i < arrayListZombie.size(); i++) {
            Zombie ZombieAux = arrayListZombie.get(i);
            zombie = new Rectangle(ZombieAux.getX(), ZombieAux.getY(), 35, 40);
            if (zombie.intersects(arrayListPersonaje.get(0).getX(), arrayListPersonaje.get(0).getY(), 35, 40)) {
                return zombie;
            }
        }
        return null;
    }
}
