package mercaderia;

import junit.extensions.TestSetup;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class OrdenTest {

     @Test
    public void costoTest(){
         Catalogo catalogo = new Catalogo();

         Producto mayonesa = new Comprado("mayonesa", 1.0, 1.0, 30.0);
         Producto aceite = new Conservado("aceite", 2.0, 5.0, 60.0, 10);
         Producto queso = new Fabricado("queso", 1.5, 4.0, 30.0);
         Producto jamon = new Fabricado("jamon", 1.5, 4.0, 30.0);

         // Agregué 4 productos al catalogo;
         catalogo.agregarProducto(mayonesa);
         catalogo.agregarProducto(aceite);
         catalogo.agregarProducto(queso);
         catalogo.agregarProducto(jamon);

         Orden orden = new Orden(catalogo);

         orden.addItem(mayonesa, 10);
         orden.addItem(aceite, 5);
         orden.addItem(queso, 1);
         orden.addItem(jamon, 1);

         //System.out.println(orden.costo());
         Assert.assertEquals(4324, orden.costo(), 0.1);

         // El costo de los productos fabricados se calculan de otra manera
         // Con una variable harcodeada
     }

    @Test
    public void contenesEsteProductoUsandoDosCatalogosTest(){
        Catalogo catalogo = new Catalogo();

        Producto mayonesa = new Comprado("mayonesa", 1.0, 1.0, 30.0);
        Producto aceite = new Conservado("aceite", 2.0, 5.0, 60.0, 10);
        Producto queso = new Fabricado("queso", 1.5, 4.0, 30.0);
        Producto jamon = new Fabricado("jamon", 1.5, 4.0, 30.0);

        // Agregué 4 productos al catalogo;
        catalogo.agregarProducto(mayonesa);
        catalogo.agregarProducto(aceite);
        catalogo.agregarProducto(queso);
        catalogo.agregarProducto(jamon);

        Orden orden = new Orden(catalogo);

        orden.addItem(mayonesa, 10);
        orden.addItem(aceite, 5);
        orden.addItem(queso, 1);
        orden.addItem(jamon, 1);

        // creo un segundo catalogo
        Catalogo catalogo2 = new Catalogo();
        Producto ketchup = new Comprado("mayonesa", 1.0, 1.0, 30.0);

        System.out.println(orden.contenesEsteProducto(ketchup));
        Assert.assertFalse(orden.contenesEsteProducto(ketchup));
    }

    @Test
    public void contenesEsteProductoUsandoUnCatalogoTest(){
        Catalogo catalogo = new Catalogo();

        Producto mayonesa = new Comprado("mayonesa", 1.0, 1.0, 30.0);
        Producto aceite = new Conservado("aceite", 2.0, 5.0, 60.0, 10);
        Producto queso = new Fabricado("queso", 1.5, 4.0, 30.0);
        Producto jamon = new Fabricado("jamon", 1.5, 4.0, 30.0);

        // Agregué 4 productos al catalogo;
        catalogo.agregarProducto(mayonesa);
        catalogo.agregarProducto(aceite);
        catalogo.agregarProducto(queso);
        catalogo.agregarProducto(jamon);

        Orden orden = new Orden(catalogo);

        orden.addItem(mayonesa, 10);
        orden.addItem(aceite, 5);
        orden.addItem(queso, 1);
        orden.addItem(jamon, 1);

        //System.out.println(orden.contenesEsteProducto(jamon));
        Assert.assertTrue(orden.contenesEsteProducto(jamon));
    }

    @Test
    public void prodectosDelicadosTest(){
        Catalogo catalogo = new Catalogo();

        Producto mayonesa = new Comprado("mayonesa", 1.0, 1.0, 30.0);
        Producto aceite = new Conservado("aceite", 2.0, 5.0, 60.0, 10);
        Producto queso = new Fabricado("queso", 11.5, 4.0, 30.0);
        Producto jamon = new Fabricado("jamon", 11.5, 4.0, 30.0);


        // Agregué 4 productos al catalogo;
        catalogo.agregarProducto(mayonesa);
        catalogo.agregarProducto(aceite);
        catalogo.agregarProducto(queso);
        catalogo.agregarProducto(jamon);

        Orden orden = new Orden(catalogo);

        orden.addItem(mayonesa, 10);
        orden.addItem(aceite, 5);
        orden.addItem(queso, 1);
        orden.addItem(jamon, 1);

        // Un producto es delicado si pesa menos de 5Kg.
        // System.out.println(orden.productosDelicados());
        Assert.assertEquals(2, orden.productosDelicados().size());
    }

    @Test
    public void getItemsTest(){
        Catalogo catalogo = new Catalogo();

        Producto mayonesa = new Comprado("mayonesa", 1.0, 1.0, 30.0);
        Producto aceite = new Conservado("aceite", 2.0, 5.0, 60.0, 10);
        Producto queso = new Fabricado("queso", 11.5, 4.0, 30.0);
        Producto jamon = new Fabricado("jamon", 11.5, 4.0, 30.0);

        // Agregué 4 productos al catalogo;
        catalogo.agregarProducto(mayonesa);
        catalogo.agregarProducto(aceite);
        catalogo.agregarProducto(queso);
        catalogo.agregarProducto(jamon);

        Orden orden = new Orden(catalogo);

        orden.addItem(mayonesa, 10);
        orden.addItem(aceite, 5);
        orden.addItem(queso, 1);
        orden.addItem(jamon, 1);

        System.out.println(orden.getItems());
        Assert.assertEquals(4, orden.getItems().size());
    }

}
