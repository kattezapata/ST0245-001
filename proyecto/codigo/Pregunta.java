
/**
 * Write a description of class Pregunta here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Pregunta
{
    private int columna;
    private int mejorValor;

    public Pregunta(int columna, int mejorValor){
        this.columna=columna;
        this.mejorValor=mejorValor;
    }

    public int getColumna(){
        return this.columna;

    }

    public int getMejorValor(){
        return this.mejorValor;

    }

    public boolean match(String [] fila){
        int valor=(int)Float.parseFloat(fila[this.columna]);
        if(valor<=this.mejorValor){
            return true;
        }else{
            return false;
        }
    }
}
