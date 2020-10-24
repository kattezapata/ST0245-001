import java.util.ArrayList;
import java.util.LinkedList;
import javafx.util.Pair;

/**
 * Implementacion de un grafo dirigido usando listas de adyacencia
 *
 * @author (Laura Katterine Zapata Rendón, Maria Alejandra Vélez Clavijo) 
 * @version (1)
 */
public class DigraphAL extends Digraph {
    //Para la lista de adyacencia se hace un ArrayList de LinkedList que a su vez almacena Pair de Integer
    private ArrayList<LinkedList<Pair<Integer,Integer>>> array=new ArrayList <>();

    /**
     * Constructor para el grafo dirigido
     * @param vertices el numero de vertices que tendra el grafo dirigido
     *
     */
    public DigraphAL(int size) {
        super(size);

        for(int i=0;i<this.size;i++){
            LinkedList<Pair<Integer,Integer>> lista=new LinkedList();
            array.add(lista);
        }

    }

    /**
     * Metodo para añadir un arco nuevo, donde se representa cada nodo con un entero
     * y se le asigna un peso a la longitud entre un nodo fuente y uno destino	
     * @param source desde donde se hara el arco
     * @param destination hacia donde va el arco
     * @param weight el peso de la longitud entre source y destination
     */
    public void addArc(int source, int destination, int weight) {
        this.array.get(source).addLast(new Pair(destination,weight));
    }

    /**
     * Metodo para obtener una lista de hijos desde un nodo, es decir todos los nodos
     * asociados al nodo pasado como argumento
     * @param vertex nodo al cual se le busca los asociados o hijos
     * @return todos los asociados o hijos del nodo vertex, listados en una ArrayList
     * Para más información de las clases:
     * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/ArrayList.html"> Ver documentacion ArrayList </a>
     */
    public ArrayList<Integer> getSuccessors(int vertex) {
        ArrayList<Integer> arr=new ArrayList<>();

        LinkedList<Pair<Integer,Integer>> lista = array.get(vertex);

        for(Pair<Integer,Integer> pareja: lista){
            arr.add(pareja.getKey());
        }

        return arr;
    }

    /**
     * Metodo para obtener el peso o longitud entre dos nodos
     * 
     * @param source desde donde inicia el arco
     * @param destination  donde termina el arco
     * @return un entero con dicho peso
     */	
    public int getWeight(int source, int destination) {
        int weight=0;
        boolean stop=false;

        int i=0;

        while(stop==false && i<this.size){
            i++;

            Pair pareja=array.get(source).poll();
            //caso; lista vacia
            if(pareja==null){
                stop=true;
            }else{
                Integer des=(Integer)pareja.getKey();
                Integer wei=(Integer)pareja.getValue();

                this.addArc(source,des,wei);
                if(des==destination){
                    weight=wei;
                    stop=true;
                }
            }

        }
        return weight;
    }

}