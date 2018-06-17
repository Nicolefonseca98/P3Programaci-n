package animación;

import dominio.Quimera;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;
import static minerider.CuevaController.arrayListPersonaje;
import static minerider.CuevaController.arrayListQuimera;

/**
 *
 * @author Nicole Fonseca, Wilmer Mata
 */
public class AnimaciónQuimera extends Quimera implements Runnable{

    AnimaciónPersonaje animaciónPersonaje = new AnimaciónPersonaje();
    int x = super.getX();
    int indiceImagenesIzquierda = 0; 
    int indiceImagenesDerecha = 2;
    
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
        sprite.add(new Image(new FileInputStream("src/quimera/quimeraDerecha.png")));
        sprite.add(new Image(new FileInputStream("src/quimera/quimeraDerechaAtaque.png")));
    }
    
    
    
    @Override
    public void run() {
        ArrayList<Image> sprite = super.getSprite();
        while (true) {
            try {
                if (x > 0) {
                    int contador = x;
                    while (contador >= 0) {
                        if (indiceImagenesIzquierda >= 2) {
                            indiceImagenesIzquierda = 0;
                        }
                        super.setImage(sprite.get(indiceImagenesIzquierda));
                        if (getBoundsQuimera()) {
                            super.setX(contador);
                        }
                        if (!getBoundsQuimera()) {
                            super.setX(contador -= 15);
                        }
                        super.setY(super.getY());
                        Thread.sleep(1000);
                        indiceImagenesIzquierda++;

                        if (contador <= 0) {
                            while (contador <= 770) {
                                if (indiceImagenesDerecha >= 4) {
                                    indiceImagenesDerecha = 2;
                                }
                                super.setImage(sprite.get(indiceImagenesDerecha));
                                if (getBoundsQuimera()) {
                                    super.setX(contador);
                                }
                                if (!getBoundsQuimera()) {
                                    super.setX(contador += 15);
                                }
                                super.setY(super.getY());
                                Thread.sleep(1000);
                                indiceImagenesDerecha++;
                            }
                        }
                    }
                }
            } catch (InterruptedException ex) {
            }
        }
    }
  
    public Boolean llamarada() {
        if (indiceImagenesIzquierda == 1 || indiceImagenesIzquierda == 3) {
            return true;
        } else {
            return false;
        }
    }
    
    public Boolean getBoundsQuimera() {
        try {
            Rectangle quimera = null;
            for (int i = 0; i < arrayListQuimera.size(); i++) {
                Quimera quimeraAux = arrayListQuimera.get(i);
                quimera = new Rectangle(quimeraAux.getX(), quimeraAux.getY(), 35, 40);
                if (quimera.intersects(arrayListPersonaje.get(0).getX(), arrayListPersonaje.get(0).getY(), 35, 40)) {
                    return true;
                }
            }
        } catch (Exception e) {   
        }
        return false;
    }
}
