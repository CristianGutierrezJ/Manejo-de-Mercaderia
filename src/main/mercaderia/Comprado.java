package mercaderia;

public class Comprado extends Producto {
//El costo de una orden se calcula así:
//	costo orden = suma (costo producto * cantidad del producto en la orden)
//El costo de un producto se calcula así:
//	costo producto = costo producción + costo almacenajeBase
//El costo de producción depende del tipo de producto, de esta forma:
//productos comprados: precio de compra

    private Double precioDeCompra;


    //CONSTRUCTOR
    public Comprado(String nombreDeProducto, Double pesoDeProductoKilos, Double valorDeAlmacenaje, Double precioDeCompra) {
        super(nombreDeProducto, pesoDeProductoKilos, valorDeAlmacenaje);
        this.precioDeCompra = precioDeCompra;
    }


    public Double costoDeProduccion(){
        return precioDeCompra;
    }

    public Double valorDeAlmacenaje() {
        return almacenajeBase *1.2;
    }




}
