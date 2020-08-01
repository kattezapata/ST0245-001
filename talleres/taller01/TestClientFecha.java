
/**
 * La clase TestClientFecha tiene la intención de hacer pruebas 
 * con la clase Fecha para verificar su correcto funcionamiento.
 * 
 * 
 * @author Maria Alejandra Velez Clavijo, Laura Katterine Zapata Rendón
 * @version 1
 */

public class TestClientFecha
{
    public static void main(String []args){
        Fecha fecha1=new Fecha(29,7,2020);
        Fecha fecha2=new Fecha(9,12,1980);
        Fecha fecha3=new Fecha(29,7,2020);

        System.out.println(fecha1.toString()+" el dia es: "+fecha1.dia());
        System.out.println(fecha1.toString()+" el mes es: "+fecha1.mes());
        System.out.println(fecha1.toString()+" el ano es: "+fecha1.anio());

        if(fecha1.comparar(fecha2)==0){ 
            System.out.println("La fecha "+fecha1.toString()+" es igual a la fecha "+fecha2.toString());
        }
        else if(fecha1.comparar(fecha2)==-1)
        { 
            System.out.println("La fecha "+fecha2.toString()+" es despues que la fecha "+fecha1.toString());
        }
        else{
            System.out.println("La fecha "+fecha1.toString()+" es despues que la fecha "+fecha2.toString());
        }
        
    }
}
