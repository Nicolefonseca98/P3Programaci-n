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
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nicole Fonseca, Wilmer Mata
 */
public class VentanaInicioController implements Initializable {

    @FXML
    private Button botonJugar;
    @FXML
    private ImageView tituloImageView;
    @FXML
    private ImageView gifImageView;
    @FXML
    private AnchorPane anchorPane;
    private Image titulo;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Image image = new Image("/cueva/start.jpg");
        botonJugar.setGraphic(new ImageView(image));
        Image titulo = new Image("/cueva/titulo.png");
        tituloImageView.setImage(titulo);
//        Fondo de la ventana
        String backgroundImage = "/cueva/mine.png";
        anchorPane.setStyle("-fx-background-image: url('" + backgroundImage + "'); "
                + "-fx-background-position: left top, center;"
                + "-fx-background-repeat: no-repeat;"
                + "-fx-background-size: cover, auto;");
        Image gif = new Image("/starlord/gif.gif");
        gifImageView.setImage(gif);
    }

    @FXML
    private void jugar(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("Cueva.fxml"));
        Scene scene = new Scene(parent);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        scene.getRoot().requestFocus();
        AudioClip start = new AudioClip(this.getClass().getResource("/music/start.mp3").toString());
        start.play();
        window.show();
    }

}
