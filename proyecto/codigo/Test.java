import java.lang.Math;

/**
 * La clase Test permite crear un bosque aleatorio de arboles construidos con el algoritmo Cart 
 * y calcular la precision, exactitud y sensibilidad.
 * 
 * @author (Maria Alejandra Vélez Clavijo, Laura Katterine Zapata Rendón) 
 * @version (1)
 */
public class Test
{
    /**
     * El constructor Test permite crear una instancia de test 
     * a partir de los nombres de los archivos del dataSet para construir el modelo y para validarlo.
     * @param crearArbol es el nombre del archivo del dataSet pata construir el modelo
     * @param test es el nombre del archivo del dataSet para hacer la validacion del modelo
     */
    public Test(String crearArbol, String test){
        Datos dato= new Datos();
        long TInicio, TFin, tiempo;
        TInicio = System.currentTimeMillis(); 
        dato.leer(crearArbol);// O(n)
        String [][] raiz=dato.getArray();
        int cont=500;
        System.out.println("Cantidad de arboles: " + cont);
        System.out.println("Tamaño de dataSet: " + raiz.length);
        Arbol[] arboles= new Arbol[cont];
        int cantidadArboles=0;
        boolean decidir;
        int limiteMenor=0;
        int limiteMayor=30;

        for(int i=0; i<cont;i++){ //O(p) p: número de árboles a crear
            decidir=true;

            while(decidir==true ){

                limiteMayor=(int)(Math.random()*raiz.length);
                limiteMenor= limiteMayor-20-(int)(Math.random()*80) ;
                if(limiteMayor>100){
                    decidir=false;
                } 

            }

            arboles[cantidadArboles]=new Arbol(dato.getArrayParametros(limiteMenor,limiteMayor)); 
            cantidadArboles++;
            //Complejidad total: 
            // O(nlogn*m*p) n: cantidad de estudiantes y m: cantidad de variables p: número de árboles a crear
            // n nunca es mayor a 60
            // p siempre es 150
        }
        TFin = System.currentTimeMillis();
        tiempo = TFin - TInicio; 
        System.out.println("Tiempo de entrenamiento: " + tiempo);
        // Aquí comienza la validación de los datos
        TInicio = System.currentTimeMillis(); 
        Datos dato1= new Datos();
        dato1.leer(test);// O(n) n: cantidad de filas del test 
        String [][] prueba=dato1.getArray();

        String [][] test1 = new String [prueba.length][2];
        System.out.println("Tamaño de test: " + test1.length);
        // exito / prediccion
        float exito=0;
        float noExito=0;
        float falseNegative=0;
        float truePositive=0;
        float falsePositive=0;
        float trueNegative=0;

        for(int i =0; i<prueba.length;i++){ // O(s) s: cantidad de filas del test 
            test1[i][0]=prueba[i][prueba[0].length-1]+"";

            exito=0;
            noExito=0; 
            for(int j=0; j<cont;j++){ // O(m) m cantidad de árboles siempre menor a 150
                if(arboles[j].predecir(prueba[i], arboles[j].getRoot())==1){ 
                    // O(n) n: cantidad de filas de cada árbol siempre menor a 60
                    exito++;
                }else{
                    noExito++;
                }

                if(exito>=noExito){
                    test1[i][1]=1+"";
                }else{
                    test1[i][1]=0+"";
                }

            }

            if(test1[i][0].equals(test1[i][1])){

                if(test1[i][0].equals("1")){
                    truePositive++;
                }else{
                    falseNegative++;
                }
            }else{
                if(test1[i][0].equals("0")){
                    falsePositive++;
                }else{
                    trueNegative++;
                }
            }

        }
        //OrdenarMatriz.imprimir(test1);

        float sensibilidadExito= truePositive/(truePositive+falseNegative);
        float sensibilidadFracaso= falseNegative/(truePositive+falseNegative);
        float exactitud= (truePositive+falseNegative)/(truePositive+trueNegative+falsePositive+falseNegative); 
        float  precision = truePositive/(truePositive+falsePositive);
        System.out.println("TP: "+truePositive);
        System.out.println("FN: "+falseNegative);
        System.out.println("TN: "+trueNegative);
        System.out.println("FP: "+falsePositive);
        System.out.println("Exactitud: "+exactitud);
        System.out.println("Precisión: "+precision);
        System.out.println("Sensibilidad exito: "+ sensibilidadExito);
        System.out.println("Sensibilidad fracaso: "+ sensibilidadFracaso);
        TFin = System.currentTimeMillis();
        tiempo = TFin - TInicio; 
        System.out.println("Tiempo de validación: " + tiempo);

    }// O(s*m*n) n: cantidad de filas del test m: cantidad de filas de cada árbol siempre menor a 60  m cantidad de árboles siempre menor a 150
}
