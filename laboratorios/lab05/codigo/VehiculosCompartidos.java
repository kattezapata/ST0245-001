import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.LinkedList;
import javafx.util.Pair;

/**
 * Implementacion de un algoritmo para asignar vehiculos compartidos
 * Estructura de datos utilizada: Grafo con Matrices de Adyacencia
 * Complejidad: Peor Caso y Mejor Caso O(n*n)
 *
 * @author Maria Alejandra Vélez Clavijo y Laura Katterine Zapata Rendon
 * @version 1
 */
public class VehiculosCompartidos
{
    /**
     * Metodo para leer un archivo con los duenos de vehiculos y la empresa
     * Complejidad: Mejor y peor caso es O(n*n), donde n es son los duenos de vehiculos y la empresa
     * @param p constante que indica tiempo máximo de demora
     * @param  numeroDePuntos  El numero de puntos es 1 de la empresa y n-1 de los duenos de vehiculos
     * @return un grafo completo con la distancia mas corta entre todos los vertices
     */
    public static DigraphAM leerArchivo(int numeroDePuntos, float p){
        final String nombreDelArchivo = "dataset-ejemplo-U="+numeroDePuntos+"-p="+p+".txt";
        DigraphAM grafo = new DigraphAM(numeroDePuntos);
        try {            
            BufferedReader br = new BufferedReader(new FileReader(nombreDelArchivo));
            String lineaActual = br.readLine();
            for (int i = 1; i <= 3; i++) // Descarta las primeras 3 lineas (información no necesaria)
                lineaActual = br.readLine();
            lineaActual = br.readLine(); 
            for (int i = 1; i <= numeroDePuntos; i++){ //Descarta los nombres y coordenadas de los vertices (información no necesaria)
                lineaActual = br.readLine();
            }          
            for (int i = 1; i <= 3; i++) // Descarta las siguientes 3 lineas (información no necesaria)
                lineaActual = br.readLine();             
            while (lineaActual != null){ // Mientras no llegue al fin del archivo. Lee la informacion de las aristas (información no necesaria)
                String [] cadenaParticionada = lineaActual.split(" ");
                grafo.addArc(Integer.parseInt(cadenaParticionada[0])-1, Integer.parseInt(cadenaParticionada[1])-1, Integer.parseInt(cadenaParticionada[2]));
                lineaActual = br.readLine();
            }
        }
        catch(IOException ioe) {
            System.out.println("Error leyendo el archivo de entrada: " + ioe.getMessage());
        }
        return grafo;
    }

    public static int[] vehiculosCercanos(DigraphAM grafo, int dueno){
        int[] vehiculosCercanos=new int[5];
        Pair<Integer,Integer>[] fila= new Pair[grafo.size()];

        for(int i=0; i<grafo.getGrafoAM().length; i++){
            Pair<Integer,Integer> pareja= new Pair((Integer)grafo.getGrafoAM()[dueno][i],(Integer) i);
            fila[i]=pareja;
        }
        Pair<Integer,Integer> menor=fila[0];
        int cont=0;
        for(int i=0; i<5; i++){
            for(int j=0; j<fila.length; j++){
                if(fila[j].getKey()!=null){
                    if(fila[j].getKey()<menor.getKey()){
                        menor= fila[j];
                    }
                }
            }
            vehiculosCercanos[cont]=menor.getValue();
            fila[menor.getValue()]=null;
            cont++;
        }
        return vehiculosCercanos;
    }

    /**
     * Algoritmo para asignar vehiculos compartidos (No tiene en cuenta la restriccion que hay en el problema)
     * Lo que hace es agrupar los duenos de vehiculos en permutaciones de maximo 5 elementos
     * Complejidad: Mejor y Peor Caso O(n), donde n son los duenos de vehiculos y la empresa
     *
     * @param  grafo  Un grafo que puede estar implementado con matrices o con listas de adyacencia
     * @return una lista de listas con la permutacion para cada subconjunto de la particion de duenos de vehiculo
     */
    public static LinkedList<int[]> asignarVehiculos(DigraphAM grafo, float p){
        LinkedList<int[]> permutacionParaCadaSubconjunto = new LinkedList<int[]>();
        //int dueno = 2; // Empieza en 2 porque 1 es la empresa
        int contador = 1;

        for(int dueno=1; dueno< grafo.getGrafoAM().length; dueno++){
            permutacionParaCadaSubconjunto.add(vehiculosCercanos(grafo,dueno));
        }

        return permutacionParaCadaSubconjunto ;
    }

    /**
     * Metodo para escribir un archivo con la respuesta
     * Complejidad: Mejor y peor caso es O(n), donde n son los duenos de vehiculo y la empresa
     *
     * @param  permutacionParaCadaSubconjunto es una lista de listas con la permutacion para cada subconjunto de la particion de duenos de vehiculo
     */
    public static void guardarArchivo(LinkedList<int[]> permutacionParaCadaSubconjunto,int numeroDePuntos, float p){
        final String nombreDelArchivo = "respuesta-ejemplo-U="+numeroDePuntos+"-p="+p+".txt";
        try {
            PrintWriter escritor = new PrintWriter(nombreDelArchivo, "UTF-8");
            for (int[] lista: permutacionParaCadaSubconjunto){
                for (Integer duenoDeVehiculo: lista)
                    escritor.print(duenoDeVehiculo + " ");
                escritor.println();
            }             
            escritor.close();
        }
        catch(IOException ioe) {
            System.out.println("Error escribiendo el archivo de salida " + ioe.getMessage() );
        }  
    }

    public static void main(String[] args){
        //Recibir el numero de duenos de vehiculo y la empresa, y el valor de p por el main
        final int numeroDePuntos = args.length == 0 ? 205 : Integer.parseInt(args[0]);
        final float p = args.length < 2 ? 1.3f : Float.parseFloat(args[1]);
        // Leer el archivo con las distancias entre los duenos de los vehiculos y la empresa
        DigraphAM grafo = leerArchivo(numeroDePuntos, p);
        // Asignar los vehiculos compartidos
        long startTime = System.currentTimeMillis();
        LinkedList<int[]> permutacionParaCadaSubconjunto = asignarVehiculos(grafo,p);
        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("El algoritmo tomo un tiempo de: "+estimatedTime+" ms");
        // Guardar en un archivo las abejas con riesgo de colision            
        guardarArchivo(permutacionParaCadaSubconjunto, numeroDePuntos, p);

    }
}