
package dominio;

import java.io.FileNotFoundException;

/**
 *
 * @author Nicole Fonseca, Wilmer Mata
 */

public class Zombie extends Personaje{

    public Zombie() {
    }

    public Zombie(int x, int y) throws FileNotFoundException {
        super(x, y);
    }
   
}

