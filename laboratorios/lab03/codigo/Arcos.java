import java.io.*;
import java.util.ArrayList;
/**
 * Write a description of class Arcos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Arcos
{
    static ArrayList<String> ID = new ArrayList<>();
    static ArrayList<String> ID1 = new ArrayList<>();
    static ArrayList<String> distancia = new ArrayList<>();
    static ArrayList<String> nombre = new ArrayList<>();

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

