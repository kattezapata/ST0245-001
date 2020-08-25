
/**
 * La clase CodigoEjercicio1 tiene diversos m�todos que pretenden darle soluci�n a 
 * problemas planteados en el laboratorio 1 del curso estructuras de datos y algoritmos 
 * 
 * @author Laura Katterine Zapata Rend�n, Maria Alejandra Velez Clavijo
 * @version 2
 */
public class CodigoEjercicio1
{ 
    /**
     * La clase compRect permite saber de cu�ntas maneras se puede completar o llenar
     * un rect�ngulo de dimensiones 2*n cm^2, con baldosas de tama�o 2*1 cm^2
     * @param x longitud en x o base del rect�ngulo
     * @return int n�mero de formas en que se pueden acomodar las baldosas en el rectangulo tal que este quede
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
  

}
    