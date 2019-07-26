package restaurante;
import java.util.Calendar;
import javax.swing.JOptionPane;

public class AppPedido {

    static Pedidos objp = new Pedidos();
    static PedidoDelivery pd = new PedidoDelivery();
    static PedidoMesa pm = new PedidoMesa();
    static Producto objpro,objpro1,objpro2,objpro3,objpro4,objpro5;
    static ListaProducto LP = new ListaProducto();
    static ListaPedidos LPE = new ListaPedidos();
    public static void main(String[] args){
        listaProductos();
        int opc;
        do{
            do{
                JOptionPane.showMessageDialog(null, "MENÚ DE INICIO");
                opc =Integer.parseInt( JOptionPane.showInputDialog(null, "INGRESE OPCION:\n1. REGISTAR PEDIDOS\n2. MOSTRAR PEDIDOS\n3. REPORTE 1: INGRESO TOTAL DE PEDIDOS POR TIPO\n4. REPORTE 2: INGRESOS ADICIONALES\n5. SALIR "));
            }while(!(opc>0 & opc<=5));
            switch(opc){
                case 1:
                    registro();
                    break;
                case 2:
                    LPE.reporte1();
                    break;
                case 3:
                    LPE.reporte2();
                    break;
                case 4:
                    LPE.reporte3();
                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, "FIN DEL REGISTRO");
                    break;
            }
        }while(!(opc==5));
    }
    public static void registro(){
        int op;
        do{
            JOptionPane.showMessageDialog(null, "MENÚ DE PEDIDOS");
            do{
                op =Integer.parseInt( JOptionPane.showInputDialog(null, "INGRESE OPCION:\n1. PEDIDOS DE MESA\n2. PEDIDOS DOMICILIO\n3. SALIR"));
            }while(!(op>0 & op<=3));
            switch(op){
                case 1:
                    pedidoMesa();
                    pm= new PedidoMesa(objp.getCodigoPedido(),objp.getFechaPedido(),objp.getClientePedido(),objp.costoTotal());
                    objp=pm;
                    LPE.Adicionar(objp);
                    break;
                case 2:
                    pedidodelivery();
                    pd= new PedidoDelivery(objp.getCodigoPedido(),objp.getFechaPedido(),objp.getClientePedido(),objp.costoTotal());
                    objp=pd;
                    LPE.Adicionar(objp);
                    break;
                case 3:
                    break;
            }
        }while(!(op==3));
    }
    public static void pedidodelivery(){
        objp=new Pedidos();
        leerPedido();
    }
    public static void pedidoMesa(){
        objp=new Pedidos();
        leerPedido();
    }
    public static void leerPedido(){
        int dd,yy,mm;
        int i;
        int opcion;
        double gasto;
        Calendar fecha=Calendar.getInstance();
        //Pedidos objp=new Pedidos();
        do{
            objp.setCodigoPedido((Integer.parseInt(JOptionPane.showInputDialog(null, "Código"))));
        }while(!(objp.getCodigoPedido()>=0));
        objp.setClientePedido(JOptionPane.showInputDialog(null, "Cliente"));
        JOptionPane.showMessageDialog(null, "FECHA");
        do{
            dd = Integer.parseInt(JOptionPane.showInputDialog(null, "Dia"));
        }while(!(dd>0 & dd<=31));
        do{
            mm = Integer.parseInt(JOptionPane.showInputDialog(null, "Mes"));
        }while(!(mm>0 & mm<=12));
        do{
            yy = Integer.parseInt(JOptionPane.showInputDialog(null, "Año"));
        }while(!(yy>=2000));
        fecha.set(yy, mm-1, dd);
        do{
            JOptionPane.showMessageDialog(null, "LISTA DE PRODUCTOS");
            do{
                opcion=Integer.parseInt(JOptionPane.showInputDialog(null, "ELIJA SU OPCIÓN\n1. AGREGAR A LISTA DE PRODUCTOS\n2. SALIR"));
            }while(!(opcion>=1 & opcion<=2));

            switch(opcion){
                case 1:
                    JOptionPane.showMessageDialog(null, "LISTA DE PRODUCTOS");
                    LP.mostrarProducto();
                    do{
                        i =Integer.parseInt( JOptionPane.showInputDialog(null, "Ingrese producto:"));
                    }while(!(i>0 & i<=6));
                    gasto=+objp.getCostoPedido()+LP.getElem()[i-1].getCostoProducto();
                    objp.setCostoPedido(gasto);
                    break;
                case 2:
                    break;
            }
        }while(!(opcion==2));

        objp=new Pedidos(objp.getCodigoPedido(),fecha,objp.getClientePedido(),objp.costoTotal());

    }
    public static void listaProductos(){
        objpro  = new Producto(1,"Pizza", 12000);
        objpro1 = new Producto(2,"Hamburguesa",15000);
        objpro2 = new Producto(3,"Ensalada",5000);
        objpro3 = new Producto(4,"Gaseosa",3500);
        objpro4 = new Producto(5,"Papas a la francesa",3000);
        objpro5 = new Producto(6,"Helado",2000);
        LP.adicionar(objpro);
        LP.adicionar(objpro1);
        LP.adicionar(objpro2);
        LP.adicionar(objpro3);
        LP.adicionar(objpro4);
        LP.adicionar(objpro5);
    }

}