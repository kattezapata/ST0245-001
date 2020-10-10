import javafx.util.Pair;
import java.util.Stack;
/**
 * Esta clase implementa una tabla hash y los métodos agregar y buscar un elemento
 * @author (Maria Alejandra Vélez Clavijo, Laura Katterine Zapata Rendón) 
 * @version (1)
 */
public class TablaHash
{
    private static Stack<Pair<String, Integer>>[] tabla;

    /**
     * Este método define el array utilizado 26 posiciones de manera que tenemos un límite de 26 elementos
     * 
     */
    public TablaHash(){
        tabla = new Stack[26];
        ;
        for(int i =0; i< tabla.length; i++){
            Stack<Pair<String, Integer>> Lista= new Stack();
            tabla[i]=Lista;
        }

    }

    /**
     * @param k es la llave del elemento que servirá como referencia al buscar
     * Este método se utiliza para darle una posicion dentro de la tabla
     * 
     */
    private int funcionHash(String k){
        return ( k.toUpperCase().charAt(0)- 'A') % tabla.length;
    }

    /**
     * @param k es la llave del elemento que servirá como referencia al buscar
     * Este método se utiliza para obtener el elmento con la clave k, se enlaza con funcionHash
     * retorna -1 si no encuentra el elemento
     * @return valor correspondiente a la clave k
     */
    public int get(String k){
        int indice = funcionHash(k);
        Stack<Pair<String, Integer>> lista= tabla[indice];
        Object lista1= lista.clone();
        Stack<Pair<String, Integer>> lista2= (Stack)lista1;
        Pair<String, Integer> nodo;

        while(lista2.size()!=0){
            nodo= lista2.pop();
            if(nodo.getKey()==k){
                return nodo.getValue();

            }
        }
        return -1;
    }

    /**
     * @param k es la llave del elemento que servirá como referencia al buscar posteriormente
     * @param v es el valor asociado a la llave k
     * Este método se utiliza para agregar un nuevo elemento
     */
    public void put(String k, int v){
        Pair<String, Integer> pair= new Pair<>(k,v);
        int indice = funcionHash(k);
        tabla[indice].push(pair);

    }
}

