
package minerider;

import animación.AnimaciónZombie;
import animación.AnimaciónPersonaje;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Nicole Fonseca, Wilmer Mata
 */
public class MineRider extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Interfaz.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        stage.setTitle("MineRider");
        stage.getIcons().add(new Image("/starlord/prueba.png")); 
        scene.getRoot().requestFocus();
        stage.setOnCloseRequest(e -> {
        Platform.exit();
        System.exit(0);
    });
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);

    }
    
}
