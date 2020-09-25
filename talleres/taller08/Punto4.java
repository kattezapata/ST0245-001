
/**
 * La clase Punto4 simula el comportamiento de un bar
 * para atenter a los clientes en el orden de llegada. 
 * 
 * @author Laura Katterine Zapata Rendón, Maria Alejandra Vélez Clavijo
 * @version 1
 */
import java.util.Queue;
import java.util.LinkedList;
public class Punto4
{

    public static void main(String []args){
        Queue<String> cola = new LinkedList<>();

        cola.add("Juan");//Llegó primero
        cola.add("Maria");
        cola.add("Pedro");//Llegó de ultimas
        atendiendoA(cola);

    }

    public static void atendiendoA(Queue<String> cola){
        int size=cola.size();
        for(int i=0;i<size;i++){
            System.out.println("Atendiendo a: "+cola.poll());
        }

    }
}
