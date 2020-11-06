
/**
 * Esta clase permite saber si se puede o no colorear un grafo conexo, con dos colores distintos.
 * @author Maria Alejandra Vélez Clavijo, Laura Katterine Zapata Rendón
 * @version 1
 */
import java.util.*; 

public class Colorear { 

    /**
     * Este método retorna true si el grafo se puede colorear
     * @param Grafo[][] matriz de adyacencia del grafo a colorear
     * @param cabeza primer vertice a colorear
     * @param colores[] arreglo que contiene los colores de cada vertice
     * @return boolean true si el grafo se puede colorear, de lo contrario false
     */
    public static boolean sePuedeColorear(int Grafo[][], int cabeza) 

    { 
        int[] colores= new int[Grafo.length];
        for(int i =0; i<colores.length; i++){
            colores[i]=-1;
        } 
        // n: numero de vertices del grafo
        // O(n)

        colores[cabeza] = 1; 

        //crea una cola de vertices
        LinkedList<Integer> queue = new LinkedList<Integer>(); 
        queue.add(cabeza);//O(1) 

        // Pasa por todos los vertices en la cola
        while (!queue.isEmpty()) // T(n)=n+c
        { 

            int verticeActual = queue.getFirst(); //O(1)
            queue.poll(); // O(1)

            // Retorna falso si se conecta a si mismo
            if (Grafo[verticeActual][verticeActual] == 1) 
                return false;   

            // Encuentra los vertices adyacentes no coloreados
            for (int v = 0; v < colores.length; v++) // T(n)= n + c
            { 

                // Si hay una conexion entre los vertices u y v y v no esta coloreado
                if (Grafo[verticeActual][v] ==1 && colores[v] == -1) 
                { 

                    // Asigna el color contrario al vertice actual
                    colores[v] = 1 - colores[verticeActual]; 
                    queue.add(v); //O(1)
                } 

                // Si hay una conexion y tiene los mismos colores
                else if (Grafo[verticeActual][v] ==1 && colores[v] ==  
                colores[verticeActual]) 
                    return false; 
            } 
        } //T(n)= n*n + c
        //O(n^2)
        //Donde n es el numero de vertices del grafo

        //  si llego hasta acá entonces todos los vertices adyacentes tienen distinto color
        return true; 
    }
}
 