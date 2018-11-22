package mercaderia;

import org.junit.Assert;
import org.junit.Test;

public class LoteTest {

    @Test
    public void testCantidadDeUnProducto(){
//La cantidad total de un determinado producto en un LOTE.
// (que será la suma de las cantidades en las órdenes que forman el lote y que incluyan ese producto).
        Catalogo catalogo = new Catalogo();

        Producto mayonesa = new Comprado("mayonesa", 1.0, 1.0, 30.0);
        Producto aceite = new Conservado("aceite", 2.0, 5.0, 60.0, 10);
        Producto queso = new Fabricado("queso", 1.5, 4.0, 30.0);

        // Agregué 3 productos al catalogo;
        catalogo.agregarProducto(mayonesa);
        catalogo.agregarProducto(aceite);
        catalogo.agregarProducto(queso);

        // Creo 3 ordenes.
        Orden orden1 = new Orden(catalogo);
        Orden orden2 = new Orden(catalogo);
        Orden orden3 = new Orden(catalogo);

        // Cargo 3 pedidos a cada orden.
        orden1.addItem(mayonesa, 10);
        orden1.addItem(aceite, 5);
        orden1.addItem(queso, 1);

        orden2.addItem(mayonesa, 10);
        orden2.addItem(aceite, 5);
        orden2.addItem(queso, 1);

        orden3.addItem(mayonesa, 10);
        orden3.addItem(aceite, 5);
        orden3.addItem(queso, 1);

        // Creo un Lote
        Lote lote = new Lote(catalogo);

        // Cargo el lote
        lote.addOrden(orden1);
        lote.addOrden(orden2);
        lote.addOrden(orden3);

        //System.out.println(lote.cantidadDeUnProducto(mayonesa));
        Assert.assertEquals(30, lote.cantidadDeUnProducto(mayonesa), 0.1);
    }

    @Test
    public void testGetItems(){
        Catalogo catalogo = new Catalogo();

        Producto mayonesa = new Comprado("mayonesa", 1.0, 1.0, 30.0);
        Producto aceite = new Conservado("aceite", 2.0, 5.0, 60.0, 10);
        Producto queso = new Fabricado("queso", 1.5, 4.0, 30.0);

        Producto jamon = new Fabricado("jamon", 1.5, 4.0, 30.0);

        // Agregué 3 productos al catalogo;
        catalogo.agregarProducto(mayonesa);
        catalogo.agregarProducto(aceite);
        catalogo.agregarProducto(queso);

        catalogo.agregarProducto(jamon);

        // Creo 3 ordenes.
        Orden orden1 = new Orden(catalogo);
        Orden orden2 = new Orden(catalogo);
        Orden orden3 = new Orden(catalogo);

        // Cargo 3 pedidos a cada orden.
        orden1.addItem(mayonesa, 10);
        orden1.addItem(aceite, 5);
        orden1.addItem(queso, 1);

        orden2.addItem(mayonesa, 10);
        orden2.addItem(aceite, 5);
        orden2.addItem(queso, 1);

        orden2.addItem(jamon, 1);

        orden3.addItem(mayonesa, 10);
        orden3.addItem(aceite, 5);
        orden3.addItem(queso, 1);

        // Creo un Lote
        Lote lote = new Lote(catalogo);

        // Cargo el lote
        lote.addOrden(orden1);
        lote.addOrden(orden2);
        lote.addOrden(orden3);

        //System.out.println(lote.getItems());
        Assert.assertFalse(lote.getItems().isEmpty());
        Assert.assertEquals(4, lote.getItems().size());
    }



}
