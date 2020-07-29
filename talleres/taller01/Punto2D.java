//Punto 1 del taller
/**
 * Clase Punto2D: Crea un punto de 2 dimensiones y permite obtener su angulo polar, su radio polar y la distancia euclidiana con otro punto.
 * @author Maria Alejandra Velez Clavijo, Laura Katterine Zapata Rendón
 * 
 */

import java.lang.Math;

public class Punto2D
{
    //Atributos
    private double x;
    private double y; 

    //Constructor: Crear un punto
    public Punto2D(double abs, double ord ){
        this.x=abs;
        this.y=ord;
    }

    //Método que retorna el valor de la coordenada x del punto actual
    public double getX(){
        return this.x;
    }

    //Método que retorna el valor de la coordenada y del punto actual
    public double getY(){
        return this.y;
    }

    //Método que retorna el valor del radio polar(distancia desde origen hasta punto)
    public double getRadio(){
        return Math.sqrt(Math.pow(this.x,2)+Math.pow(this.y,2));
    }

    //Método que retorna el valor del angulo polar(angulo en sentido antihorario desde el eje x)
    public double getAngulo() {
        double pendiente=0;

        //Bloque para capturar excepción en caso de que la coordenada x tenga el valor 0
        try {
            if(this.x==0){
                System.out.println("Angulo indefinido");
            }
            pendiente=this.y/this.x;
        } catch (Exception e) {     
            System.out.println("Angulo indefinido");
        }

        return Math.atan(pendiente);

    }

    //Método que retorna el valor de la distancia entre el punto actual con otro punto
    public double getDistancia(Punto2D punto){
        return Math.sqrt(Math.pow(this.x-punto.getX(),2)+Math.pow(this.y-punto.getY(),2));
    }

    //Metodo que retorna las coordenadas del punto actual 
    //(Se utiliza en la clase Linea que corresponde al punto 3)
    public String getCoordenadas(){
        return "( "+this.x+" , "+this.y+" ) ";
    }
}
