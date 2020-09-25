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
            ID.add(arr[0]);
        }
        if(arr.length>=2){
            Y.add(arr[1]);
        }
        if(arr.length>=3){
            X.add(arr[2]);
        }
        if(arr.length>=4){
            nombre.add(arr[3]);
        }

    }

    /**
     * El método obtCoordenadas permite obtener las coordenadas de un sitio
     * pasandole el ID
     * @param id ID del sitio
     * @return String con las coordenadas del lugar
     */
    public static String obtCoordenadas(String id){
        int index=-1;
        if(ID.contains(id)){
            index= ID.indexOf(id);
            return "Y:"+ Y.get(index) + "X: "+ X.get(index);
        }
        return ""+ index+ "";

    }

/**
     * El método obtNombre permite obtener el nombre de un sitio
     * pasandole el ID
     * @param id ID del sitio
     * @return String con el nombre del lugar
     */
    public static String obtNombre(String id){
        int index=-1;
        if(ID.contains(id)){
            index= ID.indexOf(id);
            return "Nombre: "+ nombre.get(index);
        }
        return ""+ index+ "";

    }
    
/**
     * El método obtNombre permite obtener el nombre de un sitio
     * pasandole las coordenadas
     * @param y coordenada Y del sitio
     * @param x coordenada X del sitio
     * @return String con el nombre del lugar
     */
    public static String obtNombre(String y, String x){
        int index=-1;
        if(X.contains(x)&& Y.contains(y)){
            index= Y.indexOf(y);
            return "Nombre: "+ nombre.get(index);
        }
        return ""+ index+ "";
    }
/**
     * El método obtId permite obtener el nombre de un sitio
     * pasandole las coordenadas
     * @param y coordenada Y del sitio
     * @param x coordenada X del sitio
     * @return String con el ID del lugar
     */
    public static String obtId(String y, String x){
        int index=-1;
        if(X.contains(x)&& Y.contains(y)){
            index= Y.indexOf(y);
            return "ID: "+ ID.get(index);
        }
        return ""+ index+ "";
    }

}