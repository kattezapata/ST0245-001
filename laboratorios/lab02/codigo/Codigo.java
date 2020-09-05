/**
 * La clase código permite ordenar de menor a mayor un arreglo de números enteros 
 * siguiendo la lógica de INSERTION SORT y de MERGESORT.
 * @author Laura Katterine Zapata Rendón, Maria Alejandra Vélez Clavijo
 * @version 1
 **/

public class Codigo
{
    //*******************Merge Sort**********************
    public static void main(String []args){
      //Hallar los 20 tiempos para MergeSort
        for(int n=10000;n<=200000;n=n+10000){
            int [] arr = new int[n];
            int j=0;
            for (int i=arr.length-1; i>=0; i--){
                arr[i]= j;
                j++;
            }
            long tiempoInicial=System.currentTimeMillis();
            mergesort(arr);
            long tiempoFinal=System.currentTimeMillis();
            System.out.println(tiempoFinal-tiempoInicial);

        }
        
     //Hallar los 20 tiempos para InsertionSort
        for(int n=10000;n<=200000;n=n+10000){
            int [] arr = new int[n];
            int j=0;
            for (int i=arr.length-1; i>=0; i--){
                arr[i]= j;
                j++;
            }
            long tiempoInicial=System.currentTimeMillis();
            insertionSort(arr);
            long tiempoFinal=System.currentTimeMillis();
            System.out.println(tiempoFinal-tiempoInicial);

        }

    }

    /**
     * El método mergesort es un método que permite ordenar un arreglo de enteros, en este caso de menor a mayor
     * @param Array[] arreglo a ordenar
     */
    public static void mergesort(int Array[]){
        mergesort(Array, 0, Array.length-1);
    }

    /**
     * En el método mergesort se hacen comparaciones entre los elementos del arreglo y 
     * según sea el caso se pasa al llamado recursivo que permitirá el ordeamiento de los elementos
     * @param Array[] arreglo a ordenar
     * @param izq Indicador de posiciones, en este caso posición izquierda
     * @param der Indicador de posiciones, en este caso posición izquierda
     */
    private static void mergesort(int Array[],int izq, int der){
        if (izq < der){
            int mitad=(izq+der)/2;
            mergesort(Array,izq, mitad);
            mergesort(Array,mitad+1, der);                                                                                
            merge(Array,izq, mitad, der);                                                                                 
        }
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
    private static void merge(int Array[],int izq, int mitad, int der){
        int izq1, izq2, izqG;
        int [] aux = new int[Array.length]; //array auxiliar
        for (izq1=izq; izq1<=der; izq1++)      //copia ambas mitades en el array auxiliar                                       
            aux[izq1]= Array[izq1];

        izq1=izq; izq2=mitad+1; izqG=izq;

        while (izq1<=mitad && izq2<=der) //copia el siguiente elemento más grande                                      
            if (aux[izq1]<=aux[izq2])
                Array[izqG++]=aux[izq1++];
            else
                Array[izqG++]=aux[izq2++];

        while (izq1<=mitad)         //copia los elementos que quedan de la
            Array[izqG++]= aux[izq1++]; //primera mitad (si los hay)

    }
    // complejidad del algoritmo: 
    // T(n)= n*log(n)
    // O(n*log(n)) (Simetría) Complejidad logaritmica

     //****************Insertion Sort*********************
    
    /**
     * El método intertionSort sirve como método auxiliar, el cual le pasa el array a que recibe
     * como parámetro, al método cicloMayor
     * @param [] a arreglo a ordenar
     */
    public static void insertionSort(int[] a){
        cicloMayor(a);
    } // T(n)=c1; c1=1

    /**
     * El método cicloMayor es un método que ayuda en el recorrido del arreglo.
     * Envía al método cicloMenorMayor el arreglo a ordenar y un iterador que será útil para 
     * recorrer cada uno de los elementos del arreglo; dicho iterador va desde cero, o posición inicial
     * y hasta la última posición del arreglo
     * @param [] a arreglo a ordenar
     */

    private static void cicloMayor(int[] a){
        for(int i = 0; i < a.length; i++ )
            cicloMenoraMayor(a, i);
    }
    // T(n)= c2*n + c3 + c1, donde c2= 3 y c3= 2
    // T(n)= c2*n (Regla de la suma)
    // T(n)= n (Regla del producto)

    /**
     * El método cicloMenoraMayor es un método que ayuda en el recorrido del arreglo.
     * Envía al método MenorMayor el arreglo a ordenar y dos iteradores que serán útiles en la indicación y recorrido
     * cada elemento del arreglo y su antecesor. 
     * @param [] a arreglo a ordenar
     * @param int n iterador que servirá como índice 
     */
    private static void cicloMenoraMayor(int[] a, int n){
        for(int j = n; j > 0 ; j--)
            MenorMayor(a, j, j-1);
    } // T(n)= (c4*n + c5)*n, donde c4=2 y c5= 3
    // T(n)= c4*n^2 + c5
    // T(n)= c4*n^2 (Regla de la suma)
    // T(n)= n^2 (Regla del producto)

    /**
     * El método MenorMayor identifica si el elemento en la posición n es mayor o menor al elemento
     * de la posición n-1.
     * Si el elemento en la posición n es menor al de la posición n-1 entones se llama al método intercambiar
     * y se pasa el arreglo y  dichos índices de los elementos a intercambiar
     * @param [] a arreglo a ordenar
     * @param int izq Número de índice de un elemento que está en una posición n-1
     * @param int der Número del índice de un elemento que está en la posición n
     */
    private static void MenorMayor(int[] a, int izq, int der){
        if (a[der] < a[izq])
            intercambiar(a, izq, der);
    } // T(n)= n^2 + c6, donde c6= 5
    // T(n)= n^2 (Regla de la suma)

    /**
     * El método intercambiar es un método que intercambia de posición los los elementos
     * de tal forma de que queden de menor a mayor
     * @param [] a arreglo a ordenar
     * @param int izq Número de índice de un elemento que está en una posición n-1
     * @param int der Número del índice de un elemento que está en la posición n
     */
    private static void intercambiar(int[] a, int izq, int der){
        int aux = a[izq];
        a[izq] = a[der];        
        a[der] = aux;
    }// T(n)= c7 + n^2, donde c7= 8
    // T(n) = n^2

    // complejidad del algoritmo: 
    // T(n)= n^2
    // O(n^2) (Simetría) Complejidad cuadrática

}
