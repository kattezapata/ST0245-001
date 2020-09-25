
/**
 * La clase Nevera define los atributos de una nevera y su constructor.
 * 
 * @author Laura Katterine Zapata Rendón, Maria Alejandra Vélez Clavijo 
 * @version 1
 */
public class Nevera
{
    private int codigo;
    private String descripcion;

    public int getCodigo()   {
        return this.codigo;}

    public String getDescripcion() {
        return this.descripcion; }

    public Nevera(int c, String d) {
        this.codigo = c; 
        this.descripcion = d;}
}

