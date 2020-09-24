import java.io.*;
import java.util.ArrayList;
/**
 * Write a description of class Vertices here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Vertices
{   
    static ArrayList<String> ID = new ArrayList<>();
    static ArrayList<String> X = new ArrayList<>();
    static ArrayList<String> Y = new ArrayList<>();
    static ArrayList<String> nombre = new ArrayList<>();


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

    public static String obtCoordenadas(String id){
        int index=-1;
        if(ID.contains(id)){
            index= ID.indexOf(id);
            return "Y:"+ Y.get(index) + "X: "+ X.get(index);
        }
        return ""+ index+ "";

    }

    public static String obtNombre(String id){
        int index=-1;
        if(ID.contains(id)){
            index= ID.indexOf(id);
            return "Nombre: "+ nombre.get(index);
        }
        return ""+ index+ "";

    }

    public static String obtNombre(String y, String x){
        int index=-1;
        if(X.contains(x)&& Y.contains(y)){
            index= Y.indexOf(y);
            return "Nombre: "+ nombre.get(index);
        }
        return ""+ index+ "";
    }

    public static String obtId(String y, String x){
        int index=-1;
        if(X.contains(x)&& Y.contains(y)){
            index= Y.indexOf(y);
            return "ID: "+ ID.get(index);
        }
        return ""+ index+ "";
    }

}