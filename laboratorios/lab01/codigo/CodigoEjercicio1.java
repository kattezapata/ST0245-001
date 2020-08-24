
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
}
