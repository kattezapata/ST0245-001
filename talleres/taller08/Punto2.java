
/**
 * La clase Punto2 implementa un algoritmo que recibe las
 * neveras en la forma en que están ordenadas en el almacén,
 * y las solicitudes según el orden en que llegaron, 
 * e imprime qué neveras del almacén quedan asignadas a cada tienda. 
 * 
 * @author Laura Katterine Zapata Rendón, Maria Alejandra Vélez Clavijo
 * @version 1
 */
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
public class Punto2

{ 
    public static void main(String []args){
        Stack <Nevera> neveras = new Stack<>();
        Queue <Solicitud> solicitudes = new LinkedList<>();

        Solicitud s1= new Solicitud("Exito",2);
        Solicitud s2= new Solicitud("Jumbo",4);

        solicitudes.add(s1);// La más vieja
        solicitudes.add(s2);// La más nueva

        Nevera n1= new Nevera(1,"Samsung");
        Nevera n2= new Nevera(2,"Haceb");
        Nevera n3= new Nevera(3,"LG");
        Nevera n4= new Nevera(4,"Cualquiera");
        Nevera n5= new Nevera(5,"Cualquierax2");
        Nevera n6= new Nevera(6,"Cualquierax3");
        Nevera n7= new Nevera(7,"Cualquierax4");

        neveras.push(n1);//La nevera más vieja
        neveras.push(n2);
        neveras.push(n3);
        neveras.push(n4);
        neveras.push(n5);
        neveras.push(n6);
        neveras.push(n7);//La nevera más nueva

        asignarNeveras(neveras, solicitudes);

    }

    public static void asignarNeveras(Stack<Nevera> neveras, Queue<Solicitud> solicitudes){
        for(Solicitud solicitud : solicitudes) {
            System.out.println("Tienda: "+solicitud.getTienda());
            System.out.println("Numero de neveras solicitadas: "+solicitud.getNumNeveras());
            for(int i=0;i<solicitud.getNumNeveras();i++) {
                Nevera nevera = neveras.pop();
                System.out.println("Código:"+ nevera.getCodigo());
                System.out.println("Descripcion:"+ nevera.getDescripcion());
            }
            System.out.println("");
        }
    }
}
