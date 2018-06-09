
package animación;

import dominio.Personaje;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;

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
    
    int x = 0;
    int j = 0;
    public GridPane hiloPersonaje(StackPane stackPane) {
        GridPane gridPane = new GridPane();
        ImageView imageView = new ImageView();
        imageView.setImage(super.getSprite().get(0));
        gridPane.add(imageView, x, 63);
        gridPane.setHgap(20);
        gridPane.setVgap(5);
        x++;
        
        ArrayList<Image> sprite = super.getSprite();
            stackPane.setOnKeyPressed(e -> {
                if (j >= 3) { //Indice en lista de imágenes.
                    j = 0;
                }
                if (e.getCode() == KeyCode.RIGHT) {
                    gridPane.getChildren().clear();
                    imageView.setImage(super.getSprite().get(j));
                    gridPane.add(imageView, x, 63);
                    x++;
                    j++;
                }
                if (e.getCode() == KeyCode.LEFT) {
                    gridPane.getChildren().clear();
                    imageView.setImage(super.getSprite().get(3));
                    gridPane.add(imageView, x, 63);
                    x--;
                }
                if (e.getCode() == KeyCode.A) {
                    imageView.setImage(super.getSprite().get(4));
//                    AudioClip note = new AudioClip(this.getClass().getResource("/music/espada.wav").toString());
//                    note.play();
                    
                }
                if (e.getCode() == KeyCode.S) {
                    imageView.setImage(super.getSprite().get(5));
//                    AudioClip note = new AudioClip(this.getClass().getResource("/music/latigo.wav").toString());
//                    note.play();
                    
                }
                if (e.getCode() == KeyCode.D) {
                    imageView.setImage(super.getSprite().get(6));
//                    AudioClip note = new AudioClip(this.getClass().getResource("/music/pala.mp3").toString());
//                    note.play();
                }
               
            });
            return gridPane;
    }
}
