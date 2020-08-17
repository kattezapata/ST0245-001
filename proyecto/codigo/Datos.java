import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * La clase Datos 
 * 
 * @author Maria Alejandra Velez Clavijo, Laura Katterine Zapata Rendón
 * @version 1
 */

public class Datos{
    private static ArrayList<ArrayList<String>> array=new ArrayList<>();

    public void leer(String files){
        String archivo;
        if(files.endsWith(".csv")){
            archivo=files;
        }else{
            archivo=files+".csv";
        }
        File file=new File(archivo);

        //ArrayList principal
        ArrayList<ArrayList<String>> array=new ArrayList<>();

        try{
            Scanner input =new Scanner(file);
            String line;

            while(input.hasNextLine()){

                line=input.nextLine();
                ArrayList<String> vector = new ArrayList(Arrays.asList(line.split(",")));

                array.add(vector);

            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<ArrayList<String>> getArray(){
        return this.array;
    }

    public void imprimir(ArrayList<ArrayList> array){

        for (int i = 0; i < array.size(); i++) { 
            for (int j = 0; j < array.get(i).size(); j++) { 
                System.out.print(array.get(i).get(j) + " "); 
            } 
            System.out.println(); 
        } 

    }
}
