import java.util.ArrayList;
/**
 * La clase Arcos contribuye en el algoritmo que permite
 * crear una estructura de datos con el
 * mapa de una ciudad. 
 * 
 * @author Maria Alejandra Vélez Clavijo, Laura Katterine Zapata Rendón 
 * @version 1
 */
public class Arcos
{
    static ArrayList<String> ID = new ArrayList<>();
    static ArrayList<String> ID1 = new ArrayList<>();
    static ArrayList<String> distancia = new ArrayList<>();
    static ArrayList<String> nombre = new ArrayList<>();
    /**
     * El método llenarArr permite llenar las listas
     * que contienen la información de cada sitio de la ciudad
     * @param arr arreglo que contiene la información de cada sitio
     */
    public static void llenarArr(String[] arr){
        if(arr.length>=1){ 
            ID.add(arr[0]); //T(n)=n
        }
        if(arr.length>=2){
            ID1.add(arr[1]); //T(n)=n
        }
        if(arr.length>=3){
            distancia.add(arr[2]); //T(n)=n
        }
        if(arr.length>=4){
            nombre.add(arr[3]); //T(n)=n
        }
        //T(n)= n+n+n+n = 4n
        //0(4n) = O(n) (regla del producto) Compleidad lineal
    }

    /**
     * El método obtDist permite obtener la distancia entre sitios
     * pasandole el ID de cada uno
     * @param id ID del primer sitio
     *  @param id1 ID del segundo sitio
     * @return String con la distancia
     */

    public static String obtDist(String id, String id1){
        int index=-1;
        if((ID.contains(id)&& ID1.contains(id1) || (ID.contains(id1)&& ID1.contains(id) ))){ //T(n)= n+n = 2n
            if(ID1.contains(id) ){ //T(n) = n
                index= ID1.indexOf(id);   //T(n) = n
            }else if(ID1.contains(id1) ){ //T(n) = n
                index= ID1.indexOf(id1);  //T(n) = n
            } //T(n)= n + n = 2n
            return "Distancia: "+ distancia.get(index); //T(n) = 1

        } //T(n)= 2n + 2n = 4n
        return ""+ index+ "";
    } //T(n) = 4n
    //O(4n) = O(n)(regla del producto) Compleidad lineal

    /**
     * El método obtNombre permite obtener el nombre entre sitios
     * pasandole el ID de cada uno
     * @param id ID del primer sitio
     *  @param id1 ID del segundo sitio
     * @return String con el nombre
     */
    public static String obtNombre(String id, String id1){
        int index=-1;
        if((ID.contains(id)&& ID1.contains(id1) || (ID.contains(id1)&& ID1.contains(id) ))){ // T(n)= n + n = 2n
            if(ID1.contains(id) ){ //T(n) = n
                index= ID1.indexOf(id); //T(n) = n
            }else if(ID1.contains(id1) ){ //T(n) = n
                index= ID1.indexOf(id1); //T(n) = n
            }  //T(n) = n + n = 2n
            return "Nombre: "+ nombre.get(index); //T(n) = 1

        } //T(n)= 2n + 2n = 4n
        return ""+ index+ "";
    } //T(n) = 4n
    //O(4n) = O(n)(regla del producto) Compleidad lineal
}

// n : numero de elementos de los arrayList(todos tienen el mismo tama�o), n es igual a la cantidad de lineas del archivo.txt