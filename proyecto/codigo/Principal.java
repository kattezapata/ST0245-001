
import javafx.util.Pair;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
/**
 * La clase Principal es el punto de partida para el algoritmo que diseña un arbol de decision con el algoritmo Cart.
 * @author (Maria Alejandra Vélez Clavijo, Laura Katterine Zapata Rendón) 
 * @version (1)
 */
public class Principal
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
        MemoryMXBean mbean = ManagementFactory.getMemoryMXBean();
        MemoryUsage memoryStart , memoryEnd;
        memoryStart = mbean.getHeapMemoryUsage();
       // TInicio = System.currentTimeMillis(); 

       //Test test=new Test("0 train", "0 test");
       Test test=new Test("1 train","1 test");
      //  Test test=new Test("0 test","0 test");
      // Test test=new Test("2 train","2 train");
       // Test test=new Test("4 train","4 train");
        
        // Test test=new Test("2 train","2 test");

       // Test test=new Test("4 train","4 test");
        //TFin = System.currentTimeMillis();
        memoryEnd = mbean.getHeapMemoryUsage();

        System.out.println("Memory comsuption: "+((memoryEnd.getUsed()-memoryStart.getUsed())/1000000)+"mb");
       // tiempo = TFin - TInicio;
       // System.out.println("Tiempo de ejecución en milisegundos: " + tiempo);

    }
}
