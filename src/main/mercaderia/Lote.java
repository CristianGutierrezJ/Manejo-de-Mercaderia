package mercaderia;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lote extends ConjuntoDeItems {

    private List<Orden> ordenes = new ArrayList<>();

    public Lote(Catalogo catalogo) {
        super(catalogo);
    }

    // Cada lote se compone de un conjunto de órdenes de obtención de productos,
    public void addOrden (Orden orden){
        ordenes.add(orden);
    }

    // La cantidad total de un determinado producto en un lote
    // (que será la suma de las cantidades en las órdenes que forman el lote y que incluyan ese producto).
    public Integer cantidadDeUnProducto(Producto producto){
        Integer cantidadProducto = 0;
        for(Orden orden: ordenes){
            if(orden.contenesEsteProducto(producto)){
                cantidadProducto = cantidadProducto + orden.dameLaCantidadDeEsteProducto(producto);
            }
        }
        return cantidadProducto;
    }

    // La lista de productos que aparecen en un lote (o sea, aparecen en alguna orden del lote),
    // ordenada por la cantidad total del producto en el lote.
/*
    public List<Producto> productos(){
        List<Producto> productosLote = new ArrayList<>();
    //  for(Orden orden: ordenes){
    //        productosLote.addAll(orden.obtenerProductos());
    //    }
    //    return productosLote;
    //
    ////    return ordenes.stream().flatMap(this::obtenerProductosDeOrden).collect(Collectors.toList());
        return ordenes.stream().flatMap(orden -> orden.obtenerProductos().stream()).collect(Collectors.toList());
    }

    private Stream<Producto> obtenerProductosDeOrden(Orden orden){
        return orden.obtenerProductos().stream();
    }
*/

    @Override
    public List<Item> getItems() {
        return ordenes.stream()
                .flatMap(orden -> orden.getItems().stream())
                .collect(Collectors.groupingBy( item -> this.catalogo.claveDeProducto(item.getProducto())))
                .values().stream()
                .map(this::acumularCantidadDeItems)
                .sorted(Comparator.comparingInt(Item::getCantidad))
                .collect(Collectors.toList());
    }

    private Item acumularCantidadDeItems( List<Item> items){
        Item itemAcumulado = new Item(items.get(0).getProducto(), 0);
        for(Item item: items){
            itemAcumulado.acumularCantidad(item.getCantidad());
        }
        return itemAcumulado;
    }



}
