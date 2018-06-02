
package animación;

import dominio.Quimera;
import dominio.Zombie;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Nicole Fonseca, Wilmer Mata
 */
public class AnimaciónMonstruos {
    
    public void hiloZombie(AnchorPane anchorPane) {
        ArrayList listaImagenes = new ArrayList();
        listaImagenes.add("/zombie/zombieAbajo.png");
        listaImagenes.add("/zombie/zombieAbajoAtaque.png");
        listaImagenes.add("/zombie/zombieArriba.png");
        listaImagenes.add("/zombie/zombieArribaAtaque.png");
        listaImagenes.add("/zombie/zombieDerecha.png");
        listaImagenes.add("/zombie/zombieDerechaAtaque.png");
        listaImagenes.add("/zombie/zombieIzquierda.png");
        listaImagenes.add("/zombie/zombieIzquierdaAtaque.png");
//        Zombie zombie = new Zombie(0, 0, listaImagenes);
//        ImageView imageViewZombie = new ImageView(new Image(zombie.getListaUrlImagenes().get(0).toString()));
//        anchorPane.getChildren().add(imageViewZombie);
        
        Runnable runnable = () -> {
            for (int i = 0; i < 5; i++) {
                try {     
                    
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(AnimaciónMonstruos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
    
        Thread t = new Thread(runnable);
        t.start();
    }
    
    public void hiloQuimera() {
//        ArrayList listaImagenes = new ArrayList();
//        Quimera quimera = new Quimera(0, 0, listaImagenes);
//        
//        Runnable runnable = () -> {
//            for (int i = 0; i < 5; i++) {
//                try {
//                    Thread.sleep(1000);
//                    System.out.println("Quimera");
//                } catch (InterruptedException ex) {
//                    Logger.getLogger(AnimaciónMonstruos.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        };
//    
//        Thread t = new Thread(runnable);
//        t.start();
    }
    
}
