import java.util.Scanner;
import java.util.ArrayList;

/**
 *  La clase Invertir permite leer una cantidad 
 *  indeterminada de enteros usando Scanner y los guarda en un vector
 *  dinámico de forma invertida.  
 * @author Maria Alejandra Vélez Clavijo, Laura Katterine Zapata Rendón
 * @version 1
 */
public class Invertir
{
    private static  ArrayList<Integer> Arr= new ArrayList<Integer>();
    private static ArrayList<Integer> Arr2= new ArrayList<Integer>();
    public static void main(String[] args){
        crearArr();
        System.out.println(Arr);
        System.out.println(Arr2);
    }

    /**
     * El método crearArr crea un ArrayList de enteros que se ingresan
     * por teclado usando Scanner y se lo pasa al método invertir.
     * La lectura de dichos enteros se finaliza
     * cuando ingresan el número -1.
     */
    public static void crearArr(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese los números (Para finalizar ingrese -1): ");
        for (int i=0; i< Integer.MAX_VALUE; i++){ // T(n)= n
            int num = scan.nextInt(); // T(n)=((c1)*n) 
            if(num==-1){
                break; //T(n)=(n*c2)
            }
            else{
                Arr.add(num); //T(n)= (c3*n)*n) 
            }
        } // Complejidad : T(n)= n+ c1*n+ c2*n + (c3*n)*n 
          // O(n^2)
        invertir(Arr); 
    } 

    /**
     * El método invertir invierte las posiciones de los elementos de un arraylist
     * que le pasan como parámetro, es decir, guarda primero los últimos y luego los
     *  primeros. 
     *  @param ArrayList<Integer> Arr ArrayList de enteros a invertir
     */
    public static void invertir(ArrayList<Integer> Arr){

        int size= Arr.size();// T(n)=c1;
        int cont = size-1;// T(n)=c2;
        for(int i=0 ; i<size; i++){ //T(n)=n*c3
            Arr2.add(Arr.get(cont)); //T(n)= (c4*n)*n
            cont--; // T(n)= c5
        }
        // Complejidad: T(n)= c1 + c2+ n*c3 + c4*n*n + c5
        // O(n^2)

    }
    // Complejidad final: O(n^2 + n^2) -> O(n^2)
}
