
/**
 * 
 * @author (Maria Alejandra Vélez Clavijo, Laura Katterine Zapata Rendón) 
 * @version (1)
 */
public class Nodo
{
    Nodo izq;
    Nodo der;
    int data;
    public Nodo(int data){
        this.data=data;
        this.izq=null;
        this.der=null;
    }

    public void setLeft(Nodo izq){
        this.izq=izq;
    }

    public void setRight(Nodo der){
        this.der=der;
}

public Nodo getLeft(){
        return this.izq;
    }

    public int getData(){
        return this.data;
    }

    public Nodo getRight(){
        return this.der;
    }
}
