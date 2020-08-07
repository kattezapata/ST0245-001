
/**
 * Write a description of class Punto3 here.
 * 
 * @author Maria Alejandra Vélez Clavijo, Laura Katterine Zapata Rendón
 * @version (a version number or a date)
 */
public class Punto3
{

    /**
     * @param s se trata de una cadena de caracteres sobre la cual hallaremos las posibles combinaciones.
     *
     * El método combinations se define para que solo se tenga que pasar el parametro s y no la cadena 
     * vacía necesaria para el metodo reursivo combinationsAux. Este metodo no se modifica.
     * 
     */
    public static void combinations(String s) { 
        combinationsAux("",s); 
    }

    /**
     * @param base, se utiliza como una variable auxiliar para guardar datos sobre el proceso.
     * @param s se trata de una cadena de caracteres sobre la cual hallaremos las posibles combinaciones.
     *
     *
     * El método combinationsAux se encarga de encontrar las posibles combinaciones en la cadena s
     * notese que el método es "private" de modo que solo se puede llamar desde el interior de la clase pues
     * el método que lo representa es combinations.
     * Para más detalles sobre modificadores de acceso:
     * @see <a href="http://ayudasprogramacionweb.blogspot.com/2013/02/modificadores-acceso-public-protected-private-java.html"> modificadores </a>
     *
     */
 
    private static void combinationsAux(String base, String s) {  

        if(s.length()==0){
            System.out.println("Subconjunto: "+'"'+base+'"');

        }else{

            combinationsAux(base+s.charAt(0),s.substring(1));
            
            combinationsAux(base,s.substring(1));
            

        }
    }

}
