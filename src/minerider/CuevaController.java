package minerider;

import dominio.Personaje;
import dominio.Quimera;
import dominio.Zombie;
import dominio.Cueva;
import animacion.AnimacionQuimera;
import animacion.AnimacionZombie;
import animacion.AnimacionPersonaje;
import com.sun.javafx.geom.Area;
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
import javafx.scene.paint.Color;

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
    private Image cueva;
    private Image corazonLleno;
    private Image corazonVacio;
    private Canvas canvas;
    private AnimacionZombie animacionZombie;
    private AnimacionQuimera animacionQuimera;
    private AnimacionPersonaje animacionPersonaje;
    private Cueva cuevaTierra;
    private int corazonPersonaje = 0;
    private int vidasQuimera = 0;
    private int vidasZombie = 0;
    GraphicsContext graphicsContext;
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
                    colision();
                    Thread.sleep(tiempoEspera);
                    graphicsContext = this.canvas.getGraphicsContext2D();
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
        AudioClip note = new AudioClip(this.getClass().getResource("/music/contra.mp3").toString());
        note.play();
 
        //Imagen de fondo
        cueva = new Image("/cueva/cueva1.png");
        background1.setImage(cueva);
        corazonLleno = new Image("/starlord/heart.png");
        corazon1.setImage(corazonLleno);
        corazon2.setImage(corazonLleno);
        corazon3.setImage(corazonLleno);

        //Personajes
        try {
           
            int x = 600;
            for (int i = 0; i < 3; i++) {
                animacionQuimera = new AnimacionQuimera(x, 310);
                Thread threadQuimera = new Thread(animacionQuimera);
                threadQuimera.setName("Quimera " + i);
                threadQuimera.start();
                arrayListQuimera.add(animacionQuimera);
                x += 350;
                System.out.println(threadQuimera.getName());
            }

            int xZombie = 0;
            for (int i = 0; i < 3; i++) {
                animacionZombie = new AnimacionZombie(xZombie, 300);
                Thread threadZombie = new Thread(animacionZombie);
                threadZombie.setName("Zombie " + i);
                threadZombie.start();
                arrayListZombie.add(animacionZombie);
                xZombie += 350;
            }

            for (int i = 0; i < 5; i++) {
                Image image = new Image("/cueva/tierra.png");
                cuevaTierra = new Cueva(random(), 325, image);
                arrayListTierra.add(cuevaTierra);
            }

            animacionPersonaje = new AnimacionPersonaje(50, 0);
            arrayListPersonaje.add(animacionPersonaje);

        } catch (FileNotFoundException ex) {
        }

        //Canvas
        this.canvas = new Canvas(813, 400);
        stackPane.getChildren().add(canvas);

        //Hilo principal
        run();
        animacionPersonaje.movimientPersonaje(stackPane, 310);
     
    }



/**
 * Detecta si hay una colisión entre el personaje y algún monstruo.
 *
 * @return Boolean
 * @throws java.io.FileNotFoundException
 * @throws java.lang.InterruptedException
 */
public Boolean colision() throws FileNotFoundException, InterruptedException, IOException {

        Boolean obstaculo = false;
        corazonLleno = new Image("/starlord/heart.png");
        corazonVacio = new Image("/starlord/emptyHeart.png");
        for (int i = 0; i < arrayListQuimera.size(); i++) {
            Quimera quimeraAux = arrayListQuimera.get(i);
            Rectangle quimera = new Rectangle(quimeraAux.getX(), quimeraAux.getY(), 35, 40);
            if (quimera.intersects(animacionPersonaje.getBounds().getX(), animacionPersonaje.getBounds().getY(), 35, 40)) {
                obstaculo = true;
            }
        }

        for (int i = 0; i < arrayListZombie.size(); i++) {
            Zombie zombieAux = arrayListZombie.get(i);
            Rectangle zombie = new Rectangle(zombieAux.getX(), zombieAux.getY(), 45, 55);
            if (zombie.intersects(animacionPersonaje.getBounds().getX(), animacionPersonaje.getBounds().getY(), 35, 40)) {
                obstaculo = true;
            }
        }

        if (obstaculo == true) {
            if (animacionQuimera.llamarada() == true || animacionZombie.muerdeCerebro() == true) {
                corazonPersonaje++;
                switch (corazonPersonaje) {
                    case 0:
                        corazon1.setImage(corazonLleno);
                        corazon2.setImage(corazonLleno);
                        corazon3.setImage(corazonLleno);
                        break;
                    case 10:
                        corazon1.setImage(corazonLleno);
                        corazon2.setImage(corazonLleno);
                        corazon3.setImage(corazonVacio);
                        break;
                    case 75:
                        corazon1.setImage(corazonLleno);
                        corazon2.setImage(corazonVacio);
                        corazon3.setImage(corazonVacio);
                        break;
                    case 145:
                        arrayListPersonaje.clear();
                        corazon1.setImage(corazonVacio);
                        corazon2.setImage(corazonVacio);
                        corazon3.setImage(corazonVacio);
                        graphicsContext.setStroke(Color.WHITE);
                        graphicsContext.strokeText("Juego terminado", 350, 150);
                        Thread.sleep(10000000);

                        break;
                }

            } else if (animacionPersonaje.arma() == 1 || animacionPersonaje.arma() == 2) {
                vidasQuimera++;
                switch (vidasQuimera) {
                    case 0:
                        break;
                    case 10:
                        break;
                    case 15:
                        break;
                    case 20:
                        vidasQuimera = 0;
                        for (int i = 0; i < arrayListQuimera.size(); i++) {
                            Quimera auxQuimera = arrayListQuimera.get(i);
                            if (animacionQuimera.boundsQuimera().getX() == auxQuimera.getX()) {
                                if (animacionQuimera.boundsQuimera().getY() == auxQuimera.getY()) {
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
                        vidasZombie = 0;
                        for (int i = 0; i < arrayListZombie.size(); i++) {
                            Zombie auxZombie = arrayListZombie.get(i);
                            if (animacionZombie.boundsZombie().getX() == auxZombie.getX()) {
                                if (animacionZombie.boundsZombie().getY() == auxZombie.getY()) {
                                    arrayListZombie.remove(auxZombie);
                                }
                            }
                        }
                        break;
                }
                if (arrayListQuimera.isEmpty() & arrayListZombie.isEmpty()) {
                    graphicsContext.setStroke(Color.WHITE);
                    graphicsContext.strokeText("¡¡¡Ha ganado!!!", 350, 150);
                    Thread.sleep(10000000);
                }
            }
        }
        return obstaculo;
    }

    public int random() {
        int x = (int) (10 + Math.random() * 600);
        return x;
    }

}
