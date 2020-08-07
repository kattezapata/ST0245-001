
/**
 * Write a description of class MCD here.
 * 
 *  @author Maria Alejandra Vélez Clavijo, Laura Katterine Zapata Rendón
 * @version (a version number or a date)
 */
public class MCD
{

    public static int gcd(int a,int b){
        if(b==0){ //Caso base
            return a;
        }else{
        return gcd(b,a%b);
        }
    }
}
