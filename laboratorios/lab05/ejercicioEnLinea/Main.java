
/**
 * La clase Main tiene como objetivo hacer pruebas a la clase Colorear.
 * 
 * @author Maria Alejandra Velez Clavijo, Laura Katterine Zapata Rendon
 * @version 1
 */
public class Main
{
    public static void main(String[] args){
    int[][] grafo = {
    {0,1,0,1},
    {1,0,1,0},
    {0,1,0,1},
    {1,0,1,0} }; // true
    int[][] grafo1 = {
    {0,1,0,1},
    {1,0,1,0},
    {0,1,0,1},
    {1,0,1,1} }; // false
      int[][] grafo2 = {
    {0,1,1,1},
    {1,0,1,0},
    {1,1,0,1},
    {1,0,1,0} };// false
   
    System.out.println(Colorear.sePuedeColorear(grafo, 0));
    System.out.println(Colorear.sePuedeColorear(grafo1, 1));
    System.out.println(Colorear.sePuedeColorear(grafo2, 2));
    
    }
}
