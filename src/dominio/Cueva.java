
package dominio;

/**
 *
 * @author Nicole Fonseca, Wilmer Mata
 */
public class Cueva {
    private int tamaño;
    private String urlImagen;

    public Cueva() {
    }

    public Cueva(int tamaño, String urlImagen) {
        this.tamaño = tamaño;
        this.urlImagen = urlImagen;
    }

    /**
     * @return the tamaño
     */
    public int getTamaño() {
        return tamaño;
    }

    /**
     * @param tamaño the tamaño to set
     */
    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    /**
     * @return the urlImagen
     */
    public String getUrlImagen() {
        return urlImagen;
    }

    /**
     * @param urlImagen the urlImagen to set
     */
    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    @Override
    public String toString() {
        return "Cueva{" + "tama\u00f1o=" + tamaño + ", urlImagen=" + urlImagen + '}';
    }
}
