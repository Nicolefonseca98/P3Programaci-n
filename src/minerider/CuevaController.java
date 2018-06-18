package minerider;

import animación.AnimaciónCueva;
import animación.AnimaciónPersonaje;
import animación.AnimaciónQuimera;
import animación.AnimaciónZombie;
import com.sun.javafx.geom.Area;
import dominio.Cueva;
import dominio.Personaje;
import dominio.Quimera;
import dominio.Tierra;
import dominio.Zombie;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.BufferOverflowException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.shape.Rectangle;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;

/**
 * FXML Controller class
 *
 * @author Nicole Fonseca, Wilmer Mata
 */
public class CuevaController extends Personaje implements Initializable {

    @FXML
    private StackPane stackPane;
    @FXML
    private ImageView background1;
    @FXML
    private ImageView corazon1;
    @FXML
    private ImageView corazon2;
    @FXML
    private ImageView corazon3;
    @FXML
    private Label label;
    private Image cueva;
    private Image corazonLleno;
    private Image corazonVacio;
    private Canvas canvas;
    private AnimaciónZombie animaciónZombie;
    private AnimaciónQuimera animaciónQuimera;
    private AnimaciónPersonaje animaciónPersonaje;
    private AnimaciónCueva animaciónCueva;
    private Cueva cuevaTierra;
    private int corazonPersonaje = 0;
    private int vidasQuimera = 0;
    private int vidasZombie = 0;
    public static ArrayList<Quimera> arrayListQuimera = new ArrayList<>();
    public static ArrayList<Zombie> arrayListZombie = new ArrayList<>();
    public static ArrayList<Personaje> arrayListPersonaje = new ArrayList<>();
    public static ArrayList<Cueva> arrayListTierra = new ArrayList<>();

    //Hilo principal
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
                    colisión();
//                    tierra();
                    Thread.sleep(tiempoEspera);
                    GraphicsContext graphicsContext = this.canvas.getGraphicsContext2D();
                    dibujarPersonajes(graphicsContext);
                } catch (InterruptedException | IOException | RuntimeException ex) {
                } 
            }
        };

        Thread hilo = new Thread(runnable);
        hilo.start();
    }

    //Dibuja imagénes 
    private void dibujarPersonajes(GraphicsContext graphicsContext) throws IOException, FileNotFoundException, InterruptedException {
        try {
            graphicsContext.clearRect(0, 0, 813, 400);
            for (int i = 0; i < arrayListZombie.size(); i++) {
                Zombie zombieAux = arrayListZombie.get(i);
                graphicsContext.drawImage(zombieAux.getImage(), zombieAux.getX(), zombieAux.getY());
            }

            for (int i = 0; i < arrayListQuimera.size(); i++) {
                Quimera quimeraAux = arrayListQuimera.get(i);
                graphicsContext.drawImage(quimeraAux.getImage(), quimeraAux.getX(), quimeraAux.getY());
            }

            for (int i = 0; i < arrayListTierra.size(); i++) {
                Cueva cuevaAux = arrayListTierra.get(i);
                graphicsContext.drawImage(cuevaAux.getImage(), cuevaAux.getX(), cuevaAux.getY());
            }
            for (int i = 0; i < arrayListPersonaje.size(); i++) {
                Personaje personajeAux = arrayListPersonaje.get(i);
                graphicsContext.drawImage(personajeAux.getImage(), personajeAux.getX(), personajeAux.getY());
            }
        } catch (RuntimeException c) {
        } 
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Audio
//        AudioClip note = new AudioClip(this.getClass().getResource("/music/contra.mp3").toString());
//        note.play();

        //Imagen de fondo
        cueva = new Image("/cueva/cueva1.png");
        background1.setImage(cueva);
        corazonLleno = new Image("/starlord/heart.png");
        corazon1.setImage(corazonLleno);
        corazon2.setImage(corazonLleno);
        corazon3.setImage(corazonLleno);
        animaciónCueva = new AnimaciónCueva();


        //Personajes
        try {
            int x = 600;
            for (int i = 0; i < 3; i++) {
                animaciónQuimera = new AnimaciónQuimera(x, 310);
                Thread threadQuimera = new Thread(animaciónQuimera);
                threadQuimera.setName("Quimera " + i);
                threadQuimera.start();
                arrayListQuimera.add(animaciónQuimera);
                x += 350;
                System.out.println(threadQuimera.getName());
            }

            int xZombie = 0;
            for (int i = 0; i < 3; i++) {
                animaciónZombie = new AnimaciónZombie(xZombie, 300);
                Thread threadZombie = new Thread(animaciónZombie);
                threadZombie.setName("Zombie " + i);
                threadZombie.start();
                arrayListZombie.add(animaciónZombie);
                xZombie += 350;
            }

            for (int i = 0; i < 5; i++) {
                Image image = new Image("/cueva/tierra.png");
                cuevaTierra = new Cueva(random(), 325, image);
                arrayListTierra.add(cuevaTierra);
            }

            animaciónPersonaje = new AnimaciónPersonaje(50, 0);
            arrayListPersonaje.add(animaciónPersonaje);

        } catch (FileNotFoundException ex) {
        }

        //Canvas
        this.canvas = new Canvas(813, 400);
        stackPane.getChildren().add(canvas);

        //Hilo principal
        run();
        animaciónPersonaje.movimientPersonaje(stackPane, 310);
    }

    /**
     * Detecta si hay una colisión entre el personaje y algún monstruo.
     * @return Boolean 
     * @throws java.io.FileNotFoundException
     * @throws java.lang.InterruptedException
     */
    public Boolean colisión() throws FileNotFoundException, InterruptedException, IOException {

        Boolean obstaculo = false;
        corazonLleno = new Image("/starlord/heart.png");
        corazonVacio = new Image("/starlord/emptyHeart.png");
        for (int i = 0; i < arrayListQuimera.size(); i++) {
            Quimera quimeraAux = arrayListQuimera.get(i);
            Rectangle quimera = new Rectangle(quimeraAux.getX(), quimeraAux.getY(), 35, 40);
            if (quimera.intersects(animaciónPersonaje.getBounds().getX(), animaciónPersonaje.getBounds().getY(), 35, 40)) {
                obstaculo = true;
            }
        }

        for (int i = 0; i < arrayListZombie.size(); i++) {
            Zombie zombieAux = arrayListZombie.get(i);
            Rectangle zombie = new Rectangle(zombieAux.getX(), zombieAux.getY(), 45, 55);
            if (zombie.intersects(animaciónPersonaje.getBounds().getX(), animaciónPersonaje.getBounds().getY(), 35, 40)) {
                obstaculo = true;
            }
        }

        if (obstaculo == true) {
            if (animaciónQuimera.llamarada() == true || animaciónZombie.muerdeCerebro() == true) {
                corazonPersonaje++;
                switch (corazonPersonaje) {
                    case 0:
                        corazon1.setImage(corazonLleno);
                        corazon2.setImage(corazonLleno);
                        corazon3.setImage(corazonLleno);
                        break;
                    case 5:
                        corazon1.setImage(corazonLleno);
                        corazon2.setImage(corazonLleno);
                        corazon3.setImage(corazonVacio);
                        break;
                    case 17:
                        corazon1.setImage(corazonLleno);
                        corazon2.setImage(corazonVacio);
                        corazon3.setImage(corazonVacio);
                        break;
                    case 28:
                        corazon1.setImage(corazonVacio);
                        corazon2.setImage(corazonVacio);
                        corazon3.setImage(corazonVacio);
                        System.out.println("¡¡¡¡¡¡Juego terminado!!!!!");
//                        arrayListPersonaje.clear();
//                        label.setText("terminó");
                        break;
                }

            } else if (animaciónPersonaje.arma() == 1 || animaciónPersonaje.arma() == 2) {
                vidasQuimera++;
                switch (vidasQuimera) {
                    case 0:
                        System.out.println("3 vidas");
                        break;
                    case 5:
                        System.out.println("2 vidas");
                        break;
                    case 8:
                        System.out.println("1 vida");
                        break;
                    case 12:
                        System.out.println("*************Murió quimera******************");
                        vidasQuimera = 0;
                        for (int i = 0; i < arrayListQuimera.size(); i++) {
                            Quimera auxQuimera = arrayListQuimera.get(i);
                            if (animaciónQuimera.boundsQuimera().getX() == auxQuimera.getX()) {
                                if (animaciónQuimera.boundsQuimera().getY() == auxQuimera.getY()) {
                                    arrayListQuimera.remove(auxQuimera);
                                }
                            }
                        }
                        break;
                }
                vidasZombie++;
                switch (vidasZombie) {
                    case 0:
                        System.out.println("3 vidas Z");
                        break;
                    case 6:
                        System.out.println("2 vidas Z");
                        break;
                    case 9:
                        System.out.println("1 vida Z");
                        break;
                    case 13:
                        System.out.println("*************Murió Zombie******************");
                        vidasZombie = 0;
                        for (int i = 0; i < arrayListZombie.size(); i++) {
                            Zombie auxZombie = arrayListZombie.get(i);
                            if (animaciónZombie.boundsZombie().getX() == auxZombie.getX()) {
                                if (animaciónZombie.boundsZombie().getY() == auxZombie.getY()) {
                                    arrayListZombie.remove(auxZombie);
                                }
                            }
                        }
                        break;
                }
                if(arrayListQuimera.isEmpty() & arrayListZombie.isEmpty()) {
                    System.out.println("¡¡¡Ha ganado!!!");
                }
            } else if (animaciónPersonaje.arma() == 3) {
                System.out.println("Pala");
            } 
        }
        return obstaculo;
    }
    
    public int random() {
        int x = (int) (10+Math.random()*600);
        return x;
    }

}
