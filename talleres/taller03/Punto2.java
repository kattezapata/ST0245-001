/**
 * La clase Punto 2 permite generar las posibles permutaciones de los caracteres de una cadena dada
 *
 * @author Maria Alejandra Vélez CLavijo, Laura Katterine Zapata Rendón
 * @version version 1
 */
public class Punto2

 

{
    public static void main(String []args){
        permutation("abc");
    }

 

    /**
     *
     * El método permutation es un auxiliar del proceso
     * @param str es la cadena a permutar
     */
    private static void permutation(String str) {
        permutationAux("", str);
    }

 

    /**
     *
     * El método permutationAux es el core del proceso, en el se busca conseguir
     * las posibles permutaciones que puede tener la cadena str
     * @param pregunta es la cadena a permutar
     * @param respuesta cadena auxiliar donde se guarda la cadena de salida
     *
     * Las cadenas de salida tienen una longitud de la cadena s
     * Ej: para la cadena ABC se tiene la salida: { ABC,ACB,BAC,BCA,CAB,CBA }
     * donde los caracteres no se repiten pero el orden tiene un papel importante.
     *
     */
    private static void permutationAux(String respuesta, String pregunta) {
        if (pregunta.length() == 0){
            System.out.println(respuesta);
        }
        else{
            for (int i = 0; i < pregunta.length(); i++){
                permutationAux(respuesta+pregunta.charAt(i),
                    pregunta.substring(0,i) + pregunta.substring (i+1,pregunta.length()));
            }
        }

 

    }
}