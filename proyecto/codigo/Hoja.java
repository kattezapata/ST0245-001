import javafx.util.Pair;
/**
 * Write a description of class Hoja here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hoja
{
    private String [][] hoja;
    private int predicciones;

    public Hoja(String [][] hoja){
        this.hoja=hoja;
        this.predicciones=this.contar();
    }

    public String[][] getHoja(){
        return hoja;
    }

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
