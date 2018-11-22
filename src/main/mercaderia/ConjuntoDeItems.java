package mercaderia;

import java.util.List;

public abstract class ConjuntoDeItems {

    protected Catalogo catalogo;

    public ConjuntoDeItems(Catalogo catalogo) {
        this.catalogo = catalogo;
    }

    public abstract List<Item> getItems();


}
