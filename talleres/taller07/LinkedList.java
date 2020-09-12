
   
    /** 
 * Esta clase tiene como objetivo implementar una lista simplemente enlazada
 * que permite borrar, insertar y buscar elementos en cualquier posición
 * @author Maria Alejandra Vélez Clavijo, Laura Katterine Zapata Rendon
 * @version 1
 */

import java.lang.IndexOutOfBoundsException; // Usar esto cuando se salga el índice

// Una lista simplemente enlazada

public class LinkedList{

    //Atributos

    private Node first;

    private int size;
    /**
     * Constructor inicializa los atributos de la clase
     */
    public LinkedList(){
        size = 0;
        first = null;
    }

    /**
     * Este método sirve como auxiliar del método get
     * @param index posición del elemento
     * @return elemento de la posición indicada
     */

    private Node getNode(int index) throws IndexOutOfBoundsException {

        if (index >= 0 && index < size) {

            Node temp = first;

            for (int i = 0; i < index; i++) {

                temp = temp.next;

            }

            return temp;

        } else {

            throw new IndexOutOfBoundsException(); //index inválido

        }

    }

    /**
     * Este método retorna el elemento de una posición especificada en la lista.
     * @param index - indice del elemento a retornar
     * @return elemento en la posición del indice 
     * @throws IndexOutOfBoundsException
     */
    public int get(int index) throws IndexOutOfBoundsException {
        Node temp = getNode(index);
        return temp.data;
    }

    /**
     * Este método retorna el tamaño actual de la lista
     */
    public int size()

    {

        return this.size;

    }

    /**
     * El método insert, inserta un dato en la posición index que se pasa como parámetro
     * @param data elemento a insertar
     * @param index posición en la que se va insertar el elemento
     */
    public void insert(int data, int index)
    {

        if (index <0 || index > size) { // T(n)= c1

            throw new IndexOutOfBoundsException("index : "+index); //index inválido

        }

        if (size == 0 && index > 0) // T(n)= c2
            throw new IndexOutOfBoundsException("index : "+index); //index inválido

        if(index==0){ // T(n)= c3

            Node newNode =new Node(data);

            newNode.next=first;

            this.first=newNode;

            this.size++;

            return;

        }

        if (index >0 ) { // T(n)= c4

            Node temp=first;

            for (int i = 0; i < index-1; i++)// // T(n)= c4+n 
                temp=temp.next;

            Node newNode =new Node(data);

            newNode.next=temp.next;

            temp.next=newNode;

            this.size++;

            return;

        }
        // Complejidad para el peor de los casos: 
        // T(n)= c4+n 
        // O(c4+n) (Simetría)
        // O(n) (Regla de la suma)
        // Por tanto este algoritmo sería útil para agregar millones de abejas
        // La complejidad de agregar n abejas es c*n 
        // donde n es el index de cada abeja y c es la constante que representa la cantidad de abejas a agregar
    }

    /**
     * Borra el dato en la posición index
     * @param index índice del elemento a eliminar
     */
    public void remove(int index)

    {

        if (index <0 || index > size) {
            throw new IndexOutOfBoundsException("index : "+index); //index inválido
        }

        if (size == 0 && index > 0)

            throw new IndexOutOfBoundsException("index : "+index); //index inválido

        if(index==0){
            Node temp;
            temp=first.next;
            this.first=temp;
            this.size--;
            return;
        }
        if (index >0 ) {
            //Node newNode =new Node(data);
            Node temp=first;

            for (int i = 0; i < index-1; i++) {

                temp=temp.next; // objetivo 2

            }

            Node temp2;
            temp2=temp.next.next; //4
            temp.next=temp2; //

            size--;

            return;

        }

    }

    /**
     * El método contains verifica si un dato está en la lista 
     * @param data Dato a verificar
     * @return boolean si el dato está en la lista
     */
    public boolean contains(int data) {
        if(first.data==data){
            return true;
        }

        Node temp=first;

        for (int i = 1; i < size; i++) {

            temp=temp.next;

            if(temp.data==data){
                return true;
            }

        }

        return false;

    }

    /**
     * El método search busca si está un dato en la lista y retorna la
     * posición de dicho dato. 
     * @param data dato a buscar
     * @return int índice del elemento (retorna -1 si el elemento no se encontró)
     */

    public int search(int data) {

        int index=-1;

        if(first.data==data){
            return 0;
        }

        Node temp=first;

        for (int i = 1; i < size; i++) {

            temp=temp.next;

            if(temp.data==data){
                index = i;
                return index;

            }

        }
        return index;

    }


    public static int 
    max(LinkedList lista){

        return max(lista,lista.first, lista.first.data);

    }


    /**

     * El método max nos permite obtener el número de máximo valor

     * en una lista

     * 
    @param LinkedList lista del cual se va obtener el número de valor máximo

     * 
    @param temp elemento a comparar
     * 
     * @param aux máximo temporal
    @return int Devuelve el elemento de la lista con el valor máximo

     */

    private static int max(LinkedList lista, Node temp, int aux){

        if(lista.size()==1){

            return lista.first.data;

        }
        if(temp==null){// Condición de parada 
            return aux;
        }
        else{
            int max;
            max= Math.max( temp.data, aux);

            return max(lista, temp.next, max);

        }
    }
}

