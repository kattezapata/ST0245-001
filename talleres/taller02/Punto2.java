
/**
 * En la clase Punto2, dados los pesos de un grupo de elementos, 
 * determina si existe o no existe un subgrupo de elementos 
 * cuya suma sea igual a un peso máximo.
 * 
 * @author Maria Alejandra Vélez Clavijo, Laura Katterine Zapata Rendón
 * @version 1
 */
public class Punto2
{
    /**
     * @param nums entrada 2 arreglo de enteros positivos, sobre el cual vamos a interar 
     * @param target entrada 3 entero positivo, determina el valor de referencia 
     * El método SumaGrupo tiene como objetivo darnos a conocer si hay 
     * algun subconjunto el cual su suma = target.
     * 
     *
     * @return verdadero si hay un subconjunto el cual su suma = target
     */
    public static boolean sumaGrupo(int[] nums, int target) {
        return sumaGrupo(0, nums, target);
    }	

    /**
     * @param start entrada 1 entero positivo, determina un índice dentro del proceso
     * @param nums entrada 2 arreglo de enteros positivos, sobre el cual vamos a interar 
     * @param target entrada 3 entero positivo, determina el valor de referencia 
     * El método SumaGrupo tiene como objetivo darnos a conocer si hay 
     * algun subconjunto el cual su suma = target.
     * 
     * Este método SumaGrupo es "private" de modo que solo se puede llamar desde el interior de la clase pues
     * el método que lo representa es el SumaGrupo público.
     * Para más detalles sobre modificadores de acceso:
     * @see <a href="http://ayudasprogramacionweb.blogspot.com/2013/02/modificadores-acceso-public-protected-private-java.html"> modificadores </a>
     *
     *
     * @return verdadero si hay un subconjunto el cual su suma = target
     */

    public static boolean sumaGrupo(int start, int[] nums, int target) {
        if (start >= nums.length) 
            return target == 0;

        else{
            return sumaGrupo(start+1, nums, target- nums[start]) ||  sumaGrupo(start+1, nums, target); 
        }
    }

}
