
/**
 * La clase Main tiene el objetivo realizar pruebas a los metodos de las clases Reader, Octree y Bee.
 *
 * @author (Laura Katterine Zapata Rendón, Maria Alejandra Velez Clavijo)
 * @version (1)
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

            rm.leer("10abejas.txt");

        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}