/**
 * La clase Punto1 permite ordenar de menor a mayor un arreglo de números enteros 
 * siguiendo la lógica de INSERTION SORT.
 * La complejidad asintótica para el peor de los casos en que se ejecute
 * este algoritmo es O(n), es decir, la complejidad temporal de este algoritmo es lineal.
 * @author Laura Katterine Zapata Rendón, Maria Alejandra Vélez Clavijo
 * @version 1
 **/

public class punto1{
  
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

    public static void cicloMayor(int[] a){
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
    public static void cicloMenoraMayor(int[] a, int n){
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
    public static void MenorMayor(int[] a, int izq, int der){
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
    public static void intercambiar(int[] a, int izq, int der){
        int aux = a[izq];
        a[izq] = a[der];        
        a[der] = aux;
    }// T(n)= c7 + n^2, donde c7= 8
     // T(n) = n^2

    // complejidad del algoritmo: 
    // T(n)= n^2
    // O(n^2) (Simetría) Complejidad cuadrática


    
    

}