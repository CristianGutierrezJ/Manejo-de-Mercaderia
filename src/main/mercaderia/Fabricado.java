package mercaderia;

public class Fabricado extends Producto {

////El costo de una orden se calcula así:
////	costo orden = suma (costo producto * cantidad del producto en la orden)
////El costo de un producto se calcula así:
////	costo producto = costo producción + costo almacenajeBase
////El costo de producción depende del tipo de producto, de esta forma:

    //productos fabricados:
    //	cantidad de hs/hombre que lleva producirlo * costo de la h/hombre
    //El costo de la hora/hombre es el mismo para todos los productos fabricados.

    private static final Double COSTO_HORA_HOMBRE = 60.0;
    private Double cantidadDeHorasHombrePorProduccion;


    //CONSTRUCTOR
    public Fabricado(String nombreDeProducto, Double pesoDeProductoKilos, Double valorDeAlmacenaje, Double cantidadDeHorasHombrePorProduccion) {
        super(nombreDeProducto, pesoDeProductoKilos, valorDeAlmacenaje);
        this.cantidadDeHorasHombrePorProduccion = cantidadDeHorasHombrePorProduccion;
    }


    public Double costoDeProduccion(){
        return cantidadDeHorasHombrePorProduccion * COSTO_HORA_HOMBRE;
    }

    public Double valorDeAlmacenaje() {
        return almacenajeBase;
    }



}
