package restaurante;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;

/**
 *
 * @author GeorgeJason
 */
public class AppPedido {

    static Pedidos objp = new Pedidos();
    static PedidoDelivery pd = new PedidoDelivery();
    static PedidoMesa pm = new PedidoMesa();
    static Producto objpro,objpro1,objpro2,objpro3,objpro4,objpro5;
    static ListaProducto LP = new ListaProducto();
    static ListaPedidos LPE = new ListaPedidos();
    static BufferedReader consola= new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        listaProductos();
        // leerPedido();

        // System.out.print(objp.getCodigoPedido()+"\tcosto"+objp.costoTotal());
        int opc;
        do{
            System.out.println("==============================================");
            System.out.println("===================PEDIDOS====================");
            System.out.println("==============================================");
            System.out.println("1. REGISTAR PEDIDOS");
            System.out.println("2. MOSTRAR PEDIDOS");
            System.out.println("3. REPORTE 1:INGRESO TOTAL DE PEDIDOS POR TIPO");
            System.out.println("4. REPORTE 2:INGRESOS ADICIONALES");
            System.out.println("5. SALIR");
            do{
                System.out.print("Ingrese opcion:");
                opc=Integer.parseInt(consola.readLine());
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
                    System.out.println("FIN DEL REGISTRO");
                    break;
            }
        }while(!(opc==5));
    }
    public static void registro() throws IOException{
        int op;
        do{
            System.out.println("=============================");
            System.out.println("=====REGISTRO DE PEDIDOS=====");
            System.out.println("=============================");
            System.out.println("1. PEDIDOS DE MESA");
            System.out.println("2. PEDIDOS DE DELIVERY");;
            System.out.println("3. SALIR");
            do{
                System.out.print("Ingrese opcion:");
                op=Integer.parseInt(consola.readLine());
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
    public static void pedidodelivery() throws IOException{
        objp=new Pedidos();
        leerPedido();
    }
    public static void pedidoMesa() throws IOException{
        objp=new Pedidos();
        leerPedido();
    }
    public static void leerPedido() throws IOException{
        int dd,yy,mm;
        int i,j;
        int opcion;
        double gasto;
        Calendar fecha=Calendar.getInstance();
        //Pedidos objp=new Pedidos();
        do{
            System.out.print("Codigo:");
            objp.setCodigoPedido(Integer.parseInt(consola.readLine()));
        }while(!(objp.getCodigoPedido()>=0));

        System.out.print("Cliente:");
        objp.setClientePedido(consola.readLine());
        System. out.println("FECHA:");
        do{
            System.out.print("Dia:");
            dd=Integer.parseInt(consola.readLine());
        }while(!(dd>0 & dd<=31));
        do{
            System.out.print("Mes:");
            mm=Integer.parseInt(consola.readLine());
        }while(!(mm>0 & mm<=12));
        do{
            System.out.print("Año:");
            yy=Integer.parseInt(consola.readLine());
        }while(!(yy>=2000));
        fecha.set(yy, mm-1, dd);
        do{
            System.out.println("-----------------------");
            System.out.println("--LISTA DE PRODUCTOS---");
            System.out.println("-----------------------");
            System.out.println("1. AGREGAR A LISTA DE PRODUCTOS");
            System.out.println("2. SALIR");
            do{
                System.out.print("Eliga su Opcion:");
                opcion=Integer.parseInt(consola.readLine());
            }while(!(opcion>=1 & opcion<=2));

            switch(opcion){
                case 1:
                    System.out.println("--LISTA DE PRODUCTOS---");
                    LP.mostrarProducto();
                    System.out.println("-----------------------");
                    do{
                        System.out.print("Ingrese producto");
                        i=Integer.parseInt(consola.readLine());
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
        objpro  = new Producto(1,"pizza francesa $", 15000);
        objpro1 = new Producto(2,"gaseoa $",4500f);
        objpro2 = new Producto(3,"helado $",5000f);
        objpro3 = new Producto(4,"pollo a la braza $",35000f);
        objpro4 = new Producto(5,"menu $",7000f);
        objpro5 = new Producto(6,"cafe $",2000f);
        LP.adicionar(objpro);
        LP.adicionar(objpro1);
        LP.adicionar(objpro2);
        LP.adicionar(objpro3);
        LP.adicionar(objpro4);
        LP.adicionar(objpro5);
    }

}