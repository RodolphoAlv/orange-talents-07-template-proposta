package zup.proposta.rodolpho.model;

import java.util.HashMap;
import java.util.Map;

public enum CarteiraAssociada {
    PAYPAL,
    SAMSUNG_PAY;

    public static Map<String, CarteiraAssociada> carteirasAssociadas() {

        Map<String, CarteiraAssociada> carteirasAssociadas = new HashMap<>();
        for(CarteiraAssociada c : CarteiraAssociada.values()) {
            carteirasAssociadas.put(c.name(), c);
        }

        return carteirasAssociadas;
    }
}
