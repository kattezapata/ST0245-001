import javafx.util.Pair;
/**
 * Write a description of class Main here.
 * 
 * @author (Maria Alejandra Vélez Clavijo, Laura Katterine Zapata Rendón) 
 * @version (1)
 */
public class Main
{
    public static void main(String []args){

        Tree tree=new Tree();

        tree.insert("Maria",123123);
        tree.insert("Juan",321321);
        tree.insert("Juan",111111);
        tree.insert("Juan",111112);
        tree.insert("Juan",222222);
        tree.insert("Juan",4);
        tree.insert("Juan",999999);
        System.out.println("InOrder:");
        tree.printInOrder();
        System.out.println();

        System.out.println("PreOrder:");
        tree.printPreOrder();
        System.out.println();

        System.out.println("PosOrder:");
        tree.printPosOrder();
        System.out.println(tree.getSize());
        System.out.println(tree.contains("Maria",123123));
        System.out.println(tree.contains("Jose",564735));

    }
}
