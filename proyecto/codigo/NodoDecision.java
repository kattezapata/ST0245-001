/**
 * La clase NodoDecision permite crear un nodo de decision, los cuales conforman un arbol de decision.
 * Puede ser de dos tipos: 
 * -Un nodo de decision, el cual contiene una pregunta determinada la cuáal divide mejor los datos 
 * -Un nodo hoja, el cual es un conjunto de datos donde todos los estudiantes comparten el mismo valor para la variable exito, 
 *     es decir todos tienen exito o todos no tienen exito.
 *
 * @author Maria Alejandra Vélez Clavijo, Laura Katterine Zapata Rendón
 * @version 1
 */
public class NodoDecision
{
    private Pregunta pregunta;
    private NodoDecision brazoDerecho;
    private NodoDecision brazoIzquierdo;
    private String[][] datos;
    private Hoja hoja;

    /**
     * El constructor NodoDecision con 4 parametros permite crear un nuevo nodo de decision
     * el cual contiene una pregunta que divide mejor los datos y por lo tanto un brazo derecho y brazo izquierdo.
     * @param pregunta Pregunta la cual divide mejor los datos del nodo de decision
     * @param brazoDerecho NodoDecision el cual consiste todos los datos verdaderos para la pregunta del nodo de decision actual es decir los menores 
     * @param brazoIzquierdo NodoDecision el cual consiste todos los datos falsos para la pregunta del nodo de decision actual es decir los mayores
     * @param datos arreglo de dos dimensiones que indica el conjunto de datos del nodo
     * 
     */
    public NodoDecision(Pregunta pregunta, NodoDecision brazoDerecho, NodoDecision brazoIzquierdo,  String[][] datos){
        this.pregunta=pregunta;
        this.brazoDerecho=brazoDerecho;
        this.brazoIzquierdo=brazoIzquierdo;
        this.datos=datos;
        this.hoja=null;
    }

    /**
     * El constructor NodoDecision con 1 parametro permite crear un nuevo nodo de tipo hoja
     * en el cual todos sus datos comparten el mismo valor para la variable de exito, es decir todos son 1 o 0.
     * 
     * @param [][] hoja arreglo de dos dimensiones donde se almacena el conjunto de datos correspondiente a la hoja
     */
    public NodoDecision(String [][] hoja){
        this.pregunta=null;
        this.brazoDerecho=null;
        this.brazoIzquierdo=null;
        this.datos=null;
        this.hoja=new Hoja(hoja);
    }

    /**
     * El método getPregunta() permite obtener la pregunta correspondiente al nodo de decision actual.
     * 
     * @return Pregunta pregunta que indica la columna y el mejor valor que separa mejor los datos del nodo de decision actual
     * 
     */
    public Pregunta  getPregunta(){
        return this.pregunta;
    }

    /**
     * El método getBrazoDerecho() permite obtener el brazo derecho, es decir los datos verdaderos para la pregunta correspondiente al nodo de decision actual.
     * 
     * @return NodoDecision brazo derecho del nodo de decision actual, es decir los menores al mejor valor de la pregunta
     * 
     */
    public NodoDecision getBrazoDerecho(){
        return this.brazoDerecho;
    }

    /**
     * El método getBrazoIzquierdo() permite obtener el brazo derecho, es decir los datos falsos para la pregunta correspondiente al nodo de decision actual.
     * 
     * @return NodoDecision brazo izquierdo del nodo de decision actual, es decir los mayores al mejor valor de la pregunta
     * 
     */
    public NodoDecision getBrazoIzquierdo(){
        return this.brazoIzquierdo;
    }

    /**
     * El método getDatos() permite obtener la matriz de datos correspondiente al nodo de decision actual.
     * 
     * @return String[][] arreglo de dos dimensiones que almacena el conjunto de datos correspondiente al nodo de decision actual
     * 
     */
    public String[][]  getDatos(){
        return this.datos;
    }

    /**
     * El método getHoja() permite obtener la hoja correspondiente al nodo de decision actual si es que es un nodo tipo hoja.
     * 
     * @return Hoja nodo hoja correspondiente al nodo de decision actual
     * 
     */
    public Hoja getHoja(){
        return this.hoja;
    }
}
