
/**
 * La clase TestClientLinea tiene la intención de hacer pruebas 
 * con la clase Linea para verificar su correcto funcionamiento.
 * 
 * 
 * @author Maria Alejandra Velez Clavijo, Laura Katterine Zapata Rendón
 * @version 1
 */

public class TestClientLinea
{

    public static void main(String []args){
        Punto punto1=new Punto(3,3);
        Punto punto2=new Punto(0,0);

        Linea linea=new Linea(punto1,punto2);
        System.out.println(linea.arrayList(linea.puntosIntermedios()));
        
      
    }

}
