package ohtu.kivipaperisakset.pelaajat;

import ohtu.kivipaperisakset.pelaajat.Pelaaja;

public class TekoalyHuono implements Pelaaja {

    int siirto;

    public TekoalyHuono() {
        siirto = 0;
    }

    @Override
    public String annaSiirto() {
        siirto++;
        siirto = siirto % 3;

        if (siirto == 0) {
            return "k";
        } else if (siirto == 1) {
            return "p";
        } else {
            return "s";
        }
    }

    @Override
    public void asetaSiirto(String ekanSiirto) {
        // ei tehdä mitään 
    }

    @Override
    public String getName() {
        return "tietokone";
    }
}
