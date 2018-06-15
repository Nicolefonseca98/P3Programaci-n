package animación;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

/**
 *
 * @author Nicole Fonseca, Wilmer Mata
 */
public class AnimaciónCueva {

    static Image[] generaTierra;
    static GridPane gridPane;

    public Object[][] matriz() {
        Object[][] object = new Object[2][5];
        return object;
    }

    public GridPane tierra() {
        int fila = 32;
        int columna = 0;
        gridPane = new GridPane();
        gridPane.setVgap(10);
        ImageView[] tierra = new ImageView[28];
        generaTierra = new Image[28];
        for (int i = 0; i < generaTierra.length; i++) {
            generaTierra[i] = new Image("/cueva/tierra.png");
            tierra[i] = new ImageView();
            tierra[i].setImage(generaTierra[i]);
            GridPane.setConstraints(tierra[i], columna, fila);
            gridPane.getChildren().add(tierra[i]);
            columna++;
        }

        return gridPane;
    }

    public boolean hayTierra() {
        boolean ocupado = false;
        for (int i = 0; i < generaTierra.length; i++) {
            if (generaTierra[i] != null) {
                ocupado = true;
            }
        }
        return ocupado;
    }

    public void quitaTierra(int x, int y) {
        for (int i = 0; i < generaTierra.length; i++) {
                  if(gridPane.getLayoutX() == x && gridPane.getLayoutY() == y)  {
                      System.out.println("iguales");
                  }
        }
    }
}
