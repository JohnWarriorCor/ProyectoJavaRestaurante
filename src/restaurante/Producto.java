package restaurante;
/**
 *
 * @author GeorgeJason
 */
public class Producto {
    private int codigoProducto;
    private String nombreProducto;
    private int costoProducto;

    public Producto(){

    }
    public Producto(int codigo,String nombre,int costo){
        this.codigoProducto=codigo;
        this.nombreProducto=nombre;
        this.costoProducto=costo;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public float getCostoProducto() {
        return costoProducto;
    }

    public void setCostoProducto(int costoProducto) {
        this.costoProducto = costoProducto;
    }
}
