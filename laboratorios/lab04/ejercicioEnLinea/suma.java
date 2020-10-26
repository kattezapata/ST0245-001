
/**
 * La clase suma permite sumar los nodos de una ruta del árbol y comparar este resultado con un número dado
 * 
 * @author (Maria Alejandra Vélez Clavijo, Laura Katterine Zapata Rendón) 
 * @version (1)
 */
public class suma
{
   

    public static boolean sumaElCamino(Nodo a, int suma) {
        if (a == null)
            return false;
        if (a.izq == null && a.der == null)
            return suma == a.data;
        else{
            return sumaElCamino(a.izq, suma-a.data) 
            || sumaElCamino(a.der, suma-a.data); 
        } // T(n)= T(n/2) + T(n/2)
        // O(n)
        // n: número de elementos del arbol
    }

    public static void main(String []args){
        System.out.println(suma(9, "(5 (4) (5))"));
    }

    public static boolean suma (int suma, String s){
        String abre = "(";
        String cierra = ")";
        String doble="))";
        boolean derecha=false;
        Tree arbol=new Tree();
        if (s.length() > 2){
            for (String subcadena : s.split(" ")){
                if (subcadena.contains(abre) ){

                    if(subcadena.charAt(1)==(cierra.charAt(0))){
                        continue;
                    }else if(subcadena.contains(doble))
                    {  derecha=true;
                        arbol.insert(subcadena.charAt(1), derecha);//O(logn)
                    }else{
                        derecha =false;
                    arbol.insert(subcadena.charAt(1), derecha); // O(logn)
                    }

                }          

            }
            // T(n,m)= m*logn
            //O(mlogn)
            // m: numero de subcadenas del string
            // n: numero de elementos del arbol
            
        }
       
        return sumaElCamino(arbol.getRoot(),suma);
    }

    public static void printInOrderAux(Nodo node){
       if(node!=null){
            printInOrderAux(node.getLeft());
        

        System.out.println(node.getData()+"  ");

       
            printInOrderAux(node.getRight());
        }
        
        //T(n) = T(n/2) + T(n/2)+ c1
        //O(n)
        //n: numero de nodos en el arbol
        //array=new ArrayList<String>();
    }
}
