/**
 * La clase ejerciciosEnLinea tiene diversos metodos que pretenden darle solucion a 
 * problemas planteados en el laboratorio 2 del curso estructuras de datos y algoritmos I
 * @author Laura Katterine Zapata Rendon, Maria Alejandra Velez Clavijo
 * @version 1
 **/

public class ejerciciosEnLinea {
    /****************************Array 2******************************************
     /**
     * El metodo countEvens retorna la cantidad de enteros pares en un arreglo .
     * 
     * @param nums arreglo de enteros
     * @return numero de pares en el arreglo
     */
    public int countEvens(int[] nums) {
        int numPares=0;
        for(int i : nums){
            if(i % 2 ==0){
                numPares++;
            }
        }
        return numPares;
    }
    
    /**
     * El método sum13 devuelve la suma de los números de la matriz, 
     * devolviendo 0 para una matriz vacía. 
     * Excepto que el número 13 no se cuenta y los números que vienen
     * inmediatamente después del 13 tampoco cuentan.
     * @param nums arreglo de enteros
     * @return suma de los elementos del arreglo
     */
    public int sum13(int[] nums) {
        return sum13(nums, 0, 0);
      } 
    /**
     * El método sum13 (método auxiliar) devuelve la suma de los números de la matriz, 
     * devolviendo 0 para una matriz vacía. 
     * Excepto que el número 13 no se cuenta y los números que vienen
     * inmediatamente después del 13 tampoco cuentan.
     * @param nums arreglo de enteros
     * @param i iterador
     * @param sum acumulador suma  
     * @return suma de los elementos
     */
    private int sum13(int[] nums, int i , int sum ){
        if(i>= nums.length){
          return sum;
        }
        if(nums[i]==13){
          
          return sum13(nums, i+2, sum);
        }
        else{
        sum= sum + nums[i]; 
        return sum13(nums, i+1, sum);
        }
      }

    /**
     * Dado un número n, el método fizzArray crea y devuelve una nueva matriz int de longitud n,
     * que contiene los números 0, 1, 2, ... n-1
     * @param n longitud del arreglo a crear
     * @return arreglo creado
     */
    public int[] fizzArray(int n) {
        int a[] = new int[n];
        for ( int i =0; i< n; i++){
          a[i]=i;
        }
        return a;
      }
    /**
     * Diremos que un elemento en una matriz está "solo" si hay valores antes
     * y después, y esos valores son diferentes de él. 
     * El método norAlone devuelve una versión de la matriz dada donde cada instancia del 
     * valor dado que está solo se reemplaza por el valor a su izquierda
     * o derecha que sea mayor.
     * @param nums arreglo de enteros
     * @return arreglo de enteros
     */
    public int[] notAlone(int[] nums) {
        int [] arr= new int[nums.length];
        for(int i=0; i<nums.length ;i++){
            if(i!=0 && i!= nums.length-1){

                if(nums[i-1]!= nums[i] && nums[i+1]!=nums[i]){
                    arr[i]=Math.max(nums[i], Math.max(nums[i-1], nums[i+1]));
                }else{
                    arr[i]= nums[i];
                 }
            
            } else{
                arr[i]= nums[i];
            }
          
        }
        return arr;
      }

    /**
     * Dadas dos matrices de enteros ordenados en orden creciente,
     * outer e inner , devuelve verdadero si todos los números
     * de la matriz inner aparecen en la matriz outer
     * @param outer Matriz de enteros(exterior)
     * @param inner Matriz de enteros(interior)
     * @return boolean Devuelve si es posible que los elementos de una matriz estén en la otra.
     */
    public boolean linearIn(int[] outer, int[] inner) {
      int cont=0;
      int n=0;
      for(int i=0; i< outer.length; i++){
        if((n< inner.length)&& outer[i]== inner[n]){
          cont=cont+1;
          n=n+1;
        }
      }
      if(cont==inner.length){
        return true;
      }
      return false;
      }
    /**
     * Dada una matriz no vacía, devuelve verdadero
     * si hay un lugar para dividir la matriz de modo que
     * la suma de los números de un lado sea igual a la suma de
     * los números del otro lado.
     * @param nums Matriz de enteros
     * @return boolean Devuelve si hay posibilidad de hacer una división de matrices con las condiciones dadas
     * 
     */
    public boolean canBalance(int[] nums) {
      int sum1=0;
      int sum2=0;
      for(int n=0; n<nums.length; n++){
        sum1= sum1+ nums[n];
        }
      for(int i=0; i< nums.length; i++){
        sum1=sum1-nums[i];
        sum2= sum2+nums[i];
        if(sum1==sum2){
          return true;
          }
        }
        return false;
      }
     /**
      * Supongamos que un "grupo" en una matriz es una
       serie de 2 o más elementos adyacentes del mismo valor.
       El método countClumps devuelve el número de grupos en la matriz dada
      * @param nums Matiz de enteros
      * @return Número de grupos formados
      */
      public int countClumps (int [] nums) {
        int cont = 0;
        for (int i = 0; i <nums.length-1; i ++) {
        if (nums [i] == nums [i + 1]){
          if(i == 0 || nums [i-1]!= nums [i]){
        cont=cont+1;
        }
        }
        }
        return cont;
        }
        

       /****************************Array 3******************************************
}
