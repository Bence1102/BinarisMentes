package Model;

import java.io.Serializable;
import java.util.ArrayList;
import main.Karakter;

public class JatekModel implements Serializable {

    private Karakter varazslo;
    private Karakter harcos;
    private ArrayList<Karakter> szereplok;

    public JatekModel() {
        szereplok = new ArrayList<>();
    }

    public void ujVarazslo(String nev) {
        varazslo = new Karakter("Varázsló","varazsbot","ember",6);
        szereplok.add(varazslo);
    }

    public void ujHarcos(String nev) {
        harcos = new Karakter("Harcos","vaspallos","ember",5);
        szereplok.add(harcos);
    }

    public Karakter getVarazslo() { return varazslo; }
    public Karakter getHarcos() { return harcos; }

    public String csata() {
        if (varazslo == null || harcos == null) {
            return "Hiányzik egy karakter!";
        }

        while (varazslo.getHp() > 0 && harcos.getHp() > 0) {
            varazslo.tamad(harcos);
            if (harcos.getHp() <= 0) return "A varázsló nyert!";

            harcos.tamad(varazslo);
            if (varazslo.getHp() <= 0) return "A harcos nyert!";
        }
        return "Hiba!";
    }
}
