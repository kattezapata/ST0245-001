
/**
 * La clase MCD retorna el máximo comun divisor entre dos números enteros.
 * 
 * @author Maria Alejandra Vélez Clavijo, Laura Katterine Zapata Rendón
 * @version 1
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
