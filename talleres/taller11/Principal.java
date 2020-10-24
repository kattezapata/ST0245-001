
/**
 * La clase principal tiene como objetivo realizar pruebas a los métodos de las clases DigraphAL y DigraphAM.
 * 
 * @author (Laura Katterine Zapata Rendón, Maria Alejandra Vélez Clavijo) 
 * @version (1)
 */
public class Principal
{
    public static void main(String []args){

        DigraphAL lista=new DigraphAL(8);
        //(pos origen, pos destino, nombre destino)
        lista.addArc(1,4,8);
        lista.addArc(1,6,10);
        lista.addArc(2,7,11);
        lista.addArc(3,7,11);
        lista.addArc(3,4,8);
        lista.addArc(4,5,9);
        lista.addArc(7,0,2);
        lista.addArc(7,5,9);
        lista.addArc(7,6,10);

        System.out.println("*******   Lista de adyacencia  *******");
        System.out.println("*Pos origen: "+0+  "  Pos destino: "+4+  "  Peso: "+lista.getWeight(0,4));
        System.out.println("Pos origen: "+1+  "  Pos destino: "+4+  "  Peso: "+lista.getWeight(1,4));
        System.out.println("Pos origen: "+1+  "  Pos destino: "+6+  "  Peso: "+lista.getWeight(1,6));
        System.out.println("Pos origen: "+2+  "  Pos destino: "+7+  "  Peso: "+lista.getWeight(2,7));
        System.out.println("Pos origen: "+3+  "  Pos destino: "+7+  "  Peso: "+lista.getWeight(3,7));
        System.out.println("*Pos origen: "+5+  "  Pos destino: "+4+  "  Peso: "+lista.getWeight(5,4));
        System.out.println("Pos origen: "+3+  "  Pos destino: "+4+  "  Peso: "+lista.getWeight(3,4));
        System.out.println("Pos origen: "+4+  "  Pos destino: "+5+  "  Peso: "+lista.getWeight(4,5));
        System.out.println("Pos origen: "+7+  "  Pos destino: "+0+  "  Peso: "+lista.getWeight(7,0));
        System.out.println("Pos origen: "+7+  "  Pos destino: "+5+  "  Peso: "+lista.getWeight(7,5));
        System.out.println("Pos origen: "+7+  "  Pos destino: "+6+  "  Peso: "+lista.getWeight(7,6));
        System.out.println("*Pos origen: "+4+  "  Pos destino: "+3+  "  Peso: "+lista.getWeight(4,3));

        System.out.println(lista.getSuccessors(7));
    

        
        DigraphAM lista1=new DigraphAM(8);
        //(pos origen, pos destino, nombre destino)
        lista1.addArc(1,4,8);
        lista1.addArc(1,6,10);
        lista1.addArc(2,7,11);
        lista1.addArc(3,7,11);
        lista1.addArc(3,4,8);
        lista1.addArc(4,5,9);
        lista1.addArc(7,0,2);
        lista1.addArc(7,5,9);
        lista1.addArc(7,6,10);
        System.out.println("");
        System.out.println("*******   Matriz de adyacencia  ********");

        System.out.println("*Pos origen: "+0+  "  Pos destino: "+4+  "  Peso: "+lista1.getWeight(0,4));
        System.out.println("Pos origen: "+1+  "  Pos destino: "+4+  "  Peso: "+lista1.getWeight(1,4));
        System.out.println("Pos origen: "+1+  "  Pos destino: "+6+  "  Peso: "+lista1.getWeight(1,6));
        System.out.println("Pos origen: "+2+  "  Pos destino: "+7+  "  Peso: "+lista1.getWeight(2,7));
        System.out.println("Pos origen: "+3+  "  Pos destino: "+7+  "  Peso: "+lista1.getWeight(3,7));
        System.out.println("*Pos origen: "+5+  "  Pos destino: "+4+  "  Peso: "+lista1.getWeight(5,4));
        System.out.println("Pos origen: "+3+  "  Pos destino: "+4+  "  Peso: "+lista1.getWeight(3,4));
        System.out.println("Pos origen: "+4+  "  Pos destino: "+5+  "  Peso: "+lista1.getWeight(4,5));
        System.out.println("Pos origen: "+7+  "  Pos destino: "+0+  "  Peso: "+lista1.getWeight(7,0));
        System.out.println("Pos origen: "+7+  "  Pos destino: "+5+  "  Peso: "+lista1.getWeight(7,5));
        System.out.println("Pos origen: "+7+  "  Pos destino: "+6+  "  Peso: "+lista1.getWeight(7,6));
        System.out.println("*Pos origen: "+4+  "  Pos destino: "+3+  "  Peso: "+lista1.getWeight(4,3));

        System.out.println(lista1.getSuccessors(7));
    }
}
