import java.util.HashSet;
import java.util.*;
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
     * El método mejorCondicion permite obtener cual es la columna y valor que divide mejor los datos, es decir, 
     * aquella condición con menor impureza ponderada de Gini 
     * @param arr arreglo de dos dimensiones
     * @return Pair<Integer, String> pareja cuya llave es la columna y su valor es el mejor valor
     * 
     */

    public static  Pair<Float, Pair<Integer, Integer>> mejorCondicion(String[][] arr){

        float mayorGanancia=0;
        float mayorGananciaTotal=0;
        int columna=-1;
        int mejorCondicion=0;
        int mejorCondicionTotal=0;
        Pair<Float, Integer> pareja1;
        //Se ejecuta el para cada columna de un puntaje
        for(int i=0; i<arr[0].length-1; i++){// O(m) m: cantidad de variables
            //ordenar la matriz respecto la columna i
            String [][] arreglo=OrdenarMatriz.mergesort(arr,i); // O(nlogn*m) n: cantidad de estudiantes y m: cantidad de variables

            //Hallar la mejor condicion para la columna i
            pareja1= mejorCondicionAux(arreglo,i); // O(nlogn) n -> O(nlogn*m) n: cantidad de estudiantes y m: cantidad de variables

            mayorGanancia = pareja1.getKey(); //esta es la mayor ganancia de informacion para cada columna
            //Encontrar la mayor ganancia de la informacion comparando con la mayor de cada columna
            if(mayorGanancia>mayorGananciaTotal){
                mayorGananciaTotal=mayorGanancia;
                mejorCondicion=pareja1.getValue();
                columna=i;
            }

        } // T(n)= nlogn*m + nlogn*m = T(n)= 2nlogn*m -> O(nlogn*m) n: cantidad de estudiantes y m: cantidad de variables

        //Retornar la mayor ganancia de informacion total, la mejor condicion y su respectiva columna
        Pair<Float, Pair<Integer, Integer>> pareja2= new Pair(mayorGananciaTotal, new Pair(mejorCondicion, columna));
        return pareja2;
    }

    /**
     * @param pos columna de la matriz con la cual se hallará la mejor condicion
     * @param String [][] arr: arreglo de String ordenado respecto a pos
     */

    public static Pair<Float, Integer> mejorCondicionAux(String[][] arr, int pos) 
    { 
        //posibles valores ordenados de menor a mayor
        String [] posiblesValores=OrdenarArreglo.mergesort(posiblesValores(arr, pos));// T(n)= n+nlong -> O(nlogn)

        float[][] arreglo= new float[posiblesValores.length][3];

        //Columnas: Posible valor, exito, no exito, indice de Gini
        for(int j=0; j<posiblesValores.length; j++){ // O(n) n cantidad de filas del arreglo
            arreglo[j][0]=Float.parseFloat(posiblesValores[j]);
            arreglo[j][1]=0;
            arreglo[j][2]=0;
        }

        float exito=0;
        float noExito=0;

        int iteraValores=0;
        int itera=0;
        while(iteraValores<posiblesValores.length && itera<arr.length){ // O(n) n cantidad de filas del arreglo
            // O(p) p: cantidad de posibles valores de una variable en  el peor de los casos sería O(n) con
            // n cantidad de estudiantes

            if(Float.parseFloat(arr[itera][pos])==Float.parseFloat(posiblesValores[iteraValores])){
                if(Integer.parseInt(arr[itera][arr[0].length-1])==1){
                    exito++;
                    arreglo[iteraValores][1]=exito;
                }
                itera++;
                arreglo[iteraValores][1]=exito;
                arreglo[iteraValores][2]=itera-exito;

            }else{
                iteraValores++;
            }

        } // O(n)
        //Hasta ese punto cada posible valor tiene los que tienen exito, los que no tienen exito y la impureza gini de los menores o iguales a el

        //Contar cuantos tienen exito y cuantos no en total

        float  exitoTotal=arreglo[arreglo.length-1][1];
        float  noExitoTotal=arreglo[arreglo.length-1][2];
        float impurezaTotal= impurezaGini(exitoTotal,noExitoTotal); // O(1)

        //Hasta aqui todo está bien
        float mayorGananciaInfo=0;
        float mejorValor=Float.parseFloat(posiblesValores[0]);
        //Calcula la impureza ponderada para cada posible valor
        for(int i=0; i<posiblesValores.length;i++){ // O(n) n cantidad de filas del arreglo
            float mayores;
            float menores;
            //impureza gini de aquellos menores o iguales a ese posible valor

            float impurezaGiniMenores=impurezaGini(arreglo[i][1],arreglo[i][2]);//O(1)
            //pos<=arr[0].length/2

            //cantidad con exito que sean mayores a ese posible valor
            float  exitMayores=exitoTotal-arreglo[i][1];
            //cantidad con no exito que sean mayores a ese posible valor
            float  noExitMayores= noExitoTotal-arreglo[i][2];
            //Calcular la impureza de Gini para los que son mayores a ese posible valor
            float impurezaGiniMayores=impurezaGini(exitMayores,noExitMayores);// O(1)

            //Cantidad de menores o iguales a ese posible valor
            menores= arreglo[i][1]+arreglo[i][2];
            //Cantidad de mayores a ese posible valor
            mayores= exitMayores+noExitMayores;

            //Calcular la impureza ponderada con un nodo los que sean menores o iguales y otro con los que sean mayores a es posible valor
            float impurezaPonderada = ((mayores*impurezaGiniMayores)+(menores*impurezaGiniMenores))/(mayores+menores);

            //Hasta aquí todo bien

            float gananciaInfo= impurezaTotal-impurezaPonderada;

            //Hallar la mayor ganancia de la informacion de todas
            if(gananciaInfo > mayorGananciaInfo){
                mayorGananciaInfo=gananciaInfo;
                mejorValor=Float.parseFloat(posiblesValores[i]);
            }
        }// O(n)

        Pair<Float,Integer> pareja= new Pair(mayorGananciaInfo, (int)mejorValor);
        return pareja;
        // Complejidad en el peor de los casos O(nlogn)
    } 

    /**
     * El método impurezaGini permite calcular la impureza Gini en un arreglo de dos dimensiones
     * @param array arreglo de dos dimensiones a calcular la impureza
     * @return float impureza de Gini
     */
    public static float impurezaGini(float exito, float  noExito){
        float propExito=0;
        float propNoExito=0;
        float  total=exito+noExito;

        if(exito!=0){
            propExito= (exito/total);
        }

        if(noExito!=0){
            propNoExito=(noExito/total);
        }

        float impureza= (1-((propExito*propExito)+(propNoExito*propNoExito)));
        return impureza; // O(1)
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
        HashSet<String> valores= new HashSet<String>(arr.length);
        for(int i=0; i<arr.length; i++){
            if(arr[i][pos]!=null && arr[i][pos]!=""){
                valores.add(arr[i][pos]);
                //O(1)
            }
        }// O(n) n cantidad de estudiantes
        String[] array= new String[valores.size()];
        return valores.toArray(array);
    }

    /**
     * El método dividirDatos permite dividir un arreglo en dos nuevos arreglos de acuerdo a una condición dada
     * @param array arreglo de dos dimensiones a dividir
     * @param pos posición de la condición
     * @param val condición
     * @return Pair<String[][],String[][]> pareja que contiene los dos arreglos creados
     */
    public static Pair<String[][],String[][]> dividirDatos(String[][] array, int pos, int val){
        String[][] arrayOrdenado= OrdenarMatriz.mergesort(array,pos); //   O(nlogn) n: cantidad de filas del arreglo
        int menor=0;
        double  valor= (double)val;  
        int iterador=0;
        while(Double.parseDouble(arrayOrdenado[iterador][pos])<= valor && iterador<arrayOrdenado.length){ //O(n)
            menor++;
            iterador++;
        }
        int mayor=arrayOrdenado.length-menor;
        int filaMayor=0;
        int filaMenor=0;
        String[][] arrMayor = new String[mayor][arrayOrdenado[0].length];
        String[][] arrMenor = new String[menor][arrayOrdenado[0].length];
        for(int i=0; i< arrayOrdenado.length; i++){// O(n)
            if(Double.parseDouble(arrayOrdenado[i][pos])<=valor){
                arrMenor[filaMenor]=arrayOrdenado[i];
                filaMenor++;
            } else{
                arrMayor[filaMayor]=arrayOrdenado[i];
                filaMayor++; 
            }// n número de filas

        }// O(n)

        Pair<String[][], String[][]> pareja= new Pair(arrMenor,arrMayor);
        return pareja;
        // T(n)=n+n+nlogn -> O(nlogn) n: cantidad de estudiantes 

    }

}