import java.io.*;
import java.util.ArrayList;
/**
 * La clase Vertices contribuye en el algoritmo que permite
 * crear una estructura de datos con el
 * mapa de una ciudad. 
 * 
 * @author Maria Alejandra Vélez Clavijo, Laura Katterine Zapata Rendón 
 * @version 1
 */
public class Vertices
{   
    static ArrayList<String> ID = new ArrayList<>();
    static ArrayList<String> X = new ArrayList<>();
    static ArrayList<String> Y = new ArrayList<>();
    static ArrayList<String> nombre = new ArrayList<>();

    /**
     * El método llenarArr permite llenar las listas
     * que contienen la información de cada sitio de la ciudad
     * @param arr arreglo que contiene la información de cada sitio
     */
    public static void llenarArr(String[] arr){
        if(arr.length>=1){
            ID.add(arr[0]); //T(n) = n
        }
        if(arr.length>=2){
            Y.add(arr[1]); //T(n) = n
        }
        if(arr.length>=3){
            X.add(arr[2]); //T(n) = n
        }
        if(arr.length>=4){
            nombre.add(arr[3]); //T(n) = n
        }
    // T(n) = n+n+n+n = 4n 
    // O(4n)= O(n) (regla del producto) Compleidad lineal
    
    }

    /**
     * El método obtCoordenadas permite obtener las coordenadas de un sitio
     * pasandole el ID
     * @param id ID del sitio
     * @return String con las coordenadas del lugar
     */
    public static String obtCoordenadas(String id){
        int index=-1;
        if(ID.contains(id)){ // T(n) = n
            index= ID.indexOf(id);   // T(n) = n
            return "Y:"+ Y.get(index) + "X: "+ X.get(index);  // T(n) = 1
        } //T(n)= n+n = 2n
        return ""+ index+ "";

    }//T(n) = 2n 
    // O(2n) = On (regla del producto) Compleidad lineal


/**
     * El método obtNombre permite obtener el nombre de un sitio
     * pasandole el ID
     * @param id ID del sitio
     * @return String con el nombre del lugar
     */
    public static String obtNombre(String id){
        int index=-1;
        if(ID.contains(id)){  // T(n) = n
            index= ID.indexOf(id);  // T(n) = n
            return "Nombre: "+ nombre.get(index);  // T(n) = 1
        } //T(n) =2n
        return ""+ index+ "";

    }//T(n) = 2n 
    // O(2n) = O(n) (regla del producto) Compleidad lineal
    
/**
     * El método obtNombre permite obtener el nombre de un sitio
     * pasandole las coordenadas
     * @param y coordenada Y del sitio
     * @param x coordenada X del sitio
     * @return String con el nombre del lugar
     */
    public static String obtNombre(String y, String x){
        int index=-1;
        if(X.contains(x)&& Y.contains(y)){ // T(n)= n + n = 2n
            index= Y.indexOf(y); //T(n)= n
            return "Nombre: "+ nombre.get(index); //T(n)= 1
        } //  T(n)= 2n + n = 3n
        return ""+ index+ "";
    } // T(n)= 3n
      // O(3n)= O(n)(regla del producto) Compleidad lineal
/**
     * El método obtId permite obtener el nombre de un sitio
     * pasandole las coordenadas
     * @param y coordenada Y del sitio
     * @param x coordenada X del sitio
     * @return String con el ID del lugar
     */
    public static String obtId(String y, String x){
        int index=-1;
        if(X.contains(x)&& Y.contains(y)){ // T(n)= n + n = 2n
            index= Y.indexOf(y); //T(n)= n
            return "ID: "+ ID.get(index); //T(n)= 1
        } // T(n)= 2n + n = 3n
        return ""+ index+ "";
    } // T(n)= 3n
      // O(3n)= O(n)(regla del producto) Compleidad lineal

}
//n: // n = numero de elementos de los arrayList( todos tienen el mismo tama�o), n es igual a la cantidad de lineas del archivo.txt