/**
 * La clase OrdenarArreglo implementa el algoritmo Merge sort para ordenar un arreglo de String en O(nlogn).
 * 
 * @author Maria Alejandra Vélez Clavijo, Laura Katterine Zapata Rendón
 * @version 1
 */
public class OrdenarArreglo
{

    public static void imprimir(String Array[]){
        for(int i=0;i<Array.length;i++){

            System.out.print(Array[i]+" ");

        }
        // O(n) n: cantidad de elementos del arreglo
    }

    /**
     * El metodo mergesort es un método que permite ordenar un arreglo de enteros, en este caso de menor a mayor
     * @param Array arreglo a ordenar
     * @return String[] arreglo ordenado de menor a mayor
     */
    public static String [] mergesort(String Array[]){
        if(Array.length==1 ||Array.length==0){
            return Array;
        }
        return mergesort(Array, 0, Array.length-1);
    } 

    /**
     * En el metodo mergesort se hacen comparaciones entre los elementos del arreglo y 
     * según sea el caso se pasa al llamado recursivo que permitirá el ordeamiento de los elementos
     * @param Array arreglo a ordenar
     * @param izq Indicador de posiciones, en este caso posición izquierda
     * @param der Indicador de posiciones, en este caso posición izquierda
     * @return String[] arreglo ordenado de menor a mayor
     */
    private static String[] mergesort(String Array[],int izq, int der){
        String [] arr=new String[Array.length];
        if (izq < der){
            int mitad=(izq+der)/2;
            mergesort(Array,izq, mitad); // T(n)=T(n/2)+c
            mergesort(Array,mitad+1, der);  // T(n)=T(n/2)+c                                                                               
            arr= merge(Array,izq, mitad, der);   // O(n) donde n es la cantidad de elementos del arreglo                                                                             
        }
        // Complejidad total: T(n)= T(n/2)+ T(n/2) + n
        // O(nlogn) donde n es la cantidad de elementos del arreglo
        return arr;
    }

    /**
     * El metodo merge permite ordenar un arreglo de String, en este caso de menor a mayor.
     * Aqui se hacen comparaciones entre los elementos del arreglo y según sea el caso se intercambian las posiciones
     * de estos, de esta manera se da dicho ordenamiento
     * @param Array arreglo a ordenar
     * @param izq Indicador de posiciones, en este caso posición izquierda
     * @param der Indicador de posiciones, en este caso posición izquierda 
     * @param mitad Indicador de posiciones, en este caso posición media del arreglo 
     * @return String[] arreglo ordenado de menor a mayor
     */
    private static String [] merge(String Array[],int izq, int mitad, int der){
        int izq1, izq2, izqG;
        String [] aux = new String[Array.length]; //array auxiliar
        for (izq1=izq; izq1<=der; izq1++)  
        // O(n) n: cantidad de elementos del arreglo
        //copia ambas mitades en el array auxiliar                                       
            aux[izq1]= Array[izq1];

        izq1=izq; izq2=mitad+1; izqG=izq;

        while (izq1<=mitad && izq2<=der) 
        // T(n)= n/2
        //copia el siguiente elemento más grande                                      
            if (Float.parseFloat(aux[izq1])<=Float.parseFloat(aux[izq2]))
                Array[izqG++]=aux[izq1++];
            else
                Array[izqG++]=aux[izq2++];

        while (izq1<=mitad)   
        // T(n)= n/2
        //copia los elementos que quedan de la
            Array[izqG++]= aux[izq1++]; //primera mitad (si los hay)
        return Array;
        // Complejidad total: T(n)= n/2+n/2+n+c
        // T(n)=2n 
        // O(n) donde n es la cantidad de elementos del arreglo
    }
    // complejidad del algoritmo: 
    // T(n)= n*log(n)
    // O(n*log(n)) (Simetria) Complejidad logaritmica

}
