
package minerider;


import animación.AnimaciónCueva;
import animación.AnimaciónPersonaje;
import animación.AnimaciónQuimera;
import animación.AnimaciónZombie;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Nicole Fonseca, Wilmer Mata
 */


public class CuevaController implements Initializable {
 
    @FXML private StackPane stackPane;
    @FXML private ImageView background1;
    @FXML private ImageView background2;
    @FXML private Button  btnControl;
    private Image cueva1;
    private Image cueva2;
    private Canvas canvas;
    private AnimaciónZombie animaciónZombie;
    private AnimaciónQuimera animaciónQuimera;
    private AnimaciónQuimera animaciónQuimera1;
    private AnimaciónPersonaje animaciónPersonaje;
    private AnimaciónCueva animaciónCueva;
    
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
    
    private void draw(GraphicsContext graphicsContext){
        graphicsContext.clearRect(0, 0, 1000, 403);
        graphicsContext.drawImage(this.animaciónZombie.getImage(), this.animaciónZombie.getX(), this.animaciónZombie.getY());
        graphicsContext.drawImage(this.animaciónQuimera.getImage(), this.animaciónQuimera.getX(), this.animaciónQuimera.getY());
        graphicsContext.drawImage(this.animaciónQuimera1.getImage(), this.animaciónQuimera1.getX(), this.animaciónQuimera1.getY());
        graphicsContext.drawImage(this.animaciónPersonaje.getImage(), this.animaciónPersonaje.getX(), this.animaciónPersonaje.getY());
    }
   
    public void startAmination() {
        parallelTransition.play();
    }

    public void pauseAnimation() {
        parallelTransition.pause();
    }

    private int BACKGROUND_WIDTH = 510;
    private ParallelTransition parallelTransition;

   @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        cueva1 = new Image("/cueva/cueva1.png");
        background1.setImage(cueva1);
        cueva2 = new Image("/cueva/cueva2.png");
        background2.setImage(cueva2);
      
        TranslateTransition translateTransition = new TranslateTransition(Duration.millis(10000), background1);
        translateTransition.setFromX(0);
        translateTransition.setToX(-1 * BACKGROUND_WIDTH);
        translateTransition.setInterpolator(Interpolator.LINEAR);

        TranslateTransition translateTransition2 = new TranslateTransition(Duration.millis(10000), background2);
        translateTransition2.setFromX(0);
        translateTransition2.setToX(-1 * BACKGROUND_WIDTH);
        translateTransition2.setInterpolator(Interpolator.LINEAR);

        parallelTransition
                = new ParallelTransition(translateTransition, translateTransition2);
        parallelTransition.setCycleCount(Animation.INDEFINITE);

        parallelTransition.statusProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue == Animation.Status.RUNNING) {
                btnControl.setText("||");
            } else {
                btnControl.setText(">");
            }
        });
        
//        if (parallelTransition.getStatus() == Animation.Status.RUNNING) {
//            pauseAnimation();
//        } else {
//            startAmination();
//        }
        
        try {
            animaciónZombie = new AnimaciónZombie(0, 0);
            animaciónQuimera = new AnimaciónQuimera(0, 0);
            animaciónQuimera1 = new AnimaciónQuimera(0, 0);
            animaciónPersonaje = new AnimaciónPersonaje(0, 0);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CuevaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.canvas = new Canvas(1000, 403);
        stackPane.getChildren().add(canvas);
        run();
//        animaciónZombie.hiloZombie();
        animaciónQuimera.hiloQuimera(265);
        animaciónQuimera1.hiloQuimera(265);
        animaciónPersonaje.hiloPersonaje(315, stackPane);
      
    }

    @FXML
    private void actionB(ActionEvent event) {
//         if (parallelTransition.getStatus() == Animation.Status.RUNNING) {
//            pauseAnimation();
//        } else {
//            startAmination();
//        }
    }
}


