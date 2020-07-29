//Punto 3 del taller
/**
 * Clase linea: Crea una linea a partir de dos puntos 2D y permite hallar los puntos intermedios.
 * @author Maria Alejandra Velez Clavijo, Laura Katterine Zapata Rendón
 * 
 */

import java.util.ArrayList;
public class Linea 
{
    //Atributos
    private Punto2D puntoI;
    private Punto2D puntoF;
    private ArrayList<String> puntos = new ArrayList();
  
    //Constructor: Crear Linea
    public Linea(Punto2D punto1, Punto2D punto2){
        //Establecer el punto inicial y final
        if(punto1.getX()<punto2.getX()||punto1.getY()<punto2.getY()) {
            this.puntoI=punto1;
            this.puntoF=punto2;}
        else{
            this.puntoI=punto2;
            this.puntoF=punto1;}

    }

    //Método que retorna las coordenadas del punto inicial
    public String getPuntoIni(){
        return this.puntoI.getCoordenadas();
    }

    //Método que retorna las coordenadas del punto final
    public String getPuntoFin(){
        return this.puntoF.getCoordenadas();
    }

    //Método que retorna el ArrayList con las coordenadas de los puntos intermedios
    public  ArrayList<String> puntosIntermedios(){
        double xMenor,xMayor,yMenor,yMayor;

        if(this.puntoI.getX()<this.puntoF.getX()){
            xMenor=this.puntoI.getX();
            xMayor=this.puntoF.getX();
        }else{
            xMenor=this.puntoF.getX();
            xMayor=this.puntoI.getX();
        }

        if(this.puntoI.getY()<this.puntoF.getY()){
            yMenor=this.puntoI.getY();
            yMayor=this.puntoF.getY();
        }else{
            yMenor=this.puntoF.getY();
            yMayor=this.puntoI.getY();
        }

        int xme = (int)xMenor;
        int xma = (int)xMayor;
        int yme = (int)yMenor;
        int yma = (int)yMayor;

        puntos.add(puntoI.getCoordenadas());

        for(int x=xme;x<=xma;x++){
            for(int y=yme;y<=yma;y++){
                Punto2D punto=new Punto2D(x,y);

                if(this.pendiente(puntoI,punto)==this.pendiente(puntoI,puntoF)){
                    puntos.add(punto.getCoordenadas());
                }

            }
        }

        return puntos;
    }

    //Método que retorna una cadena con todos los elementos del ArrayList
    public String arrayList(ArrayList<String> array ){
        String cadena="";
        for(int i=0;i<array.size();i++){
            cadena=cadena+array.get(i);
        }
        return cadena;
    }

    //Método que calcula pendiente
    public double pendiente(Punto2D puntoI, Punto2D puntoF){
        return (puntoI.getY()-puntoF.getY())/(puntoI.getX()-puntoF.getX());
    }

}