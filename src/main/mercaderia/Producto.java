package mercaderia;

public abstract class Producto {

    private String nombreDeProducto;
    protected Double pesoDeProductoKilos;
    protected Double almacenajeBase;


    public String getNombre() {
        return nombreDeProducto;
    }

    // CONSTRUCTOR
    public Producto(String nombreDeProducto, Double pesoDeProductoKilos, Double valorDeAlmacenaje) {
        this.nombreDeProducto = nombreDeProducto;
        this.pesoDeProductoKilos = pesoDeProductoKilos;
        this.almacenajeBase = valorDeAlmacenaje;
    }

    public abstract Double costoDeProduccion();

    //El costo de almacenaje de un producto es:
    //peso en kg * valor de almacenaje del producto por kg
    //este valor de almacenaje es distinto para cada producto.
    //Para los productos comprados hay que agregarle un 20% más, que corresponde al (todo) costo de traslado hasta el depósito.
    public abstract Double valorDeAlmacenaje();

    //El costo de almacenajeBase de un producto es:
    //peso en kg * valor de almacenajeBase del producto por kg
    //este valor de almacenajeBase es distinto para cada producto.
    //Para los productos comprados hay que agregarle un 20% más, que corresponde al costo de traslado hasta el depósito.
    public Double costoDeAlmacenaje(){
        return pesoDeProductoKilos * valorDeAlmacenaje();
    }

    //El costo de un producto se calcula así:
    //	costo producto = costo producción + costo almacenaje
    public Double costoDeProducto(){
        return costoDeProduccion() + costoDeAlmacenaje();
    }

    //La lista de los productos delicados que aparecen en una orden, ordenada por nombre del producto.
    // Un producto se considera delicado si pesa menos de 5 kg.
    public Boolean esDelicado(){
        return pesoDeProductoKilos < 5;
    }



}
