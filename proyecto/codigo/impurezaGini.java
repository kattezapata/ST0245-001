import java.util.HashSet;
import javafx.util.Pair;
/**
 * La clase impurezaGini permite saber cuál es la mejor condición para dividir un conjunto de datos
 * teniendo en cuenta la menor impureza ponderada
 *
 * @author Maria Alejandra Velez Clavijo, Laura Katterine Zapata Rendón
 * @version 1
 */
public class impurezaGini
{   
    /**
     * El método dividirDatos permite dividir un arreglo en dos nuevos arreglos de acuerdo a una condición dada
     * @param array arreglo de dos dimensiones a dividir
     * @param pos posición de la condición
     * @param val condición
     * @return Pair<String[][],String[][]> pareja que contiene los dos arreglos creados
     */
    public static Pair<String[][],String[][]> dividirDatos(String[][] array, int pos, String val){
        int igual=0;

        for(int i=0; i< array.length; i++){
            if(array[i][pos].equals(val)){
                igual++;
            }
        }
        int noIgual=array.length-igual;
        int fila=0;
        int filaIgual=0;
        int filaDiferente=0;
        String[][] iguales = new String[igual][array[0].length];
        String[][] noIguales = new String[noIgual][array[0].length];
        while(fila<array.length){
            if(array[fila][pos].equals(val)){
                iguales[filaIgual]=array[fila];
                filaIgual++;
                fila++;
            }else{
                noIguales[filaDiferente]= array[fila];
                filaDiferente++;
                fila++;
            }
        }
        Pair<String[][], String[][]> pareja= new Pair(iguales, noIguales);
        return pareja;

    }

    /**
     * El método impurezaGini permite calcular la impureza Gini en un arreglo de dos dimensiones
     * @param array arreglo de dos dimensiones a calcular la impureza
     * @return float impureza de Gini
     */
    public static float impurezaGini(String[][] arr){
        int ext=0;

        for(int i=0; i<arr.length; i++){
            if(arr[i][(arr[0].length)-1].equals("1")){
                ext++;
            }
        }
        int noExt=arr.length-ext;
        float propExito=0;
        float propNoExito=0;
        if(arr.length!=0){
            propExito= (ext/arr.length);
            propNoExito=(noExt/arr.length);
        }
        float impureza= (1-((propExito*propExito)+(propNoExito*propNoExito)));

        return impureza;
    }

    /**
     * El método impurezaPonderada permite calcular la impureza Gini ponderada en un arreglo de dos dimensiones
     * en una posición y condición determinada
     * @param array arreglo de dos dimensiones a calcular la impureza ponderada
     * @param pos posición de la condición
     * @param val condición
     * @return float impureza ponderada
     */
    public static float impurezaPonderada(String[][] arr, int pos, String val){
        Pair<String[][], String[][]> pareja= dividirDatos(arr,pos,val);
        float derecho= impurezaGini(pareja.getKey());
        float izquierdo= impurezaGini(pareja.getValue());
        int numDer= pareja.getKey().length;
        int numIzq=pareja.getValue().length;
        float impurezaPonderada= ((numDer*derecho)+(numIzq*izquierdo))
            /(numDer+numIzq);
        return impurezaPonderada;

    }

    /**
     * El método posiblesValores permite obtener los diferentes valores que pueden presentarse en una columna (variable)
     * determinada del arreglo
     * @param arr arreglo de dos dimensiones
     * @param pos posición de la variable a analizar
     * @return String[] diferentes posibles valores que toma la variable
     * 
     */
    public static String[] posiblesValores(String[][]arr, int pos){
        HashSet<String> valores= new HashSet<String>();
        for(int i=0; i<arr.length; i++){
            if(arr[i][pos]!=null && arr[i][pos]!=""){
                valores.add(arr[i][pos]);
            }
        }
        String[] array= new String[valores.size()];
        return valores.toArray(array);
    }

    /**
     * El método mejorCondicion permite obtener cual es la columna y valor que divide mejor los datos, es decir, 
     * aquella condición con menor impureza ponderada de Gini 
     * @param arr arreglo de dos dimensiones
     * @return Pair<Integer, String> pareja cuya llave es la columna y su valor es el mejor valor
     * 
     */

    public static Pair<Integer, String> mejorCondicion(String[][] arr){
        String[] valores;
        Pair<Integer, String> pareja;
        float menorImpureza=1;
        float menorImpurezaT=1;
        String mejorValor="";
        String mejorValorT="";
        int columna=-1;
        for(int i=0; i<arr[0].length-1; i++){
            valores = posiblesValores(arr,i);
            for(String valor: valores){
                float impurezaPonderada= impurezaPonderada(arr, i, valor);

                if(impurezaPonderada<menorImpureza){
                    menorImpureza= impurezaPonderada;
                    mejorValor=valor;

                }

            }
            if(menorImpurezaT > menorImpureza){
                menorImpurezaT= menorImpureza;
                columna = i;
                mejorValorT = mejorValor;

            }
        }

        pareja= new Pair(columna, mejorValorT);
        return pareja;

    }

}
