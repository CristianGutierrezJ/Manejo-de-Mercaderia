package mercaderia;

public class Conservado extends Producto  {

////El costo de una orden se calcula así:
////	costo orden = suma (costo producto * cantidad del producto en la orden)
////El costo de un producto se calcula así:
////	costo producto = costo producción + costo almacenajeBase
////El costo de producción depende del tipo de producto, de esta forma:

//productos conservados:
//  precio de compra original + días de conservación del producto ...
//  ...   * peso del producto en kg. * costo de conservación x día x kg.)

// El costo de conservación por día y por kg es el mismo para todos los productos conservados.
//Por ejemplo, si la horma de queso sardo lleva 45 días de conservación y pesa 8 kg,
//  el costo de conservación x día x kg es de 0.10 pesos,
//  y el precio de compra original de la horma de queso sardo es 30 pesos, su costo de producción será
//    30 + (45 * 8 * 0.1) = 66 pesos
//Para estandarizar, se toma un peso promedio x producto
// (en el ejemplo, que todas las hormas hormas de queso sardo pesan 45 kg).

    private Double precioDeCompra;
    private Integer diasDeConservacion;
    private static final Double COSTO_DE_CONSERVACION = 0.5;    // En caso de que el costo de conservacio aumente (Por la suba de luz quizás)
                                                                // Deberia tener un set de esta variable.
                                                            // Podria instanciarlo en otra clase y llamarlo aqui para su uso.
                                                            // Creando así un controlador de precios estaticos.


    //CONSTRUCTOR
    public Conservado(String nombreDeProducto, Double pesoDeProductoKilos, Double valorDeAlmacenaje, Double precioDeCompra, Integer diasDeConservacion) {
        super(nombreDeProducto, pesoDeProductoKilos, valorDeAlmacenaje);
        this.precioDeCompra = precioDeCompra;
        this.diasDeConservacion = diasDeConservacion;
    }


    public Double costoDeProduccion(){
        return precioDeCompra + diasDeConservacion * pesoDeProductoKilos * COSTO_DE_CONSERVACION;
    }

    public Double valorDeAlmacenaje() {
        return almacenajeBase;
    }



}
