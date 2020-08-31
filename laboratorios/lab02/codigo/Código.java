    /**
     * La clase código 
     * 
     * @author Laura Katterine Zapata Rendón, Maria Alejandra Velez Clavijo
     * @version 1
     */
    
public class Código
{
    //**********Merge sort***********
        public static void main(String []args){

            int [] array ={ 10,1,6,2,9,3,5};
            mergesort(array,0,array.length-1);
            System.out.print("{");
            for(int i=0;i<array.length;i++){
                System.out.print(" "+array[i]+" ");
            }
            System.out.print("}");
        }

        public static void mergesort(int A[],int izq, int der){
            if (izq < der){
                int m=(izq+der)/2;
                mergesort(A,izq, m);
                mergesort(A,m+1, der);                                                                                
                merge(A,izq, m, der);                                                                                 
            }
        }

        public static void merge(int A[],int izq, int m, int der){
            int i, j, k;
            int [] B = new int[A.length]; //array auxiliar
            for (i=izq; i<=der; i++)      //copia ambas mitades en el array auxiliar                                       
                B[i]=A[i];

            i=izq; j=m+1; k=izq;

            while (i<=m && j<=der) //copia el siguiente elemento más grande                                      
                if (B[i]<=B[j])
                    A[k++]=B[i++];
                else
                    A[k++]=B[j++];

            while (i<=m)         //copia los elementos que quedan de la
                A[k++]=B[i++]; //primera mitad (si los hay)

        }
    }

