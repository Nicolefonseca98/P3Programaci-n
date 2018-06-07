/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minerider;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Wilmata
 */


public class CuevaController implements Initializable {
 
    @FXML private ImageView background1;
    @FXML private ImageView background2;
    @FXML private Button  btnControl;
    private Image cueva1;
    private Image cueva2;
    
   
    public void startAmination() {

        parallelTransition.play();
    }

    public void pauseAnimation() {
        parallelTransition.pause();
    }

    public void controlPressed() {
       
    }

 
    private int BACKGROUND_WIDTH = 520;
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

        TranslateTransition translateTransition2
                = new TranslateTransition(Duration.millis(10000), background2);
        translateTransition2.setFromX(0);
        translateTransition2.setToX(-1 * BACKGROUND_WIDTH);
        translateTransition2.setInterpolator(Interpolator.LINEAR);

        parallelTransition
                = new ParallelTransition(translateTransition, translateTransition2);
        parallelTransition.setCycleCount(Animation.INDEFINITE);

        //
        // Sets the label of the Button based on the animation state
        //
        parallelTransition.statusProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue == Animation.Status.RUNNING) {
                btnControl.setText("||");
            } else {
                btnControl.setText(">");
            }
        });
    }

    @FXML
    private void actionB(ActionEvent event) {
         if (parallelTransition.getStatus() == Animation.Status.RUNNING) {
            pauseAnimation();
        } else {
            startAmination();
        }
    }
}


