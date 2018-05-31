
package dominio;

import java.util.ArrayList;

/**
 *
 * @author Nicole Fonseca, Wilmer Mata
 */
public class Personaje {
    
    private int x;
    private int y;
    private ArrayList listaUrlImagenes;

    public Personaje() {
    }

    public Personaje(int x, int y, ArrayList listaUrlImagenes) {
        this.x = x;
        this.y = y;
        this.listaUrlImagenes = listaUrlImagenes;
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return the listaUrlImagenes
     */
    public ArrayList getListaUrlImagenes() {
        return listaUrlImagenes;
    }

    /**
     * @param listaUrlImagenes the listaUrlImagenes to set
     */
    public void setListaUrlImagenes(ArrayList listaUrlImagenes) {
        this.listaUrlImagenes = listaUrlImagenes;
    }

    @Override
    public String toString() {
        return "Personaje{" + "x=" + x + ", y=" + y + ", listaUrlImagenes=" + listaUrlImagenes + '}';
    }
}
