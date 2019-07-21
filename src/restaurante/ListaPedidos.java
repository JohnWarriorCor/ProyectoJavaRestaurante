package restaurante;

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
        System.out.println("----------DELYVERY---------------");
        for(int i=0; i<cantidad;i++){
            if ((elem[i] instanceof PedidoDelivery)){
                pd=(PedidoDelivery)elem[i];
                pd.mostrarPedidosDelivery();
            }
        }
        System.out.println("---------------MESAS------------");
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
        System.out.println("Monto total de Mesas:" + itm);
        System.out.println("monto total en delivery:" + itd);
    }
    public void reporte3(){
        PedidoDelivery pd = null;
        PedidoMesa pm = null;
        double iam = 0,iad = 0;
        System.out.println("=================DELYVERY================");
        for(int i=0; i<cantidad;i++){
            if ((elem[i] instanceof PedidoDelivery)){
                pd=(PedidoDelivery)elem[i];
                iad=pd.getCostoEntrega()+ iad;
                System.out.println("codigo:" + elem[i].getCodigoPedido()+
                        "\tCosto:"+pd.getCostoEntrega());
            }

        }//ingresos adicionales por propinas
        System.out.println("gasto adicional en mesa:" + iad);
        System.out.println("==================MESAS=================");
        for(int i=0; i<cantidad;i++){
            if ((elem[i] instanceof PedidoMesa)){
                pm=(PedidoMesa)elem[i];
                iam=pm.getPropinaMesa()+ iam;
                System.out.println("codigo:" + elem[i].getCodigoPedido()+
                        "\tPropina:"+pm.getPropinaMesa());
            }

        }
        System.out.println("monto adicioonal enDelivery :" + iam);
    }
}