import java.io.*;

/**
 * La clase lector permite leer datos que serán utilizados en el algoritmo que permite
 * crear una estructura de datos con el
 * mapa de una ciudad. 
 * 
 * @author Maria Alejandra Vélez Clavijo, Laura Katterine Zapata Rendón 
 * @version 1
 */

public class Lector
{
    public static void main(String[] args){ 
        try{ 
            File archivo = new File ("vertices.txt");
            FileReader fr = new FileReader (archivo);
            BufferedReader br = new BufferedReader(fr);
            String cadena;

            while((cadena= br.readLine())!= null){ //T(n) = n
                // Arcos.llenarArr(cadena.split(","));
                Vertices.llenarArr(cadena.split(",")); // T(n,m)= (n*m)*n
            } /// T(n,m)= (n^2)*m 

            /**
            System.out.println( " Id: "+ Arcos.ID.get(311240)+ " Id1: "+ Arcos.ID1.get(311240)+ 
            " Distancia: "+ Arcos.distancia.get(311240) +" Nombre:" +Arcos.nombre.get(311240));
            System.out.println( Arcos.obtDist(Arcos.ID.get(311240), Arcos.ID1.get(311240)));
            System.out.println(Arcos.obtNombre(Arcos.ID.get(311240), Arcos.ID1.get(311240)));
             */
            System.out.println( " Id: "+ Vertices.ID.get(56536)+ " X: "+ Vertices.X.get(56536)+ 
                " Y: "+ Vertices.Y.get(56536) +" Nombre:" +Vertices.nombre.get(56536)); //T(n)=1
            System.out.println( Vertices.obtCoordenadas(Vertices.ID.get(56536)));  //T(n)=n
            System.out.println( Vertices.obtNombre(Vertices.ID.get(56536)));  //T(n)=n
            System.out.println( Vertices.obtNombre((Vertices.Y.get(56536)),( Vertices.X.get(56536))));  //T(n)=n
            System.out.println( Vertices.obtId((Vertices.Y.get(56536)),( Vertices.X.get(56536))));  //T(n)=n
        //T(n) = n+n+n+n = 4n
            
           
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        //T(n,m)= (n^2) * m 
        //O(n^2 * m)
    }
}
// n : cantidad de lineas que tenga el archivo.txt
// m : cantidad de cadenas que tiene cada linea del archivo.txt