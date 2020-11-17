
/**
 * La clase Ordenar implementa el algoritmo Merge sort para ordenar una matriz de String en O(nlogn).
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OrdenarMatriz
{

    public static void imprimir(String Array[][]){
        for(int i=0;i<Array.length;i++){
            for(int j=0;j<Array[0].length;j++){
                System.out.print(Array[i][j]+" ");
            }
            System.out.println();
        }
    }

    /**
     * El método mergesort es un método que permite ordenar un arreglo de enteros, en este caso de menor a mayor
     * @param Array[] arreglo a ordenar
     * @param pos columna de la matriz a ordenar
     */
    public static String [][] mergesort(String Array[][],int pos){
        if(Array.length==1 ||Array.length==0){
            return Array;
        }
        return mergesort(Array, 0, Array.length-1,pos);
    }

    /**
     * En el método mergesort se hacen comparaciones entre los elementos del arreglo y 
     * según sea el caso se pasa al llamado recursivo que permitirá el ordeamiento de los elementos
     * @param Array[] arreglo a ordenar
     * @param izq Indicador de posiciones, en este caso posición izquierda
     * @param der Indicador de posiciones, en este caso posición izquierda
     * @param pos columna de la matriz a ordenar
     */
    private static String[][] mergesort(String Array[][],int izq, int der, int pos){
        String [][] arr=new String[Array.length][Array[0].length];
        if (izq < der){
            int mitad=(izq+der)/2;
            mergesort(Array,izq, mitad, pos);
            mergesort(Array,mitad+1, der, pos);                                                                                
            arr= merge(Array,izq, mitad, der, pos);                                                                                 
        }
        // Complejidad total: T(n)= T(n/2)+ T(n/2) + n
        // O(nlogn) donde n es el número de filas del arreglo 
        return arr;
    }

    /**
     * El método merge es un método que permite ordenar un arreglo de enteros, en este caso de menor a mayor.
     * Aquí se hacen comparaciones entre los elementos del arreglo y según sea el caso se intercambian las posiciones
     * de estos, de esta manera se da dicho ordenamiento
     * @param Array[] arreglo a ordenar
     * @param izq Indicador de posiciones, en este caso posición izquierda
     * @param der Indicador de posiciones, en este caso posición izquierda 
     * @param mitad Indicador de posiciones, en este caso posición media del arreglo 
     */
    private static String [][] merge(String Array[][],int izq, int mitad, int der, int pos){
        int izq1, izq2, izqG;
        String [][] aux = new String[Array.length][Array[0].length]; //array auxiliar
        for (izq1=izq; izq1<=der; izq1++)      //copia ambas mitades en el array auxiliar                                       
            aux[izq1]= Array[izq1];

        izq1=izq; izq2=mitad+1; izqG=izq;

        while (izq1<=mitad && izq2<=der) //copia el siguiente elemento más grande                                      
            if (Float.parseFloat(aux[izq1][pos])<=Float.parseFloat(aux[izq2][pos]))
                Array[izqG++]=aux[izq1++];
            else
                Array[izqG++]=aux[izq2++];

        while (izq1<=mitad)         //copia los elementos que quedan de la
            Array[izqG++]= aux[izq1++]; //primera mitad (si los hay)
        return Array;
    }
    // complejidad del algoritmo: 
    // T(n)= n*log(n)
    // O(n*log(n)) (Simetria) Complejidad logaritmica

}