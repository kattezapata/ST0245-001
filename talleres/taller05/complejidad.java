public class complejidad{

    public static void main(String[] args){
        System.out.println("Tiempos punto1: ");
        main1();
        System.out.println("Tiempos punto2: ");
        main2();
        System.out.println("Tiempos punto3: ");
       // ¡Cuidado!: antes de ejecutar el main3 debe asegurarse de que el método 
       // multiplicar de la clase punto 3, tenga comentado el System.out.println()
        main3();
    }

    public static void main1(){

        for(int n=1000;n<=20000;n=n+1000){
            int [] arr = new int[n];
            for (int i=arr.length-1; i==0; i++){
                arr[i]= i;
            }
            long tiempoInicial=System.currentTimeMillis();
            punto1.insertionSort(arr);
            long tiempoFinal=System.currentTimeMillis();
            System.out.println(tiempoFinal-tiempoInicial);

        }

    }

    public static void main2(){

        for (int n = 10000000; n <= 200000000; n = n + 10000000) {
            long ti = System.currentTimeMillis();
            Punto2.sumaArreglo(new int[n]); 
            long tf = System.currentTimeMillis();
            System.out.println(tf - ti);
        }
    }

    public static void main3(){
        String tiempo="";

        for ( long i= 100000000; i<=300000000; i=i+10000000){
            long tiempoInicial=System.currentTimeMillis(); 
            punto3.multiplicar(i);
            long tiempoFinal=System.currentTimeMillis();
            System.out.println(tiempoFinal-tiempoInicial);

        } 
    }
    
}