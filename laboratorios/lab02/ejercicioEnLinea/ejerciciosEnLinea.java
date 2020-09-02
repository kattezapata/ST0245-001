public class ejerciciosEnLinea {
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

      
}
