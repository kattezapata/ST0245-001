import java.lang.Math;
/**
 * La clase Punto1 permite calcular el máximo de los elementos de un
 * arreglo de forma recursiva. 
 * La complejidad asintótica para el peor de los casos en que se ejecute
 * este algoritmo es O(n), es decir, la complejidad temporal de este algoritmo es lineal.
 * @author Laura Katterine Zapata Rendón, Maria Alejandra Vélez Clavijo
 * @version 1
 **/

public class Punto1
{

    /**
     * 
     */
    public static void main(String args[]){
        long tiempoInicial=System.currentTimeMillis();
        for(int n=9000;n<9020;n++){
            max(new int [n]);
            long tiempoFinal=System.currentTimeMillis();
            System.out.println(tiempoFinal-tiempoInicial);
        }

    }

    /**
     * El método max nos permite obtener el número de máximo valor 
     * en un arreglo de enteros
     * @param arreglo[] Arreglo del cual se va obtener el número de valor máximo
     * @return int Devuelve el elemento del arreglo con el valor máximo
     */

    public static int  max(int arreglo []){
        return max(arreglo,arreglo.length);
    }
    //n= longitud del arreglo
    /**
     * El método max nos permite obtener el número de máximo valor 
     * en un arreglo de enteros
     * @param arreglo[] Arreglo del cual se va obtener el número de valor máximo
     * @param n Longitud del arreglo números enteros
     * @return int Devuelve el elemento del arreglo con el valor máximo
     */
    private static int max(int arreglo [],int n){
        if(n==1){
            return arreglo[0]; //T(n)=c1, donde c1=4
        }else{
            return  Math.max(max(arreglo,n-1),arreglo[n-1]);
            // T(n)=c2+T(n-1), donde c2=6
            // T(n)=c2*n + c1
            // T(n)= n (Lineal)
        }
    }

}