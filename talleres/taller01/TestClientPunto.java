
/**
 * La clase TestClientPunto tiene la intención de hacer pruebas 
 * con la clase Punto para verificar su correcto funcionamiento.
 * 
 * 
 * @author Maria Alejandra Velez Clavijo, Laura Katterine Zapata Rendón
 * @version 1
 */
public class TestClientPunto
{

    public static void main(String[]args){
        Punto a=new Punto(10,20);
        System.out.println("Punto a: "+a.getCoordenadas());
        System.out.println("La coordenada x es: "+a.x());
        System.out.println("La coordenada y es: "+a.y());
        System.out.println("El radio es: "+a.radioPolar());
        System.out.println("El angulo es: "+a.anguloPolar());

        Punto b=new Punto(0,0);
        System.out.println("Punto b: "+b.getCoordenadas());
        System.out.println("La coordenada x es: "+b.x());
        System.out.println("La coordenada y es: "+b.y());
        System.out.println("El radio es: "+b.radioPolar());
        System.out.println("El angulo es: "+b.anguloPolar());
        System.out.println("");
        System.out.println("La distancia del punto a al punto b es: "+a.distanciaEuclidiana(b));

    }

}
