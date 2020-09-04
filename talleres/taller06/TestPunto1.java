
/**
 * La clase Punto1 tiene la intención de hacer pruebas a los métodos de la clase MyArrayList.
 * 
 * @author Laura Katterine Zapata Rendón, Maria Alejandra Vélez Clavijo
 * @version 1
 */
public class TestPunto1
{
    public static void main(String []args){
        try {
            MiArrayList array = new MiArrayList();
            array.add(1);
            array.add(2);
            array.add(3);
            array.add(4);
            array.add(5);
            array.imprimir();
            
            array.add(5,6);
            array.add(6,7);
            array.add(7,8);
            array.imprimir();
             

            for(int i=0;i<array.size();i++){
                array.del(i);
            }
            array.imprimir();

            for(int i=0;i<array.size();i++){
                System.out.println(array.get(i));
            }
            array.imprimir();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
