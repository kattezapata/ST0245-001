
/**
 * La clase CodigoEjercicio1 tiene diversos métodos que pretenden darle solución a 
 * problemas planteados en el laboratorio 1 del curso estructuras de datos y algoritmos 
 * 
 * @author Laura Katterine Zapata Rendón, Maria Alejandra Velez Clavijo
 * @version 2
 */
public class CodigoEjercicio1
{ 
    /**
     * La clase compRect permite saber de cuántas maneras se puede completar o llenar
     * un rectángulo de dimensiones 2*n cm^2, con baldosas de tamaño 2*1 cm^2
     * @param x longitud en x o base del rectángulo
     * @return int número de formas en que se pueden acomodar las baldosas en el rectangulo tal que este quede
     * totalmente completo
     */
    public static int compRect(int x){
        if(x==0){
            return 1;
        } 
        else if(x<0){
            return 0;
        } 
        else{
            return compRect(x-2) + compRect(x-1);
            // t(n)= c1 + t(n-2) + t(n-1), donde ci=5
            // t(n)= 2^n
            // complejidad: O(2^n) exponencial
      }
  }
    
      /**
     * Este metodo calcula la longitud de la subsecuencia más larga en comun entre 2 cadenas
     * 
     * @param cadena1 es la primera cadena
     * @param cadena2 es la segunda cadena
     * @return longitud de la subsecuencia mas larga en comun
     */
    
    public static int subsecuencia(String cadena1, String cadena2){
        return subsecuencia(cadena1,cadena2,cadena1.length(),cadena2.length());
    }

    /**
     * Este metodo calcula la longitud de la subsecuencia más larga en comun entre 2 cadenas
     * y sirve como un metodo auxiliar para el metodo subsecuencia(String cadena1, String cadena2)
     * 
     * @param cadena1 es la primera cadena
     * @param cadena2 es la segunda cadena
     * @param m posicion del caracter a comparar en la cadena1
     * @param n posicion del caracter a comparar en la cadena2
     * @return longitud de la subsecuencia mas larga en comun
     */
    private static int subsecuencia(String cadena1, String cadena2, int m, int n) {
        if(m==0 || n==0){
          
            return 0; // T(n) = c1, donde c1 = 5
        }
        
        if(cadena1.charAt(m)==cadena2.charAt(n)){
           
            return 1 + subsecuencia(cadena1,cadena2, m-1, n-1); 
        // T(n) = c2 + T(n-1) + T(n-1), donde c2 = 10
        // T(n) = c2((2^n)-1) + c1 * 2^(n-1)
        // T(n) = 2^n (exponencial)
          
        }
        
        return Math.max(subsecuencia(cadena1, cadena2,m-1, n), subsecuencia(cadena1, cadena2, m, n-1));
        //T(n) = c3 + T(n-1) + T(n-1), donde c3 = 4
        // T(n) = c3((2^n)-1) + c3 * 2^(n-1)
        // T(n) = 2^n (exponencial)
    }
  

}
    