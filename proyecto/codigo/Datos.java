
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * La clase Datos permite leer un arcivo.csv y almacenar sus datos en un arreglo
 *
 * @author Maria Alejandra Velez Clavijo, Laura Katterine Zapata Rendón
 * @version 1
 */

public class Datos{
    private static String [][] array;
    /**
     * El método leer permite leer un archivo.csv y lo almacena en un arreglo de dos dimensiones
     * @param files Nombre del archivo a leer
     */
    public void leer(String files){
        String archivo;
        if(files.endsWith(".csv")){
            archivo=files;
        }else{
            archivo=files+".csv";
        }
        File file=new File(archivo);

        try{
            Scanner input =new Scanner(file);
            Scanner input1= new Scanner(file);
            String line;
            String line1;
            int i=0;
            int cont=0;
            while(input1.hasNextLine()){
                line1=input1.nextLine();
                cont++;
            }
            //System.out.println(cont);
            this.array=new String[cont][78];
            //Array principal
            String [][] arr=new String[cont][78];

            while(input.hasNextLine()){

                line=input.nextLine();
                String [] vector =line.split(";");

                arr[i]=vector;
                i++;
                array=arr;
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * El método getArray() permite obtener el arreglo de dos dimensiones creado en el método leer()
     * @return String[][] arreglo de cadenas
     * 
     */
    public String[][] getArray(){
        return this.array;
    }

    /**
     * El método imprimir permite mostrar el arreglo de dos dimensiones
     * @param array arreglo a imprimir
     */
    public void imprimir(String[][] array){

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

    }
}