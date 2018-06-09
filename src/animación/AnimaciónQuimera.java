
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

    public AnimaciónQuimera(int x, int y) throws FileNotFoundException {
        super(x, y);
        setSprite();
    }
    
    public void setSprite() throws FileNotFoundException {
        ArrayList<Image> sprite = super.getSprite();
        sprite.add(new Image(new FileInputStream("src/quimera/quimeraIzquierda.png")));
        sprite.add(new Image(new FileInputStream("src/quimera/quimeraIzquierdaAtaque.png")));
    }

    public void hiloQuimera()  {
        ArrayList<Image> sprite = super.getSprite();
        int[][] matriz = new int[5][5];
        Runnable runnable = () -> {
            while (true) {
                try {
                    System.out.println("hola");
//                    int j = 0; //Indice en lista de imágenes.
//                    for (int x = super.getX(); x >= 0; x -= 2) { //Recorrido del zombie.
//                        if (j >= 2) {
//                            j = 0;
//                        }
//                        super.setImage(sprite.get(j));
//                        super.setX(x);
//                        super.setY(super.getY());
//                        for (int i = 0; i < matriz.length; i++) {
//                            for (int j = 0; j < matriz[0].length; j++) {
//                                System.out.println(matriz[i][j]);
//                            }
//                            
//                    }
                        
                        Thread.sleep(400);
//                        j++;
//                    }

                } catch (InterruptedException ex) {
                }
            }
        };
        Thread hiloQuimera = new Thread(runnable);
        hiloQuimera.start();
    }
   
}
