import javafx.util.Pair;
/**
 * La clase Hoja permite crear aquellos nodos tipo hoja que conforman los datos. 
 * Un nodo tipo hoja son los conjuntos de datos donde la totalidad de sus elementos comparten el mismo valor para la variable de exito,
 * es decir todos son 1 o todos son 0.
 *
 * @author Maria Alejandra Vélez Clavijo, Laura Katterine Zapata Rendón
 * @version 1
 */
public class Hoja
{
    private String [][] hoja;
    private int predicciones;
    
    /**
     * El constructor Hoja permite crear un nuevo nodo hoja a partir 
     * de un arreglo de dos dimensiones que corresponde la conjunto de datos de la hoja.
     * @param hoja arreglo de dos dimensiones que indica el conjunto de datos de la hoja
     * 
     */
    public Hoja(String [][] hoja){
        this.hoja=hoja;
        this.predicciones=this.contar();
    }

    /**
     * El metodo getHoja() permite obtener la matriz hoja correspondiente al nodo tipo hoja actual.
     * 
     * @return String[][] arreglo de dos dimensiones que indica el conjunto de datos de la hoja
     * 
     */
    public String[][] getHoja(){
        return hoja;
    }

    /**
     * El metodo contar() permite obtener aquel valor de la variable exito
     * el cual comparten todos los estudiantes del conjunto de datos de la hoja actual.
     * 
     * @return int numero que indica el valor que comparte el conjunto de datos de la hoja, es 1 si todos son exito o 0 si todos son no exito.
     * 
     */
    public int contar(){
        int predicciones=0;
        int exito=0, noExito=0;
        for(int i=0;i<this.hoja.length;i++){ // O(n) n cantidad de elementos del arreglo
            if(Integer.parseInt(this.hoja[i][hoja[0].length-1])==1){
                exito++;
            }else{
                noExito++;
            }

        }
        int total=exito+noExito;
        if(total==exito){
            predicciones = 1;
        }
        if(total==noExito){
            predicciones = 0;
        }
        /*
        String exit="Exito:  "+(exito/total)*100+"%";
        String noExit="No exito:  "+(noExito/total)*100+"%";
        predicciones= exit+"  "+noExit;
         */
        return  predicciones;
    } // O(n) n cantidad de elementos del arreglo
}
