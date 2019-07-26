package restaurante;
import javax.swing.JOptionPane;

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
        String [] menu = new String[6];
        for(int i=0;i<getCantidad();i++){
            menu[i] = "Codigo: "+getElem()[i].getCodigoProducto()+"\nNombre: "+getElem()[i].getNombreProducto()+"\n Costo: $"+getElem()[i].getCostoProducto()+"\n======================";
        }
        /*for(String i:menu){
            System.out.println(i);
        }*/
        JOptionPane.showMessageDialog(null, menu );
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