package mercaderia;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Catalogo {

    private Map<String, Producto> productos;


    public Catalogo() {
        productos = new HashMap<>();
    }

    public void agregarProducto(Producto prod) {
        productos.put(prod.getNombre(), prod);
    }

    public Producto getProducto(String nombre) {     // Busco en la lista el nombre del producto, y retorno todo el objeto producto que responde a ese nombre;
        return productos.get(nombre);
    }

    public void imprimirCatalogo() {
        for (Map.Entry<String, Producto> entry : productos.entrySet()) {
            String k = entry.getKey();
            Producto v = entry.getValue();
            System.out.println("Key: " + k + ": Value: " + v);
        }
    }


    protected boolean estaEnCatalogo(Producto producto) {
        return productos.containsKey(producto.getNombre());
    }


    public Optional<String> claveDeProducto(Producto producto) {
        if (productos.containsKey(producto.getNombre())) {
            return Optional.ofNullable(producto.getNombre());
        } else {
            return Optional.empty();
        }

    }

    public static void main(String[] args) {

        String mensaje = ingresarMensaje();

        Integer cantidadRepeticiones = vecesQueDeseaImprimir();

        for (int i = 0; i < cantidadRepeticiones; i++) {
            //imprimir("A Fabri le gusta la...");
            imprimir(mensaje);
        }

    }

    private static Integer vecesQueDeseaImprimir() {
        String repeticiones = JOptionPane.showInputDialog("¿Cuantas veces desea repetir el mensaje?");
        return Integer.parseInt(repeticiones);
    }


    public static String ingresarMensaje() {
        String mensaje = JOptionPane.showInputDialog("Ingrese mensaje");
        return mensaje;
    }

    public static void imprimir(String mensaje) {
        System.out.println(mensaje);
    }


}
