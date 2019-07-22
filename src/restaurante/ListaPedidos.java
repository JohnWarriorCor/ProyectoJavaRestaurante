package restaurante;
import javax.swing.JOptionPane;
public class ListaPedidos {
    private Pedidos elem[];
    private int cantidad;
    private int max;
    final int delta = 4;

    ListaPedidos(){
        cantidad=0;
        max=0;
        elem=null;
    }

    public void Adicionar(Pedidos dato){
        if(cantidad==max)
            crecer();
        elem[cantidad]=dato;
        cantidad++;
    }
    public void crecer(){
        Pedidos obj[]=new Pedidos[delta+max];
        for(int i=0;i<cantidad;i++)
            obj[i]=this.elem[i];

        this.elem=obj;
        max+=delta;
    }
    //mostrar todos los pedidos por tipo
    public void reporte1(){
        PedidoDelivery pd;
        PedidoMesa pm;
        JOptionPane.showMessageDialog(null, "DOMICILIOS");
        for(int i=0; i<cantidad;i++){
            if ((elem[i] instanceof PedidoDelivery)){
                pd=(PedidoDelivery)elem[i];
                pd.mostrarPedidosDelivery();
            }
        }
        JOptionPane.showMessageDialog(null, "MESA");
        for(int i=0; i<cantidad;i++){
            if ((elem[i] instanceof PedidoMesa)){
                pm=(PedidoMesa)elem[i];
                pm.mostrarPedidosMesa();
            }
        }
    }
    //ingreso total por tipos
    public void reporte2(){
        PedidoDelivery pd;
        PedidoMesa pm;
        double itm = 0,itd = 0;
        // System.out.println("--------------DELYVERY--------------------");
        for(int i=0; i<cantidad;i++){
            if ((elem[i] instanceof PedidoDelivery)){
                pd=(PedidoDelivery)elem[i];
                itd=pd.costoTotal()+ itd;
            }
        }
        //System.out.println("----------------MESAS--------------------");
        for(int i=0; i<cantidad;i++){
            if ((elem[i] instanceof PedidoMesa)){
                pm=(PedidoMesa)elem[i];
                itm=pm.costoTotal()+ itm;
            }
        }
        JOptionPane.showMessageDialog(null, "Monto total de Mesas: $" + itm + "\n Monto total en domicilio: $" + itd);
        System.out.println();
        System.out.println();
    }
    public void reporte3(){
        PedidoDelivery pd = null;
        PedidoMesa pm = null;
        double iam = 0,iad = 0;
        JOptionPane.showMessageDialog(null, "DOMICILIOS");
        for(int i=0; i<cantidad;i++){
            if ((elem[i] instanceof PedidoDelivery)){
                pd=(PedidoDelivery)elem[i];
                iad=pd.getCostoEntrega()+ iad;
                JOptionPane.showMessageDialog(null, "codigo:" + elem[i].getCodigoPedido()+"\nCosto: $"+pd.getCostoEntrega());
            }

        }//ingresos adicionales por propinas
        JOptionPane.showMessageDialog(null, "gasto adicional en Mesa: $" + iad);
        JOptionPane.showMessageDialog(null, "MESA");
        for(int i=0; i<cantidad;i++){
            if ((elem[i] instanceof PedidoMesa)){
                pm=(PedidoMesa)elem[i];
                iam=pm.getPropinaMesa()+ iam;
                System.out.println();
                JOptionPane.showMessageDialog(null, "codigo:" + elem[i].getCodigoPedido()+"\nPropina: $"+pm.getPropinaMesa());
            }

        }
        JOptionPane.showMessageDialog(null, "monto adicioonal en Domicilio $:" + iam);
    }
}