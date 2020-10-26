
import javafx.util.Pair;

/**
 * La clase Tree implementa un arbol binario de búsqueda.
 * 
 * @author (Maria Alejandra Vélez Clavijo, Laura Katterine Zapata Rendón) 
 * @version (1)
 */
public class Tree
{
    private Nodo root;
    private int size;
    private  String codigo="";

    public Tree(){
        this.root=null;
        this.size=0;
    }

    public int getSize(){
        return this.size;
    }

    public Nodo getRoot(){
        return this.root;
    }

    public void insert(int numero, boolean derecha){
        if(root==null){
            this.root=new Nodo(numero);
            //T(n)=  c1
        }else{
            insertAux(numero, this.root, derecha);
            //T(n)= T(n/2) + c2
        }
        //T(n)= T(n/2)
        //O(log n)
        //n: numero de nodos en el arbol
        this.size++;
    }

    public void insertAux(int numero, Nodo node, boolean derecha){
       if(derecha==false){
                if(node.getLeft()==null){
                    node.setLeft(new Nodo(numero));
                }else{
                    insertAux(numero, node.getLeft(), false);
                }
            }else{
                if(node.getRight()==null){
                    node.setRight(new Nodo(numero));
                }else{
                    insertAux(numero, node.getRight(), true);
                }
            }
        // O(logn)
        // n: numero de elementos del arbol
    }

}
