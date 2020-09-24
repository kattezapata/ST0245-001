import java.io.*;
/**
 * Write a description of class Lector here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lector
{
    public static void main(String[] args){ 
        try{ 
            File archivo = new File ("vertices.txt");
            FileReader fr = new FileReader (archivo);
            BufferedReader br = new BufferedReader(fr);
            String cadena;

            while((cadena= br.readLine())!= null){ 
               // Arcos.llenarArr(cadena.split(","));
                Vertices.llenarArr(cadena.split(","));
            }

            /**
             System.out.println( " Id: "+ Arcos.ID.get(311240)+ " Id1: "+ Arcos.ID1.get(311240)+ 
            " Distancia: "+ Arcos.distancia.get(311240) +" Nombre:" +Arcos.nombre.get(311240));
            System.out.println( Arcos.obtDist(Arcos.ID.get(311240), Arcos.ID1.get(311240)));
            System.out.println(Arcos.obtNombre(Arcos.ID.get(311240), Arcos.ID1.get(311240)));
             */
               System.out.println( " Id: "+ Vertices.ID.get(56536)+ " X: "+ Vertices.X.get(56536)+ 
            " Y: "+ Vertices.Y.get(56536) +" Nombre:" +Vertices.nombre.get(56536));
            System.out.println( Vertices.obtCoordenadas(Vertices.ID.get(56536)));
            System.out.println( Vertices.obtNombre(Vertices.ID.get(56536)));
            System.out.println( Vertices.obtNombre((Vertices.Y.get(56536)),( Vertices.X.get(56536))));
            System.out.println( Vertices.obtId((Vertices.Y.get(56536)),( Vertices.X.get(56536))));
            
            
             
        }catch(IOException e){
            System.out.println(e.getMessage());
        }

    }
}
