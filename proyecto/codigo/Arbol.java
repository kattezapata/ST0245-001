import javafx.util.Pair;
/**
 * La clase Arbol permite crear un Arbol conformado por nodos de decision, a partir de un arreglo de String de dos dimensiones.
 *
 * @author Maria Alejandra Vélez Clavijo, Laura Katterine Zapata Rendón
 * @version 1
 */
public class Arbol
{
    private  NodoDecision root;

    /**
     * El constructor Arbol permite crear un nuevo arbol de decision
     * a partir de un arreglo de String de dos dimensiones.
     * @param raiz arreglo de dos dimensiones que indica la raiz del arbol
     */
    public Arbol(String [][] raiz){

        // System.out.println("Matriz inicial: ");

        Pair<Float, Pair<Integer, Integer>> mejorCondicion=impurezaGini.mejorCondicion(raiz); //O(nlogn*m) n: cantidad de estudiantes y m: cantidad de variables

        int mejorValor=mejorCondicion.getValue().getKey();

        int columna=mejorCondicion.getValue().getValue();

        Pregunta pregunta=new Pregunta(columna, mejorValor);
        Pair<String[][], String[][]> division=impurezaGini.dividirDatos(raiz, columna, mejorValor);// O(nlogn) n: cantidad de estudiantes
        NodoDecision brazoDerecho = CrearArbol(division.getKey());// O(nlogn*m) n: cantidad de estudiantes y m: cantidad de variables
        NodoDecision brazoIzquierdo = CrearArbol(division.getValue());// O(nlogn*m) n: cantidad de estudiantes y m: cantidad de variables
        this.root= new NodoDecision(pregunta,brazoDerecho,brazoIzquierdo,raiz);
        // O(logn) n: cantidad de estudiantes

        this.CrearArbol(raiz); // O(nlogn*m) n: cantidad de estudiantes y m: cantidad de variables
        //dato.leer("lite.csv");

        //System.out.println("Conjunto de datos: ");
        //dato.imprimir(dato.getArray()); 
        //Complejidad total: // O(nlogn*m) n: cantidad de estudiantes y m: cantidad de variables
    }

    /**
     * El metodo crearArbol es recursivo y permite la division de cada nodo de decision del arbol 
     * en otros dos nodos de decision de acuerdo a la mejor condición que se encuentre.
     * @param datos arreglo de dos dimendiones que indica el conjunto de datos del nodo de decision actual
     * @return NodoDecision nodo de decision actual
     */
    public NodoDecision CrearArbol(String [][] datos){

        if(datos.length==0 || datos==null){

            NodoDecision nuevaHoja = new NodoDecision(datos);
            return nuevaHoja;
        }else{
            //En algun punto datos.length=0
            Pair<Float, Pair<Integer, Integer>> mejorCondicion=impurezaGini.mejorCondicion(datos);// O(nlogn*m) n: cantidad de estudiantes y m: cantidad de variables
            float mayorGananciaInfo= mejorCondicion.getKey();
            int mejorValor=mejorCondicion.getValue().getKey();
            int columna=mejorCondicion.getValue().getValue();

            if(mayorGananciaInfo==0){
                NodoDecision nuevaHoja = new NodoDecision(datos);
                return nuevaHoja;
            }

            Pair<String[][], String[][]> division=impurezaGini.dividirDatos(datos, columna, mejorValor);
            // O(nlogn) n: cantidad de estudiantes
            if(division.getKey().length==0){
                NodoDecision nuevaHoja = new NodoDecision(division.getValue());
                return nuevaHoja;
            }
            else if(division.getValue().length==0){
                NodoDecision nuevaHoja = new NodoDecision(division.getKey());
                return nuevaHoja;
            }else{
                NodoDecision brazoDerecho = CrearArbol(division.getKey()); //menores // O(logn) n: cantidad de estudiantes
                NodoDecision brazoIzquierdo = CrearArbol(division.getValue()); //mayores // O(logn)

                Pregunta pregunta= new Pregunta(columna, mejorValor);
                NodoDecision nuevoNodoDecision = new NodoDecision(pregunta, brazoDerecho, brazoIzquierdo, datos); 

                return nuevoNodoDecision;
            }
        }
        // O(nlogn*m) n: cantidad de estudiantes y m: cantidad de variables
    }

    /**
     * El metodo predecir es un metodo recursivo, recibe la información de un estudiante en particular
     * y busca retornar lo que el arbol actual prediga acerca de si tendra o no exito.
     * @param fila arreglo de String con la información del estudiante a predecir
     * @param nodo NodoDecision actual sobre el que se hara la pregunta
     * 
     * return int numero que indica si el estudiante tendra o no exito. Es 1 si predice que tendra exito o 0 si predice que no tendra exito
     */
    public int predecir(String [] fila, NodoDecision nodo){
        if(nodo!=null && nodo.getHoja()!=null){
            return nodo.getHoja().contar();  // O(n) n cantidad de elementos del arreglo
        }else if(nodo!=null){
            if(nodo.getPregunta().match(fila)){
                return predecir(fila,nodo.getBrazoDerecho()); //menor o igual 
                // O(logn) n: cantidad de estudiantes 
            }else{
                return predecir(fila,nodo.getBrazoIzquierdo()); //mayor
                // O(logn) n: cantidad de estudiantes 
            }
        }else{
            //es null
            return 0;
        }
        // O(n) n: cantidad de estudiantes 
    }

    /**
     * El método getRoot() permite obtener el NodoDecision correspondiente a la raiz del arbol actual
     * 
     * @return NodoDecision raiz del arbol actual
     * 
     */
    public NodoDecision getRoot(){
        return this.root;
    }
}