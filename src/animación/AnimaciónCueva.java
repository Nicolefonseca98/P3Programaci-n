package animación;

import dominio.Cueva;
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
    

    static Image[] generaTierra = new Image[28];
    static GridPane gridPane = new GridPane();;
    static ImageView[] tierra = new ImageView[28];;
    public Object[][] matriz() {
        Object[][] object = new Object[2][5];
        return object;
    }

    public GridPane tierra() {
        int fila = 32;
        int columna = 0;
        gridPane.setVgap(10);
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
        generaTierra[0] = new Image("/cueva/tierra150.png");
        tierra[0] = new ImageView();
        tierra[0].setImage(generaTierra[0]);
        GridPane.setConstraints(tierra[0], 0, 32);
        gridPane.getChildren().add(tierra[0]);
        System.out.println(gridPane.getRowConstraints().size());
//        for (int i = 0; i < gridPane.getRowConstraints().size(); i++) {
            for (int j = 0; j < gridPane.getColumnConstraints().size(); j++) {
//                System.out.println("row " + i);
                System.out.println("column " + j);
            }
//        }
    }
    
    
}
