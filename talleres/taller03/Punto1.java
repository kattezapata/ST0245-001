/**
 * La clase Punto1 permite mostrar en la pantalla la solución
 * al problema de las torres de Hanoi para un número de discos ingresado por
 * el usuario
 * @author Maria Alejandra Vélez CLavijo, Laura Katterine Zapata Rendón
 * @version version 1
 */
import java.io.*;
import java.util.Scanner;

 

public class Punto1
{
    static int nDisc; 

 

    public static void main(String[] args) {
        System.out.println("Ingrese el número de discos");
        Scanner read = new Scanner( System.in);
        nDisc =read.nextInt(); 
        Torres(nDisc, "Torre1", "Torre2", "Torre3");
    } 

 

    /**
     *
     * El método Torres permite permite mostrar en la pantalla la solución
     * al problema de las torres de Hanoi para un número de discos ingresado por
     * el usuario
     * @param topN numero de discos
     * @param a la torre número uno donde se posicionan todos los discos antes
     * @param c la torre donde deben posicionarse todos los discos terminado el proceso
     * @param b torre auxiliar para que el cambio de torres se haga efectivo
     *
     */
    public static void Torres(int topN, String a, String b, String c){
        if(topN==1)
            System.out.println("Disco 1, de " + a + " a "+ c);

 

        else { 
            Torres(topN-1, a,c, b); 
            System.out.println("Disco" + " " + topN + ", de " + a + " a "+ c); 
            Torres(topN-1, b, a, c); 
        } 
    }

 

}
 