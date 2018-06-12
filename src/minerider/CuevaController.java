package minerider;

import animación.AnimaciónCueva;
import animación.AnimaciónPersonaje;
import animación.AnimaciónQuimera;
import animación.AnimaciónZombie;
import java.awt.Rectangle;
import java.awt.geom.Area;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
//import javafx.scene.shape.Rectangle;

/**
 * FXML Controller class
 *
 * @author Nicole Fonseca, Wilmer Mata
 */
public class CuevaController implements Initializable {

    @FXML
    private StackPane stackPane;
    @FXML
    private ImageView background1;
    @FXML
    private ImageView corazon1;
    @FXML
    private ImageView corazon2;
    @FXML
    private ImageView corazon3;
    private Image cueva;
    private Image corazonLleno;
    private Image corazonVacio;
    private Canvas canvas;
    private AnimaciónZombie animaciónZombie;
    private AnimaciónZombie animaciónZombie1;
    private AnimaciónQuimera animaciónQuimera;
    private AnimaciónQuimera animaciónQuimera1;
    private AnimaciónPersonaje animaciónPersonaje;
    private AnimaciónCueva animaciónCueva;
    private Area personaje;
    private Area cuerpo;
    int corazonPersonaje = 0;

    //Hilo principal
    public void run() {
        Runnable runnable = () -> {
            long inicio;
            long transcurrido;
            long tiempoEspera;
            int fps = 30;
            long tiempo = 1000 / fps;

            while (true) {
                try {
                    inicio = System.nanoTime();
                    transcurrido = System.nanoTime() - inicio;
                    tiempoEspera = tiempo - transcurrido / 1000000;
                    colision();
                    Thread.sleep(tiempoEspera);
                    GraphicsContext graphicsContext = this.canvas.getGraphicsContext2D();
                    draw(graphicsContext);
                } catch (InterruptedException ex) {
                    System.out.println("Exception");
                }
            }
        };
        Thread hilo = new Thread(runnable);
        hilo.start();
    }

    //Dibuja imagénes 
    private void draw(GraphicsContext graphicsContext) {
        graphicsContext.clearRect(0, 0, 813, 400);
        graphicsContext.drawImage(this.animaciónZombie.getImage(), this.animaciónZombie.getX(), this.animaciónZombie.getY());
        graphicsContext.drawImage(this.animaciónZombie1.getImage(), this.animaciónZombie1.getX(), this.animaciónZombie1.getY());
        graphicsContext.drawImage(this.animaciónQuimera.getImage(), this.animaciónQuimera.getX(), this.animaciónQuimera.getY());
        graphicsContext.drawImage(this.animaciónQuimera1.getImage(), this.animaciónQuimera1.getX(), this.animaciónQuimera1.getY());
        graphicsContext.drawImage(this.animaciónPersonaje.getImage(), this.animaciónPersonaje.getX(), animaciónPersonaje.getY());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Audio
//        AudioClip note = new AudioClip(this.getClass().getResource("/music/contra.mp3").toString());
//        note.play();
        //Imagen de fondo
        cueva = new Image("/cueva/cueva1.png");
        background1.setImage(cueva);
        corazonLleno = new Image("/starlord/heart.png");
        corazon1.setImage(corazonLleno);
        corazon2.setImage(corazonLleno);
        corazon3.setImage(corazonLleno);

        //Personajes
        try {

            animaciónZombie = new AnimaciónZombie(100, 300);
            animaciónZombie1 = new AnimaciónZombie(225, 300);
            animaciónQuimera = new AnimaciónQuimera(500, 272);
            animaciónQuimera1 = new AnimaciónQuimera(700, 272);
            animaciónPersonaje = new AnimaciónPersonaje(50, 0);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(CuevaController.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Canvas
        this.canvas = new Canvas(813, 400);
        stackPane.getChildren().add(canvas);

        //Hilos
        run();
        animaciónZombie.hiloZombie();
        animaciónZombie1.hiloZombie();
        animaciónQuimera.hiloQuimera();
        animaciónQuimera1.hiloQuimera();
        animaciónPersonaje.movimientPersonaje(stackPane, 310);

    }

    public Boolean obstaculo() {

        Rectangle quimera1 = new Rectangle(animaciónQuimera.getX(), animaciónQuimera.getY(), 38, 40);
        Area areaQuimera1 = new Area(quimera1);
        areaQuimera1.intersect(getBounds());

        Rectangle quimera2 = new Rectangle(animaciónQuimera1.getX(), animaciónQuimera1.getY(), 38, 40);
        Area areaQuimera2 = new Area(quimera2);
        areaQuimera2.intersect(getBounds());

        Rectangle zombie1 = new Rectangle(animaciónZombie.getX(), animaciónZombie.getY(), 38, 40);
        Area areaZombie1 = new Area(zombie1);
        areaZombie1.intersect(getBounds());

        Rectangle zombie2 = new Rectangle(animaciónZombie1.getX(), animaciónZombie1.getY(), 38, 40);
        Area areaZombie2 = new Area(zombie2);
        areaZombie2.intersect(getBounds());
        return !areaQuimera1.isEmpty() || !areaQuimera2.isEmpty() || !areaZombie1.isEmpty() || !areaZombie2.isEmpty();
    }

    public Area getBounds() {
        Rectangle starlord = new Rectangle(animaciónPersonaje.getX(), animaciónPersonaje.getY(), 38, 40);
        cuerpo = new Area(starlord);
        personaje = cuerpo;
        personaje.add(cuerpo);

        return personaje;
    }

    public void colision() throws InterruptedException {

        corazonLleno = new Image("/starlord/heart.png");
        corazonVacio = new Image("/starlord/emptyHeart.png");

        if (obstaculo()) {
            corazonPersonaje++;
            System.out.println("golpe");
//            if(detectaArma()){
                
//            }
        }
        switch (corazonPersonaje) {
            case 0:
                corazon1.setImage(corazonLleno);
                corazon2.setImage(corazonLleno);
                corazon3.setImage(corazonLleno);
                break;
            case 5:
                corazon1.setImage(corazonLleno);
                corazon2.setImage(corazonLleno);
                corazon3.setImage(corazonVacio);
                break;
            case 17:
                corazon1.setImage(corazonLleno);
                corazon2.setImage(corazonVacio);
                corazon3.setImage(corazonVacio);
                break;
            case 28:
                corazon1.setImage(corazonVacio);
                corazon2.setImage(corazonVacio);
                corazon3.setImage(corazonVacio);
                break;
        }
    }
    public int detectaArma(int arma){
        if (arma==1) {
            return 1;
        } else if(arma == 2){
            return 2;
        } else if(arma == 3){
            return 3;
        }
        return 0;
    }
}
