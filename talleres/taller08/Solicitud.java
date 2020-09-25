
/**
 * La clase Solicitud define los atributos de una solicitud y su constructor.
 * 
 * @author Laura Katterine Zapata Rendón, Maria Alejandra Vélez Clavijo
 * @version 1
 */
public class Solicitud
{
    private String tienda;
    private int numNeveras;

    public String getTienda(){
        return this.tienda;
    }

    public int getNumNeveras(){
        return this.numNeveras;
    }

    public Solicitud(String t, int n){
        this.tienda=t;
        this.numNeveras=n;
    }
}
