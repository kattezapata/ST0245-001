//Punto 2 del taller
/**
 * Clase Fecha: Crea una fecha y compara 2 fechas diciendo si son iguales o cual va despues de la otra.
 * @author Maria Alejandra Velez Clavijo, Laura Katterine Zapata Rendón
 * 
 */

public class Fecha
{
    //Atributos
    private int dia;
    private int mes;
    private int ano;

    //Constructor: Crear fecha
    public Fecha(int day, int month, int year){
        this.dia=day;
        this.mes=month;
        this.ano=year;
    }

    //Método que retorna el dia
    public int getDia(){
        return this.dia;
    }

    //Método que retorna el mes
    public int getMes(){
        return this.mes;
    }

    //Método que retorna el year
    public int getAno(){
        return this.ano;
    }

    //Método que retorna la fecha
    public String getFecha(){
        String fecha="";
        if(this.dia>=1 && this.dia<=31){

            if(this.mes>=1 && this.mes<=12){

                if(this.ano>=1)
                    fecha=this.dia+"/"+this.mes+"/"+this.ano;
            }
            else{
                System.out.println("Mes invalido");
            }

        }
        else{
            System.out.println("Dia invalido");
        }
        return fecha;
    }

    //Método que compara dos fechas
    public String compararFecha(Fecha fecha){
        String cadena="";
        //Comparar si son iguales
        if(this.getFecha().equals(fecha.getFecha())){
            cadena="La fecha "+this.getFecha()+" y la fecha "+fecha.getFecha()+" son iguales";
        }
        //Determinar de acuerdo al year que fecha es despues de la otra
        else if(this.ano>fecha.getAno()){
            cadena=this.getFecha()+" es despues de "+fecha.getFecha();
        }
        else if(this.ano<fecha.getAno()){
            cadena=fecha.getFecha()+" es despues de "+this.getFecha();
        }
        else if(this.ano==fecha.getAno()){
            //Determinar de acuerdo al mes que fecha es despues de la otra
            if(this.mes>fecha.getMes()){
                cadena=this.getFecha()+" es despues de "+fecha.getFecha();
            } 
            else if(this.mes<fecha.getMes()){
                cadena=fecha.getFecha()+" es despues de "+this.getFecha();
            }
            else if(this.mes==fecha.getMes()){
                //Determinar de acuerdo al dia que fecha es despues de la otra
                if(this.dia>fecha.getDia()){
                    cadena=this.getFecha()+" es despues de "+fecha.getFecha();
                } else if(this.dia<fecha.getDia()){
                    cadena=fecha.getFecha()+" es despues de "+this.getFecha();
                }
            }
        }

        return cadena;

    }

}
