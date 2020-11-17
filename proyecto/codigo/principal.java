
import javafx.util.Pair;
/**
 * La clase principal permite hacer una prueba a la clase Datos e impurezaGini
 * @author (Maria Alejandra Vélez Clavijo, Laura Katterine Zapata Rendón) 
 * @version (1)
 */
public class principal
{
    public static void main(String[] args){

        //Test test=new Test("2_test_balanced_25000.csv");
        //Datos datos= new Datos();
        //datos.leer("2_test_balanced_25000.csv");
        long TInicio, TFin, tiempo; //Variables para determinar el tiempo de ejecución
        // TInicio = System.currentTimeMillis(); 
        //Arbol arbol=new Arbol("test1.csv");
        //TFin = System.currentTimeMillis(); //Tomamos la hora en que finalizó el algoritmo y la almacenamos en la variable T
        //tiempo = TFin - TInicio; //Calculamos los milisegundos de diferencia
        //System.out.println("Tiempo de ejecución en milisegundos: " + tiempo);
        TInicio = System.currentTimeMillis(); 
  
        //Test test=new Test("4_train_balanced_135000", "2_test_balanced_25000");
       //Test test=new Test("0_train_balanced_15000","1_test_balanced_15000");
        //Test test=new Test("1_train_balanced_45000","2_test_balanced_25000");
       // Test test=new Test("4_train_balanced_135000","4_train_balanced_135000");
         Test test=new Test("4_train_balanced_135000","4_test_balanced_45000");
        TFin = System.currentTimeMillis();
        tiempo = TFin - TInicio;
        System.out.println("Tiempo de ejecución en milisegundos: " + tiempo);
        

    }
}
