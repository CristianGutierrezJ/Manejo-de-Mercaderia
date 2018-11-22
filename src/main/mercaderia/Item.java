package mercaderia;

import java.util.Objects;

public class Item {

    private Producto producto;
    private Integer cantidad;

    protected Item(Producto producto, Integer cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Item() {
    }

    public Producto getProducto() {
        return producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

// Aca debería hacer los calculos de la clase Orden

    // quiza deba hacer algo para ver que tipo de producto tengo (String nombre), sumar sus cantidades y achicar la lista(ya que son el mismo producto)
    // ......


    ////El costo de una orden se calcula así:
    //     costo orden = suma (costo producto * cantidad del producto en la orden)
    protected Double costo(){
        return producto.costoDeProducto()*cantidad;
    }

    public void acumularCantidad(Integer cantidad){
        this.cantidad += cantidad;
    }

    @Override
    public String toString() {
        return "Item{" +
                "producto=" + producto.getNombre() +
                ", cantidad=" + cantidad +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(producto, cantidad);
    }


}
