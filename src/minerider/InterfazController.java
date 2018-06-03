
package minerider;

import animación.AnimaciónCueva;
import animación.AnimaciónMonstruos;
import animación.AnimaciónPersonaje;
import dominio.Zombie;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
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
    private Zombie zombie;

    public void run() {

        Runnable runnable = () -> {
        
        long start;
        long elapsed;
        long wait;
        int fps = 30;
        long time = 1000/fps;

        while(true){
            try {
                start = System.nanoTime();
                elapsed = System.nanoTime()-start;                    
                wait = time-elapsed/1000000;
                Thread.sleep(wait);
                GraphicsContext gc = this.canvas.getGraphicsContext2D();
                draw(gc);
            } 
            catch (InterruptedException ex) {
            }
        }
 
        };
        Thread t = new Thread(runnable);
        t.start();
    }
    
    private void draw(GraphicsContext gc){
        gc.clearRect(0, 0, 250, 250);
        gc.drawImage(this.zombie.getImage(), this.zombie.getX(), this.zombie.getY());
    }

    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        zombie = new Zombie();
        this.canvas = new Canvas(250, 250);

        //Fondo de la ventana
        String backgroundImage = "/cueva/fondo.jpg";
        anchorPane.setStyle("-fx-background-image: url('" + backgroundImage + "'); "
                + "-fx-background-position: left top, center;"
                + "-fx-background-repeat: no-repeat;"
                + "-fx-background-size: cover, auto;");

//        //Imagenes tierra
        AnimaciónCueva animaciónCueva = new AnimaciónCueva();
//        AnimaciónMonstruos animaciónMonstruos = new AnimaciónMonstruos();
        AnimaciónPersonaje animaciónPersonaje = new AnimaciónPersonaje();
//        
        ImageView[][] cueva = animaciónCueva.matrizCueva("/cueva/tierra.png");
        GridPane gridPaneCueva = new GridPane();
        animaciónPersonaje.moverPersonaje(anchorPane);
//        animaciónMonstruos.hiloZombie(anchorPane);
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
        anchorPane.getChildren().add(gridPaneCueva);
        anchorPane.getChildren().add(canvas);
        run();
        zombie.run();
    }    
    
}
