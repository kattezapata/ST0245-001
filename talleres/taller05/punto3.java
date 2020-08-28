/**
 * La clase Punto3 tiene como objetivo implementar un algoritmo
 * que calcule las tablas de multiplicar desde 1 hasta n
 * 
 * @author Laura Katterine Zapata Rendon, Maria Alejandra Velez Clavijo
 * @version 1
 */
public class punto3{

    public static void multiplicar(long n){
       long mult=1; // t(n)=c1, donde c1= 1
        for( long i=1; i<=n; i++){
            //T(n)= c2*n + c3, donde c2=4 y c3=1
            mult=i*n; //T(n)=c4*n, donde c4=2
            // Complejidad para cuando no se imprimen las tablas de multiplicar:
            // T(n)= c1 + c2*n + c3 + c4*n 
            //T(n)= c2*n+c4*n
            // T(n)= C*n, donde C(constantota)
            //T(n)=n
            // O(n)
            System.out.println(i + " x " + n + " = "+ (n*i));
            //T(n)= (c5*n + c6)*n, donde c6=6
        } 
        //complejidad para cuando se imprimen las tablas de multiplicar:
        // T(n)= c1 + c2*n + c3 + c4*n + c5*n^2 + c6*n
        //T(n)= c2*n+c4*n+ c5*n^2
        // T(n)= c5*n^2
        //T(n)=n^2 
        // O(n^2)

    }

}