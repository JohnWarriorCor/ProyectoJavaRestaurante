package restaurante;

import java.util.Calendar;
import javax.swing.JOptionPane;

public class Pedidos {
    private int codigoPedido;
    private Calendar fechaPedido;
    private String clientePedido;
    private double costoPedido;
    //constructor Vacio
    public Pedidos(){

    }
    //constructor con Parametros
    public Pedidos(int cod,Calendar fecha,String cliente,double costo){
        this.codigoPedido=cod;
        this.fechaPedido=fecha;
        this.clientePedido=cliente;
        this.costoPedido=costo;
    }
    public void mostrarDatos(){
        JOptionPane.showMessageDialog(null, "Codigo: "+ getCodigoPedido()+ "\nFecha: "+mostrarFecha()+
                "\nCliente: "+getClientePedido()+"\nCosto: $"+costoTotal());
    }

    public double costoTotal(){
        return costoPedido;
    }

    public String mostrarFecha(){
        String cad;
        int mm,yy,dd;
        dd=fechaPedido.get(Calendar.DATE);
        mm=fechaPedido.get(Calendar.MONTH)+1;
        yy=fechaPedido.get(Calendar.YEAR);
        cad=dd+"/"+mm+"/"+yy;
        return cad;
    }

    public int getCodigoPedido() {
        return codigoPedido;
    }

    public void setCodigoPedido(int codigoPedido) {
        this.codigoPedido = codigoPedido;
    }

    public Calendar getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Calendar fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public String getClientePedido() {
        return clientePedido;
    }

    public void setClientePedido(String cliente) {
        this.clientePedido = cliente;
    }

    public double getCostoPedido() {
        return costoPedido;
    }

    public void setCostoPedido(double costoTotal) {
        this.costoPedido = costoTotal;
    }
}