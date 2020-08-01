import java.util.ArrayList;
/**
 * La clase linea permite crear una línea en dos dimensiones, además de esto permite calcular la pendiente de esta recta,
 * hallar los puntos intermedios y permite obtener tanto el punto inicial como final de esta.
 * @author Maria Alejandra Velez Clavijo, Laura Katterine Zapata Rendón
 * @version 1
 */

public class Linea 
{
    //Atributos
    private Punto puntoI;
    private Punto puntoF;
    private ArrayList<String> puntos = new ArrayList();


    /**
     * Se inicializan las variables globales en el constructor de manera que no posean valores nulos o 0s.
     */
    public Linea(Punto punto1, Punto punto2){
        //Establecer el punto inicial y final
        if(punto1.x()<punto2.x()||punto1.y()<punto2.y()) {
            this.puntoI=punto1;
            this.puntoF=punto2;}
        else{
            this.puntoI=punto2;
            this.puntoF=punto1;}


    }
 
    /**
     * Método que permite obtener el punto inicial de la recta
     * @return Punto inicial
     */
    public String getPuntoIni(){
        return this.puntoI.getCoordenadas();
    }


    /**
     * Método que permite obtener el punto inicial de la recta
     * @return Punto final
     */
    public String getPuntoFin(){
        return this.puntoF.getCoordenadas();
    }


    /**
     * Método que permite obtener los puntos intermedios entre el punto inicial y punto final de la línea, almacenados en el arraylist puntos
     * @return ArrayList puntos 
     */


    public  ArrayList<String> puntosIntermedios(){
        double xMenor,xMayor,yMenor,yMayor;


        if(this.puntoI.x()<this.puntoF.x()){
            xMenor=this.puntoI.x();
            xMayor=this.puntoF.x();
        }else{
            xMenor=this.puntoF.x();
            xMayor=this.puntoI.x();
        }


        if(this.puntoI.y()<this.puntoF.y()){
            yMenor=this.puntoI.y();
            yMayor=this.puntoF.y();
        }else{
            yMenor=this.puntoF.y();
            yMayor=this.puntoI.y();
        }


        int xme = (int)xMenor;
        int xma = (int)xMayor;
        int yme = (int)yMenor;
        int yma = (int)yMayor;


        puntos.add(puntoI.getCoordenadas());
 

        for(int x=xme;x<=xma;x++){
            for(int y=yme;y<=yma;y++){
                Punto punto=new Punto(x,y);


                if(this.pendiente(puntoI,punto)==this.pendiente(puntoI,puntoF)){
                    puntos.add(punto.getCoordenadas());
                }


            }
        }


        return puntos;
    }


    /**
     * Método que permite almacenar en una cadena los puntos de la líne almacenados en un arraylist que se pasa como parámetro,
     * para su posterior visualización.
     */


    public String arrayList(ArrayList<String> array ){
        String cadena="";
        for(int i=0;i<array.size();i++){
            cadena=cadena+array.get(i);
        }
        return cadena;
    }


    /**
     * Método que permite calcular la pendiente de la línea formada entre los dos puntos que se ingresan como parámetros
     * @return pendiente de la línea
     */
    public double pendiente(Punto puntoI, Punto puntoF){
        return (puntoI.y()-puntoF.y())/(puntoI.x()-puntoF.x());
    }


}