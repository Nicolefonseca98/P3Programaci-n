
package minerider;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nicole Fonseca, Wilmer Mata
 */
public class VentanaInicioController implements Initializable {

    @FXML
    private Button botónJugar;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Image image = new  Image("/starlord/1.png");
        botónJugar.setGraphic(new ImageView(image));
    }    

    @FXML
    private void jugar(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("Cueva.fxml"));
        Scene scene = new Scene(parent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        scene.getRoot().requestFocus();
        window.show();
    }

}
