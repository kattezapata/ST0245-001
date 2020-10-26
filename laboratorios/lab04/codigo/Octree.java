/**
 *This is our data structure, Octree. This will be responsible for positioning each bee in a specific quadrant, 
 *so you can determine if it collides or not. Its main function will be divided into eight quadrants, in 3D. 
 *If more than one bee is found in a quadrant, this quadrant will be divided into multiple subOctrees, found 
 *in the limits of this, until the bee is alone, or within a diagonal quadrant of less than 100 meters in length. 
 *This is done to ensure that all the bees within this quadrant are in danger of colliding.
 *
 * @author (Laura Katterine Zapata Rendón, Maria Alejandra Velez Clavijo)
 * @version (1)
 * 
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections; 
public class Octree
{
    private double midD,midW,midH;

    /**
     * This will be the method that represents the Octree, on this method all the recursion will be done, here each bee will be assigned 
     *to its respective sector of the Octree, represented by an ArrayList of 8 spaces (each one representing each sector), where it will 
     *be stored in a LinkedList. The process of deciding which sector each bee goes to will be done by the hashing method. After each bee
     *is located in a sector it will happen to create the sub-views of the Octree with the new method Octree. Before going on to create 
     *the new subdivisions of the Octree, it is asked if the octual diagonal is less than 100 meters, if so it will start printing the 
     *bees located in the sectors where there is more than one bee.
     * @param ArrayList<Bee> abejas: ArrayList with all the bees
     * @param ArrayList<Double> mins: they are the values of the coordinates, to which they will be sumed with all others in order to determine
     * the posicion in the Octree. It can be resemble as a vertex of the Octree.
     * @param double midD: will be the value of the latitude found in the middle of the bee with the lowest latitude and the bee with the highest latitude
     * @param double midW: will be the value of the latitude found in the middle of the bee with the lowest longitude and the bee with the highest longitude
     * @param double midD: will be the value of the latitude found in the middle of the bee with the lowest altitude and the bee with the highest altitude
     * @see hashing
     * @see nuevoOct
     */
    public void octree(LinkedList<Bee> abejas,ArrayList<Double> mins,double midD,double midW,double midH) {

        this.midD=midD;
        this.midW=midW;
        this.midH=midH;

        //si solo hay una abeja o no hay abejas no se divide en otro octree sino que ahí termima ese nodo hoja
        if(abejas.size()<=1){
            return;
        }
        else{

            ArrayList< LinkedList<Bee> > arbol=new ArrayList<>();
            //Crear linkedList vacios para cada pos del arrayList
            for(int j=0;j<8;j++){
                LinkedList<Bee> lista=new LinkedList();
                arbol.add(lista);
            }
            //añadir cada abeja en la lista enlazada de acuerdo a la posición en el array que arroje la función hashing()

            ArrayList<Double> mids=getMids(abejas);
            for(Bee abeja:abejas){

                //ArrayList<Double> minimos=new ArrayList<>();

                arbol.get(this.hashing(abeja,mids)).add(abeja);
            }

            for(int i=0;i<8;i++){
                getMins(arbol.get(i));
                //hacer un nuevo octree para cada posición del arreglo, es decir para cada lista enlazada de abejas
                nuevoOctree(arbol.get(i),mins,i);
            }
        }
    }

    /**
     * This method will be responsible for receiving each bee that is in the octree, and place it in a certain sector of the data structure, 
     *so that it will be located in the space of the ArrayList table corresponding to the sector in which the bee is positioned. Determine the 
     *sector by comparing the minimum, that is, the vertices of the Octree, plus the average values of the Octree with which it is being worked.
     * @param Bee abeja: abeja que sera ubicada
     * @param ArrayList<Double> mins: this ArrayList will contain the minimum, that is, the vertex composed by each coordinate. This parameter 
     *is necessary to be able to make an appropriate location for each bee, because the use of this parameter will simplify the code so that only 
     *one value will have to be added to determine if a bee is in a sector or in other.
     * @return number of the sector the Bee is located in.
     */
    private int hashing(Bee abeja,ArrayList<Double> mids) {
        int hashNum=0;
        double midLatitud= mids.get(0);
        double midLongitud= mids.get(1);
        double midAltura= mids.get(2);

        double latitud= abeja.getLatitude();
        double longitud= abeja.getLongitude();
        double altura=abeja.getAltitude();

        if(latitud<=midLatitud && longitud<=midLongitud && altura<=midAltura){
            hashNum=0;
        }
        if(latitud<=midLatitud && longitud>midLongitud && altura<=midAltura){
            hashNum=1;
        }
        if(latitud>midLatitud && longitud<=midLongitud && altura<=midAltura){
            hashNum=2;
        }
        if(latitud>midLatitud && longitud>midLongitud && altura<=midAltura){
            hashNum=3;
        }
        if(latitud<=midLatitud && longitud<=midLongitud && altura>midAltura){
            hashNum=4;
        }
        if(latitud<=midLatitud && longitud>midLongitud && altura>midAltura){
            hashNum=5;
        }
        if(latitud>midLatitud && longitud<=midLongitud && altura>midAltura){
            hashNum=6;
        }
        if(latitud>midLatitud && longitud>midLongitud && altura>midAltura){
            hashNum=7;
        }

        return hashNum;
    }

    /**
     * This method is responsible for making the recursion, with respect to the main octree method. Receive the parameters corresponding to 
     *the bees located in the sector, and the vertices of this, which are in the ArrayLis mins. With the paramtero sector they identify how 
     *the vertices of the next sub-octree should be redefined, since these vary by sector.
     * @param LinkedList<Bee> abejas: bees of the corresponding sector
     * @param ArrayList<Double> mins: they are the minimum values of coordinates, to which other parameters will be added to redefine the 
     *vertex of the next Octree. Take it as if it were one of the vertex of the octree.
     * @param int sector: sector in which it is located.
     */
    public void nuevoOctree(LinkedList<Bee> abejas,ArrayList<Double> mins,int sector) {

        //si solo hay una abeja o no hay abejas no se divide en otro octree sino que ahí termima ese nodo hoja
        if(abejas.size()<=1){
            return;
        }
        else{

            ArrayList< LinkedList<Bee> > arbol=new ArrayList<>();

            //Crear linkedList vacios para cada pos del arrayList
            for(int j=0;j<8;j++){
                LinkedList<Bee> lista=new LinkedList();
                arbol.add(lista);
            }

            //añadir cada abeja en la lista enlazada de acuerdo a la posición en el array que arroje la función hashing()
            for(Bee abeja: abejas){

                ArrayList<Double> mids= getMids(abejas);
                arbol.get(this.hashing(abeja, mids)).add(abeja);
            }

            for(int i=0;i<8;i++){
                if(arbol.get(i).size()!=0){
                    //calcular la nueva diagonal
                    double ph=Math.sqrt(Math.pow((midD)*111325,2)+Math.pow((midW)*111325,2));
                    double diagonal=Math.sqrt(Math.pow(ph,2)+Math.pow((midH),2));

                    //si la diagonal es menor a 100 entonces hay colisiones
                    if(diagonal<100){
                        choque(arbol.get(i));
                    }else {

                        //hacer un nuevo octree para cada posición del arreglo, es decir para cada lista enlazada de abejas
                        nuevoOctree(arbol.get(i),getMins(arbol.get(i)),i);
                    }
                }

            }
        }

    }

    public ArrayList<Double> getMins(LinkedList<Bee> abejas){
        if(abejas.size()!=0){
            LinkedList<Double> lat = new LinkedList();
            LinkedList<Double> lon = new LinkedList();
            LinkedList<Double> alt = new LinkedList();

            for(Bee abeja: abejas){
                lat.addFirst(abeja.getLatitude());
                lon.addFirst(abeja.getLongitude());
                alt.addFirst(abeja.getAltitude());
            }

            double minlat=(double)Collections.min(lat);
            System.out.println("La latitud minima es: "+minlat);
            double minlon=(double)Collections.min(lon);
            System.out.println("La longitud minima es: "+minlon);
            double minalt=(double)Collections.min(alt);
            System.out.println("La altura minima es: "+minalt);

            ArrayList<Double> mins=new ArrayList();
            mins.add(minlat);
            mins.add(minlon);
            mins.add(minalt);
        }
        ArrayList<Double> mins=new ArrayList();
        return mins;
    }

    public ArrayList<Double> getMaxs(LinkedList<Bee> abejas){
        if(abejas.size()!=0){
            LinkedList<Double> lat = new LinkedList();
            LinkedList<Double> lon = new LinkedList();
            LinkedList<Double> alt = new LinkedList();

            for(Bee abeja: abejas){
                lat.addFirst(abeja.getLatitude());
                lon.addFirst(abeja.getLongitude());
                alt.addFirst(abeja.getAltitude());
            }

            double maxlat=(double)Collections.max(lat);

            double maxlon=(double)Collections.max(lon);

            double maxalt=(double)Collections.max(alt);

            ArrayList<Double> mins=new ArrayList();
            mins.add(maxlat);
            mins.add(maxlon);
            mins.add(maxalt);
        }

        ArrayList<Double> mins=new ArrayList();
        return mins;
    }

    public ArrayList<Double> getMids(LinkedList<Bee> abejas){
        if(abejas.size()!=0){
            ArrayList<Double> minimos=getMins(abejas);
            ArrayList<Double> maximos=getMaxs(abejas);

            double midlat = maximos.get(0)-minimos.get(0);

            double midlon = maximos.get(1)-minimos.get(1);

            double midalt = maximos.get(2)-minimos.get(2);

            ArrayList<Double> mids=new ArrayList();
            mids.add(midlat);
            mids.add(midlon);
            mids.add(midalt);
        }

        ArrayList<Double> mids=new ArrayList();
        return mids;
    }

    /**
     * This sector is in charge of printing all the coordinates of the bees of the sector, if it prints them is because
     * all these Bees are in risk of colliding.
     * @param LinkedList<Bee> abejas: bees of the sector
     */
    public void choque(LinkedList<Bee> abejas) {
        System.out.println("Las abejas en las siguientes coordenadas estan en peligro de chocarse");
        for (Bee abeja:abejas) {
            System.out.println(abeja.getLatitude()+","+abeja.getLongitude()+","+abeja.getAltitude());
        }
    }

}