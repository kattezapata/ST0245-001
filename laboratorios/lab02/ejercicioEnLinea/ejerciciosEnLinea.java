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
     * El m�todo lucky13 retorna true si no hay 1's o 3's en el arreglo de enteros.
     * 
     * @param nums arreglo de enteros
     * @return true si no hay 1's o 3's y false si hay 1's o 3's
     */
    public boolean lucky13(int[] nums) {
        boolean contain=true;
        for(int i : nums){
            if(i==1 || i==3){
                contain=false;
            }
        }
        return contain;
    }
    
    /**
     * El m�todo matchUp dados dos arreglos de enteros compara cada elemento en la misma posici�n
     * y determina cuantos de ellos son diferentes y se encuentran en un 
     * rango de 2 numeros por encima o 2 numeros por debajo
     * 
     * @param nums1 primer arreglo de enteros
     * @param nums2 segundo arreglo de enteros
     * @return cuantos elementos en la misma posici�n cumplen la condicion
     */
    public int matchUp(int[] nums1, int[] nums2) {

        int total=0;

        for(int i=0 ; i<nums1.length ; i++){

            if(nums1[i]!=nums2[i]){

                int max=nums1[i]+2;
                int min=nums1[i]-2;

                if(nums2[i]>=min && nums2[i]<=max){
                    total++;
                }

            }

        }
        return total;
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

    
    /****************************Array 3******************************************
     
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
        
     /**
     * El m�todo maxSpan dado un arreglo de enteros, encuentra dos elementos que sean iguales 
     * y establece como longitud la cantidad de elementos que hay entre ellos,incluyendolos.
     * Luego devuelve la mayor longitud encontrada.
     * 
     * @param nums arreglo de enteros
     * @return la maxima longitud(span) encontrada
     */
    public int maxSpan(int[] nums) {

        int max=0;
        int span=0;
        for(int i=0;i<nums.length;i++){
            for(int j=nums.length-1;j>=0;j--){
                if(nums[i]==nums[j]){
                    span=(j-i)+1;
                    if(span>max){
                        max=span;
                    }
                }

            }

        }
        return max;

    }
   
    
    /**
     * El m�todo seriesUp dado un entero n, retorna un arreglo de enteros 
     * con la serie de la forma {1,    1, 2,    1, 2, 3,   ... 1, 2, 3 .. n}.
     * 
     * @param n numero hasta donde va la serie
     * @return el arreglo de enteros con la serie
     */
    public int[] seriesUp(int n) {
        int index=0;
        int length=(n*(n+1))/2;
        int [] array = new int[length];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                array[index]=j;
                index++;
            }

        }
        return array;
    }
    
     /**
     * El m�todo squareUp dado un entero n, retorna un arreglo de enteros 
     * con la serie de la forma para n=3: {0, 0, 1,    0, 2, 1,    3, 2, 1}.
     * 
     * @param n numero hasta donde va la serie
     * @return el arreglo de enteros con la serie
     */
    public int[] squareUp(int n) {
        int n0=n-1; //numero de ceros
        int index=0; //posicion del elemento a ingresar
        int [] array=new int[n*n];

        for(int i=1;i<=n;i++){
            //a�adir ceros
            for(int j=1;j<=n0;j++){
                array[index]=0;
                index++;

            }
            n0--;

            // a�adir serie de numeros
            for(int j=i;j>0;j--){
                array[index]=j;
                index++;

            }

        }

        return array;
    }

}
