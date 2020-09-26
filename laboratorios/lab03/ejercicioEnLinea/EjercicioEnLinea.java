
/**
 * La clase EjercicioEnLinea implementa un algoritmo que resuelve el problema del teclado roto. 
 * En donde '[' significa que la tecla Inicio fue presionada internamente,
 * y ']'significa que la tecla 'Fin' fue presionada internamente.
 * 
 * @author Laura Katterine Zapata Rendon, Maria Alejandra Velez Clavijo 
 * @version 1
 */
import java.util.LinkedList;

public class EjercicioEnLinea
{
    public static void main(String []args){
        System.out.println(tecladoRoto("This_is_a_[Beiju]_text"));
        System.out.println(tecladoRoto("[[]][][]Happy_Birthday_to_Tsinghua_University"));
        System.out.println(tecladoRoto("asd[fgh[jkl"));
        System.out.println(tecladoRoto("asd[fgh[jkl["));
        System.out.println(tecladoRoto("[[a[[d[f[[g[g[h[h[dgd[fgsfa[f"));
        System.out.println(tecladoRoto("asd[gfh[[dfh]hgh]fdfhd[dfg[d]g[d]dg"));

    }

    /**
     * El metodo tecladoRoto devuelve la forma en que quedaria el texto teniendo en cuenta que:
     * cuando se presiona la tecla 'Inicio' lo manda al principio de la linea, y 'Fin' al final de esta.
     * 
     * @param palabra Cadena que se va a ordenar
     * @return cadena ordenada
     **/
    public static String tecladoRoto(String palabra){
        LinkedList<String> lista=new LinkedList<>();

        StringBuilder cadena =new StringBuilder("");
        boolean fin=true;

        for(int i=0; i<palabra.length();i++){ //T(n)=n
            char c = palabra.charAt(i);
            if(c =='[' || c == ']'){

                if(fin==true){
                    lista.addLast(cadena.toString()); //T(n)=1
                }else{
                    lista.addFirst(cadena.toString()); //T(n)=1
                }

                if(c=='['){
                    fin=false;
                }else{
                    fin=true;
                }
                cadena=new StringBuilder("");            
            }
            else{
                cadena.append(c);

            }

        }

        if(fin==true){
            lista.addLast(cadena.toString()); //T(n)= 1
        }else{
            lista.addFirst(cadena.toString()); //T(n)= 1
        }

        String texto="";
        while(lista.size()>0){ //T(m) = m
            texto=texto+lista.pollFirst();  //T(m) = 1*m = m

        }

        return texto;
    }
        //Complejidad del algoritmo: T(n,m)= n+1+m = n + m
        //O(n + m) -> Complejidad asintotica 

}
// n : Numero de caracteres de la cadena que se quiere ordenar
// m: Numero de nodos de la lista, es decir la cantidad de palabras separadas por "[" y "]" que tenga la cadena a ordenar

