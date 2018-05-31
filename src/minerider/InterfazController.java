
package minerider;

import animación.AnimaciónCueva;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //Fondo de la ventana
        String backgroundImage = "/cueva/fondo.jpg";
        anchorPane.setStyle("-fx-background-image: url('" + backgroundImage + "'); "
                + "-fx-background-position: left top, center;"
                + "-fx-background-repeat: no-repeat;"
                + "-fx-background-size: cover, auto;");
        
        //Imagenes tierra
        AnimaciónCueva animaciónCueva = new AnimaciónCueva();
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
        
        //Imagen personaje
        ImageView imageViewPersonaje = new ImageView(new Image("/starlord/derechaEspada.png"));
        GridPane.setConstraints(imageViewPersonaje, 1, 1);
        gridPaneCueva.getChildren().add(imageViewPersonaje);
        
        //Agrega el GridPane al AnchorPane
        anchorPane.getChildren().add(gridPaneCueva);
    }    
    
}
