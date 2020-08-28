
/**
 * La clase Punto2 tiene como objetivo implementar un algoritmo
 * que calcule la suma de los elementos de un arreglo utilizando ciclos
 * 
 * @author Laura Katterine Zapata Rendon, Maria Alejandra Velez Clavijo
 * @version 1
 */
public class Punto2
{

    public static int sumaArreglo(int [] arreglo){
        int suma=0; // c1 
        for (int i=0;i<arreglo.length;i++){ // c2 + c3n
            suma = suma + arreglo[i]; // c4*n
        }
        return suma; // c5
                     // T(n) = c1 + c2 + c3n + c4n + c5 la complejidad es O(n)
    }
                  

}
