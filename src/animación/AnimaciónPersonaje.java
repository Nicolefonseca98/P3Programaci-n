package animación;

import dominio.Personaje;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import minerider.CuevaController;

/**
 *
 * @author Nicole Fonseca, Wilmer Mata
 */
public class AnimaciónPersonaje extends Personaje {
  long time;
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

    public void movimientPersonaje(StackPane stackPane, int y) {
        ArrayList<Image> sprite = super.getSprite();
        stackPane.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.RIGHT) {
                if (j >= 3) {
                    j = 0;
                }
                if (x <= 783 && x >= 0) {
                    super.setImage(sprite.get(j));
                    super.setX(x += 10);
                    super.setY(y);
                }
                j++;
            }

            if (event.getCode() == KeyCode.LEFT) {
                if (x > 0) {
                    super.setImage(sprite.get(3));
                    super.setX(x -= 10);
                    super.setY(y);
                }
            }

            if (event.getCode() == KeyCode.UP) {
                if (!super.getImage().equals(sprite.get(3))) {
                    if (x > 0 && x < 765) {
                        super.setImage(sprite.get(0));
                        super.setX(x);
                        int auxY = y;
                        auxY -= 90;
                        super.setY(auxY);
                    }
                } else {
                    if (x > 25) {
                        super.setImage(sprite.get(3));
                        super.setX(x);
                        int auxY = y;
                        auxY -= 90;
                        super.setY(auxY);
                    }
//                    AudioClip note = new AudioClip(this.getClass().getResource("/music/jump.mp3").toString());
//                    note.play();
                }
            }

            if (event.getCode() == KeyCode.A) {
                super.setImage(sprite.get(4));
                super.setX(x);
                super.setY(y);
//                    AudioClip note = new AudioClip(this.getClass().getResource("/music/espada.wav").toString());
//                    note.play();
            }

            if (event.getCode() == KeyCode.S) {
                super.setImage(sprite.get(5));
                super.setX(x);
                super.setY(y);
//                    AudioClip note = new AudioClip(this.getClass().getResource("/music/latigo.wav").toString());
//                    note.play();
            }

            if (event.getCode() == KeyCode.D) {
                super.setImage(sprite.get(6));
                super.setX(x);
                super.setY(y);
//                    AudioClip note = new AudioClip(this.getClass().getResource("/music/pala.mp3").toString());
//                    note.play();
            }
        });

        stackPane.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.UP) {
                if (!super.getImage().equals(sprite.get(3))) {
                    if (x > 0 && x < 765) {
                        super.setImage(sprite.get(0));
                        super.setX(x += 30);
                        super.setY(y);
                    }
                } else {
                    if (x > 25) {
                        super.setImage(sprite.get(3));
                        super.setX(x -= 30);
                        super.setY(y);
                    }
                }
            }
        });
    }

}
