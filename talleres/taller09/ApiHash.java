import java.util.HashMap;
/**
 * Esta clase implementa los puntos 2,3 y 4 del taller 09.
 * @author (Maria Alejandra Vélez Clavijo, Laura Katterine Zapata Rendón) 
 * @version (1)
 */
public class ApiHash
{   private static HashMap<String, String> tabla = new HashMap<String, String>();

    public static void agregar(String nombre, String pais){
        tabla.put(nombre.toUpperCase(), pais.toUpperCase());
    }

    public static String buscar(String nombre){
        if(tabla.containsKey(nombre.toUpperCase())){
            return tabla.get(nombre.toUpperCase());
        }
        return "";

    }

    public static String buscarN(String pais){
        String value= "";
        if(tabla.containsValue(pais.toUpperCase())){
            for(String nombre: tabla.keySet() ){

                value = tabla.get(nombre);
                if(value.equalsIgnoreCase(pais)){
                return nombre;
                }

            }
        }
        return "";

    }

    public static void main(String[] args){
        agregar("Google", "Estados Unidos");
        agregar("La locura", "Colombia");
        agregar("Nokia", "Finlandia");
        agregar("Sony", "Japon");
        System.out.println(tabla);
        System.out.println(buscar("Google"));
        System.out.println(buscar("Nokia"));
        System.out.println(buscarN("Colombia"));

    }
}
