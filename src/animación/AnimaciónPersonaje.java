
package animación;

import dominio.Personaje;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;

/**
 *
 * @author Nicole Fonseca, Wilmer Mata
 */
public class AnimaciónPersonaje extends Personaje{

    public AnimaciónPersonaje() {
    }

    public AnimaciónPersonaje(int x, int y) throws FileNotFoundException {
        super(x, y);
        setSprite();
    }
    
    public void setSprite() throws FileNotFoundException {
        ArrayList<Image> sprite = super.getSprite();
        sprite.add(new Image(new FileInputStream("src/starlord/sl1.png")));
        sprite.add(new Image(new FileInputStream("src/starlord/derecha.png")));
        sprite.add(new Image(new FileInputStream("src/starlord/sl4.png")));
        sprite.add(new Image(new FileInputStream("src/starlord/izquierda.png")));
        sprite.add(new Image(new FileInputStream("src/starlord/derechaEspada.png")));
        sprite.add(new Image(new FileInputStream("src/starlord/derechaLatigo.png")));
        sprite.add(new Image(new FileInputStream("src/starlord/derechaPala.png")));
    }
    
    int x = 100;
    int j = 0;
    public void hiloPersonaje(int y, StackPane stackPane) {
     
        ArrayList<Image> sprite = super.getSprite();
        Runnable runnable = () -> {
            stackPane.setOnKeyPressed(e -> {
                if (j >= 3) { //Indice en lista de imágenes.
                    j = 0;
                }
                if (e.getCode() == KeyCode.RIGHT) {   
                    super.setImage(sprite.get(j));
                    super.setX(x += 10);
                    super.setY(y);
                    j++;
                    
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(AnimaciónPersonaje.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (e.getCode() == KeyCode.LEFT) {
                    super.setImage(sprite.get(3));
                    super.setX(x -= 10);
                    super.setY(y);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(AnimaciónPersonaje.class.getName()).log(Level.SEVERE, null, ex);
                    }
                
                }
                if (e.getCode() == KeyCode.A) {
                    System.out.println("espada");
                    super.setImage(sprite.get(4));
                    super.setX(x += 10);
                    super.setY(y);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(AnimaciónPersonaje.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (e.getCode() == KeyCode.S) {
                    System.out.println("látigo");
                    super.setImage(sprite.get(5));
                    super.setX(x += 10);
                    super.setY(y);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(AnimaciónPersonaje.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (e.getCode() == KeyCode.D) {
                    System.out.println("pala");
                    super.setImage(sprite.get(6));
                    super.setX(x += 10);
                    super.setY(y);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(AnimaciónPersonaje.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
               
            });
        };
        Thread hiloQuimera = new Thread(runnable);
        hiloQuimera.start(); 
    }
}
