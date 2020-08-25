
/**
 * La clase CodigoEjercicio2 tiene diversos métodos que pretenden darle solución a 
 * problemas planteados en el laboratorio 1 del curso estructuras de datos y algoritmos 
 * @author Laura Katterine Zapata Rendón, Maria Alejandra Velez Clavijo
 * @version 1
 */
public class CodigoEjercicio2
{
    /**
     * El método countHi: dada una cadena, calcula de forma recursiva el número de veces que aparece "hi" minúscula en la cadena, 
     * haciendo un llamado al método countHi, que es el encargado de analizar la cadena y al cual se le pasa una cadena 
     * y un interador como parámetro 
     * para hacer el recorrido en dicha cadena 
     * @param str cadena a analizar
     * @return número de veces que aparece "hi" en la cadena
     */
    public int countHi(String str) {
        return countHi(str, 0);
  
    } 
    private int countHi(String str, int a){
        if(str.length()==0){
            return a; 
    } else{
        if(str.endsWith("hi")){
            a++;
            return countHi(str.substring(0, str.length()-2),a);
        }
        return countHi(str.substring(0, str.length()-1),a);
        // complejidad para el peor de los casos:
        // t(n)= c1 + t(n-1), donde c1= 5
        // t(n)= c3*n + c1
        // t(n)= c3*n (regla de la suma)
        // t(n)= n (regla del producto)
        // complejidad: O(n) lineal
      } 
   
   
    }
    /**
     * Se tienen conejitos en fila, numerados 1, 2, ...
     * Los conejitos impares (1, 3, ..) tienen las 2 orejas normales. Los conejitos pares (2, 4, ..)
     * que tienen 3 orejas, porque cada uno tiene un pie levantado. 
     * El método bunnyEars2 devuelve de forma recursiva el número de "orejas" en la línea del conejo 1, 2, ... n (sin bucles ni multiplicaciones).
     * @param bunnies número de conejos en la fila 
     * @return suma de orejas en la línea del conejo
     */
    public int bunnyEars2(int bunnies) {
        int num=0;
        if(bunnies==0){
            return num=0;
        }
        if(bunnies%2==0){
            return num= 3 + bunnyEars2(bunnies-1);
        } 
        if(bunnies%2!=0){
            return num = 2 + bunnyEars2(bunnies-1);
            // t(n)= c1+t(n-1), donde c1= 6
            // t(n)= c3*n + c1
            // t(n)= c3*n (regla de la suma)
            // t(n)= n (regla del producto)
            // complejidad: O(n) lineal
        }     
        return num;
    }
    /**
     * Se tiene un triángulo hecho de bloques. La fila superior tiene 1 bloque,
     * la siguiente fila hacia abajo tiene 2 bloques, la siguiente fila tiene 3 bloques,
     * y así sucesivamente. 
     * El método triangle calcula de forma recursiva el número total de bloques en dicho triángulo con el número de filas dado.
     * @param rows número de filas
     * @return número de bloques en el número de filas dado
     */
    
    public int triangle(int rows) {
        int num=0;
        if(rows==0){
            return 0;
        } 
        else if(rows==1){
            return 1;
        } 
        else{
            num= rows+triangle(rows-1);
            // t(n)= c1+t(n-1), donde c1= 4
            // t(n)= c3*n + c1
            // t(n)= c3*n (regla de la suma)
            // t(n)= n (regla del producto)
            // complejidad: O(n) lineal
        }
        return num;
    }
    
    /**
     * Dada una matriz de ints, el método groupSum6 devuelve si es posible elegir un grupo de algunos de los ints,
     * comenzando por el índice de inicio, de manera que el grupo sume el objetivo dado,
     * con la restricción adicional de que se deben elegir los 6. 
     * @param start iterador que permite recorrer el arreglo de ints
     * @param nums matriz de ints
     * @param target objetivo de suma
     * @return devuelve si es posible elegir un grupo con las restricciones dadas
     */
    public boolean groupSum6(int start, int[] nums, int target) {
        if(start>= nums.length){
            return target==0;
        }
        else{
            if( nums[start]==6){
                return groupSum6(start+1, nums, target-6);
            }
        return groupSum6(start+1, nums, target-nums[start]) || groupSum6(start+1, nums, target);
            // t(n)= c1+t(n-1)+ t(n-1), donde c1= 7
            // t(n) = c_1*(2^n - 1) + c_1*2^(n - 1) 
            // t(n)= (2^n - 1) + 2^(n - 1) (regla del producto)
            // t(n)= 2^n+ 2^n (regla de la suma)
            // t(n)= 2*(2^n)
            // t(n)= 2^n (regla del producto)
            // complejidad: O(2^n) exponencial
        }
    }
    /**
     * Dada una matriz de ints, el método groupNoAdj devuelve si es posible elegir un grupo de algunos de los ints,
     * comenzando por el índice de inicio, de manera que el grupo sume el objetivo dado,
     * con la restricción adicional de que si se elige un valor en la matriz para que esté en el grupo, 
     * el valor inmediatamente siguiente en la matriz no debe ser elegido. 
     * @param start iterador que permite recorrer el arreglo de ints
     * @param nums matriz de ints
     * @param target objetivo de suma
     * @return devuelve si es posible elegir un grupo con las restricciones dadas
     */
    public boolean groupNoAdj(int start, int[] nums, int target) {
        if(start>=nums.length){
            return target==0;
        }
        else{
            return groupNoAdj(start+2, nums, target-nums[start]) || groupNoAdj(start+1, nums, target);
            // t(n)= c1+ t(n-2)+t(n-1), donde c1= 7
            // t(n)= 2^n
            // complejidad: O(2^n) exponencial
        }
    }
    /**
     * Dada una matriz de ints, el método split53 devuelve si es posible dividir los ints en dos grupos,
     * de modo que la suma de los dos grupos sea la misma, con estas restricciones: 
     * todos los valores que son múltiplos de 5 deben estar en un grupo, 
     * y todos los los valores que son múltiplos de 3 (y no múltiplos de 5) deben estar en el otro.
     * @param nums matriz de ints
     * @return devuelve si es posible elegir un grupo con las restricciones dadas
     */
    public boolean split53(int[] nums) {
        return split53(0, nums, 0, 0);
    }
    private boolean split53(int start, int [] nums, int sum5 , int sum3) {
        if(start>=nums.length){
            return sum5==sum3;
        } 
        else{
            if(nums[start]%5==0){
                return split53(start+1, nums, sum5+nums[start], sum3);
            }
            else if(nums[start]%3==0){
                return split53(start+1, nums, sum5, sum3+nums[start]);
            } 
            else{
                return split53(start+1, nums, sum5+nums[start], sum3) || split53(start+1, nums, sum5, sum3+nums[start]);
                // t(n)= c1+ t(n-1)+t(n-1) donde c1= 9
                // t(n) = c_1*(2^n - 1) + c_1*2^(n - 1) 
                // t(n)= (2^n - 1) + 2^(n - 1) (regla del producto)
                // t(n)= 2^n+ 2^n (regla de la suma)
                // t(n)= 2*(2^n)
                // t(n)= 2^n (regla del producto)
                
                // complejidad: O(2^n) exponencial
                
            }
      
           }
}
/**
 * El método bunnyEars calcula el número total de orejas de todos los conejos de forma recursiva
 * sabiendo que cada conejo tiene 2 orejas.
 * 
 * @param bunnies numero de conejos
 * @return número de orejas que tienen en total los conejos
 */
public int bunnyEars(int bunnies) {
//Caso base
if(bunnies==0) return 0;
//Llamado recursivo
else return 2+bunnyEars(bunnies-1);
}

/**
 * El método factorial calcula de forma recursiva el factorial de n, que es n * (n-1) * (n-2) ... 1.
 * 
 * @param n numero a calcular el factorial
 * @return factorial de n
 */
public int factorial(int n) {
if (n==1) return n;
else return n*factorial(n-1);
}

/**
 * El método fibonacci calcula de forma recursiva el nesimo numero en la serie fibonacci
 * 
 * @param n numero en la serie fibonacci
 * @return nesimo numero fibonacci
 */
public int fibonacci(int n) {
if(n<=1) return n;
else return fibonacci(n-1)+fibonacci(n-2);
}

/**
 * El método splitArray dado un array de ints, calcula si es posible dividir los elementos del array en dos grupos, 
 * de modo que las sumas de los dos grupos sean las mismas. Cada elemento debe estar en un grupo o en el otro. 
 * @param nums arreglo de enteros a analizar
 * @return posibilidad de dividir los elementos en 2 grupos con las condiciones anteriores
 */
public boolean splitArray(int[] nums) {
return  splitArray(0,0,0,nums); 
}

/**
 * El método splitArray es un metodo recursivo que sirve como método auxiliar para splitArray()
 * Dado un array de ints, calcula si es posible dividir los elementos del array en dos grupos, 
 * de modo que las sumas de los dos grupos sean las mismas. Cada elemento debe estar en un grupo o en el otro. 
 *  @param start contador que indica la posicion inicial
 * @param suma1 suma de los elementos del primer grupo 
 *  @param suma2 suma de los elementos del segundo grupo 
 *  @param nums arreglo de enteros a analizar
 * @return posibilidad de dividir los elementos en 2 grupos con las condiciones anteriores
 **/

public boolean splitArray(int start, int suma1,int suma2, int[] nums) {
if(start>=nums.length) return suma1==suma2;
else return  splitArray(start+1, suma1+nums[start], suma2, nums) ||  splitArray(start+1, suma1, suma2+nums[start], nums);
}

/**
 * El método splitOdd10 dado un array de ints, calcula si es posible dividir los elementos del array en dos grupos, 
 * de modo que la suma de un grupo sea un múltiplo de 10, y la suma del otro grupo sea impar. 
 * Cada elemento debe estar en un grupo o en el otro. 
 * 
 *  @param nums arreglo de enteros a analizar
 * @return posibilidad de dividir los elementos en 2 grupos con las condiciones anteriores
 */
public boolean splitOdd10(int[] nums) {
return  splitOdd10(0,0,0,nums); 
}

/**
 * El método splitOdd10 es un metodo recursivo que sirve como método auxiliar para splitOdd10()
 * dado un array de ints, calcula si es posible dividir los elementos del array en dos grupos, 
 * de modo que la suma de un grupo sea un múltiplo de 10, y la suma del otro grupo sea impar. 
 * Cada elemento debe estar en un grupo o en el otro. 
 * 
 *  @param start contador que indica la posicion inicial
 * @param suma1 suma de los elementos del primer grupo 
 *  @param suma2 suma de los elementos del segundo grupo 
 *  @param nums arreglo de enteros a analizar
 * @return posibilidad de dividir los elementos en 2 grupos con las condiciones anteriores
 */
public boolean splitOdd10(int start, int suma1,int suma2, int[] nums) {
if(start>=nums.length) return (suma1 % 10 == 0 && suma2 % 2 != 0)||(suma2 % 10 == 0 && suma1 % 2 != 0);
else return  splitOdd10(start+1, suma1+nums[start], suma2, nums) ||  splitOdd10(start+1, suma1, suma2+nums[start], nums);
}

/**
 *  * El método groupSum5 dado un array de ints, calcula si es posible elegir un grupo de elementos del array, 
 * de manera que el grupo sume el numero objetivo dado,
 * con estas limitaciones adicionales: 
 * todos los múltiplos de 5 del conjunto deben ser incluidos en el grupo. 
 * Si el valor inmediatamente posterior a un múltiplo de 5 es 1, no debe elegirse. 
 *  @param start contador que indica la posicion inicial
 *  @param nums arreglo de enteros a analizar
 *  @param target objetivo a alcanzar

 * @return posibilidad de encontrar el subgrupo con las condiciones anteriores
 */
public boolean groupSum5(int start, int[] nums, int target) {
if(start>=nums.length) return target==0;

else if(nums[start]%5==0)
return groupSum5(start+1,nums,target-nums[start]);

else if(start>1 && nums[start]==1 &&  nums[start-1]%5==0)
return groupSum5(start+1,nums,target);

else return groupSum5(start+1,nums,target-nums[start])|| groupSum5(start+1,nums,target); 
}

}
