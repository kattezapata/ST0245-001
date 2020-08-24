
/**
 * CodigoEjercicio2
 * 
 * @author Laura Katterine Zapata Rendón, Maria Alejandra Velez Clavijo
 * @version 1
 */
public class CodigoEjercicio2
{
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
        }
        return num;
    }
    
public int bunnyEars(int bunnies) {
  //Caso base
  if(bunnies==0) return 0;
  //Llamado recursivo
  else return 2+bunnyEars(bunnies-1);
}

public int factorial(int n) {
  if (n==1) return n;
  else return n*factorial(n-1);
}

public int fibonacci(int n) {
  if(n<=1) return n;
  else return fibonacci(n-1)+fibonacci(n-2);
}

}
