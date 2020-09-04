import java.util.ArrayList;
/**
 * La clase punto2 tiene un algoritmo que recibe por
 * parámetro un número N > 0 y genera un vector dinámico con el patrón
 * {1, 1, 2, 1, 2, 3, … 1,2,3..n}. 
 * 
 * @author Maria Alejandra Velez Clavijo y Laura Katterine Zapata Rendón
 * @version 1
 */
public class punto3{
    public static void main(String[] args){
        for(int i=5; i<11; i++){
            System.out.println("N= "+ i);
            System.out.println(seriesUp(i));
        }
    }

    /** El método seriesUp recibe por
     * parámetro un número N > 0 y genera un vector dinámico con el patrón
     * {1, 1, 2, 1, 2, 3, … 1,2,3..n}. 
     * @param n valor hasta el cual se va a realizar el patrón, es decir, 
     * el último elemento del vector
     * @return int[] array de enteros ordenados según el patrón
     */
    public static ArrayList<Integer> seriesUp(int n) {
        ArrayList<Integer> arr = new ArrayList<Integer>();

        for(int i=1; i<=n; i++){ // T(n)=n*c1 
            for(int j=1; j<=i; j++){ // T(n)= (n*c2)*n 
                arr.add(j);// T(n)= (n*c3)*n*n

            }
        }
        return arr;
        // Complejidad: O((n*c3)*n*n)
        // O(n*n*n) = O(n^3)
    }
}
