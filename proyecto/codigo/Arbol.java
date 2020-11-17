import javafx.util.Pair;
/**
 * Write a description of class Arbol here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Arbol
{
    private  NodoDecision root;

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
                NodoDecision brazoIzquierdo = CrearArbol(division.getValue()); //mayores

                Pregunta pregunta= new Pregunta(columna, mejorValor);
                NodoDecision nuevoNodoDecision = new NodoDecision(pregunta, brazoDerecho, brazoIzquierdo, datos); 
                
                return nuevoNodoDecision;
            }
        }
        // O(nlogn*m) n: cantidad de estudiantes y m: cantidad de variables
    }

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

    public NodoDecision getRoot(){
        return this.root;
    }
}