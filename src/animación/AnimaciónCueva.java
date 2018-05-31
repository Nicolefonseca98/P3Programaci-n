
package animación;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Nicole Fonseca, Wilmer Mata
 */
public class AnimaciónCueva {
    
    public ImageView[][] matrizCueva(String url){
        
        ImageView[][] cueva = new ImageView[3][3];
        for (int i = 0; i < cueva.length; i++) {
            for (int j = 0; j < cueva[0].length; j++) {
                cueva[i][j] = new ImageView(new Image(url));
            }
        }
       return cueva;
    }
    
}
