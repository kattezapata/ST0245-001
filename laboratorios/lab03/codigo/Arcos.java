import java.io.*;
import java.util.ArrayList;
/**
 * La clase Arcos contribuye en el algoritmo que permite
 * crear una estructura de datos con el
 * mapa de una ciudad. 
 * 
 * @author Maria Alejandra Vélez Clavijo, Laura Katterine Zapata Rendón 
 * @version 1
 */
public class Arcos
{
    static ArrayList<String> ID = new ArrayList<>();
    static ArrayList<String> ID1 = new ArrayList<>();
    static ArrayList<String> distancia = new ArrayList<>();
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
            ID1.add(arr[1]);
        }
        if(arr.length>=3){
            distancia.add(arr[2]);
        }
        if(arr.length>=4){
            nombre.add(arr[3]);
        }

    }

    /**
     * El método obtDist permite obtener la distancia entre sitios
     * pasandole el ID de cada uno
     * @param id ID del primer sitio
     *  @param id1 ID del segundo sitio
     * @return String con la distancia
     */

    public static String obtDist(String id, String id1){
        int index=-1;
        if((ID.contains(id)&& ID1.contains(id1) || (ID.contains(id1)&& ID1.contains(id) ))){
            if(ID1.contains(id) ){
                index= ID1.indexOf(id);
            }else if(ID1.contains(id1) ){
                index= ID1.indexOf(id1);
            } 
            return "Distancia: "+ distancia.get(index);

        }
        return ""+ index+ "";
    }

    /**
     * El método obtNombre permite obtener el nombre entre sitios
     * pasandole el ID de cada uno
     * @param id ID del primer sitio
     *  @param id1 ID del segundo sitio
     * @return String con el nombre
     */
    public static String obtNombre(String id, String id1){
        int index=-1;
        if((ID.contains(id)&& ID1.contains(id1) || (ID.contains(id1)&& ID1.contains(id) ))){
            if(ID1.contains(id) ){
                index= ID1.indexOf(id);
            }else if(ID1.contains(id1) ){
                index= ID1.indexOf(id1);
            } 
            return "Nombre: "+ nombre.get(index);

        }
        return ""+ index+ "";
    }
}

