package restaurante;

import java.util.Calendar;

public class PedidoDelivery extends Pedidos{
    private double costoEntrega;

    public PedidoDelivery(){

    }
    public PedidoDelivery(int cod,Calendar fecha,String cliente,double costo){
        super(cod, fecha, cliente, costo);

    }
    public void mostrarPedidosDelivery(){
        super.mostrarDatos();
    }
    @Override
    public double costoTotal(){
        double gasto;
        gasto=(getCostoPedido()+0.1*getCostoPedido());
        return gasto;
    }

    public double getCostoEntrega() {
        costoEntrega=0.1*getCostoPedido();
        return costoEntrega;
    }

    public void setCostoEntrega(double costoEntrega) {
        this.costoEntrega = costoEntrega;
    }
}