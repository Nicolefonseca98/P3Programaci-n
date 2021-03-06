
package minerider;

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
        Parent root = FXMLLoader.load(getClass().getResource("VentanaInicio.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        stage.setTitle("MineRider");
        stage.getIcons().add(new Image("/starlord/icono.png")); 
        scene.getRoot().requestFocus();
        stage.setResizable(false);
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
