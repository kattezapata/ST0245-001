import java.util.ArrayList;
/**
 * Esta clase implementa un árbol binario de búsqueda
 * @author Maria Alejnadra Velez Clavijo, Laura Katterine Zapata Rendón
 */
public class Point2
{
    public Node root;
    /**
     * Pasa por cada posición del arreglo y llama al método que inserta cada elemento del arreglo en el árbol
     * @param int[] preOrder arreglo a insertar
     */

    public void buildingTree (int [] preOrder) {
        root=new Node(preOrder[0]);
        for(int i = 1; i < preOrder.length; i++) {
            insert(root, preOrder[i]);
        }
        // n: número de elementos a agregar
        // T(n)= n*logn + c
        //O(n*logn)
    }

    /**
     * Inserta cada elemento en el árbol
     * @param node nodo padre
     * @param data dato a insertar
     */
    public void insert (Node node, int data) {
        if(data<node.getData() && node.getLeft() == null) {
            node.setLeft(new Node(data));
        } else if(data<node.getData()) {
            insert(node.getLeft(), data);
        } else if(data>node.getData() && node.getRight() == null) {
            node.setRight(new Node(data));
        } else if(data>node.getData()) {
            insert(node.getRight(),data);
        }
        // T(n)= T(n/2)+c
        //O(logn) 
        // n: numero de elementos del árbol;
    }

    /**
     * Imprime los elementos de un arbol en preorder
     * @param node nodo padre
     */
    public void preOrder(Node node) {
        if(node != null) {
            System.out.println(node.getData());
            preOrder(node.getLeft());
            preOrder(node.getRight());
        }
        // T(n)= T(n/2) + T(n/2) + c
        // O(n)
        // n: número de elementos del árbol
    }

    /**
     * Imprime los elementos de un arbol en posorder
     * @param node nodo padre
     */
    public void posOrder(Node node) {
        if(node != null) {
            posOrder(node.getLeft());
            posOrder(node.getRight());
            System.out.println(node.getData());
        }
         // T(n)= T(n/2) + T(n/2) + c
        // O(n)
        // n: número de elementos del árbol
    }

    /**
     * Recibe el arreglo, llama el método que crea el árbol con dicho arreglo e imprime los elementos del árbol en posorder
     * @param input arreglo de enteros 
     */
    public void exercise21 (int [] input) {
        buildingTree(input); // O(nlogn)
        System.out.println("PosOrder");
        posOrder(root);// O(n)
        System.out.println();
        // T(n)= nlogn + n
        // O(nlogn)
        // n: total de elementos del árbol
    }

    /**
     * Método principal
     */
    public static void main (String [] args) {
        int [] test = {50,30,24,5,28,45,98,52,60};
        Point2 testing = new Point2();
        testing.exercise21(test);
    }
}