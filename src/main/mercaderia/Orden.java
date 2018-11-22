package mercaderia;

import java.util.*;
import java.util.stream.Collectors;

public class Orden extends ConjuntoDeItems {


    private List<Item> items = new ArrayList<>();

    public Orden (Catalogo catalogo){
        super (catalogo);
    }

    public void addItem(Producto producto, Integer cantidad) {
        if (catalogo.estaEnCatalogo(producto)) {
            Optional<Item> ordenExistente = items.stream()
                                                .filter((item -> item.getProducto().getNombre() == producto.getNombre()))
                                                .findFirst();
            if (ordenExistente.isPresent()) {
                ordenExistente.get().acumularCantidad(cantidad);
                // ordenExistente.ifPresent(ordenItem -> ordenItem.acumularCantidad(cantidad));
            } else {
                Item item = new Item(producto, cantidad);
                items.add(item);
            }
        } else {
            System.out.println(producto + ", no está en el catalogo");
        }
    }

    //El costo de una orden se calcula así:
    //	costo orden = suma (costo producto * cantidad del producto en la orden)
    public Double costo() {
        Double costoDeOrden = 0.0;
        for (Item item : items) {
            costoDeOrden = costoDeOrden + item.costo();
        }
        return costoDeOrden;
    }

    // La lista de los productos delicados que aparecen en una orden, ordenada por nombre del producto.
    // Un producto se considera delicado si pesa menos de 5 kg.
    public List<Item> productosDelicados() {
        List<Item> productosDelicados = new ArrayList<>();
        for (Item item : items) {
            if (item.getProducto().esDelicado()) {
                productosDelicados.add(item);
            }
        }
        //Que pasa si la lista contiene solo un Producto?, porque el comparador requiere dos parametros
        productosDelicados.sort((o1, o2) -> o2.getProducto().getNombre().compareTo(o1.getProducto().getNombre()));
        return productosDelicados;
    }


    // (Todo) Trabajos con LOTE
    protected boolean contenesEsteProducto(Producto producto) {
        for (Item item : items) {
            if (item.getProducto().equals(producto)) return true;
        }
        return false;
    }

    protected Integer dameLaCantidadDeEsteProducto(Producto producto) {
        Integer cantidadProducto = 0;
        for (Item item : items) {
            if (item.getProducto() == producto) {
                cantidadProducto = cantidadProducto + item.getCantidad();
            }
        }
        return cantidadProducto;
    }

/*
    public List<Producto> obtenerProductos() {
        return items.stream().map(this::dameTuProducto).collect(Collectors.toList());
    }

    private Producto dameTuProducto(Item item) {
        return item.getProducto();
    }
*/

    @Override
    public List<Item> getItems() {
        return items;
    }


}
