import javafx.util.Pair;
/**
 * Write a description of class Node here.
 * 
 * @author (Maria Alejandra Vélez Clavijo, Laura Katterine Zapata Rendón) 
 * @version (1)
 */
public class Node
{
    private Pair<String,Integer> data;
    private Node left;
    private Node right;

    public Node(String nombre,Integer numero){

        this.data=new Pair(nombre,numero);

        this.left=null;
        this.right=null;

    }

    public Pair<String,Integer> getData(){
        return this.data;
    }

    public Node getLeft(){
        return this.left;
    }

    public Node getRight(){
        return this.right;
    }

    public void setLeft(Node left){
        this.left=left;
    }

    public void setRight(Node right){
        this.right=right;
    }

}
