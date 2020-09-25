
/**
 * La clase Punto1 implementa un algoritmo para evaluar expresiones
 * en notación polaca inversa utilizando pilas
 * 
 * @author Laura Katterine Zapata Rendón, Maria Alejandra Vélez Clavijo
 * @version 1
 */
import java.util.Stack;
public class Punto1
{
    public static void main(String []args){
        System.out.println(notacionPolacaInversa("6 5 - 4 +"));
    }

    public static int notacionPolacaInversa(String s){
        String simbolos = "+-*/";
        Stack<Integer> pila = new Stack();
        if (s.length() > 2)
            for (String subcadena : s.split(" ")){
                if (simbolos.contains(subcadena)){
                    if (subcadena.equals("+")){
                        pila.push(pila.pop()+pila.pop()); 
                    }

                    if (subcadena.equals("-")){
                        pila.push(-1*pila.pop()+pila.pop()); 
                    }
                    if (subcadena.equals("*")){
                        pila.push(pila.pop()*pila.pop()); 
                    }
                    if (subcadena.equals("/")){
                        int numeroDeArriba = pila.pop();
                        int numeroDeAbajo =  pila.pop();
                        pila.push(numeroDeAbajo/numeroDeArriba); 
                    }

                }
                else
                    pila.push(Integer.parseInt(subcadena)); //Cannot convert String into Integer
            }
        return pila.pop();
    }
}

