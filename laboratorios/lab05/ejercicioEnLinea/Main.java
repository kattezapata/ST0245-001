
/**
 * Write a description of class Main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
