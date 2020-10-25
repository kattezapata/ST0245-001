
/**
 * Write a description of class Main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
public class Main
{

    public static void main (String []args) throws IOException {
        Reader rm=new Reader();
        try {
            //System.out.println("Porfavor ingrese la direccion donde se encuentran las coordenadas de las abejas");
            //Scanner dir=new Scanner(System.in);
            //String direccion=dir.nextLine();

            rm.leer("10abejas.txt");

        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}