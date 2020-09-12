/** 
 * Esta clase permite crear un nodo
 * @author Maria Alejandra Vélez Clavijo, Laura Katterine Zapata Rendon
 * @version 1
 */
public class Node {

    //Atributos

    public int data;

    public Node next;

    //Constructor
    public Node(int data)
    {
        next = null;
        this.data = data;
    }

}