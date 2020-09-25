
/**
 * La clase Punto3 implementa un algoritmo que
 * invierte los elementos de una pila.
 * 
 * @author Laura Katterine Zapata Rendón, Maria Alejandra Vélez Clavijo
 * @version 1
 */
import java.util.Stack;
public class Punto3
{

    public static void main(String []args){
        Stack<Integer> pila = new Stack<>();

        pila.push(1);
        pila.push(2);
        pila.push(3);
        System.out.println("Pila original: "+pila);
        System.out.println("Pila invertida: "+invertirPila(pila));
       
    }

    public static Stack<Integer> invertirPila(Stack<Integer> pila){
        int size=pila.size();
        Stack<Integer> pilaInvertida = new Stack<>();
        while(pilaInvertida.size()!=size){
            pilaInvertida.push(pila.pop());
        }
        return pilaInvertida;
    }
}
