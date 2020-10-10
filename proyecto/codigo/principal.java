
/**
 * La clase principal permite hacer una prueba a la clase Datos e impurezaGini
 * @author (Maria Alejandra Vélez Clavijo, Laura Katterine Zapata Rendón) 
 * @version (1)
 */
public class principal
{
    public static void main(String[] args){
        Datos dato= new Datos();
        dato.leer("test");
        // dato.imprimir(dato.getArray());
        int key= impurezaGini.mejorCondicion(dato.getArray()).getKey();
       String value=impurezaGini.mejorCondicion(dato.getArray()).getValue();
        System.out.println("Columna: "+key+ " Mejor valor: " + value);

    }
}
