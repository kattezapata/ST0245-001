/**
 * La clase Punto1 permite ordenar de menor a mayor un arreglo de números enteros 
 * siguiendo la lógica de INSERTION SORT.
 * La complejidad asintótica para el peor de los casos en que se ejecute
 * este algoritmo es O(n), es decir, la complejidad temporal de este algoritmo es lineal.
 * @author Laura Katterine Zapata Rendón, Maria Alejandra Vélez Clavijo
 * @version 1
 **/

public class punto1{
    private static int min, max;

    public static void main(String [] args){

        for(int n=9979;n<9999;n++){
            int [] arr = new int[n];
            for (int i=arr.length-1; i==0; i++){
                arr[i]= i;
            }
           long tiempoInicial=System.currentTimeMillis();
            OrdenarArr(arr);
            long tiempoFinal=System.currentTimeMillis();
            System.out.println(tiempoFinal-tiempoInicial);
        
        }

    }
    /**
     * El método OrdenarArr permite ordenar los elementos de un arreglo de  menor a mayor 
     * @param array arreglo de enteros 
     * @return int[] Arreglo de enteros ordenados ascendentemente
     */
    public static int[] OrdenarArr(int[] array){
        return OrdenarArr(array, 0);
    }
    /**
     * El método OrdenarArr es un auxiliar que permite ordenar los elementos de un arreglo de  menor a mayor 
     * @param array arreglo de enteros 
     * @param n iterador
     * @return int[] Arreglo de enteros ordenados ascendentemente
     */
    private static int[] OrdenarArr(int[] array, int n ){
        if(n==1){
            min=max=array[n];    
        }

        if(n>array.length-1){
            return array;
        }
        else{
            if(n > 0 && array[n]<array[n-1]){
                min= array[n];
                max= array[n-1];
                array[n]=max;
                array[n-1]=min;
                return OrdenarArr(array, n-1);
                // Complejidad:
                // T(n)= c_1 + T(n-1), donde c_1=19
                // T(n)= c1 n + c_1
                // O(c1 n + c_1) (Simetría)
                // O(c1 n ) (Regla de la suma)
                // O(n) (Regla del producto)
                // O(n) Complejidad lineal



            }
            return OrdenarArr(array, n+1);
        }

    }

}