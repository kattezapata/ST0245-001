
/**
 * Write a description of class CÃ³digo here.
 * 
 * @author Laura Katterine Zapata Rendón, Maria Alejandra Velez Clavijo
 * @version 2
 */
public class CodigoEjercicio1
{
  public static int mcd(int a){
        return mcd(2*a, 2);
    }
    private static int mcd(int a,int b){
        if(b==0){ 
            return a;
        }else{
            return mcd(b,a%b); 
            // O(log n)
        }
    }
        
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

}
    
