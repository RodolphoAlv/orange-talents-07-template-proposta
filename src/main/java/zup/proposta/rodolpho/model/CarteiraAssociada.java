package zup.proposta.rodolpho.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public enum CarteiraAssociada {
    PAYPAL;

    public static Map<String, CarteiraAssociada> carteirasAssociadas() {

        Map<String, CarteiraAssociada> carteirasAssociadas = new HashMap<>();
        for(CarteiraAssociada c : CarteiraAssociada.values()) {
            carteirasAssociadas.put(c.name(), c);
        }

        return carteirasAssociadas;
    }
}
