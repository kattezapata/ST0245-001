/**
 * La clase Punto3 calcula el valor enésimo de la serie
 * de Fibonacci recursivamente.
 * La complejidad asintótica para el peor de los casos en que se ejecute este
 * algoritmo es O(2^n) es decir la complejidad temporal de este algoritmo es exponencial.		
 * @author Laura Katterine Zapata Rendón, Maria Alejandra Vélez Clavijo
 * @version 1
 */

public class Punto3
{
    public static void main(String []args){
        long tiempoInicial=System.currentTimeMillis();
        for(int n=22;n<42;n++){
            fibonacci(n);
            long tiempoFinal=System.currentTimeMillis();
            System.out.println(tiempoFinal-tiempoInicial);
        }
    }

    /**
     * El metodo se encarga de devolvernos el valor fibonacci en la enesima posicion
     * @param n Numero entero hasta el cual se va a realizar la serie
     * @return Valor de fibonacci en la posición n
     */

    public static int fibonacci(int n){
        if(n<=1){ 
            return n;// T(n)=c1, donde c1=3
        }else{
            return fibonacci(n-1)+fibonacci(n-2);
            //T(n)= c2+T(n-1)+T(n-2), donde c2=5
            //T(n)= 2^n (Exponencial)
        }
    }
}
 