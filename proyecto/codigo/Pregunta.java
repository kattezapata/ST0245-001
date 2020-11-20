
/**
 * La clase Pregunta permite almacenar la informacion de aquella condicion que divide mejor los datos,
 * es decir ese mejor valor y su respectiva columna.
 *
 * @author Maria Alejandra Vélez Clavijo, Laura Katterine Zapata Rendón
 * @version 1
 */
public class Pregunta
{
    private int columna;
    private int mejorValor;

    /**
     * El constructor Pregunta permite crear una nueva pregunta a partir 
     * de el mejor valor que divide los datos y su respectiva columna.
     * @param columna numero que indica la respectiva columna del mejor valor que divide los datos.
     * @param mejorValor numero que indica el mejor valor que divide los datos.
     * 
     */
    public Pregunta(int columna, int mejorValor){
        this.columna=columna;
        this.mejorValor=mejorValor;
    }

    /**
     * El metodo getColumna() permite obtener la columna correspondiente a la pregunta actual.
     * 
     * @return int numero que indica la respectiva columna del mejor valor que divide los datos.
     *  
     */
    public int getColumna(){
        return this.columna;

    }

    /**
     * El metodo getMejorValor() permite obtener el valor que divide mejor los datos de acuerdo a la pregunta actual.
     * 
     * @return int numero que indica el mejor valor que divide los datos.
     *  
     */
    public int getMejorValor(){
        return this.mejorValor;

    }

    /**
     * El metodo match() permite saber si un estudiante en especifico cumple con la pregunta actual, 
     * es decir si en la columna respectiva tiene un valor menor o igual a el mejor valor de la pregunta actual.
     * 
     * @return boolean que indica si el estudiante cumple con la pregunta actual.
     *  
     */
    public boolean match(String [] fila){
        int valor=(int)Float.parseFloat(fila[this.columna]);
        if(valor<=this.mejorValor){
            return true;
        }else{
            return false;
        }
    }
}
