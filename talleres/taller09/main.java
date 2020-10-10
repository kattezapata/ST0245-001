
/**
 * Clase de prueba de la clase TablaHash
 * @author (Maria Alejandra Vélez Clavijo, Laura Katterine Zapata Rendón) 
 * @version (1)
 */
public class main
{
    public static void main(String[] args){
    TablaHash tabla1= new TablaHash();
    tabla1.put("maria", 123);
    tabla1.put("laura", 456);
    tabla1.put("alejandra", 789);
    tabla1.put("katterine", 101112);
    tabla1.put("katterine", 255621);
    System.out.println(tabla1.get("katterine"));
    
    }
    
    
}
