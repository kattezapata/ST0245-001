import javafx.util.Pair;
/**
 * Write a description of class NodoDesicion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class NodoDecision
{
    private Pregunta pregunta;
    private NodoDecision brazoDerecho;
    private NodoDecision brazoIzquierdo;
    private String[][] datos;
    private Hoja hoja;

    public NodoDecision(Pregunta pregunta, NodoDecision brazoDerecho, NodoDecision brazoIzquierdo,  String[][] datos){
        this.pregunta=pregunta;
        this.brazoDerecho=brazoDerecho;
        this.brazoIzquierdo=brazoIzquierdo;
        this.datos=datos;
        this.hoja=null;
    }

    public NodoDecision(String [][] hoja){
        this.pregunta=null;
        this.brazoDerecho=null;
        this.brazoIzquierdo=null;
        this.datos=null;
        this.hoja=new Hoja(hoja);
    }

    public Pregunta  getPregunta(){
        return this.pregunta;
    }

    public NodoDecision getBrazoDerecho(){
        return this.brazoDerecho;
    }

    public NodoDecision getBrazoIzquierdo(){
        return this.brazoIzquierdo;
    }

    public String[][]  getDatos(){
        return this.datos;
    }

    public Hoja getHoja(){
        return this.hoja;
    }
}
