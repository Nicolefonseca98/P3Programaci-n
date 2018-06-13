
package dominio;

/**
 *
 * @author Nicole Fonseca, Wilmer Mata.
 */
public class Configuración {
    
    private String ruta;
    private int anchura;
    private int altura;
    private String tipo;
    private int piedra;
    private int zombie;
    private int quimera;
    private int rangoVisiónJugador;
    private int defensaJugador;
    private int ataqueCortoJugador;
    private int ataqueLargoJugador;
    private int retrocesoJugador;
    private int rangoJugador;
    private int defensaQuimera;
    private int ataqueCortoQuimera;
    private int ataqueLargoQuimera;
    private int retrocesoQuimera;
    private int rangoQuimera;
    private int defensaZombie;
    private int ataqueCortoZombie;
    private int retrocesoZombie;
    private int rangoZombie;

    public Configuración() {
    }

    public Configuración(String ruta, int anchura, int altura, String tipo, int piedra, int zombie, int quimera, int rangoVisiónJugador, int defensaJugador, int ataqueCortoJugador, int ataqueLargoJugador, int retrocesoJugador, int rangoJugador, int defensaQuimera, int ataqueCortoQuimera, int ataqueLargoQuimera, int retrocesoQuimera, int rangoQuimera, int defensaZombie, int ataqueCortoZombie, int retrocesoZombie, int rangoZombie) {
        this.ruta = ruta;
        this.anchura = anchura;
        this.altura = altura;
        this.tipo = tipo;
        this.piedra = piedra;
        this.zombie = zombie;
        this.quimera = quimera;
        this.rangoVisiónJugador = rangoVisiónJugador;
        this.defensaJugador = defensaJugador;
        this.ataqueCortoJugador = ataqueCortoJugador;
        this.ataqueLargoJugador = ataqueLargoJugador;
        this.retrocesoJugador = retrocesoJugador;
        this.rangoJugador = rangoJugador;
        this.defensaQuimera = defensaQuimera;
        this.ataqueCortoQuimera = ataqueCortoQuimera;
        this.ataqueLargoQuimera = ataqueLargoQuimera;
        this.retrocesoQuimera = retrocesoQuimera;
        this.rangoQuimera = rangoQuimera;
        this.defensaZombie = defensaZombie;
        this.ataqueCortoZombie = ataqueCortoZombie;
        this.retrocesoZombie = retrocesoZombie;
        this.rangoZombie = rangoZombie;
    }

    /**
     * @return the ruta
     */
    public String getRuta() {
        return ruta;
    }

    /**
     * @param ruta the ruta to set
     */
    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    /**
     * @return the anchura
     */
    public int getAnchura() {
        return anchura;
    }

    /**
     * @param anchura the anchura to set
     */
    public void setAnchura(int anchura) {
        this.anchura = anchura;
    }

    /**
     * @return the altura
     */
    public int getAltura() {
        return altura;
    }

    /**
     * @param altura the altura to set
     */
    public void setAltura(int altura) {
        this.altura = altura;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the piedra
     */
    public int getPiedra() {
        return piedra;
    }

    /**
     * @param piedra the piedra to set
     */
    public void setPiedra(int piedra) {
        this.piedra = piedra;
    }

    /**
     * @return the zombie
     */
    public int getZombie() {
        return zombie;
    }

    /**
     * @param zombie the zombie to set
     */
    public void setZombie(int zombie) {
        this.zombie = zombie;
    }

    /**
     * @return the quimera
     */
    public int getQuimera() {
        return quimera;
    }

    /**
     * @param quimera the quimera to set
     */
    public void setQuimera(int quimera) {
        this.quimera = quimera;
    }

    /**
     * @return the rangoVisiónJugador
     */
    public int getRangoVisiónJugador() {
        return rangoVisiónJugador;
    }

    /**
     * @param rangoVisiónJugador the rangoVisiónJugador to set
     */
    public void setRangoVisiónJugador(int rangoVisiónJugador) {
        this.rangoVisiónJugador = rangoVisiónJugador;
    }

    /**
     * @return the defensaJugador
     */
    public int getDefensaJugador() {
        return defensaJugador;
    }

    /**
     * @param defensaJugador the defensaJugador to set
     */
    public void setDefensaJugador(int defensaJugador) {
        this.defensaJugador = defensaJugador;
    }

    /**
     * @return the ataqueCortoJugador
     */
    public int getAtaqueCortoJugador() {
        return ataqueCortoJugador;
    }

    /**
     * @param ataqueCortoJugador the ataqueCortoJugador to set
     */
    public void setAtaqueCortoJugador(int ataqueCortoJugador) {
        this.ataqueCortoJugador = ataqueCortoJugador;
    }

    /**
     * @return the ataqueLargoJugador
     */
    public int getAtaqueLargoJugador() {
        return ataqueLargoJugador;
    }

    /**
     * @param ataqueLargoJugador the ataqueLargoJugador to set
     */
    public void setAtaqueLargoJugador(int ataqueLargoJugador) {
        this.ataqueLargoJugador = ataqueLargoJugador;
    }

    /**
     * @return the retrocesoJugador
     */
    public int getRetrocesoJugador() {
        return retrocesoJugador;
    }

    /**
     * @param retrocesoJugador the retrocesoJugador to set
     */
    public void setRetrocesoJugador(int retrocesoJugador) {
        this.retrocesoJugador = retrocesoJugador;
    }

    /**
     * @return the rangoJugador
     */
    public int getRangoJugador() {
        return rangoJugador;
    }

    /**
     * @param rangoJugador the rangoJugador to set
     */
    public void setRangoJugador(int rangoJugador) {
        this.rangoJugador = rangoJugador;
    }

    /**
     * @return the defensaQuimera
     */
    public int getDefensaQuimera() {
        return defensaQuimera;
    }

    /**
     * @param defensaQuimera the defensaQuimera to set
     */
    public void setDefensaQuimera(int defensaQuimera) {
        this.defensaQuimera = defensaQuimera;
    }

    /**
     * @return the ataqueCortoQuimera
     */
    public int getAtaqueCortoQuimera() {
        return ataqueCortoQuimera;
    }

    /**
     * @param ataqueCortoQuimera the ataqueCortoQuimera to set
     */
    public void setAtaqueCortoQuimera(int ataqueCortoQuimera) {
        this.ataqueCortoQuimera = ataqueCortoQuimera;
    }

    /**
     * @return the ataqueLargoQuimera
     */
    public int getAtaqueLargoQuimera() {
        return ataqueLargoQuimera;
    }

    /**
     * @param ataqueLargoQuimera the ataqueLargoQuimera to set
     */
    public void setAtaqueLargoQuimera(int ataqueLargoQuimera) {
        this.ataqueLargoQuimera = ataqueLargoQuimera;
    }

    /**
     * @return the retrocesoQuimera
     */
    public int getRetrocesoQuimera() {
        return retrocesoQuimera;
    }

    /**
     * @param retrocesoQuimera the retrocesoQuimera to set
     */
    public void setRetrocesoQuimera(int retrocesoQuimera) {
        this.retrocesoQuimera = retrocesoQuimera;
    }

    /**
     * @return the rangoQuimera
     */
    public int getRangoQuimera() {
        return rangoQuimera;
    }

    /**
     * @param rangoQuimera the rangoQuimera to set
     */
    public void setRangoQuimera(int rangoQuimera) {
        this.rangoQuimera = rangoQuimera;
    }

    /**
     * @return the defensaZombie
     */
    public int getDefensaZombie() {
        return defensaZombie;
    }

    /**
     * @param defensaZombie the defensaZombie to set
     */
    public void setDefensaZombie(int defensaZombie) {
        this.defensaZombie = defensaZombie;
    }

    /**
     * @return the ataqueCortoZombie
     */
    public int getAtaqueCortoZombie() {
        return ataqueCortoZombie;
    }

    /**
     * @param ataqueCortoZombie the ataqueCortoZombie to set
     */
    public void setAtaqueCortoZombie(int ataqueCortoZombie) {
        this.ataqueCortoZombie = ataqueCortoZombie;
    }

    /**
     * @return the retrocesoZombie
     */
    public int getRetrocesoZombie() {
        return retrocesoZombie;
    }

    /**
     * @param retrocesoZombie the retrocesoZombie to set
     */
    public void setRetrocesoZombie(int retrocesoZombie) {
        this.retrocesoZombie = retrocesoZombie;
    }

    /**
     * @return the rangoZombie
     */
    public int getRangoZombie() {
        return rangoZombie;
    }

    /**
     * @param rangoZombie the rangoZombie to set
     */
    public void setRangoZombie(int rangoZombie) {
        this.rangoZombie = rangoZombie;
    }

    @Override
    public String toString() {
        return "Configuraci\u00f3n{" + "ruta=" + ruta + ", anchura=" + anchura + ", altura=" + altura + ", tipo=" + tipo + ", piedra=" + 
                piedra + ", zombie=" + zombie + ", quimera=" + quimera + ", rangoVisi\u00f3nJugador=" + rangoVisiónJugador + ", defensaJugador=" + 
                defensaJugador + ", ataqueCortoJugador=" + ataqueCortoJugador + ", ataqueLargoJugador=" + ataqueLargoJugador + ", retrocesoJugador=" + 
                retrocesoJugador + ", rangoJugador=" + rangoJugador + ", defensaQuimera=" + defensaQuimera + ", ataqueCortoQuimera=" +
                ataqueCortoQuimera + ", ataqueLargoQuimera=" + ataqueLargoQuimera + ", retrocesoQuimera=" + retrocesoQuimera + ", rangoQuimera=" +
                rangoQuimera + ", defensaZombie=" + defensaZombie + ", ataqueCortoZombie=" + ataqueCortoZombie + ", retrocesoZombie=" 
                + retrocesoZombie + ", rangoZombie=" + rangoZombie + '}';
    }
    
}
