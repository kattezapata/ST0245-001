/**
 * La clase Punto2 permite encontrar si existe un subgrupo de
 * volúmenes cuya suma sea igual a un volumen máximo constante. 
 * La complejidad asintótica para el peor de los casos en que se ejecute este
 * algoritmo es O(2^n), es decir, la complejidad temporal de este algoritmo es exponencial.
 * @author Laura Katterine Zapata Rendón, Maria Alejandra Vélez Clavijo
 * @version 1
 */

public class Punto2
{

    public static void main(String args[]){
        for(int n=13;n<33;n++){
            long tiempoInicial=System.currentTimeMillis();
            sumaVol(new int [n],10);
            long tiempoFinal=System.currentTimeMillis();
            System.out.println(tiempoFinal-tiempoInicial);
        }
    }

    /**
     * El método sumaVol nos indica si existe un conjunto de volúmenes 
     * tal que su suma sea igual al volumen máximo que se pasa como parámetro
     * @param volumenes[] Arreglo de enteros el cual contiene un conjunto de volumenes
     * @param max Volumen maximo que se desea encontrar
     * @return boolean Nos indica si existe o no un subgrupo de volúmenes 
     * tal que su suma sea igual a max
     *  
     */

    public static boolean  sumaVol(int volumenes [], int max){

        return sumaVol(0,volumenes,max);
    }

    /**
     * El método sumaVol nos indica si existe un conjunto de volúmenes 
     * tal que su suma sea igual al volumen máximo que se pasa como parámetro
     * @param start es un contador, nos sirve para saber cuando debemos parar
     * @param volumenes[] Arreglo de enteros que representan volumenes
     * @param max Volumen maximo o meta que debe alcanzar la suma
     * @return boolean Nos indica si existe o no un subgrupo de volúmenes 
     * tal que su suma sea igual a max
     *   
     **/
    private static boolean sumaVol(int start,int volumenes [],int max){
        if(start>=volumenes.length){
            return max==0; // T(n)=c1, donde c1=5
        }else{
            return  sumaVol(start+1,volumenes,max-volumenes[start]) || sumaVol(start+1,volumenes,max);
            // T(n)=c2+T(n-1)+T(n-1), donde c2=7
            // T(n)=c1* 2^(n-1)+ c2*((2^n)-1)
            // T(n)= 2^n (Exponencial)
        }
    }

}