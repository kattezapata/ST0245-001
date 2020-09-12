/**
 * La clase TestLinkedList tiene el objetivo de hacer pruebas a los metodos de la clase LinkedList
 *
 * @author Laura Katterine Zapata Rendon, Maria Alejandra Velez Clavijo
 * @version 1
 */
public class TestLinkedList
{
    public static void main(String []args) throws IndexOutOfBoundsException {
        try{
            LinkedList list = new LinkedList();
            LinkedList list2 = new LinkedList();
            //********** Metodo size() **************
            System.out.println("Size(0): "+list.size());

            //********** Metodo insert() **************
            list.insert(5, 0);
            list.insert(4, 0);
            list.insert(3, 0);
            list.insert(2, 0);
            list.insert(1, 0);
            list.insert(0, 0);
           list.insert(100, 3);

            list2.insert(0, 0);
            list2.insert(1, 1);
            list2.insert(2, 2);
            list2.insert(3, 3);
            list2.insert(4, 4);
            list2.insert(5, 5);

            System.out.println( "El máximo es: "+ list.max(list));
            System.out.println("¿ Son iguales?"+ list.comparar(list, list2));

            System.out.println("Size : "+list.size());
            //********** Metodo get() **************
            //Imprimir el indice y los datos de los nodos
            for (int i = 0; i <list.size() ; i++) {

                System.out.println("Elemento "+i+" : "+list.get(i));

            }

            //********** Metodo remove() **************
            list.remove(3);
            System.out.println("Size: "+list.size());
            //Imprimir el indice y los datos de los nodos
            for (int i = 0; i <list.size() ; i++) {

                System.out.println("Elemento "+i+" : "+list.get(i));

            }

            //********** Metodo contains() **************
            System.out.println(list.contains(5)); // Retorna true
            System.out.println(list.contains(17));// Retorna false
            //********** Metodo search() **************
            int pos=list.search(4);
            if(pos<0){
                System.out.println("Abeja no encontrada");
            }else{
                System.out.println("La posicion es: "+pos);
            }

        }catch(Exception e){
            System.out.println("Index no válido");
        }
    }

}