package restaurante;

/**
 *
 * @author GeorgeJason
 */
public class ListaProducto {
    private Producto elem[];
    private int cantidad;
    private int max;
    final int delta=4;

    public ListaProducto(){
        cantidad=0;
        max=0;
        elem=null;
    }
    public void adicionar(Producto dato){
        if(getCantidad()==getMax())
            crecer();
        elem[getCantidad()]=dato;
        cantidad++;
    }
    public void crecer(){
        Producto obj[]=new Producto[delta+getMax()];
        for(int i=0;i<getCantidad();i++)
            obj[i]=this.getElem()[i];

        this.elem=obj;
        max+=delta;
    }
    public void mostrarProducto(){
        for(int i=0;i<getCantidad();i++){
            System.out.println("Codigo: "+getElem()[i].getCodigoProducto()+"\tNombre:"+getElem()[i].getNombreProducto()+"\t\t\t\tCosto:"+getElem()[i].getCostoProducto());
        }

    }

    public Producto[] getElem() {
        return elem;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getMax() {
        return max;
    }
}