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
    AnimaciónCueva animaciónCueva = new AnimaciónCueva();
    CuevaController cuevaController = new CuevaController();
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
        sprite.add(new Image(new FileInputStream("src/starlord/SLI3.png")));
        sprite.add(new Image(new FileInputStream("src/starlord/SLI4.png")));
        sprite.add(new Image(new FileInputStream("src/starlord/derechaEspada.png")));
        sprite.add(new Image(new FileInputStream("src/starlord/derechaLatigo.png")));
        sprite.add(new Image(new FileInputStream("src/starlord/derechaPala.png")));
        sprite.add(new Image(new FileInputStream("src/starlord/izquierdaEspada.png")));
        sprite.add(new Image(new FileInputStream("src/starlord/izquierdaLatigo.png")));
        sprite.add(new Image(new FileInputStream("src/starlord/izquierdaPala.png")));
    }

    int x = 450;
    int j = 0;
    int arma = 0;
    int indice = 3;
    
    public void movimientPersonaje(StackPane stackPane, int y) {
        ArrayList<Image> sprite = super.getSprite();
        super.setImage(sprite.get(0));
        super.setX(x);
        super.setY(y);
        
        stackPane.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.RIGHT) {
                if (j >= 3) {
                    j = 0;
                }
                if (x <= 783 && x >= 0) {
                    super.setImage(sprite.get(j));
                    super.setX(x += 10);
                    super.setY(y);
                    j++;
                    arma = 0;
                }
            }
           
            if (event.getCode() == KeyCode.LEFT) {
                if (x > 14) {
                    if(indice >= 6) {
                        indice = 3;
                    }
                    super.setImage(sprite.get(indice));
                    super.setX(x -= 10);
                    super.setY(y);
                    indice++;
                }
                arma = 0;
            }

            if (event.getCode() == KeyCode.UP) {
                if (super.getImage().equals(sprite.get(0)) || super.getImage().equals(sprite.get(1)) || super.getImage().equals(sprite.get(2))
                        || super.getImage().equals(sprite.get(6)) || super.getImage().equals(sprite.get(7)) || super.getImage().equals(sprite.get(8))) {
                    if (x > 0 && x < 730) {
                        super.setImage(sprite.get(0));
                        super.setX(x);
                        int auxY = y;
                        auxY -= 90;
                        super.setY(auxY);
                    }
                } else {
                    if (x > 50) {
                        if (super.getImage().equals(sprite.get(3)) || super.getImage().equals(sprite.get(4)) || super.getImage().equals(sprite.get(5))
                                || super.getImage().equals(sprite.get(9)) || super.getImage().equals(sprite.get(10)) || super.getImage().equals(sprite.get(11))) {
                            super.setImage(sprite.get(3));
                            super.setX(x);
                            int auxY = y;
                            auxY -= 90;
                            super.setY(auxY);
                        }
                    }
//                    AudioClip note = new AudioClip(this.getClass().getResource("/music/jump.mp3").toString());
//                    note.play();
                }
                arma = 0;
            }

            if (event.getCode() == KeyCode.A) {
                if (super.getImage().equals(sprite.get(0))|| super.getImage().equals(sprite.get(1)) || super.getImage().equals(sprite.get(2))
                        || super.getImage().equals(sprite.get(7)) || super.getImage().equals(sprite.get(8))) {
                    super.setImage(sprite.get(6));
                    super.setX(x);
                    super.setY(y);
                } else if (super.getImage().equals(sprite.get(3)) || super.getImage().equals(sprite.get(4)) || super.getImage().equals(sprite.get(5))
                        || super.getImage().equals(sprite.get(10)) || super.getImage().equals(sprite.get(11))){
                    super.setImage(sprite.get(9));
                    super.setX(x);
                    super.setY(y);
                }
                arma = 1;

//                    AudioClip note = new AudioClip(this.getClass().getResource("/music/espada.wav").toString());
//                    note.play();
            }

            if (event.getCode() == KeyCode.S) {
                if (super.getImage().equals(sprite.get(0))|| super.getImage().equals(sprite.get(1)) || super.getImage().equals(sprite.get(2))
                        || super.getImage().equals(sprite.get(6)) || super.getImage().equals(sprite.get(8))) {
                    super.setImage(sprite.get(7));
                    super.setX(x);
                    super.setY(y);
                } else if (super.getImage().equals(sprite.get(3)) || super.getImage().equals(sprite.get(4)) || super.getImage().equals(sprite.get(5))
                        || super.getImage().equals(sprite.get(9)) || super.getImage().equals(sprite.get(11))){ 
                    super.setImage(sprite.get(10));
                    super.setX(x);
                    super.setY(y);
                }
                arma = 2;

//                    AudioClip note = new AudioClip(this.getClass().getResource("/music/latigo.wav").toString());
//                    note.play();
            }

            if (event.getCode() == KeyCode.D) {
                if (super.getImage().equals(sprite.get(0)) || super.getImage().equals(sprite.get(1)) || super.getImage().equals(sprite.get(2))
                        || super.getImage().equals(sprite.get(6)) || super.getImage().equals(sprite.get(7))) {
                    super.setImage(sprite.get(8));
                    super.setX(x);
                    super.setY(y);
                } else if (super.getImage().equals(sprite.get(3)) || super.getImage().equals(sprite.get(4)) || super.getImage().equals(sprite.get(5))
                        || super.getImage().equals(sprite.get(9)) || super.getImage().equals(sprite.get(10))) {
                    super.setImage(sprite.get(11));
                    super.setX(x);
                    super.setY(y);
                    
                } if(animaciónCueva.hayTierra() == true){
                     animaciónCueva.quitaTierra(x, y);
                     System.out.println("Palazo");
                }
                
               arma = 3;
//                    AudioClip note = new AudioClip(this.getClass().getResource("/music/pala.mp3").toString());
//                    note.play();
            }
        });

        stackPane.setOnKeyReleased(event -> {
            if (event.getCode() == KeyCode.UP) {
                if (super.getImage().equals(sprite.get(0)) || super.getImage().equals(sprite.get(1)) || super.getImage().equals(sprite.get(2))
                        || super.getImage().equals(sprite.get(6)) || super.getImage().equals(sprite.get(7)) || super.getImage().equals(sprite.get(8))) {
                    if (x > 0 && x < 730) {
                        super.setImage(sprite.get(0));
                        super.setX(x += 120);
                        super.setY(y);
                    }
                } else {
                    if (x > 50) {
                        if (super.getImage().equals(sprite.get(3)) || super.getImage().equals(sprite.get(4)) || super.getImage().equals(sprite.get(5))
                               || super.getImage().equals(sprite.get(9)) || super.getImage().equals(sprite.get(10)) || super.getImage().equals(sprite.get(11))) {
                            super.setImage(sprite.get(3));
                            super.setX(x -= 120);
                            super.setY(y);
                        }
                    }
                }
            }
        });
    }

    public int arma() {
        if (arma == 1) {
            return 1;
        } else if (arma == 2) {
            return 2;
        } else if (arma == 3) {
            return 3;
        }
        return 0;
    }

}
