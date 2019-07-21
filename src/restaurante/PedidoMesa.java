package restaurante;

import java.util.Calendar;

public class PedidoMesa  extends Pedidos{
    private double propinaMesa;

    public PedidoMesa(){

    }
    public PedidoMesa(int cod,Calendar fecha,String cliente,double costo){
        super(cod, fecha, cliente, costo);

    }
    public void mostrarPedidosMesa(){
        super.mostrarDatos();
    }
    @Override
    public double costoTotal(){
        double gasto;
        gasto=getCostoPedido()+0.05*getCostoPedido();
        return gasto;
    }

    public double getPropinaMesa() {
        propinaMesa=0.05*getCostoPedido();
        return propinaMesa;
    }

    public void setPropinaMesa(double propinaMesa) {
        this.propinaMesa = propinaMesa;
    }
}