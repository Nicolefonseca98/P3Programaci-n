
package minerider;

import animación.AnimaciónCueva;
import animación.AnimaciónZombie;
import animación.AnimaciónPersonaje;
import animación.AnimaciónQuimera;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Nicole Fonseca, Wilmer Mata
 */
public class InterfazController implements Initializable {
    
    @FXML private AnchorPane anchorPane;
    private Canvas canvas;
    private AnimaciónZombie animaciónZombie;
    private AnimaciónQuimera animaciónQuimera;
    private AnimaciónQuimera animaciónQuimera1;
    
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
        graphicsContext.clearRect(0, 0, 800, 500);
        graphicsContext.drawImage(this.animaciónZombie.getImage(), this.animaciónZombie.getX(), this.animaciónZombie.getY());
        graphicsContext.drawImage(this.animaciónQuimera.getImage(), this.animaciónQuimera.getX(), this.animaciónQuimera.getY());
        graphicsContext.drawImage(this.animaciónQuimera1.getImage(), this.animaciónQuimera1.getX(), this.animaciónQuimera1.getY());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            animaciónZombie = new AnimaciónZombie(0, 0);
            animaciónQuimera = new AnimaciónQuimera(0, 0);
            animaciónQuimera1 = new AnimaciónQuimera(0, 0);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(InterfazController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.canvas = new Canvas(800, 500);

        //Fondo de la ventana
        String backgroundImage = "/cueva/fondo.jpg";
        anchorPane.setStyle("-fx-background-image: url('" + backgroundImage + "'); "
                + "-fx-background-position: left top, center;"
                + "-fx-background-repeat: no-repeat;"
                + "-fx-background-size: cover, auto;");

        //Imagenes tierra
        AnimaciónCueva animaciónCueva = new AnimaciónCueva();
        AnimaciónPersonaje animaciónPersonaje = new AnimaciónPersonaje();
        animaciónPersonaje.moverPersonaje(anchorPane);
        
        ImageView[][] cueva = animaciónCueva.matrizCueva("/cueva/tierra.png");
        GridPane gridPaneCueva = new GridPane();     
        gridPaneCueva.setPadding(new Insets(30));
       
        GridPane.setConstraints(cueva[0][0], 0, 0);
        gridPaneCueva.getChildren().add(cueva[0][0]);
        GridPane.setConstraints(cueva[1][0], 1, 0);
        gridPaneCueva.getChildren().add(cueva[1][0]);
        GridPane.setConstraints(cueva[2][0], 2, 0);
        gridPaneCueva.getChildren().add(cueva[2][0]);
        
        GridPane.setConstraints(cueva[0][1], 0, 1);
        gridPaneCueva.getChildren().add(cueva[0][1]);
        GridPane.setConstraints(cueva[1][1], 1, 1);
        gridPaneCueva.getChildren().add(cueva[1][1]); 
        GridPane.setConstraints(cueva[2][1], 2, 1);
        gridPaneCueva.getChildren().add(cueva[2][1]);
        
        GridPane.setConstraints(cueva[0][2], 0, 2);
        gridPaneCueva.getChildren().add(cueva[0][2]);
        GridPane.setConstraints(cueva[1][2], 1, 2);
        gridPaneCueva.getChildren().add(cueva[1][2]); 
        GridPane.setConstraints(cueva[2][2], 2, 2);
        gridPaneCueva.getChildren().add(cueva[2][2]);
        
        //Agrega el GridPane al AnchorPane
//        anchorPane.getChildren().add(gridPaneCueva);
        anchorPane.getChildren().add(canvas);
        run();
        animaciónZombie.hiloZombie();
        animaciónQuimera.hiloQuimera(200);
        animaciónQuimera1.hiloQuimera(300);
    }    
    
}
