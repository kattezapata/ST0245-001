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
            }// O(n) n cantidad de elementos del arreglo
            //System.out.println(cont);
            this.array=new String[cont][9];
            //Array principal
            String [][] arr=new String[cont][9];

            while(input.hasNextLine()){
                /*
                for (int j = 1; j <= 1; j++){ // Descarta la primera linea
                line= input.nextLine();
                }*/

                line=input.nextLine();
                String [] vector =line.split(";");

                arr[i]=vector;
                i++;
                array=arr;
            }// O(n) n cantidad de elementos del arreglo
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }// O(n) n cantidad de elementos del arreglo

    /**
     * El método getArray() permite obtener el arreglo de dos dimensiones creado en el método leer()
     * @return String[][] arreglo de cadenas
     * 
     */
    public String[][] getArray(){
        return this.array;
    }

    public String[][] getArrayParametros(int limiteInferior, int limiteSuperior){
        String[][] matriz= new String[limiteSuperior-limiteInferior][];
        int cont=0;
        for(int i= limiteInferior; i<limiteSuperior;i++){
            matriz[cont]=this.array[i];
            cont++;
        }
        return matriz;
    }// O(n) n cantidad de elementos del arreglo

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

    }// O(n*n) n cantidad de elementos del arreglo
}